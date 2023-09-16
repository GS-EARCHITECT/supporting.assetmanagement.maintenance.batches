package asset_main_schd_doservice_details;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import common.master.ServiceRequestMaster;

@Service("assetMaintenanceSchdDoServiceListenerServ")
public class AssetMainSchdDoServiceListener_Service	
{
	private static final Logger logger = LoggerFactory.getLogger(AssetMainSchdDoServiceListener_Service.class);
	
	@KafkaListener(topics = "${topic.name.requestresponse}", groupId = "group_id")
	public void consume(ConsumerRecord<String, ServiceRequestMaster> payload) 
	{
		logger.info("key: {}", payload.key());
		logger.info("Headers: {}", payload.headers());
		logger.info("Partion: {}", payload.partition());
		logger.info("Order: {}", payload.value());

}
}
