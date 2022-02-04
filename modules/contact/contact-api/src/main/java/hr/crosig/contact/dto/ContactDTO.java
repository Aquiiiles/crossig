package hr.crosig.contact.dto;

import java.util.List;

public class ContactDTO {

    private List<AddressDTO> addressList;
    private List<SubscriptionDTO> subscriptionList;
    private GenderDTO gender;
    private List<TelephoneDTO> telephoneList;
    private LanguageDTO language;
    private ChannelTypeDTO channelType;
    private PreferredDeliveryTypeDTO preferredDeliveryType;
    private TitleDTO title;
    private List<EmailDTO> emailList;
    private ProfessionDTO profession;
    private EntityTypeDTO entityType;
    private List<IdentifierDTO> identifierList;
    private String dateOfBirth;
    private String firstName;
    private NationalityDTO nationality;
    private String name;
    private List<ConsentDTO> consentList;
    private String middleName;
    private FamilyStatusDTO familyStatus;

    public List<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDTO> addressList) {
        this.addressList = addressList;
    }

    public List<SubscriptionDTO> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<SubscriptionDTO> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public GenderDTO getGender() {
        return gender;
    }

    public void setGender(GenderDTO gender) {
        this.gender = gender;
    }

    public List<TelephoneDTO> getTelephoneList() {
        return telephoneList;
    }

    public void setTelephoneList(List<TelephoneDTO> telephoneList) {
        this.telephoneList = telephoneList;
    }

    public LanguageDTO getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }

    public ChannelTypeDTO getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelTypeDTO channelType) {
        this.channelType = channelType;
    }

    public PreferredDeliveryTypeDTO getPreferredDeliveryType() {
        return preferredDeliveryType;
    }

    public void setPreferredDeliveryType(PreferredDeliveryTypeDTO preferredDeliveryType) {
        this.preferredDeliveryType = preferredDeliveryType;
    }

    public TitleDTO getTitle() {
        return title;
    }

    public void setTitle(TitleDTO title) {
        this.title = title;
    }

    public List<EmailDTO> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<EmailDTO> emailList) {
        this.emailList = emailList;
    }

    public ProfessionDTO getProfession() {
        return profession;
    }

    public void setProfession(ProfessionDTO profession) {
        this.profession = profession;
    }

    public EntityTypeDTO getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityTypeDTO entityType) {
        this.entityType = entityType;
    }

    public List<IdentifierDTO> getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(List<IdentifierDTO> identifierList) {
        this.identifierList = identifierList;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public NationalityDTO getNationality() {
        return nationality;
    }

    public void setNationality(NationalityDTO nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConsentDTO> getConsentList() {
        return consentList;
    }

    public void setConsentList(List<ConsentDTO> consentList) {
        this.consentList = consentList;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public FamilyStatusDTO getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatusDTO familyStatus) {
        this.familyStatus = familyStatus;
    }
}
