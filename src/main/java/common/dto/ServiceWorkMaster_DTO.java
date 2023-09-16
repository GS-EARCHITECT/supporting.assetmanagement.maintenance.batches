package common.dto;

import java.io.Serializable;

public class ServiceWorkMaster_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -725497823375126222L;
	private Long serviceWorkSeqNo;
	private Character autoAllocStatus;
	private Character billedflag;
	private Long billingCurrencySeqNo;
	private Long bookingSeqNo;
	private Long createdBy;
	private Character doneflag;
	private Character jobAllocStatus;
	private Long jobTemplateSeqNo;
	private Character jobautoflag;
	private Long membershipSeqNo;
	private Character okflag;
	private String onDate;
	private Integer opFlag;
	private Long parentServiceWorkSeqNo;
	private Long partySeqNo;
	private String remark;
	private Long requestSeqNo;
	private Character resAllocStatus;
	private Character resDirectIndirectFlag;
	private Character resautoflag;
	private Long serviceSeqNo;

	public Long getServiceWorkSeqNo() {
		return serviceWorkSeqNo;
	}

	public void setServiceWorkSeqNo(Long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

	public Character getAutoAllocStatus() {
		return autoAllocStatus;
	}

	public void setAutoAllocStatus(Character autoAllocStatus) {
		this.autoAllocStatus = autoAllocStatus;
	}

	public Character getBilledflag() {
		return billedflag;
	}

	public void setBilledflag(Character billedflag) {
		this.billedflag = billedflag;
	}

	public Long getBillingCurrencySeqNo() {
		return billingCurrencySeqNo;
	}

	public void setBillingCurrencySeqNo(Long billingCurrencySeqNo) {
		this.billingCurrencySeqNo = billingCurrencySeqNo;
	}

	public Long getBookingSeqNo() {
		return bookingSeqNo;
	}

	public void setBookingSeqNo(Long bookingSeqNo) {
		this.bookingSeqNo = bookingSeqNo;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Character getJobAllocStatus() {
		return jobAllocStatus;
	}

	public void setJobAllocStatus(Character jobAllocStatus) {
		this.jobAllocStatus = jobAllocStatus;
	}

	public Long getJobTemplateSeqNo() {
		return jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(Long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public Character getJobautoflag() {
		return jobautoflag;
	}

	public void setJobautoflag(Character jobautoflag) {
		this.jobautoflag = jobautoflag;
	}

	public Long getMembershipSeqNo() {
		return membershipSeqNo;
	}

	public void setMembershipSeqNo(Long membershipSeqNo) {
		this.membershipSeqNo = membershipSeqNo;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public String getOnDate() {
		return onDate;
	}

	public void setOnDate(String onDate) {
		this.onDate = onDate;
	}

	public Integer getOpFlag() {
		return opFlag;
	}

	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}

	public Long getParentServiceWorkSeqNo() {
		return parentServiceWorkSeqNo;
	}

	public void setParentServiceWorkSeqNo(Long parentServiceWorkSeqNo) {
		this.parentServiceWorkSeqNo = parentServiceWorkSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getRequestSeqNo() {
		return requestSeqNo;
	}

	public void setRequestSeqNo(Long requestSeqNo) {
		this.requestSeqNo = requestSeqNo;
	}

	public Character getResAllocStatus() {
		return resAllocStatus;
	}

	public void setResAllocStatus(Character resAllocStatus) {
		this.resAllocStatus = resAllocStatus;
	}

	public Character getResDirectIndirectFlag() {
		return resDirectIndirectFlag;
	}

	public void setResDirectIndirectFlag(Character resDirectIndirectFlag) {
		this.resDirectIndirectFlag = resDirectIndirectFlag;
	}

	public Character getResautoflag() {
		return resautoflag;
	}

	public void setResautoflag(Character resautoflag) {
		this.resautoflag = resautoflag;
	}

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public ServiceWorkMaster_DTO(Long serviceWorkSeqNo, Character autoAllocStatus, Character billedflag,
			Long billingCurrencySeqNo, Long bookingSeqNo, Long createdBy, Character doneflag, Character jobAllocStatus,
			Long jobTemplateSeqNo, Character jobautoflag, Long membershipSeqNo, Character okflag, String onDate,
			Integer opFlag, Long parentServiceWorkSeqNo, Long partySeqNo, String remark, Long requestSeqNo,
			Character resAllocStatus, Character resDirectIndirectFlag, Character resautoflag, Long serviceSeqNo) {
		super();
		this.serviceWorkSeqNo = serviceWorkSeqNo;
		this.autoAllocStatus = autoAllocStatus;
		this.billedflag = billedflag;
		this.billingCurrencySeqNo = billingCurrencySeqNo;
		this.bookingSeqNo = bookingSeqNo;
		this.createdBy = createdBy;
		this.doneflag = doneflag;
		this.jobAllocStatus = jobAllocStatus;
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.jobautoflag = jobautoflag;
		this.membershipSeqNo = membershipSeqNo;
		this.okflag = okflag;
		this.onDate = onDate;
		this.opFlag = opFlag;
		this.parentServiceWorkSeqNo = parentServiceWorkSeqNo;
		this.partySeqNo = partySeqNo;
		this.remark = remark;
		this.requestSeqNo = requestSeqNo;
		this.resAllocStatus = resAllocStatus;
		this.resDirectIndirectFlag = resDirectIndirectFlag;
		this.resautoflag = resautoflag;
		this.serviceSeqNo = serviceSeqNo;
	}

	public ServiceWorkMaster_DTO() {
		super();
	}

}