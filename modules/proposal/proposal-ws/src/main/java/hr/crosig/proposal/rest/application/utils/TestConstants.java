package hr.crosig.proposal.rest.application.utils;

import hr.crosig.proposal.rest.application.enums.InsuredRole;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

/**
 * @author victor.catanante
 */
public abstract class TestConstants {

    public static final List<InsuredRole> INSURED_ROLES_RESPONSE = Arrays.asList(InsuredRole.values());

    public static final int API_SUCCESS_STATUS_CODE =
            Response.Status.OK.getStatusCode();
}