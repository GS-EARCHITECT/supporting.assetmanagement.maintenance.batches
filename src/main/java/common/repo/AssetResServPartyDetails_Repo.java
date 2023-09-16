package common.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import common.master.AssetResServPartyDetail;

@Repository("assetResServPartyDetailsRepo")
public interface AssetResServPartyDetails_Repo extends JpaRepository<AssetResServPartyDetail, Long> 
{
	@Query(value = "SELECT party_seq_no FROM ASSET_ResServ_Party_DETAILS a WHERE (RESSRVPRD_SEQ_NO = :id and rownum=1)", nativeQuery = true)
	Long getPartyForResProd(@Param("id") Long id);
	
	@Query(value = "SELECT service_seq_no FROM ASSET_ResServ_Party_DETAILS a WHERE (RESSRVPRD_SEQ_NO = :id and rownum=1)", nativeQuery = true)
	Long getServiceForResProd(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE party_seq_no in :ids  order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetResServPartyDetail> getDetailsForParties(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE resource_seq_no in :ids  order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetResServPartyDetail> getDetailsForResources(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE resource_seq_no = :id  order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetResServPartyDetail> getDetailsForResource(@Param("id") Long id);
	
	@Query(value = "SELECT RESSRVPRD_SEQ_NO FROM ASSET_ResServ_Party_DETAILS a WHERE resource_seq_no = :id  order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<Long> getResProdNumbersForResource(@Param("id") Long id);
		
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE service_seq_no in :ids  order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetResServPartyDetail> getDetailsForServices(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS  order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetResServPartyDetail> getAllDetails();
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS where RESSRVPRD_SEQ_NO in :ids order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetResServPartyDetail> getSelectDetails(@Param("ids") CopyOnWriteArrayList<Long> ids);
		
}