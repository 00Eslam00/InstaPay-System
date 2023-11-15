package enums;

/**
 * Enum representing different states of a billing transaction.
 * This enum includes the following billing states:
 * - PAID: The bill has been successfully paid.
 * - NOT_ENOUGH_MONEY: There are insufficient funds to pay the bill.
 * - NOT_FOUND_BILL: The specified bill could not be found.
 */
public enum BillStat {
    /**
     * The bill has been successfully paid.
     */
    PAID,

    /**
     * There are insufficient funds to pay the bill.
     */
    NOT_ENOUGH_MONEY,

    /**
     * The specified bill could not be found.
     */
    NOT_FOUND_BILL
}
