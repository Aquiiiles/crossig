package hr.crosig.proposal.rest.application.enums;

/**
 * @author victor.catanante
 */
public enum InsuredRole {
    POLICY_HOLDER("Policy Holder"), INSURED("Insured"), PAYER("Payer");

    private final String _title;

    InsuredRole(String title) {
        this._title = title;
    }
}