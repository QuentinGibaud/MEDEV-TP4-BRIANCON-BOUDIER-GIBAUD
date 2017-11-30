/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.Scanner;

/**
 *
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class JeuDeDames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("-----------------------------------------------");
        System.out.println("-----Bienvenue dans notre jeu de dames !!!-----");
        System.out.println("-----------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur blanc : ");
        String nom1 = scan.next();
        System.out.println("Entrez le nom du joueur noir : ");
        String nom2 = scan.next();
        //Création du plateau
        Plateau plateau = new Plateau(nom1,nom2);
        
        
        
    }
    
}
