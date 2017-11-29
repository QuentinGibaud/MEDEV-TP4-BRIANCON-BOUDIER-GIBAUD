/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 *
 * @author Quentin GIBAUD
 */
public class Plateau {
    //Gére les pions, les cases et les joueurs
    
    //Attributs
    private ArrayList<Joueur> joueurs ;
    private Case[][] plateau;
    private ArrayList<Pion> pions;

    //Getters and setters
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Case[][] plateau) {
        this.plateau = plateau;
    }

    public ArrayList<Pion> getPions() {
        return pions;
    }

    public void setPions(ArrayList<Pion> pions) {
        this.pions = pions;
    }
}
