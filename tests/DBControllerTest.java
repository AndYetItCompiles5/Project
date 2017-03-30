package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Project.*;

public class DBControllerTest {
	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	private DBController dbcontroller;
	  
	@Before
	public void init(){
		  userUI = new UserUI();
		  adminUI = new AdminUI();
		  loginUI = new LoginUI();
		  dbcontroller = new DBController();
	}
	@Test
	public void testGetAccount() {
		Account something = dbcontroller.getAccount("calseth");
		String name = something.getFirstName();
		assertTrue(name.equals("NotColton"));
	}

	@Test
	public void testGetUniversity() {
		assertTrue(dbcontroller.getUniversity("ADELPHI").getState().equals("NEW YORK"));
	}

	@Test
	public void testDisplayUniversity() {
		int something = 0;
		for(int i = 0 ; i <= dbcontroller.displayUniversity("ADELPHI").size();i++){		
					something++;
		}
		assertTrue(something > 6);
	}

//	@Test
//	public void testEditUniversity() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testAddUniversity() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSaveSchool() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetUserSavedSchools() {
		assertTrue(dbcontroller.getUserSavedSchools("zakluetmer").contains("QUEENS"));
	}

	@Test
	public void testIsUsername() {
		assertTrue(dbcontroller.isUsername("zakluetmer") == true);
	}

	@Test
	public void testGetAllUniversities() {
		ArrayList<String> testingSize = new ArrayList<String>();
		testingSize = dbcontroller.getAllUniversities();
		assertTrue(testingSize.size() > 50);
	}

//nathan	@Test
//	public void testSearch() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsWithinRange() {
		fail("Not yet implemented");
	}

//zak	@Test
	//public void testRemoveSchool() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsSchoolSaved() {
		assertTrue(dbcontroller.isSchoolSaved("ADELPHI"));
		assertTrue(dbcontroller.isSchoolSaved("asdfasdfsfasfasd")== false);
	}

	@Test
	public void testGetAllUsers() {
		String[][] testing = dbcontroller.getAllUsers();
		assertTrue(testing.length >= 6);
	}

//zak	@Test
//	public void testAddAccount() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsUsernameTaken() {
		assertTrue(dbcontroller.isUsername("zakluetmer") == true); //is there a difference in this method and tisUsername method???
	}

//colton	@Test
//	public void testEditAccount() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsDeactivated() {
		assertTrue(dbcontroller.isDeactivated("zakluetmer") == false);
		assertTrue(dbcontroller.isDeactivated("calseth"));
	}

//tj	@Test
//	public void testDeactivateUser() {
//		fail("Not yet implemented");
//	}

	@Test //get from serach contolre
	public void testFindRecommendations() {
		fail("Not yet implemented");
	}

}
