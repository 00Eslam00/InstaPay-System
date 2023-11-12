package interfaces;

import enums.RegestrationStat;
import models.*;

public interface RegisterBehavior {
    RegestrationStat[] Register(User user);
}