package common.repo;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import common.master.AssetMaintenanceSchdDetail;

@Transactional(propagation=Propagation.REQUIRES_NEW)
@Repository("assetMaintenanceSchdDetailsCUDRepo")
public interface AssetMaintenanceSchdDetailsCUD_Repo extends JpaRepository<AssetMaintenanceSchdDetail, Long> 
{	
	
	@Modifying
	@Query(value="delete from ASSET_MAINTENANCE_SCHD_DETAILS b  where b.ASSET_MAINTENANCE_SEQ_NO in :ids ",nativeQuery = true)
	void delSelectSchedulesByMaintenance(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Modifying
	@Query(value="delete from ASSET_MAINTENANCE_SCHD_DETAILS b  where upper(trim(b.schedule_id)) in :ids",nativeQuery = true)
	void delSelectSchedulesByScheduleIds(@Param("ids") CopyOnWriteArrayList<String> ids);
	
	@Modifying
	@Query(value="delete from ASSET_MAINTENANCE_SCHD_DETAILS b  where b.RESSRVPRD_SEQ_NO in :ids",nativeQuery = true)
	void delSelectSchedulesByResSrvProds(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(okflag))='Y'",nativeQuery = true) 
	void delAssetsOK();
	
	@Modifying
	@Query(value = "update ASSET_MAINTENANCE_SCHD_DETAILS set wipflag = 'Y' where schedule_seq_no= :id",nativeQuery = true) 
	void setAssetWIP(@Param("id") Long id);

	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(doneflag))='Y'",nativeQuery = true) 
	void delAssetsDone();

	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(okflag))<> 'Y'",nativeQuery = true) 
	void delAssetsNotOK();

	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
	void delAssetsNotDone();

	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(wipflag)) = 'Y'",nativeQuery = true) 
	void delAssetsWIP();
	
	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(wipflag))<> 'Y'",nativeQuery = true) 
	void delAssetsNotWIP();
	
	@Modifying
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM))",nativeQuery = true) 
	void delAssetsBetweenDTTM(@Param(value = "fr") Timestamp fr, @Param(value = "to") Timestamp to);
	
	
	
} 

