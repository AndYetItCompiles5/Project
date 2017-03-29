package Project.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountControllerTest.class, AccountTest.class, AdminFuncControllerTest.class,
		DBControllerTest.class, SearchControllerTest.class, UniversityControllerTest.class, UniversityTest.class,
		UserFuncControllerTest.class, UserTest.class })
public class AllTests {

}
