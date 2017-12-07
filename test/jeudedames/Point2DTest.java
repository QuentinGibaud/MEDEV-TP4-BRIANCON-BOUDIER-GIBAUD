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
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Point2DTest {
    
    public Point2DTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getX method, of class Point2D.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point2D instance = new Point2D(24,23);
        int expResult = 24;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Point2D.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point2D instance = new Point2D(24,23);
        int expResult = 23;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class Point2D.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Point2D instance = new Point2D(24,23);
        instance.setX(x);
        assertEquals(x,instance.getX());
    }

    /**
     * Test of setY method, of class Point2D.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Point2D instance = new Point2D(24,23);
        instance.setY(y);
        assertEquals(y,instance.getY());
    }


    /**
     * Test of translate method, of class Point2D.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        int dx = -1;
        int dy = 1;
        Point2D instance = new Point2D();
        instance.translate(dx, dy);
        Point2D expResult = new Point2D(-1,1);
        assertEquals(expResult.getX(), instance.getX());
        assertEquals(expResult.getY(), instance.getY());
    }

    /**
     * Test of setPosition method, of class Point2D.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 0;
        int y = 0;
        Point2D instance = new Point2D(24,23);
        Point2D expResult = new Point2D(0,0);
        Point2D result = instance.setPosition(x, y);
        assertEquals(expResult.getX(),result.getX());
        assertEquals(expResult.getY(),result.getY());
    }

    /**
     * Test of distance method, of class Point2D.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        Point2D P = new Point2D(4,3);
        Point2D instance = new Point2D();
        double expResult = 4.0;
        double result = instance.distance(P);
        assertEquals(expResult, result, 4.0);
    }

    /**
     * Test of equalsTo method, of class Point2D.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Point2D p0 = null;
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(0,4);
        Simple p3 = new Simple();
        Point2D instance = new Point2D(0,4);
        assertFalse(instance.equals(p0));
        assertFalse(instance.equals(p1));
        assertTrue(instance.equals(p2));
        assertFalse(instance.equals(p3));
    }
    
    /**
     * Test of hashCode method, of class Point2D
     */
    @Test
    public void testHashCode(){
        System.out.println("hashCode");
        Point2D p = new Point2D(2,3);
        int res = p.hashCode();
        assertEquals(1212,res);
    }

    /**
     * Test of isPositionIn method, of class Point2D
     */
    @Test
    public void testIsPositionIn(){
        System.out.println("isPositionIn");
        Plateau p = new Plateau("A","B");
        Point2D ptIn = new Point2D(2,6);
        Point2D ptOut1 = new Point2D(11,7);
        Point2D ptOut2 = new Point2D(6,12);
        Point2D ptOut3 = new Point2D(13,18);
        Point2D ptOut4 = new Point2D(-4,2);
        Point2D ptOut5 = new Point2D(2,-2);
        assertTrue(ptIn.isPositionIn(p));
        assertFalse(ptOut1.isPositionIn(p));
        assertFalse(ptOut2.isPositionIn(p));
        assertFalse(ptOut3.isPositionIn(p));
        assertFalse(ptOut4.isPositionIn(p));
        assertFalse(ptOut5.isPositionIn(p));
    }

    /**
     * Test of affiche method, of class Point2D
     */
    @Test
    public void testAffiche(){
        System.out.println("affiche");
        Point2D p = new Point2D();
        p.affiche();
    }
}
