package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import excelReader.ExcelReader;
import excelReader.FileRow;
import rules.BuildRules;
import rules.Rule;
import rules.RulePart;
import utils.DataBase;
import utils.Defect;
import utils.LogicOperator;

public class DataBase_Test {

	DataBase db = new DataBase("D:/Computer_Files/Downloads/Long-Method.xlsx");
	List<FileRow> dbex = db.getExcel_file(); 
	List<RulePart> l1 = new ArrayList<RulePart>();
	List<LogicOperator> lo = new ArrayList<LogicOperator>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetExcel_file() {
		List<FileRow> ex = ExcelReader.ReadFile("D:/Computer_Files/Downloads/Long-Method.xlsx");
		assertEquals(ex.toString(), dbex.toString());
	}

	@Test
	public void testGetColumns() {
		l1.add(new RulePart("LOC", 80, ">"));
		Rule obj = new Rule(l1, null, "long method", Defect.is_long) ;
		new BuildRules(obj, db).calculate();
		List<rules.Column> c = db.getColumns();	
		assertEquals("long method", c.get(0).getRuleName());
	}

	@Test
	public void testAddColumn() {

		l1.add(new RulePart("LOC", 80, ">"));
		Rule obj = new Rule(l1, lo, "long method", Defect.is_long) ;
		new BuildRules(obj, db).calculate();
		db.addRule(obj);
		
		assertEquals(1, db.getRules().get(0).getRulePart().size());
		
		l1.add(new RulePart("CYCLO", 10, ">"));
		lo.add(LogicOperator.AND);
		Rule x = new Rule(l1, lo, "long method", Defect.is_long) ;
		new BuildRules(x, db).calculate();
		db.addRule(x);
		
		Rule y = new Rule(l1, lo, "long method 2", Defect.is_long) ;
		new BuildRules(y, db).calculate();
		db.addRule(y);
		
		assertEquals("long method",db.getColumns().get(0).getRuleName());
		assertEquals("long method 2",db.getColumns().get(1).getRuleName());
		assertEquals(2, db.getRules().get(0).getRulePart().size());
		assertEquals(2, db.getRules().get(1).getRulePart().size());
	}

	@Test
	public void testAddRule() {			
		l1.add(new RulePart("LOC", 80, ">"));
		Rule obj = new Rule(l1, lo, "long method", Defect.is_long) ;
		db.addRule(obj);
		
		l1.add(new RulePart("CYCLO", 10, ">"));
		lo.add(LogicOperator.AND);
		Rule x = new Rule(l1, lo, "long method", Defect.is_long) ;
		db.addRule(x);
		
		Rule y = new Rule(l1, lo, "long method 2", Defect.is_long) ;
		db.addRule(y);
		
		assertEquals(false, db.getRules().contains(obj));
		assertEquals(true, db.getRules().contains(x));
		assertEquals(true, db.getRules().contains(y));
	}

	@Test
	public void testGetRules() {
		l1.add(new RulePart("LOC", 80, ">"));
		Rule obj = new Rule(l1, lo, "long method", Defect.is_long) ;
		db.addRule(obj);
		assertEquals("[Name: long method Defect: is_long Condition: LOC > 80.0]", db.getRules().toString());
	}

	@Test
	public void testGetRulesName() {
		l1.add(new RulePart("LOC", 80, ">"));
		Rule obj = new Rule(l1, null, "long method", Defect.is_long) ;
		BuildRules r = new BuildRules(obj, db);
		r.calculate();
		List<String> l = db.getRulesName();
		
		assertEquals("long method", l.get(0));
	}

}
