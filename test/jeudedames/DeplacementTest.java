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
public class DeplacementTest {
    
    public DeplacementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of hashCode method, of class Deplacement
     */
    @Test
    public void testHashCode(){
        System.out.println("hashCode");
        Deplacement d = new Deplacement();
        int res = d.hashCode();
        assertEquals(2965196,res);
    }
    
    /**
     * Test of equals method, of class Deplacement
     */
    @Test
    public void testEquals(){
        System.out.println("equals");
        Deplacement d = new Deplacement();
        Deplacement p = new Deplacement();
        Simple s = new Simple();
        assertTrue(d.equals(p));
        assertTrue(d.equals(s));
        p = null;
        assertFalse(d.equals(p));
    }
    
}
