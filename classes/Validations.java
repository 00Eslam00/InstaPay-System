package classes;

import enums.AccountType;
import models.User;
import repository.DataBaseRepo;

public class Validations {
    public static boolean validateMobile(String mob)
    {
        for (char c: mob.toCharArray()) {
            if(!Character.isDigit(c))
                return false;
        }
        return (mob.length() == 11);
    }

    public static boolean validateMobile(String mob, AccountType accountType, DataBaseRepo db)
    {
        return db.getUserProvider(usr -> usr.mobileNum.equals(mob) && usr.accountType.equals(accountType)) != null;
    }

    public static boolean uniqueUsername(String s, DataBaseRepo db)
    {
        return db.getUser(usr -> usr.getInstaAccount().getUserName().equals(s)) == null;
    }

}
