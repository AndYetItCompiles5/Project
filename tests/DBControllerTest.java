package Project.tests;

import java.util.*;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Project.*;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
 private UserUI userUI;
 private AdminUI adminUI;
 private LoginUI loginUI;
 private DBController dbcontroller;

 
 private UniversityDBLibrary dataBase = new UniversityDBLibrary("andyic","andyic","csci230");
 
 private SearchController sController;
 private HashSet<String> searchResult;
   
 @Before
 public void init(){
    userUI = new UserUI();
    adminUI = new AdminUI();
    loginUI = new LoginUI();
    dbcontroller = new DBController();
    sController = new SearchController();
    

    ArrayList<String> emphasis= new ArrayList<String>();
    searchResult = new HashSet<String>();
    searchResult.clear();
    
    // need to remove the school from the user's list of schools before testing saveSchool
    dbcontroller.removeSchool("zakluetmer", "_TESTSCHOOL");
    dataBase.university_deleteUniversity("SEXTON");
    
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
  ArrayList<String> emphasis = new ArrayList<String>();
dbcontroller.editUniversity("_TESTSCHOOL", "MMIN", "URBAN", "PRIVATE", 100000, 50, 500, 500, 100000, 90, 10000, 98, 50, 1, 1, 1, emphasis);
  
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
// }emphasis

 @Test
 public void testAddUniversity() {
  ArrayList<String> emphasis= new ArrayList<String>();
  //invalid name//
  assertTrue(dbcontroller.addUniversity("", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20, 50, 5, 5, 5, emphasis).equals("Name is required"));
  assertTrue(dbcontroller.addUniversity("ADELPHI", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20, 50, 5, 5, 5, emphasis).equals("School is already saved"));
  
  
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAddUniversityIlleaglArguments(){
  ArrayList<String> emphasis= new ArrayList<String>();
  //invalid location
  dbcontroller.addUniversity("SEXTON", "MINNESOTA", "EARTH", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20, 50, 5, 5, 5, emphasis);
  
  //invalid control
  dbcontroller.addUniversity("SEXTON", "MINNESOTA", "URBAN", "ONLINE", 100, 90, 750, 750, 10000, 90, 15000, 20, 50, 5, 5, 5, emphasis);
 }
  

 @Test
 public void testSaveSchoolFail() 
 {
   assertFalse("User does not have _TESTSCHOOL saved to their list of schools", 
               dbcontroller.getUserSavedSchools("zakluetmer").contains("_TESTSCHOOL"));
 }
 public void testSaveSchool(){
	 
   assertTrue("The school was successfully saved to the user's list of saved schools.", 
              dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL"));
 }
 public void testSaveSchoolFail2(){
   assertTrue("User's list of schools contains _TESTSCHOOL", 
              dbcontroller.getUserSavedSchools("zakluetmer").contains("_TESTSCHOOL"));
 }
 public void testSaveSchoolFail3(){
   assertTrue("The school has already been saved to the user's profile", 
              dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL"));
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

 @Test
 public void testSearchFullNameCaps() {
  searchResult = dbcontroller.search("COLORADO COLLEGE", "", "", "", -20, 100000, -20.0, 110.0, -10, 900, -10, 900, -1000, 100000, -10.0, 110.0, -100, 100000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("COLORADO COLLEGE"));
 }
 
 @Test
 public void testSearchFullName() {
  searchResult = dbcontroller.search("colorado college", "", "", "", -20, 100000, -20.0, 110.0, -10, 900, -10, 900, -1000, 100000, -10.0, 110.0, -100, 100000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("COLORADO COLLEGE"));
 }
 
 @Test
 public void testSearchPartialNameCaps() {
  searchResult = dbcontroller.search("ARIZONA ST", "", "", "", -20, 100000, -20.0, 110.0, -10, 900, -10, 900, -1000, 100000, -10.0, 110.0, -100, 100000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("ARIZONA STATE"));
 }
 
 @Test
 public void testSearchPartialName() {
  searchResult = dbcontroller.search("arizona st", "", "", "", -20, 100000, -20.0, 110.0, -10, 900, -10, 900, -1000, 100000, -10.0, 110.0, -100, 100000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("ARIZONA STATE"));
 }
 
 @Test
 public void testSearchNoneExistantName() {
  searchResult = dbcontroller.search("ZXYQU", "-1", "-1", "-1", -20, 100000, -20.0, 110.0, -10, 900, -10, 900, -1000, 100000, -10.0, 110.0, -100, 100000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.isEmpty());
 }
 
 @Test
 public void testSearchNameEmpty() {
  searchResult = dbcontroller.search(null, "", "", "", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testStateFullCaps() {
  dbcontroller.addUniversity("STATE DUMMY", "COLLEGEVILLE", "URBAN", "PRIVATE", 100, 10.0, 10, 10, 10, 10.0, 10, 10.0, 10.0, 4, 4, 4, null);
  searchResult = dbcontroller.search(null, "COLLEGEVILLE", "", "", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("STATE DUMMY"));
 }
 
 @Test
 public void testStateFull() {
  searchResult = dbcontroller.search(null, "collegeville", "", "", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("STATE DUMMY"));
 }
 
 @Test
 public void testStatePart() {
  searchResult = dbcontroller.search(null, "college", "", "", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("STATE DUMMY"));
 }
 
 @Test
 public void testStatePartCaps() {
  searchResult = dbcontroller.search(null, "COLLEGE", "", "", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.contains("STATE DUMMY"));
 }
 
 @Test
 public void testStateEmpty() {
  searchResult = dbcontroller.search(null, "-1", "-1", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationSuburbanCaps() {
  searchResult = dbcontroller.search(null, "-1", "SUBURBAN", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationSuburban() {
  searchResult = dbcontroller.search(null, "-1", "suburban", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationUrbanCaps() {
  searchResult = dbcontroller.search(null, "-1", "URBAN", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationUrban() {
  searchResult = dbcontroller.search(null, "-1", "urban", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationSmallCityCaps() {
  searchResult = dbcontroller.search(null, "-1", "SMALL-CITY", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationSmallCity() {
  searchResult = dbcontroller.search(null, "-1", "small-city", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationEmpty() {
  searchResult = dbcontroller.search(null, "-1", "-1", "-1", -20, 1000100, -20.0, 110.0, -10, 900, -10, 900, -1000, 1000100, -10.0, 110.0, -100, 1000000, -10.0, 110.0, -10.0, 110.0, -5, 10, -5, 10, -5, 10, null);
  assertTrue(searchResult.size()==188);
 }

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

 @Test
 public void testEditAccount() {
   Account account = dbcontroller.getAccount("zakluetmer");;
   
   assertTrue("Account cannot have a blank 'username' field", 
              dbcontroller.editAccount("Zak", "Luetmer", "","password",'u','Y').equals("Missing username, password, or type"));
   assertTrue("Account cannot have a blank 'password' field", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","",'u','Y').equals("Missing username, password, or type"));
   assertTrue("Account cannot have a blank 'type' field", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password",' ','Y').equals("Missing username, password, or type"));
   
   assertFalse("Account's password is not 'hello'", account.getPassword().equals("hello"));
   dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","hello",'u','Y');
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's password is 'hello'", account.getPassword().equals("hello"));
   
   assertFalse("Account's first name is not 'Virgil'", account.getFirstName().equals("Virgil"));
   dbcontroller.editAccount("Virgil", "Luetmer", "zakluetmer","password",'u','Y');
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's first name is 'Virgil'", account.getFirstName().equals("Virgil"));
   
   assertFalse("Account's last name is not 'Michael-House'", account.getLastName().equals("Michael-House"));
   dbcontroller.editAccount("Zak", "Michael-House", "zakluetmer","password",'u','Y');
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Account's password is 'Michael-House'", account.getLastName().equals("Michael-House"));
   
   assertFalse("Account's type is not 'a'", account.getType()==('a'));
   dbcontroller.editAccount("Zak", "Michael-House", "zakluetmer","password",'a','Y');
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
