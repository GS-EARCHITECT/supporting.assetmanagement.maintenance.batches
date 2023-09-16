package common.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the SERVICE_REQUEST_MASTER database table.
 * 
 */
@Entity
@Table(name = "SERVICE_REQUEST_MASTER")
public class ServiceRequestMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_request_seq_no")
	@SequenceGenerator(name = "customer_request_seq_no", sequenceName = "customer_request_seq_no", allocationSize = 1)
	@Column(name = "REQUEST_SEQ_NO")
	private Long requestSeqNo;

	@Column(name = "FR_PARTY_SEQ_NO")
	private Long frPartySeqNo;

	@Column(name = "REFERENCE_SEQ_NO")
	private Long referenceSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "REQUEST_DTTM")
	private Timestamp requestDttm;

	@Column(name = "STATUS")
	private Character status;

	@Column(name = "TO_PARTY_SEQ_NO")
	private Long toPartySeqNo;

	public ServiceRequestMaster() {
	}

	public Long getRequestSeqNo() {
		return this.requestSeqNo;
	}

	public void setRequestSeqNo(Long requestSeqNo) {
		this.requestSeqNo = requestSeqNo;
	}

	public Long getFrPartySeqNo() {
		return this.frPartySeqNo;
	}

	public void setFrPartySeqNo(Long frPartySeqNo) {
		this.frPartySeqNo = frPartySeqNo;
	}

	public Long getReferenceSeqNo() {
		return this.referenceSeqNo;
	}

	public void setReferenceSeqNo(Long referenceSeqNo) {
		this.referenceSeqNo = referenceSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getRequestDttm() {
		return this.requestDttm;
	}

	public void setRequestDttm(Timestamp requestDttm) {
		this.requestDttm = requestDttm;
	}

	public Long getToPartySeqNo() {
		return this.toPartySeqNo;
	}

	public void setToPartySeqNo(Long toPartySeqNo) {
		this.toPartySeqNo = toPartySeqNo;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frPartySeqNo == null) ? 0 : frPartySeqNo.hashCode());
		result = prime * result + ((referenceSeqNo == null) ? 0 : referenceSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((requestDttm == null) ? 0 : requestDttm.hashCode());
		result = prime * result + (int) (requestSeqNo ^ (requestSeqNo >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toPartySeqNo == null) ? 0 : toPartySeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceRequestMaster other = (ServiceRequestMaster) obj;
		if (frPartySeqNo == null) {
			if (other.frPartySeqNo != null)
				return false;
		} else if (!frPartySeqNo.equals(other.frPartySeqNo))
			return false;
		if (referenceSeqNo == null) {
			if (other.referenceSeqNo != null)
				return false;
		} else if (!referenceSeqNo.equals(other.referenceSeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (requestDttm == null) {
			if (other.requestDttm != null)
				return false;
		} else if (!requestDttm.equals(other.requestDttm))
			return false;
		if (requestSeqNo != other.requestSeqNo)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toPartySeqNo == null) {
			if (other.toPartySeqNo != null)
				return false;
		} else if (!toPartySeqNo.equals(other.toPartySeqNo))
			return false;
		return true;
	}

	public ServiceRequestMaster(Long requestSeqNo, Long frPartySeqNo, Long referenceSeqNo, String remark,
			Timestamp requestDttm, Character status, Long toPartySeqNo) {
		super();
		this.requestSeqNo = requestSeqNo;
		this.frPartySeqNo = frPartySeqNo;
		this.referenceSeqNo = referenceSeqNo;
		this.remark = remark;
		this.requestDttm = requestDttm;
		this.status = status;
		this.toPartySeqNo = toPartySeqNo;
	}

}