/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Joueur : stocke les informations concernant les joueurs : nom et liste de pions
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Joueur {

    /**
     * Attributs : nom et liste de pions
     */
    private String nom;
    
    private ArrayList<Pion> pions ;

    /**
     * Getter de l'attribut nom
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de l'attribut nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Constructeur par défaut de Joueur 
     * demande le nom à l'utilisateur
     */
    public Joueur(String nomJoueur) {
        
        this.nom = nomJoueur;
        this.pions = new ArrayList<Pion>();
    }

    /**
     * Getter de l'attribut pions
     * @return la liste des pions du joueur
     */
    public ArrayList<Pion> getPions() {
        return pions;
    }

    /**
     * Setter de l'attribut pions
     * @param pions
     */
    public void setPions(ArrayList<Pion> pions) {
        this.pions = pions;
    }
}
