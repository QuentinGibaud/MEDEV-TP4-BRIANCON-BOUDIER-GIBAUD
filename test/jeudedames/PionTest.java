/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Justine
 */
public class PionTest {
    
    public PionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    

    /**
     * Test of equals method, of class Pion.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Pion p = new Simple((new Point2D(0,3)));
        Pion instance = new Simple((new Point2D(0,3)));
        boolean expResult = true;
        boolean result = instance.equals(p);
        assertEquals(expResult, result);
        
        Simple p2 = new Simple((new Point2D(0,1)));
        boolean expRes = false;
        boolean result2 = p.equals(p2);
        assertEquals(expRes,result2);
    }

    
    
}
