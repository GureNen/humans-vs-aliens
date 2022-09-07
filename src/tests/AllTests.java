package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlienTest.class, EntityTest.class, EnvironmentTest.class, HumanTest.class })
public class AllTests {

}
