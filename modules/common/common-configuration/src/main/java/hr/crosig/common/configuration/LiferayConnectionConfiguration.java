package hr.crosig.common.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Leonardo Miyagi
 */
@ExtendedObjectClassDefinition(category = "agent-portal")
@Meta.OCD(
	id = LiferayConnectionConfiguration.LIFERAY_CONNECTION,
	localization = "content/Language", name = "Liferay Connection"
)
public interface LiferayConnectionConfiguration {

	public static String LIFERAY_CONNECTION =
		"hr.crosig.common.configuration.LiferayConnectionConfiguration";

	@Meta.AD(
		deflt = "dGVzdEBsaWZlcmF5LmNvbTp0ZXN0", description = "",
		name = "Auth Token", required = false
	)
	public String getAccessToken();

	@Meta.AD(
		deflt = "Basic", description = "", name = "Auth Type", required = false
	)
	public String getAuthType();

	@Meta.AD(
		deflt = "http://localhost:8080", description = "", name = "Host",
		required = false
	)
	public String getHost();

	@Meta.AD(
		deflt = "id-b69df217-6aad-5b61-877b-0c6915fa9e0", description = "",
		name = "OAuth Client ID", required = false
	)
	public String getOAuthClientId();

	@Meta.AD(
		deflt = "secret-65f6cc75-4578-885c-963c-77894cc7604d", description = "",
		name = "OAuth Client Secret", required = false
	)
	public String getOAuthClientSecret();

	@Meta.AD(
		deflt = "/o/oauth2/token", description = "", name = "OAuth Token URL",
		required = false
	)
	public String getOauth2TokenURL();

}