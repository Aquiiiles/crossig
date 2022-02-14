package hr.crosig.proposal.rest.enums;

/**
 * @author victor.catanante
 */
public enum InsuredRole {
    POLICY_HOLDER("Policy Holder"), INSURED("Insured"), PAYER("Payer");

    private final String _title;

    InsuredRole(String title) {
        this._title = title;
    }
    
    public String getTitle() {
        return _title;
    }
}