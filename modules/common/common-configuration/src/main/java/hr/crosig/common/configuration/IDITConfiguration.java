package hr.crosig.common.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author david.martini
 */
@ExtendedObjectClassDefinition(category = "agent-portal")
@Meta.OCD(
	id = IDITConfiguration.IDIT_CONFIGURATION_ID,
	localization = "content/Language.properties", name = "IDIT"

)
public interface IDITConfiguration {

	public static final String IDIT_CONFIGURATION_ID =
		"hr.crosig.common.configuration.IDITConfiguration";

	@Meta.AD(deflt = "https://demo3197060.mockable.io/",required = true)
	public String hostURL();

	@Meta.AD(deflt = "", required = false)
	public String oAuth2ClientSecret();

	@Meta.AD(deflt = "", required = false)
	public String oAuth2ClientID();

	@Meta.AD(
		deflt = "", description = "",
		name = "OAuth Token URL", required = false
	)
	public String getOauth2TokenURL();

	@Meta.AD(
		deflt = "", description = "",
		name = "OAuth Grant Type", required = false
	)
	public String getOAuth2GrantType();

	@Meta.AD(deflt = "", required = false)
	public String accessToken();

	@Meta.AD(
		deflt = "Basic", name = "authentication-type",
		optionLabels = {"Basic", "OAuth2"}, optionValues = {"Basic", "OAuth2"},
		required = false
	)
	public String authenticationType();

}