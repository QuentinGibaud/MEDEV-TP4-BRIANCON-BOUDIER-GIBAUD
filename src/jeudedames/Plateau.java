/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 *
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Plateau {
    //Gére les pions, les cases et les joueurs
    
    //Attributs
    private Joueur joueurBlanc ;
    private Joueur joueurNoir ;
    
    private static final int TAILLE = 10;

    //Constructeurs
    public Plateau() {
        System.out.println("Création du joueur blanc : ");
        this.joueurBlanc = new Joueur();
        System.out.println("Création du joueur noir : ");
        this.joueurNoir = new Joueur();
    }

    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    public void setJoueurBlanc(Joueur joueurBlanc) {
        this.joueurBlanc = joueurBlanc;
    }

    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    public void setJoueurNoir(Joueur joueurNoir) {
        this.joueurNoir = joueurNoir;
    }



    public static int getTAILLE() {
        return TAILLE;
    }

    
}
