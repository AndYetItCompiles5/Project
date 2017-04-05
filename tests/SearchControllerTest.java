package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.*;


import Project.SearchController;

public class SearchControllerTest {

 private SearchController sController;
 private HashSet<String> searchResult;
 
 @Before
 public void init()
 {
  sController = new SearchController();
  searchResult = new HashSet<String>();
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
 
 @Test
 public void testSearchFullNameCaps() {
  searchResult = sController.search("COLORADO COLLEGE", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
  assertTrue(searchResult.contains("COLORADO COLLEGE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchFullName() {
	 searchResult = sController.search("colorado college", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("COLORADO COLLEGE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchPartialNameCaps() {
	 searchResult = sController.search("ARIZONA ST", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("ARIZONA STATE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchPartialName() {
	 searchResult = sController.search("arizona st", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("ARIZONA STATE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchNoneExistantName() {
	 searchResult = sController.search("ZJ", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.isEmpty());
 }
 
 @Test
 public void testSearchNameEmpty() {
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testStateFullCaps() {
  searchResult = sController.search("-1", "COLLEGEVILLE", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
  assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStateFull() {
	 searchResult = sController.search("-1", "collegeville", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStatePart() {
	 searchResult = sController.search("-1", "college", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStatePartCaps() {
	 searchResult = sController.search("-1", "COLLEGE", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStateEmpty() {
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testLocationSuburbanCaps() {
	 searchResult = sController.search("-1", "-1", "SUBURBAN", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==44);
 }
 
 @Test
 public void testLocationSuburban() {
	 searchResult = sController.search("-1", "-1", "suburban", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==44);
 }
 
 @Test
 public void testLocationUrbanCaps() {
	 searchResult = sController.search("-1", "-1", "URBAN", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()>=82);
 }
 
 @Test
 public void testLocationUrban() {
	 searchResult = sController.search("-1", "-1", "urban", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()>=82);
 }
 
 @Test
 public void testLocationSmallCityCaps() {
	 searchResult = sController.search("-1", "-1", "SMALL-CITY", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==57);
 }
 
 @Test
 public void testLocationSmallCity() {
	 searchResult = sController.search("-1", "-1", "small-city", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);  
	 assertTrue(searchResult.size()==57);
 }
 
 @Test
 public void testLocationEmpty() {
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testControlPrivateCaps() {
	 searchResult = sController.search("-1", "-1", "-1", "PRIVATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==115);
 }
 
 @Test
 public void testControlPrivate() {
	 searchResult = sController.search("-1", "-1", "-1", "private", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==115);
 }
 
 @Test
 public void testControlCityCaps() {
	 searchResult = sController.search("-1", "-1", "-1", "CITY", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testControlCity() {
	 searchResult = sController.search("-1", "-1", "-1", "city", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testControlStateCaps() {
	 searchResult = sController.search("-1", "-1", "-1", "STATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==72);
 }
 
 @Test
 public void testControlstate() {
	 searchResult = sController.search("-1", "-1", "-1", "state", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==72);
 }
 
 @Test
 public void testNumStudentsNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", -100, 999999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==188);
 }
 
 @Test
 public void testNumStudentsZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 99999999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testNumStudentsLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 10000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testNumStudentsSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 9999, 10001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==87);
 }
 
 @Test
 public void testNumStudentsMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 14999, 15001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==34);
 }
 
 @Test
 public void testNumStudentsNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==188);
 }
}
