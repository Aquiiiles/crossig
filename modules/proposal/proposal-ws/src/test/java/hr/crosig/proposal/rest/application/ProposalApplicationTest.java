package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.rest.application.utils.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.core.Response;

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
        Response response = _proposalApplication.getInsuredRoleTypes();

        Assert.assertEquals(TestConstants.API_SUCCESS_STATUS_CODE, response.getStatus());
        Assert.assertEquals(TestConstants.INSURED_ROLES_RESPONSE, response.getEntity());
    }

    private final ProposalApplication _proposalApplication = new ProposalApplication();
}