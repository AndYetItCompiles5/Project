package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import Project.*;
import org.junit.Before;
import org.junit.Test;

public class UniversityTest {
	private University testUniversity;
	private University emptyUniversity;
	ArrayList<String> emphases = new ArrayList<String>();
	
	@Before
	public void init(){
		emphases.add("Accounting");
		emphases.add("Science");
		testUniversity = new University("SJU","Minnesota","URBAN","PRIVATE",4000,2.0,500,400,50000,92.0,7000,62.0,50.0,4,3,3,emphases);
		emptyUniversity = new University("CSB");
	}

	@Test
	public void testGetName() {
		assertTrue("Name should be SJU",testUniversity.getName().equals("SJU"));
		assertTrue("Name should be CSB",emptyUniversity.getName().equals("CSB"));
	}

	@Test
	public void testGetState() {
		assertTrue("State should return Minnesota", testUniversity.getState().equals("Minnesota"));
		assertTrue("State should return Nothing", emptyUniversity.getState().equals("-1"));
	}

	@Test
	public void testSetState() {
		testUniversity.setState("New York");
		assertTrue("State should return New York", testUniversity.getState().equals("New York"));
	}

	@Test
	public void testGetLocation() {
		assertTrue("Location should return URBAN", testUniversity.getLocation().equals("URBAN"));
		assertTrue("Location should return Nothing", emptyUniversity.getLocation().equals("-1"));
	}

	@Test
	public void testSetLocation() {
		testUniversity.setLocation("SUBURBAN");
		assertTrue("Location should return Urban",testUniversity.getLocation().equals("SUBURBAN"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetLocation(){
		testUniversity.setLocation("rural");
	}
	

	@Test
	public void testGetControl() {
		assertTrue("Control should return Private", testUniversity.getControl().equals("PRIVATE"));
		assertTrue("Control should return Nothing", emptyUniversity.getControl().equals("-1"));
	}

	@Test
	public void testSetControl() {
		testUniversity.setControl("STATE");
		assertTrue("Control should return STATE",testUniversity.getControl().equals("STATE"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetControl(){
		testUniversity.setControl("country");
	}

	@Test
	public void testGetNumStudents() {
		assertTrue("Number of students should be 4000", testUniversity.getNumStudents()==4000);
		assertTrue("Number of students should be 0", emptyUniversity.getNumStudents()==-1);
	}

	@Test
	public void testSetNumStudents() {
		testUniversity.setNumStudents(4500);
		assertTrue("Number of fail students should be 4500", testUniversity.getNumStudents()==4500);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetNumStudents(){
		testUniversity.setNumStudents(-500);
	}

	@Test
	public void testGetPercentFemale() {
		assertTrue("Percent female should be 2%", testUniversity.getPercentFemale()==2.0);
		assertTrue("Percent female should be 0%", emptyUniversity.getPercentFemale()==-1.0);
	}

	@Test
	public void testSetPercentFemale() {
		testUniversity.setPercentFemale(5.0);
		assertTrue("Percent female should be 5%", testUniversity.getPercentFemale()==5.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetPercentFemaleLow(){
		testUniversity.setPercentFemale(-50.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetPercentFemaleHigh(){
		testUniversity.setPercentFemale(150.0);
	}

	@Test
	public void testGetSatVerbal() {
		assertTrue("SAT Verbal should be 500", testUniversity.getSatVerbal()==500);
		assertTrue("SAT Verbal should be 0", emptyUniversity.getSatVerbal()==-1);
	}

	@Test
	public void testSetSatVerbal() {
		testUniversity.setSatVerbal(450);
		assertTrue("SAT Verbal should be 450", testUniversity.getSatVerbal()==450);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSatVerbalLow(){
		testUniversity.setSatVerbal(-50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSatVerbalHigh(){
		testUniversity.setSatVerbal(1150);
	}

	@Test
	public void testGetSatMath() {
		assertTrue("SAT Math should be 400", testUniversity.getSatMath()==400);
		assertTrue("SAT Math should be 0", emptyUniversity.getSatMath()==-1);
	}

	@Test
	public void testSetSatMath() {
		testUniversity.setSatMath(450);
		assertTrue("SAT Math should be 450", testUniversity.getSatMath()==450);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSatMathLow(){
		testUniversity.setSatMath(-50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSatMathHigh(){
		testUniversity.setSatMath(1150);
	}

	@Test
	public void testGetExpenses() {
		assertTrue("Expenses should be 50,000", testUniversity.getExpenses()==50000);
		assertTrue("Expesnes should be 0", emptyUniversity.getExpenses()==-1);
	}

	@Test
	public void testSetExpenses() {
		testUniversity.setExpenses(51000);
		assertTrue("Expenses should be 51,000", testUniversity.getExpenses()==51000);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetExpenses(){
		testUniversity.setExpenses(-1150);
	}

	@Test
	public void testGetFinancialAid() {
		assertTrue("Percent Financial Aid should be 92%" ,testUniversity.getFinancialAid()==92.0);
		assertTrue("Percent Financial Aid should be 0%" ,emptyUniversity.getFinancialAid()==-1.0);
	}

	@Test
	public void testSetFinancialAid() {
		testUniversity.setFinancialAid(95.0);
		assertTrue("Percent Financial Aid should be 95%" ,testUniversity.getFinancialAid()==95.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetFinancialAidLow(){
		testUniversity.setFinancialAid(-15.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetFinancialAidHigh(){
		testUniversity.setFinancialAid(115.0);
	}

	@Test
	public void testGetNumApplicants() {
		assertTrue("Number of applicants should be 7000", testUniversity.getNumApplicants()==7000);
		assertTrue("Number of applicants should be 0", emptyUniversity.getNumApplicants()==-1);
	}

	@Test
	public void testSetNumApplicants() {
		testUniversity.setNumApplicants(7500);
		assertTrue("Number of applicants should be 7500", testUniversity.getNumApplicants()==7500);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetNumApplicants(){
		testUniversity.setNumApplicants(-15);
	}

	@Test
	public void testGetPercentAdmitted() {
		assertTrue("Percent admitted should be 62%", testUniversity.getPercentAdmitted()==62.0);
		assertTrue("Percent admitted should be 0%", emptyUniversity.getPercentAdmitted()==-1.0);
	}

	@Test
	public void testSetPercentAdmitted() {
		testUniversity.setPercentAdmitted(60.0);
		assertTrue("Percent admitted should be 60%", testUniversity.getPercentAdmitted()==60.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetPercentAdmittedLow(){
		testUniversity.setPercentAdmitted(-15.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetPercentAdmittedHigh(){
		testUniversity.setPercentAdmitted(145.0);
	}

	@Test
	public void testGetPercentEnrolled() {
		assertTrue("Percent Enrolled should be 50%", testUniversity.getPercentEnrolled()==50.0);
		assertTrue("Percent Enrolled should be 0%", emptyUniversity.getPercentEnrolled()==-1.0);
	}

	@Test
	public void testSetPercentEnrolled() {
		testUniversity.setPercentEnrolled(55.0);
		assertTrue("Percent Enrolled should be 55%", testUniversity.getPercentEnrolled()==55.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetPercentEnrolledLow(){
		testUniversity.setPercentEnrolled(-15.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetPercentEnrolledHigh(){
		testUniversity.setPercentEnrolled(145.0);
	}

	@Test
	public void testGetAcademicScale() {
		assertTrue("Academic Scale should be 4", testUniversity.getAcademicScale()==4);
		assertTrue("Academic Scale should be 0", emptyUniversity.getAcademicScale()==-1);
	}

	@Test
	public void testSetAcademicScale() {
		testUniversity.setAcademicScale(3);
		assertTrue("Academic Scale should be 3", testUniversity.getAcademicScale()==3);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFailSetAcademicScaleLow(){
		testUniversity.setAcademicScale(-2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetAcademicScaleZero(){
		testUniversity.setAcademicScale(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetAcademicScaleHigh(){
		testUniversity.setAcademicScale(6);
	}
	
	@Test
	public void testGetSocialScale() {
		assertTrue("Social Scale should be 3", testUniversity.getSocialScale()==3);
		assertTrue("Social Scale should be 0", emptyUniversity.getSocialScale()==-1);
	}

	@Test
	public void testSetSocialscale() {
		testUniversity.setSocialscale(4);
		assertTrue("Social Scale should be 4", testUniversity.getSocialScale()==4);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSocialScaleLow(){
		testUniversity.setAcademicScale(-2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSocialScaleZero(){
		testUniversity.setAcademicScale(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetSocialScaleHigh(){
		testUniversity.setAcademicScale(6);
	}
	
	@Test
	public void testGetLifeScale() {
		assertTrue("Life Scale should be 3", testUniversity.getLifeScale()==3);
		assertTrue("Life Scale should be 0", emptyUniversity.getLifeScale()==-1);
	}

	@Test
	public void testSetLifeScale() {
		testUniversity.setLifeScale(4);
		assertTrue("Life Scale should be 4", testUniversity.getLifeScale()==4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetLifeScaleLow(){
		testUniversity.setAcademicScale(-2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetLifeScaleZero(){
		testUniversity.setAcademicScale(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailSetLifeScaleHigh(){
		testUniversity.setAcademicScale(6);
	}
	
	@Test
	public void testGetEmphases(){
		assertTrue("Emphases list should be null", emptyUniversity.getEmphases()==null);
	}
}
