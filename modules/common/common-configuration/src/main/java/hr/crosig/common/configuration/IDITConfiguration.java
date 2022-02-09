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

	@Meta.AD(deflt = "https://demo3197060.mockable.io/")
	public String hostURL();

	@Meta.AD(deflt = "", required = false)
	public String oAuth2ClientSecret();

	@Meta.AD(deflt = "", required = false)
	public String oAuth2ClientID();

	@Meta.AD(
		deflt = "", description = "", name = "OAuth Token URL", required = false
	)
	public String getOauth2TokenURL();

	@Meta.AD(
		deflt = "", description = "", name = "OAuth Grant Type",
		required = false
	)
	public String getOAuth2GrantType();

	@Meta.AD(deflt = "", required = false)
	public String accessToken();

	@Meta.AD(
		deflt = "CUSTOM", name = "authentication-type",
		optionLabels = {"Basic", "Custom", "OAuth2"},
		optionValues = {"BASIC", "CUSTOM", "OAUTH"}, required = false
	)
	public String authenticationType();

	@Meta.AD(
		deflt = "EXTERNAL", name = "service-source",
		optionLabels = {"EXTERNAL", "MOCK"},
		optionValues = {"EXTERNAL", "MOCK"}, required = false
	)
	public String getSource();

	@Meta.AD(deflt = "", required = false)
	public String headerUserName();

	@Meta.AD(deflt = "", required = false)
	public String headerPassword();

}