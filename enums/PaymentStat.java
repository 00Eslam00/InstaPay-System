package enums;

/**
 * Enum representing different states of a payment transaction.
 * This enum includes the following payment states:
 * - DONE: The payment has been successfully completed.
 * - NOT_ENOUGH_MONEY: There are insufficient funds to complete the payment.
 * - NOT_FOUND_ACCOUNT: The specified account for the payment could not be found.
 * - NOT_FOUND_PROVIDER: The specified payment provider could not be found.
 * - WRONG_PROVIDER: The wrong payment provider was used for the transaction.
 */
public enum PaymentStat {
    /**
     * The payment has been successfully completed.
     */
    DONE,

    /**
     * There are insufficient funds to complete the payment.
     */
    NOT_ENOUGH_MONEY,

    /**
     * The specified account for the payment could not be found.
     */
    NOT_FOUND_ACCOUNT,

    /**
     * The specified payment provider could not be found.
     */
    NOT_FOUND_PROVIDER,

    /**
     * The wrong payment provider was used for the transaction.
     */
    WRONG_PROVIDER
}
