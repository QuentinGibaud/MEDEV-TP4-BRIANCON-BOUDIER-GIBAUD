/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la classe Plateau
 * @author Justine BOUDIER, Quentin GIBAUD, Yann BRIANCON
 */
public class PlateauTest {
    
    public PlateauTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    

    /**
     * Test of initialisePlateau method, of class Plateau.
     */
    @Test
    public void testInitialisePlateau() throws FileNotFoundException {
        System.out.println("initialisePlateau");
        Plateau instance = new Plateau("Sacha","Justine");
        instance.initialisePlateau();
        ArrayList<Pion> pionNoir = instance.getJoueurNoir().getPions();
        ArrayList<Pion> pionBlanc = instance.getJoueurBlanc().getPions();
        Point2D point1 = new Point2D(0,3);
        Point2D point2 = new Point2D(1,6);
        Point2D point3 = new Point2D(2,1);
        Point2D point4 = new Point2D(3,8);
        Point2D point5 = new Point2D(6,3);
        Point2D point6 = new Point2D(7,6);
        Point2D point7 = new Point2D(8,1);
        Point2D point8 = new Point2D(9,8);
        assertTrue(pionNoir.contains(point1));
        assertTrue(pionNoir.contains(point2));
        assertTrue(pionNoir.contains(point3));
        assertTrue(pionNoir.contains(point4));
        assertTrue(pionBlanc.contains(point5));
        assertTrue(pionBlanc.contains(point6));
        assertTrue(pionBlanc.contains(point7));
        assertTrue(pionBlanc.contains(point8));
    }
    
}
