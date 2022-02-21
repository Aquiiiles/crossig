package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.dto.InsuredRoleDTO;
import hr.crosig.proposal.rest.application.utils.TestConstants;
import hr.crosig.proposal.service.InsuredRoleLocalService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

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

    @Before
    public void setUp() {
        _injectMocks();
    }

    private void _injectMocks() {
        Whitebox.setInternalState(
                _proposalApplication, "_insuredRoleLocalService", _insuredRoleLocalService);
    }

    @Test
    public void getInsuredRoles_ApiSuccess() {

        Mockito.when(_insuredRoleLocalService.getAllInsuredRole()).thenReturn(Collections.singletonList(createInsuredRoleMock()));

        Response response = _proposalApplication.getInsuredRoles();

        Assert.assertEquals(
                TestConstants.API_SUCCESS_STATUS_CODE, response.getStatus());
        Assert.assertEquals(Collections.singletonList(createInsuredRoleMock()), response.getEntity());
    }

    private InsuredRoleDTO createInsuredRoleMock(){
        InsuredRoleDTO insuredRoleDTO = new InsuredRoleDTO(
                1,"titleTest","nameTest","externalId"
        );
        return insuredRoleDTO;
    }

    private final ProposalApplication _proposalApplication =
            new ProposalApplication();

    @Mock
    private InsuredRoleLocalService _insuredRoleLocalService;
}