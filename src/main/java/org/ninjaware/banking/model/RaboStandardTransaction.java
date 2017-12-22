package org.ninjaware.banking.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Standard Rabobank transaction defintion
 */
@Document(collection = "transaction")
public class RaboStandardTransaction extends BaseTransaction {

    private String accountNumber;               //  Own account number in IBAN format
    private String currency;                    //  Currency code
    private LocalDate interestDate;
    private DebetCreditType debetCreditType;    //  Debet or credit
    private Double amount;                      //  Amount in 2 decimals
    private String offsetAccount;               //  Contra account
    private String accountName;                 //  Name of the offset account
    private String transactionType;             //  Transaction type
    private String description1;                //  Optional descriptions 1 to 6
    private String description2;
    private String description3;
    private String description4;
    private String description5;
    private String description6;

    private String sepaId;                      //  Sepa Credit transfer transaction id
    private String sepaOffsetAccount;           //  Sepa Credit transfer contra account
    private String sepaMandate;                 //  Sepa Debet direct authorization id

}
