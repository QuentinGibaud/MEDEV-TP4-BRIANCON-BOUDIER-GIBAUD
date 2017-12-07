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
public class SimpleTest {
    
    public SimpleTest() {
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
    public void testSimple() {
        System.out.println("constructor without parameters");
        Simple s1 = new Simple();
        assertEquals(0,s1.getPos().getX());
        assertEquals(0,s1.getPos().getY());
        System.out.println("constructor with one parameter");
        Point2D p = new Point2D(2,3);
        Simple s2 = new Simple(p);
        assertEquals(2,s2.getPos().getX());
        assertEquals(3,s2.getPos().getY());
        System.out.println("constructor with two parameters");
        Simple s3 = new Simple(4,5);
        assertEquals(4,s3.getPos().getX());
        assertEquals(5,s3.getPos().getY());
    }
    
}
