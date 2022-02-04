package hr.crosig.contact.dto;

import java.util.List;

/**
 * @author david.martini
 */
public class ContactDTO {

	public List<AddressDTO> getAddressList() {
		return addressList;
	}

	public ChannelTypeDTO getChannelType() {
		return channelType;
	}

	public List<ConsentDTO> getConsentList() {
		return consentList;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public List<EmailDTO> getEmailList() {
		return emailList;
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

	public List<IdentifierDTO> getIdentifierList() {
		return identifierList;
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

	public List<SubscriptionDTO> getSubscriptionList() {
		return subscriptionList;
	}

	public List<TelephoneDTO> getTelephoneList() {
		return telephoneList;
	}

	public TitleDTO getTitle() {
		return title;
	}

	public void setAddressList(List<AddressDTO> addressList) {
		this.addressList = addressList;
	}

	public void setChannelType(ChannelTypeDTO channelType) {
		this.channelType = channelType;
	}

	public void setConsentList(List<ConsentDTO> consentList) {
		this.consentList = consentList;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmailList(List<EmailDTO> emailList) {
		this.emailList = emailList;
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

	public void setIdentifierList(List<IdentifierDTO> identifierList) {
		this.identifierList = identifierList;
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

	public void setSubscriptionList(List<SubscriptionDTO> subscriptionList) {
		this.subscriptionList = subscriptionList;
	}

	public void setTelephoneList(List<TelephoneDTO> telephoneList) {
		this.telephoneList = telephoneList;
	}

	public void setTitle(TitleDTO title) {
		this.title = title;
	}

	private List<AddressDTO> addressList;
	private ChannelTypeDTO channelType;
	private List<ConsentDTO> consentList;
	private String dateOfBirth;
	private List<EmailDTO> emailList;
	private EntityTypeDTO entityType;
	private FamilyStatusDTO familyStatus;
	private String firstName;
	private GenderDTO gender;
	private List<IdentifierDTO> identifierList;
	private LanguageDTO language;
	private String middleName;
	private String name;
	private NationalityDTO nationality;
	private PreferredDeliveryTypeDTO preferredDeliveryType;
	private ProfessionDTO profession;
	private List<SubscriptionDTO> subscriptionList;
	private List<TelephoneDTO> telephoneList;
	private TitleDTO title;

}