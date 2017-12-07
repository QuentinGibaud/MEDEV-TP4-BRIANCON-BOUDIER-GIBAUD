/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quentin GIBAUD
 */
public class JeuDeDamesTest {
    
    public JeuDeDamesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class JeuDeDames.
     */
    @Test
    public void testMain() throws FileNotFoundException {
        System.out.println("main");
        String[] args = null;
        System.setIn(new FileInputStream("TestJoueur.txt"));
        JeuDeDames.main(args);
    }
    
}
