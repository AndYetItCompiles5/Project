package Project.tests;

import static org.junit.Assert.*;

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
		fail("Not yet implemented");
	}

//del	@Test
//	public void testWrongLoginInfoError() {
//		fail("Not yet implemented");
//	}

//del	@Test
//	public void testDeactivateError() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetAllUniversities() {
		fail("Not yet implemented");
	}

//nathan	@Test
//	public void testSearch() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsWithinRange() {
		fail("Not yet implemented");
	}

//del	@Test
///	public void testConfirm() {
//		fail("Not yet implemented");
//	}

//zak	@Test
	//public void testRemoveSchool() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsSchoolSaved() {
		fail("Not yet implemented");
	}

//del	@Test
//	public void testAlreadySavedError() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

//zak	@Test
//	public void testAddAccount() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsUsernameTaken() {
		fail("Not yet implemented");
	}

//del	@Test
//	public void testUserAlreadyTakenError() {
//		fail("Not yet implemented");
//	}

//del		@Test
//	public void testUserNotCompleteError() {
	//	fail("Not yet implemented");
//	}

//colton	@Test
//	public void testEditAccount() {
//		fail("Not yet implemented");
//	}

//del	@Test
//	public void testConfirmationMessage() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsDeactivated() {
		fail("Not yet implemented");
	}

//tj	@Test
//	public void testDeactivateUser() {
//		fail("Not yet implemented");
//	}

//del	@Test
//	public void testAlreadyDeactivatedError() {
//		fail("Not yet implemented");
//	}

	@Test //get from serach contolre
	public void testFindRecommendations() {
		fail("Not yet implemented");
	}

}
