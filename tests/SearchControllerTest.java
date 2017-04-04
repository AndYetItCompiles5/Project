package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;


import Project.SearchController;

public class SearchControllerTest {

 SearchController sController;
 
 @Before
 public void init()
 {
  sController = new SearchController();
 }
 
 /* still need to do this
 @Test
 public void testSearch()
 {
  fail("Not yet implemented");
 }
 */
 
 @Test (expected = IllegalArgumentException.class)
 public void testFindReccomendationsFail()
 {
  sController.findRecommendations("South Harmon Institute of Technology");
 }
 
 @Test
 public void testFindRecommendations()
 {
ArrayList<String> listRecs = sController.findRecommendations("_TESTSCHOOL");
   
   assertTrue("The first reccomended school for _TESTSCHOOL is '_TESTSCHOOL1'",  listRecs.get(0).equals("_TESTSCHOOL1"));
   assertTrue("The second reccomended school for _TESTSCHOOL is '_TESTSCHOOL2'", listRecs.get(1).equals("_TESTSCHOOL2"));
   assertTrue("The third reccomended school for _TESTSCHOOL is '_TESTSCHOOL3'",  listRecs.get(2).equals("_TESTSCHOOL3"));
   assertTrue("The fourth reccomended school for _TESTSCHOOL is '_TESTSCHOOL4'", listRecs.get(3).equals("_TESTSCHOOL4"));
   assertTrue("The fifth reccomended school for _TESTSCHOOL is '_TESTSCHOOL5'",  listRecs.get(4).equals("_TESTSCHOOL5"));
 }
}
