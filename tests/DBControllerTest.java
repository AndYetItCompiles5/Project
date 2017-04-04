package Project.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
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
 SearchController sController;
   
 @Before
 public void init(){
    userUI = new UserUI();
    adminUI = new AdminUI();
    loginUI = new LoginUI();
    dbcontroller = new DBController();
    sController = new SearchController();
    
    ArrayList<String> emphasis= new ArrayList<String>();
    
    // need to remove the school from the user's list of schools before testing saveSchool
    dbcontroller.removeSchool("zakluetmer", "_TESTSCHOOL");
    
    // reseting the info for test purposes
    dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'u', 'Y');
    
   // do we need these anymore?
   // dbcontroller.editUniversity("_TESTSCHOOL", "MMIN", "URBAN", "PRIVATE", 100000, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
   // dbcontroller.editUniversity("_TESTSCHOOL1", "MMIN", "URBAN", "PRIVATE", 100001, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
   // dbcontroller.addUniversity("_TESTSCHOOL2", "MMIN", "URBAN", "PRIVATE", 100002, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
   // dbcontroller.addUniversity("_TESTSCHOOL3", "MMIN", "URBAN", "PRIVATE", 100003, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
   // dbcontroller.addUniversity("_TESTSCHOOL4", "MMIN", "URBAN", "PRIVATE", 100004, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
   // dbcontroller.addUniversity("_TESTSCHOOL5", "MMIN", "URBAN", "PRIVATE", 100005, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testIllegalArgumentExceptions(){
  dbcontroller.getAccount("SomethingThatWillNotbeAUserName");
  dbcontroller.getUniversity("ANameOfAUniversityThatWillNotBeInTheDatabase");
  dbcontroller.getUserSavedSchools("calseth");
  dbcontroller.deactivateUser("luser");
  dbcontroller.deactivateUser("asdfasdfasdfasdf");
  
 }
 
 @Test
 public void testGetAccount() {
  Account something = dbcontroller.getAccount("zakluetmer");
  String name = something.getFirstName();
  assertTrue(name.equals("Zak"));
 }

 @Test
 public void testGetUniversity() {
  assertTrue(dbcontroller.getUniversity("_TESTSCHOOL").getLocation().equals("URBAN"));
 }

 @Test
 public void testDisplayUniversity() {
  int something = 0;
  for(int i = 0 ; i <= dbcontroller.displayUniversity("ADELPHI").size();i++){  
     something++;
  }
  assertTrue(something > 6);
  assertTrue(dbcontroller.displayUniversity("ADELPHI").get(3).equals("PRIVATE"));
  assertTrue(dbcontroller.displayUniversity("ADELPHI").get(2).equals("-1"));
 }

// @Test
// public void testEditUniversity() {
//  fail("Not yet implemented");
// }

// @Test
// public void testAddUniversity() {
//  fail("Not yet implemented");
// }

 @Test
 public void testSaveSchool() 
 {
   assertFalse("User does not have _TESTSCHOOL saved to their list of schools", 
               dbcontroller.getUserSavedSchools("zakluetmer").contains("_TESTSCHOOL"));
   assertTrue("The school was successfully saved to the user's list of saved schools.", 
              dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL").equals("School Saved!"));
   assertTrue("User's list of schools contains _TESTSCHOOL", 
              dbcontroller.getUserSavedSchools("zakluetmer").contains("_TESTSCHOOL"));
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testSaveSchoolAlreadySavedFail()
 {
   dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL");
   dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL");
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testSaveSchoolInvalidSchoolFail()
 {
   dbcontroller.saveSchool("zakluetmer", "NotASchool");
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testSaveSchoolInvalidUserFail()
 {
   dbcontroller.saveSchool("LakZuetmer", "_TESTSCHOOL");
 }
 
 @Test
 public void testGetUserSavedSchools() {
  dbcontroller.saveSchool("zakluetmer", "QUEENS");
  assertTrue(dbcontroller.getUserSavedSchools("zakluetmer").contains("QUEENS"));
 }

 @Test
 public void testGetAllUniversities() {
  ArrayList<String> testingSize = new ArrayList<String>();
  testingSize = dbcontroller.getAllUniversities();
  assertTrue(testingSize.size() > 50);
 }

//nathan @Test
// public void testSearch() {
//  fail("Not yet implemented");
// }

//TJ @Test
 //public void testIsWithinRange() {
//  fail("Not yet implemented");
// }

 @Test
 public void testRemoveSchool() {
  dbcontroller.saveSchool("calseth", "QUEENS");
  dbcontroller.removeSchool("calseth", "QUEENS");
  ArrayList<String> temp = dbcontroller.getUserSavedSchools("zakluetmer");
  assertTrue(!temp.get(0).equals("QUEENS"));
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testRemoveSchoolFail(){
  dbcontroller.removeSchool("Not a user", "School");
 }

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

//zak @Test
// public void testAddAccount() {
//  fail("Not yet implemented");
// }

 @Test
 public void testIsUsernameTaken() {
  assertTrue(dbcontroller.isUsernameTaken("zakluetmer") == true);
  assertTrue(dbcontroller.isUsernameTaken("AUserNameThatNoOneWillHave") == false);
 }

 @Test (expected=IllegalArgumentException.class)
 public void testEditAccountEmptyUsernameFail() {
   dbcontroller.editAccount("Zak", "Luetmer", "","password",'u','Y');
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testEditAccountEmptyPasswordFail() {
   dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","",'u','Y');
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testEditAccountEmptyTypeFail() {
   dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password",' ','Y');
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testEditAccountEmptyStatusFail() {
   dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password",'u',' ');
 }
 
 @Test
 public void testEditAccountPassword() {
   Account account = dbcontroller.getAccount("zakluetmer");
   
   assertFalse("Account's password is not 'hello'", account.getPassword().equals("hello"));
   assertTrue("Accounts password was successfully changed", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","hello",'u','Y').equals("Edit Successful!"));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's password is 'hello'", account.getPassword().equals("hello"));
 }
 
 @Test
 public void testEditAccountFirstName() {
   Account account = dbcontroller.getAccount("zakluetmer");
   
   assertFalse("Account's first name is not 'Virgil'", account.getFirstName().equals("Virgil"));
   assertTrue("Accounts last name was successfully changed", 
              dbcontroller.editAccount("Virgil", "Luetmer", "zakluetmer","password",'u','Y').equals("Edit Successful!"));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's first name is 'Virgil'", account.getFirstName().equals("Virgil"));
 }
 
 @Test
 public void testEditAccountLastName() {
   Account account = dbcontroller.getAccount("zakluetmer");
   
   assertFalse("Account's last name is not 'Michael-House'", account.getLastName().equals("Michael-House"));
   assertTrue("Accounts last name was successfully changed", 
              dbcontroller.editAccount("Zak", "Michael-House", "zakluetmer","password",'u','Y').equals("Edit Successful!"));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's password is 'Michael-House'", account.getLastName().equals("Michael-House"));
 }
 
 @Test
 public void testEditAccountType() {
   Account account = dbcontroller.getAccount("zakluetmer");
   
   assertFalse("Account's type is not 'a'", account.getType()==('a'));
      assertTrue("Accounts last name was successfully changed", 
                 dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password",'a','Y').equals("Edit Successful!"));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's type is 'a'", account.getType()==('a'));   
 }

 @Test
 public void testIsDeactivated() {
  assertTrue(dbcontroller.isDeactivated("zakluetmer") == false);
  assertTrue(dbcontroller.isDeactivated("luser"));
 }

 @Test
 public void testDeactivateUser() {
  dbcontroller.editAccount("Lynn", "User", "luser", "user", 'u', 'Y');
  dbcontroller.deactivateUser("luser");
  assertTrue(dbcontroller.isDeactivated("luser"));
  
  
 }

 @Test //get from search controller
 public void testFindRecommendations() {
  
   ArrayList<String> listRecs = dbcontroller.findRecommendations("_TESTSCHOOL");
   
   assertTrue("The first reccomended school for _TESTSCHOOL is '_TESTSCHOOL1'",  listRecs.get(0).equals("_TESTSCHOOL1"));
   assertTrue("The second reccomended school for _TESTSCHOOL is '_TESTSCHOOL2'", listRecs.get(1).equals("_TESTSCHOOL2"));
   assertTrue("The third reccomended school for _TESTSCHOOL is '_TESTSCHOOL3'",  listRecs.get(2).equals("_TESTSCHOOL3"));
   assertTrue("The fourth reccomended school for _TESTSCHOOL is '_TESTSCHOOL4'", listRecs.get(3).equals("_TESTSCHOOL4"));
   assertTrue("The fifth reccomended school for _TESTSCHOOL is '_TESTSCHOOL5'",  listRecs.get(4).equals("_TESTSCHOOL5"));
 }
}
