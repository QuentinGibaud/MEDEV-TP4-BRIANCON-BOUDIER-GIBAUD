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
        ArrayList<Pion> pionNoir = new ArrayList<Pion>();
        pionNoir = instance.getJoueurNoir().getPions();
        ArrayList<Pion> pionBlanc = instance.getJoueurBlanc().getPions();
        Simple pion1 = new Simple(new Point2D(0,3));
        Simple pion2 = new Simple(new Point2D(1,6));
        Simple pion3 = new Simple(new Point2D(2,1));
        Simple pion4 = new Simple(new Point2D(3,8));
        Simple pion5 = new Simple(new Point2D(6,3));
        Simple pion6 = new Simple(new Point2D(7,6));
        Simple pion7 = new Simple(new Point2D(8,1));
        Simple pion8 = new Simple(new Point2D(9,8));
        boolean expResult = true;
        boolean result = pionBlanc.contains(pion1);
        assertEquals(expResult,result);
        assertTrue(pionNoir.contains(pion1));
        assertTrue(pionNoir.contains(pion2));
        assertTrue(pionNoir.contains(pion3));
        assertTrue(pionNoir.contains(pion4));
        assertTrue(pionBlanc.contains(pion5));
        assertTrue(pionBlanc.contains(pion6));
        assertTrue(pionBlanc.contains(pion7));
        assertTrue(pionBlanc.contains(pion8));
    }
    
}
