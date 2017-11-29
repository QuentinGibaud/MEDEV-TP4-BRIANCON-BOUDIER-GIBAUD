/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.Scanner;

/**
 *
 * @author Quentin GIBAUD
 */
public class Joueur {

    //Attributs 
    private String nom;

    //Getter and setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Constructeur
    public Joueur() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur : ");
        String nomJoueur = scan.next();
        this.nom = nomJoueur;
    }
}
