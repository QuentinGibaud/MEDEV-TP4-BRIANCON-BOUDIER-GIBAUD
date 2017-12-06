/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 * Classe Point2D : permet de connaitre la position des pions et de les déplacer
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Point2D {

    /**
     * Attributs
     */
    
    //abscisse du point
    private int x;

    //ordonnée du point
    private int y;

    /**
     * Getter de l'abscisse x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter de l'ordonnée y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter de l'abscisse x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter de l'ordonnée y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Constructeur sans paramètre
     */
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructeur à partir de 2 paramètres
     *
     * @param x abscisse
     * @param y ordonnée
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur à partir d'un autre point : constructeur de recopie
     *
     * @param p
     */
    public Point2D(Point2D p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Affiche un Point2D en mode textuel
     */
    public void affiche() {
        System.out.println("Position : " + "[" + this.getX() + ";" + this.getY() + "]");
    }

    /**
     * Translate un Point2D d'un vecteur [dx, dy]
     *
     * @param dx
     * @param dy
     * @return Le Point2D translaté
     */
    public Point2D translate(int dx, int dy) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);

        return this;
    }

    /**
     * Modifie les 2 coordonnées d'un Point2D
     *
     * @param x
     * @param y
     * @return Le Point2D dont les coordonnées ont été modifiées
     */
    public Point2D setPosition(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }
    
    /**
     * Modifie les 2 coordonnées d'un Point2D
     *
     * @param pos
     * @return Le Point2D dont les coordonnées ont été modifiées
     */
    public Point2D setPosition(Point2D pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        
        return this;
    }

    /**
     * Calcule la distance du point par rapport à un autre point
     *
     * @param p
     * @return dist
     */
    public double distance(Point2D p) {
        return Math.max(Math.abs(x-p.x), Math.abs(y-p.y));
    }
    

    /**
     * Vérifie l'égalité entre un objet et le Point2D.
     * @param obj Objet à comparer
     * @return True si égalité et false sinon
     */
    @Override
    public boolean equals(Object obj) {
        boolean res = false;
        if((obj != null) && (obj instanceof Point2D)){
            if(this.x == ((Point2D)obj).x && this.y == ((Point2D)obj).y){
                res = true;
            }
        }
        return res;
    }

    /**
     * Définit des équivalents en nombre des informations contenues dans le point
     * @return equivalent
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.x;
        hash = 13 * hash + this.y;
        return hash;
    }
        
    /**
     * Détermine si le Point2D est inclus dans les limites d'un plateau
     * 
     * @param p
     * @return true si le Point2D est dans les limites du plateau, false sinon.
     */
    public boolean isPositionIn(Plateau p){
        boolean res = true;
        
        if(this.x < 0 || this.x >= Plateau.getTAILLE() || this.y < 0 || this.y >= Plateau.getTAILLE()){
            res = false;
        }
        
        return res;
    }
}
