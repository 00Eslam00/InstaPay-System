package repository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.function.Function;
import classes.Bill;
import classes.ElectricityBill;
import classes.GasBill;
import classes.WaterBill;
import enums.AccountType;
import enums.BillType;
import models.User;
import models.UserProvider;

/**
 * Implementation of a simple in-memory database for user and bill information.
 * The database contains dummy data for testing purposes.
 */
public class DataBaseV1 extends DataBaseRepo {

    private LinkedList<Bill> dummyGasBill = new LinkedList<Bill>();
    private LinkedList<Bill> dummyElectricityBills = new LinkedList<Bill>();
    private LinkedList<Bill> dummyWaterBillBills = new LinkedList<Bill>();
    private LinkedList<User> dummyUsers = new LinkedList<User>();
    private LinkedList<UserProvider> dummyUsersProvider = new LinkedList<UserProvider>();

    private static DataBaseV1 db = null;

    /**
     * Gets the singleton instance of the database.
     *
     * @return The singleton instance of the database.
     */
    public static DataBaseV1 getDB() {
        if (db == null) {
            db = new DataBaseV1();
        }

        return db;
    }

    private DataBaseV1() {

        dummyGasBill.add(new GasBill(122, "01112345678", LocalDateTime.of(2022, 11, 2, 11, 12)));

        dummyElectricityBills.add(new ElectricityBill(322, "01212345678", LocalDateTime.of(2022, 11, 2, 11, 12)));

        dummyWaterBillBills.add(new WaterBill(123, "01012345678", LocalDateTime.of(2022, 11, 2, 11, 12)));

        dummyUsersProvider.add(new UserProvider("01212345678", AccountType.BANK, 3000));
        dummyUsersProvider.add(new UserProvider("01012345678", AccountType.WALLET, 300));
        dummyUsersProvider.add(new UserProvider("01012335678", AccountType.WALLET, 600));
        dummyUsersProvider.add(new UserProvider("01012335679", AccountType.WALLET, 700));
        dummyUsersProvider.add(new UserProvider("01112345678", AccountType.BANK, 1000));

        dummyUsers.add(new User("01212345678", "test", AccountType.BANK, "ayhaga@gmail.com", "password"));
        dummyUsers.add(new User("01012335678", "test3", AccountType.WALLET, "ayhaga1@gmail.com", "password"));

        dummyUsers
                .add(new User("01012345678", "test2", AccountType.WALLET, "ayhaga2@gmail.com", "password2"));

    }

    @Override
    public Boolean addUser(User user) {
        if (user == null)
            return false;

        dummyUsers.add(user);
        return true;
    }

    @Override
    public User getUser(Function<User, Boolean> func) {
        for (User user : dummyUsers) {
            if (func.apply(user))
                return user;
        }
        return null;
    }

    @Override
    public Bill getBill(BillType billtype, Function<Bill, Boolean> func) {
        LinkedList<Bill> dummyBills = null;

        switch (billtype) {
            case WATER:
                dummyBills = dummyWaterBillBills;
                break;
            case ELECTRICITY:
                dummyBills = dummyElectricityBills;
                break;
            case GAS:
                dummyBills = dummyGasBill;
                break;
            default:
                break;
        }

        for (Bill bill : dummyBills) {
            if (func.apply(bill))
                return bill;
        }
        return null;
    }

    @Override
    public Boolean removeBill(BillType billtype, Function<Bill, Boolean> func) {

        LinkedList<Bill> dummyBills = null;

        switch (billtype) {
            case WATER:
                dummyBills = dummyWaterBillBills;
                break;
            case ELECTRICITY:
                dummyBills = dummyElectricityBills;
                break;
            case GAS:
                dummyBills = dummyGasBill;
                break;
            default:
                break;
        }
        for (int i = 0; i < dummyBills.size(); i++) {
            if (func.apply(dummyBills.get(i))) {
                dummyBills.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public UserProvider getUserProvider(Function<UserProvider, Boolean> func) {
        for (UserProvider usp : dummyUsersProvider) {
            if (func.apply(usp))
                return usp;
        }
        return null;
    }

    @Override
    public Boolean updateUserProvider(UserProvider user) {
        for (int i = 0; i < dummyUsersProvider.size(); i++) {
            if (user.mobileNum.equals(dummyUsersProvider.get(i).mobileNum)) {
                dummyUsersProvider.remove(i);
                dummyUsersProvider.add(user);
                return true;
            }
        }
        return false;
    }

}
