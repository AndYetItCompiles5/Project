package Project.tests;
import Project.*;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	 private UserUI userUI;
	 private AdminUI adminUI;
	 private LoginUI loginUI;
	  
	@Before
	public void init(){
		  UserUI userUI = new UserUI();
		  AdminUI adminUI = new AdminUI();
		  LoginUI loginUI = new LoginUI();
		
	}
	
	@Test
	public void testUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSavedSchools() {

	}

	@Test
	public void testAddNewUniversity() {
		fail("Not yet implemented");
		}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeactivate() {
		fail("Not yet implemented");
	}

}
