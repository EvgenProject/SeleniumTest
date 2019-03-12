package factory;

import constants.IBrowsers;
import org.testng.annotations.Factory;
import tests.Case1;
import tests.Case2;
import tests.Main;

public class MainFactory {

    @Factory
    public Object [] createInstances() {
        return new Object[] {

                new Case1(IBrowsers.chrome, "", ""),
                new Case1(IBrowsers.firefox, "", ""),
                new Case1(IBrowsers.chrome, "78.40.87.18", "808"),
                new Case1(IBrowsers.firefox, "78.40.87.18", "808"),
                new Case1(IBrowsers.chrome, "194.25.1.196", "3128"),
                new Case1(IBrowsers.firefox, "194.25.1.196", "3128"),
                new Case2(IBrowsers.chrome, "", ""),
                new Case2(IBrowsers.firefox, "", "")
        };
    }

    //@Factory
    public Object [] createInstancesTest() {
        return new Object[] {

                /*new Main(IBrowsers.chrome, "", ""),
                new Main(IBrowsers.firefox, "", ""),*/
                new Main(IBrowsers.chrome, "78.40.87.18", "808"),
                new Main(IBrowsers.firefox, "78.40.87.18", "808")/*,
                new Main(IBrowsers.chrome, "194.25.1.196", "3128"),
                new Main(IBrowsers.firefox, "194.25.1.196", "3128")*/
        };
    }
}
