package factory;

import constants.IBrowsers;
import org.testng.annotations.Factory;
import tests.*;
import tests.Main;

public class MainFactory {

    @Factory
    public Object [] createInstances() {
        return new Object[] {

                /*new Case1(IBrowsers.CHROME, "", ""),
                new Case1(IBrowsers.FIREFOX, "", ""),
                new Case1(IBrowsers.CHROME, "78.40.87.18", "808"),*/
                new Case1(IBrowsers.FIREFOX, "78.40.87.18", "808")/*,
                new Case1(IBrowsers.CHROME, "85.93.19.57", "3128"),
                new Case1(IBrowsers.FIREFOX, "85.93.19.57", "3128"),
                new Case2(IBrowsers.CHROME, "", ""),
                new Case2(IBrowsers.FIREFOX, "", ""),
                new Case3(IBrowsers.CHROME, "", ""),
                new Case3(IBrowsers.FIREFOX, "", "")*/
        };
    }

    //@Factory
    public Object [] createInstancesTest() {
        return new Object[] {

                new Case1(IBrowsers.FIREFOX, "78.40.87.18", "808")
        };
    }
}
