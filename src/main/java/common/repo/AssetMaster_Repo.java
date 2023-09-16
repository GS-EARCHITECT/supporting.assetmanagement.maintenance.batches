package common.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import common.master.AssetMaster;

@Repository("assetMasterRepo")
public interface AssetMaster_Repo extends JpaRepository<AssetMaster, Long> 
{
	@Query(value = "SELECT * FROM ASSET_MASTER order by asset_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMaster> getAllAssets();

	@Query(value = "SELECT * FROM ASSET_MASTER a WHERE a.resource_seq_no in :ids order by asset_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMaster> getSelectAssetsByResources(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT party_seq_no FROM ASSET_MASTER a WHERE a.asset_seq_no = :id", nativeQuery = true)
	Long getPartyForAsset(@Param("id") Long id);
	
}
