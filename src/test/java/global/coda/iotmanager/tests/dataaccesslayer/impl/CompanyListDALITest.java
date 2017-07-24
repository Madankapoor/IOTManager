package global.coda.iotmanager.tests.dataaccesslayer.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import global.coda.iotmanager.dataaccesslayer.impl.CompanyListDALI;
import global.coda.iotmanager.dataaccesslayer.intf.CompanyListDAL;
import global.coda.iotmanager.models.Company;

public class CompanyListDALITest {
	private static CompanyListDAL cmpDal;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cmpDal=new CompanyListDALI();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCompany() {
		Company cmp=new Company();
		cmp.setAdminEmail("madankapoor10@gmail.com");
		cmp.setName("TestCompany");
	    
		try {
			cmpDal.addCompany(cmp);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			fail(e.toString());
		}
	}

	@Test
	public void testGetCompaniesId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCompaniesName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCompanyHeader() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCompany() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckUser() {
		//fail("Not yet implemented");
	}

}
