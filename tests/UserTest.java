package Project.tests;
import Project.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	 private User user;
	 private DBController dbController;
	@Before
	public void init(){
		  dbController = new DBController();
		  user = new User("Person","2","person2","password");
		  
	}

	@Test
	public void testGetSavedSchools() {
		user.addNewUniversity("ADEPHI");
		assertTrue(user.getSavedSchools().contains("ADELPHI"));
	}

	@Test
	public void testAddNewUniversity() {
		assertTrue(user.addNewUniversity("QUEENS"));
		}
	
	@Test
	public void testAddNewUniversityFail() {
		user.addNewUniversity("QUEENS");
		assertFalse(user.addNewUniversity("QUEENS"));
		}

	//@Test
	//public void testRemoveSchool() {
	////	dbController.saveSchool("calseth", "QUEENS");
	//	dbController.removeSchool("calseth", "QUEENS");
	//	ArrayList<String> temp = dbController.getUserSavedSchools("zakluetmer");
	//	assertTrue(!temp.get(0).equals("QUEENS"));
	//}

}
