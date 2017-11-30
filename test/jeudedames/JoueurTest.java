/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quentin GIBAUD
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of constructor of class Joueur.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testJoueur() throws FileNotFoundException, IOException {
        System.out.println("constructeur");
        System.setIn(new FileInputStream("TestJoueur.txt"));
        Joueur instance = new Joueur();
        assertTrue(instance.getPions().isEmpty());
        assertEquals("Sacha",instance.getNom());
    }

    
}
