package enums;

/**
 * Enum representing different states of a registration process.
 * This enum includes the following registration states:
 * - DONE: The registration process has been successfully completed.
 * - NOT_EXISTING_NUMBER: The specified phone number does not exist.
 * - INVALID_NUMBER: The provided phone number is invalid.
 * - USERNAME_EXISTS: The specified username is already taken.
 * - WRONG_CODE: The verification code provided is incorrect.
 */
public enum RegestrationStat  {
    /**
     * The registration process has been successfully completed.
     */
    DONE,

    /**
     * The specified phone number does not exist.
     */
    NOT_EXISTING_NUMBER,

    /**
     * The provided phone number is invalid.
     */
    INVALID_NUMBER,

    /**
     * The specified username is already taken.
     */
    USERNAME_EXSITS,

    /**
     * The verification code provided is incorrect.
     */
    WRONG_CODE
}
