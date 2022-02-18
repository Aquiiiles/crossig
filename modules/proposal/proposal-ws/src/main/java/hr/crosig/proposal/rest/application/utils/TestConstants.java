package hr.crosig.proposal.rest.application.utils;

import hr.crosig.proposal.enums.InsuredRole;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

/**
 * @author victor.catanante
 */
public abstract class TestConstants {

	public static final int API_SUCCESS_STATUS_CODE =
		Response.Status.OK.getStatusCode();

	public static final List<InsuredRole> insuredRolesResponse = Arrays.asList(
		InsuredRole.values());

}