package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.rest.application.utils.TestConstants;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author victor.catanante
 */
@PrepareForTest(
	fullyQualifiedNames = "hr/crosig/proposal/rest/application/ProposalApplication"
)
@RunWith(PowerMockRunner.class)
public class ProposalApplicationTest {

	@Test
	public void getInsuredRoles_ApiSuccess() {
		Response response = _proposalApplication.getInsuredRole();

		Assert.assertEquals(
			TestConstants.API_SUCCESS_STATUS_CODE, response.getStatus());
		Assert.assertEquals(
			TestConstants.insuredRolesResponse, response.getEntity());
	}

	private final ProposalApplication _proposalApplication =
		new ProposalApplication();

}