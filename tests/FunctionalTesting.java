package Project.tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.*;

import Project.*;

public class FunctionalTesting {

	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	private HashSet<String> searchResult;
	
	@Before
	public void init(){
		userUI = new UserUI();
		adminUI = new AdminUI();
		loginUI = new LoginUI();
		HashSet<String> searchResult = new HashSet<String>();
		userUI.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'U', 'Y');
	}
	@Test
	public void testLogin() {
		Assert.assertTrue(loginUI.Login("zakluetmer","password"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginWrongUsername(){
		loginUI.Login("asdf", "password");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginWrongPassword(){
		loginUI.Login("zakluetmer", "asdf");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginDeactivated(){
		loginUI.Login("calseth", "password");
	}
	
	@Test
	public void testSearch(){
		searchResult = userUI.search("colorado college", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
		assertTrue(searchResult.contains("COLORADO COLLEGE"));
		  assertTrue(searchResult.size()==1);
	}
	
	@Test
	 public void testGetUserSavedSchools() {
	  userUI.saveSchool("zakluetmer", "_TESTSCHOOL");
	  assertTrue(userUI.viewSavedSchools("zakluetmer").contains("_TESTSCHOOL"));
	 }
	
	@Test
	public void testEditProfile(){
		assertTrue(userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "password", 'U', 'Y'));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEditProfileBadType(){
		userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "password", 'F', 'Y');
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEditProfileBadStatus(){
		userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "password", 'U', 'F');
	}

}
