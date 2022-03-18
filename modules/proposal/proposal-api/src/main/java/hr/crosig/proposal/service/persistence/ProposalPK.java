/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalPK implements Comparable<ProposalPK>, Serializable {

	public long proposalId;
	public long agentUserId;

	public ProposalPK() {
	}

	public ProposalPK(long proposalId, long agentUserId) {
		this.proposalId = proposalId;
		this.agentUserId = agentUserId;
	}

	public long getProposalId() {
		return proposalId;
	}

	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}

	public long getAgentUserId() {
		return agentUserId;
	}

	public void setAgentUserId(long agentUserId) {
		this.agentUserId = agentUserId;
	}

	@Override
	public int compareTo(ProposalPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (proposalId < pk.proposalId) {
			value = -1;
		}
		else if (proposalId > pk.proposalId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (agentUserId < pk.agentUserId) {
			value = -1;
		}
		else if (agentUserId > pk.agentUserId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProposalPK)) {
			return false;
		}

		ProposalPK pk = (ProposalPK)object;

		if ((proposalId == pk.proposalId) && (agentUserId == pk.agentUserId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, proposalId);
		hashCode = HashUtil.hash(hashCode, agentUserId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("proposalId=");

		sb.append(proposalId);
		sb.append(", agentUserId=");

		sb.append(agentUserId);

		sb.append("}");

		return sb.toString();
	}

}