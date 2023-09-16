package asset_main_schd_doservice_details;

import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import common.repo.AssetMaintenanceSchdDetailsCUD_Repo;
import common.repo.AssetMaintenanceSchdDetailsRead_Repo;
import common.repo.AssetMaster_Repo;
import common.repo.AssetResServPartyDetails_Repo;
import common.master.*;

@Service("assetMaintenanceSchdDoServiceServ")
public class AssetMainSchdDoService_Service implements I_AssetMainSchdDoService_Service {
	private static final Logger logger = LoggerFactory.getLogger(AssetMainSchdDoService_Service.class);

	@Autowired
	private AssetMaintenanceSchdDetailsRead_Repo assetMainSchdDetailsReadRepo;

	@Autowired
	private AssetMaintenanceSchdDetailsCUD_Repo assetMainSchdDetailsCUDRepo;

	@Autowired
	private AssetResServPartyDetails_Repo assetResServPartyDetailsRepo;

	@Autowired
	private AssetMaster_Repo assetMasterRepo;

	@Value("${topic.name.request}")
	private String topicmyRequest;

	@Value("${topic.name.requestresponse}")
	private String myRequestResponse;

	@Autowired
	private KafkaTemplate<String, ServiceRequestMaster> kafkaTemplateRequest;

	@Scheduled(fixedRate = 3000)
	public void runBatch() {
		// For Each Asset - Get All Res Prod Servs
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsReadRepo
				.getAssetsNotWIP();

		logger.info("Assets Size : " + assetMaintenanceSchdDetails.size());
		AssetMaintenanceSchdDetail assetMaintenanceSchdDetail = null;

		if (assetMaintenanceSchdDetails != null && assetMaintenanceSchdDetails.size() > 0) {
			for (int i = 0; i < assetMaintenanceSchdDetails.size(); i++) {
				assetMaintenanceSchdDetail = assetMaintenanceSchdDetails.get(i);

				sendToServiceManager(assetMaintenanceSchdDetail);
			}
		}
		return;
	}

	public synchronized void sendToServiceManager(AssetMaintenanceSchdDetail assetMaintenanceSchdDetail) {
		ServiceRequestMaster serviceRequestMaster = new ServiceRequestMaster();
		Long ownerSeqNo = assetMasterRepo.getPartyForAsset(assetMaintenanceSchdDetail.getAssetSeqNo());
		Long partySeqNo = assetResServPartyDetailsRepo
				.getPartyForResProd(assetMaintenanceSchdDetail.getRessrvprdSeqNo());
		serviceRequestMaster.setFrPartySeqNo(ownerSeqNo);
		serviceRequestMaster.setReferenceSeqNo(assetMaintenanceSchdDetail.getRuleLineSeqNo());
		serviceRequestMaster.setToPartySeqNo(partySeqNo);

		ListenableFuture<SendResult<String, ServiceRequestMaster>> future = kafkaTemplateRequest.send(topicmyRequest,
				serviceRequestMaster);
		future.addCallback(new ListenableFutureCallback<SendResult<String, ServiceRequestMaster>>() {

			@Override
			public void onSuccess(final SendResult<String, ServiceRequestMaster> message) 
			{
				logger.info("sent message= " + message + " with offset= " + message.getRecordMetadata().offset());
				assetMainSchdDetailsCUDRepo.setAssetWIP(message.getProducerRecord().value().getReferenceSeqNo());
			}

			@Override
			public void onFailure(final Throwable throwable) {
				logger.error("unable to send message= ", throwable);
			}
		});
		return;
	}
}
