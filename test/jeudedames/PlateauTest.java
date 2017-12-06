/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

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
    
    
    /**
     * Test of trouverDeplacements method, of class Plateau.
     */
    @Test
    public void testTrouverDeplacements() {
        System.out.println("initialisePlateau");
        Plateau instance = new Plateau("Sacha","Justine");
        ArrayList<Pion> pionsBlancs = new ArrayList<>();
        pionsBlancs = instance.getJoueurBlanc().getPions();
        ArrayList<Pion> pionsNoirs = new ArrayList<>();
        pionsNoirs = instance.getJoueurNoir().getPions();
        
        Simple pionN1 = new Simple(1, 5);
        pionsNoirs.add(pionN1);
        Simple pionN2 = new Simple(3, 1);
        pionsNoirs.add(pionN2);
        Simple pionB1 = new Simple(4, 2);
        pionsBlancs.add(pionB1);
        Simple pionB2 = new Simple(6, 2);
        pionsBlancs.add(pionB2);
        Simple pionB3 = new Simple(2, 4);
        pionsBlancs.add(pionB3);
        Simple pionB4 = new Simple(2, 6);
        pionsBlancs.add(pionB4);
        Simple pionB5 = new Simple(4, 8);
        pionsBlancs.add(pionB5);
        Simple pionB6 = new Simple(6, 8);
        pionsBlancs.add(pionB6);
        Simple pionB7 = new Simple(6, 6);
        pionsBlancs.add(pionB7);
        Simple pionB8 = new Simple(8, 8);
        pionsBlancs.add(pionB8);
        
        ArrayList<Pion> pionsManges1= new ArrayList<>();
        pionsManges1.add(pionB4);
        pionsManges1.add(pionB5);
        pionsManges1.add(pionB6);
        pionsManges1.add(pionB7);
        Deplacement dep1 = new Deplacement(pionsManges1, pionN1.getPos(), new Point2D(5, 5));
        ArrayList<Pion> pionsManges2 = new ArrayList<>();
        pionsManges2.add(pionB4);
        pionsManges2.add(pionB5);
        pionsManges2.add(pionB6);
        pionsManges2.add(pionB8);
        Deplacement dep2 = new Deplacement(pionsManges2, pionN1.getPos(), new Point2D(9, 9));
        ArrayList<Deplacement> depsNoirs = instance.trouverDeplacementPion("Noir", pionsBlancs, pionN1, true);
        assertTrue(depsNoirs.size()==2);
        assertTrue(depsNoirs.contains(dep1));
        assertTrue(depsNoirs.contains(dep2));
    }
}
