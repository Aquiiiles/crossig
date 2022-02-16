package hr.crosig.proposal.ws;

import hr.crosig.proposal.model.Product;
import hr.crosig.proposal.service.ProductLocalService;
import hr.crosig.proposal.ws.util.ApplicationUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author david.martini
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/proposal",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Proposal.Rest",
                JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class ProductApplication extends Application {

    @GET
    @Path("/products/{roleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@PathParam("roleId") long roleId) {
        try {
            List<Product> products = _productLocalService.getProducts(roleId);

            return ApplicationUtilities.handleSuccessResponse(products);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

    @Reference
    private ProductLocalService _productLocalService;

}


