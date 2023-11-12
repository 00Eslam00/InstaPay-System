package repository;

import java.util.function.Function;

import classes.Bill;
import enums.BillType;
import models.User;
import models.UserProvider;

abstract public class DataBaseRepo {

    abstract public Boolean addUser(User user);

    abstract public User getUser(Function<User, Boolean> func);

    abstract public Bill getBill(BillType billtype, Function<Bill, Boolean> func);

    abstract public Boolean removeBill(BillType billtype, Function<Bill, Boolean> func);

    abstract public UserProvider getUserProvider(Function<UserProvider, Boolean> func);

    abstract public Boolean updateUserProvider(UserProvider user);

}
