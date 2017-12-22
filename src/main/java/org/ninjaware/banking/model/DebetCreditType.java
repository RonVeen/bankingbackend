package org.ninjaware.banking.model;

/**
 * Transaction type enumeration
 */
public enum DebetCreditType {
    DEBET,
    CREDIT;


    public static DebetCreditType toDebetCreditType(String type) {
        switch (type) {
            case "D" : return DEBET;
            case "C" : return CREDIT;
            default: throw new IllegalArgumentException(String.format("Illegal DebetCreditType supplied: %s", type));
        }
    }
}
