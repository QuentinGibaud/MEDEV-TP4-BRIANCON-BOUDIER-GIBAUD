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
public class DameTest {
    
    public DameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of constructor with and without parameters of class Dame
     */
    @Test
    public void testDame() {
        System.out.println("constructor without parameters");
        Dame d1 = new Dame();
        assertEquals(0,d1.getPos().getX());
        assertEquals(0,d1.getPos().getY());
        System.out.println("constructor with parameters");
        Point2D p = new Point2D(2,3);
        Dame d2 = new Dame(p);
        assertEquals(2,d2.getPos().getX());
        assertEquals(3,d2.getPos().getY());
    }
    
}
