package hr.crosig.contact.dto;

import java.util.List;

/**
 * @author david.martini
 */
public class ContactDTO {

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public ChannelTypeDTO getChannelType() {
		return channelType;
	}

	public List<ConsentDTO> getConsents() {
		return consents;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public List<EmailDTO> getEmails() {
		return emails;
	}

	public EntityTypeDTO getEntityType() {
		return entityType;
	}

	public FamilyStatusDTO getFamilyStatus() {
		return familyStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public GenderDTO getGender() {
		return gender;
	}

	public List<IdentifierDTO> getIdentifiers() {
		return identifiers;
	}

	public LanguageDTO getLanguage() {
		return language;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getName() {
		return name;
	}

	public NationalityDTO getNationality() {
		return nationality;
	}

	public PreferredDeliveryTypeDTO getPreferredDeliveryType() {
		return preferredDeliveryType;
	}

	public ProfessionDTO getProfession() {
		return profession;
	}

	public List<SubscriptionDTO> getSubscriptions() {
		return subscriptions;
	}

	public List<TelephoneDTO> getTelephones() {
		return telephones;
	}

	public TitleDTO getTitle() {
		return title;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public void setChannelType(ChannelTypeDTO channelType) {
		this.channelType = channelType;
	}

	public void setConsents(List<ConsentDTO> consents) {
		this.consents = consents;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}

	public void setEntityType(EntityTypeDTO entityType) {
		this.entityType = entityType;
	}

	public void setFamilyStatus(FamilyStatusDTO familyStatus) {
		this.familyStatus = familyStatus;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(GenderDTO gender) {
		this.gender = gender;
	}

	public void setIdentifiers(List<IdentifierDTO> identifiers) {
		this.identifiers = identifiers;
	}

	public void setLanguage(LanguageDTO language) {
		this.language = language;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNationality(NationalityDTO nationality) {
		this.nationality = nationality;
	}

	public void setPreferredDeliveryType(
			PreferredDeliveryTypeDTO preferredDeliveryType) {

		this.preferredDeliveryType = preferredDeliveryType;
	}

	public void setProfession(ProfessionDTO profession) {
		this.profession = profession;
	}

	public void setSubscriptions(List<SubscriptionDTO> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public void setTelephones(List<TelephoneDTO> telephones) {
		this.telephones = telephones;
	}

	public void setTitle(TitleDTO title) {
		this.title = title;
	}

	private List<AddressDTO> addresses;
	private ChannelTypeDTO channelType;
	private List<ConsentDTO> consents;
	private String dateOfBirth;
	private List<EmailDTO> emails;
	private EntityTypeDTO entityType;
	private FamilyStatusDTO familyStatus;
	private String firstName;
	private GenderDTO gender;
	private List<IdentifierDTO> identifiers;
	private LanguageDTO language;
	private String middleName;
	private String name;
	private NationalityDTO nationality;
	private PreferredDeliveryTypeDTO preferredDeliveryType;
	private ProfessionDTO profession;
	private List<SubscriptionDTO> subscriptions;
	private List<TelephoneDTO> telephones;
	private TitleDTO title;

}