package hr.crosig.proposal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Guilherme Kfouri
 */
public class ProposalDTO {

	public long getAgentUserId() {
		return _agentUserId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public String getExternalProposalNumber() {
		return _externalProposalNumber;
	}

	public String getInsuredObjectExtNumber() {
		return _insuredObjectExtNumber;
	}

	public String getOrigin() {
		return _origin;
	}

	public List<PolicyCoverageOptionDTO> getPolicyCoverageOptions() {
		return _policyCoverageOptions;
	}

	public String getPolicyHolderExtNumber() {
		return _policyHolderExtNumber;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public PolicyOptionsDTO getPolicyOptions() {
		return _policyOptions;
	}

	public List<ProposalContactDTO> getProposalContacts() {
		return _proposalContacts;
	}

	public long getProposalId() {
		return _proposalId;
	}

	public String getStatus() {
		return _status;
	}

	public long getUserId() {
		return _userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setAgentUserId(long agentUserId) {
		_agentUserId = agentUserId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setExternalProposalNumber(String externalProposalNumber) {
		_externalProposalNumber = externalProposalNumber;
	}

	public void setInsuredObjectExtNumber(String insuredObjectExtNumber) {
		_insuredObjectExtNumber = insuredObjectExtNumber;
	}

	public void setOrigin(String origin) {
		_origin = origin;
	}

	public void setPolicyCoverageOptions(
		List<PolicyCoverageOptionDTO> policyCoverageOptions) {

		_policyCoverageOptions = policyCoverageOptions;
	}

	public void setPolicyHolderExtNumber(String policyHolderExtNumber) {
		_policyHolderExtNumber = policyHolderExtNumber;
	}

	public void setPolicyOptions(PolicyOptionsDTO policyOptions) {
		_policyOptions = policyOptions;
	}

	public void setProposalContacts(List<ProposalContactDTO> proposalContacts) {
		_proposalContacts = proposalContacts;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private long _agentUserId;
	private long _companyId;
	private String _externalProposalNumber;
	private String _insuredObjectExtNumber;
	private String _origin;
	private List<PolicyCoverageOptionDTO> _policyCoverageOptions;
	private String _policyHolderExtNumber;
	private PolicyOptionsDTO _policyOptions;
	private List<ProposalContactDTO> _proposalContacts;
	private long _proposalId;
	private String _status;
	private long _userId;
	private String _userName;

}