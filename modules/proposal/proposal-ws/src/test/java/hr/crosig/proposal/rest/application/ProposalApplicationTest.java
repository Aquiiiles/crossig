package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.dto.InsuredRoleDTO;
import hr.crosig.proposal.rest.application.utils.TestConstants;
import hr.crosig.proposal.service.InsuredRoleLocalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.core.Response;
import java.util.Collections;

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

        Mockito.when(_insuredRoleLocalService.getAllInsuredRole()).thenReturn(Collections.singletonList(_insuredRoleDTO));

        Response response = _proposalApplication.getInsuredRoles();

        Assert.assertEquals(
                TestConstants.API_SUCCESS_STATUS_CODE, response.getStatus());
        Assert.assertEquals(Collections.singletonList(_insuredRoleDTO), response.getEntity());
    }

    @InjectMocks
    private final ProposalApplication _proposalApplication =
            new ProposalApplication();

    @Mock
    private InsuredRoleDTO _insuredRoleDTO;

    @Mock
    private InsuredRoleLocalService _insuredRoleLocalService;
}