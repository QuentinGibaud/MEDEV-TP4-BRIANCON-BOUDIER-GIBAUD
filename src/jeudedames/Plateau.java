/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 * Classe Plateau
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Plateau {
    
    /**
     * Attribut joueurBlanc
     */
    private Joueur joueurBlanc ;
    
    /**
     * Attribut joueurNoir
     */
    private Joueur joueurNoir ;
    
    /**
     * taille du plateau
     */
    private static final int TAILLE = 10;

    

    /**
     * Constructeur du plateau qui génère deux joueurs
     * @param nom1
     * @param nom2
     */
    public Plateau(String nom1, String nom2) {
        System.out.println("Création du joueur blanc");
        this.joueurBlanc = new Joueur(nom1);
        System.out.println("Création du joueur noir");
        this.joueurNoir = new Joueur(nom2);
    }

    /**
     * Getter du joueurBlanc
     * @return joueurBlanc
     */
    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    /**
     * setter du joueurBlanc
     * @param joueurBlanc joueur par lequel on veut remplacer l'ancien
     */
    public void setJoueurBlanc(Joueur joueurBlanc) {
        this.joueurBlanc = joueurBlanc;
    }

    /**
     * getter du joueurNoir
     * @return joueurNoir
     */
    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    /**
     * Setter du joueurNoir
     * @param joueurNoir joueur par lequel on veut remplacer l'ancien
     */
    public void setJoueurNoir(Joueur joueurNoir) {
        this.joueurNoir = joueurNoir;
    }

    /**
     * getter de la taille du plateau
     * @return taille du plateau
     */
    public static int getTAILLE() {
        return TAILLE;
    }
    
    /**
     * Permet d'ajouter aux joueurs la liste de leurs pions aux cases initiales
     */
    public void initialisePlateau(){
        for (int i =0;i<4;i++){
            for (int j=0;j<5;j++){
                if (i % 2 == 0){
                    Point2D pointNoir = new Point2D(i, 2*j+1);
                    Point2D pointBlanc = new Point2D(i+6, 2*j+1);
                    joueurNoir.getPions().add(new Simple(pointNoir));
                    joueurBlanc.getPions().add(new Simple(pointBlanc));
                }
                else {
                    Point2D pointNoir = new Point2D(i, 2*j);
                    Point2D pointBlanc = new Point2D(i+6, 2*j);
                    joueurNoir.getPions().add(new Simple(pointNoir));
                    joueurBlanc.getPions().add(new Simple(pointBlanc));
                }
            }
        }
    }

    
}
