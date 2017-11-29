/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

/**
 *
 * @author Quentin GIBAUD
 */
public class JeuDeDames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("-----------------------------------------------");
        System.out.println("-----Bienvenue dans notre jeu de dames !!!-----");
        System.out.println("-----------------------------------------------");
        
        //Création du plateau
        Plateau plateau = new Plateau();
        
        //Création des deux joueurs
        System.out.println("Création du joueur 1 : ");
        Joueur joueur1 = new Joueur();
        System.out.println("Création du joueur 2 : ");
        Joueur joueur2 = new Joueur();
        //Ajout au plateau
        plateau.getJoueurs().add(joueur1);
        plateau.getJoueurs().add(joueur2);
        
    }
    
}
