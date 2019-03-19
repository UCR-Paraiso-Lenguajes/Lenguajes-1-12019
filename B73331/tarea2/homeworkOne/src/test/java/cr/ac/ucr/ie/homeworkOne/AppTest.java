package cr.ac.ucr.ie.homeworkOne;

import java.util.ArrayList;

import cr.ac.ucr.ie.dataContainer.DataList;
import cr.ac.ucr.ie.domain.Cow;
import cr.ac.ucr.ie.domain.CowController;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	CowController cowController = new CowController();
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testingCowClass() {
    	Cow cow  = new Cow(15,5,"Jersey");
    	System.out.println(cow);
    	
    }
    public void testingListOfCows() {
    	cowController.insertACow(new Cow(3,5,"Holstein"));
    	cowController.insertACow(new Cow(5,9,"Jersey"));
    	cowController.insertACow(new Cow(7,9,"Holstein"));
    	cowController.insertACow(new Cow(3,4,"Simental"));
    	cowController.listAllCows();
    	System.out.println("##### Testing a cow delete ######");
    	cowController.delteACow(0);
    	cowController.listAllCows();
    	System.out.println("##### Testing a cow update ######");
    	cowController.updateACow(1, new Cow(8,8,"Gensey"));
    	cowController.listAllCows();
    }
    
    
}
