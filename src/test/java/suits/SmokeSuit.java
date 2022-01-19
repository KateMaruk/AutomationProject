package suits;

import addresses.AddNewAddress;
import groups.AddNewGroup;
import groups.EditExistedGroup;
import logout.LogOut;
import login.LogIn;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LogIn.class,
                AddNewGroup.class,
                EditExistedGroup.class,
                AddNewAddress.class,
                LogOut.class
        }
)

public class SmokeSuit {

}
