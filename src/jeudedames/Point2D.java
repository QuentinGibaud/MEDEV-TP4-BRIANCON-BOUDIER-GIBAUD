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
public class Point2D {

    //abscisse du point
    private int x;

    //ordonnée du point
    private int y;

    /**
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
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
     * @param x
     * @param y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur à partir d'un autre point
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
     * Calcule la distance du point par rapport à un autre point
     *
     * @param p
     * @return dist
     */
    public double distance(Point2D p) {
        return Math.max(Math.abs(x-p.x), Math.abs(y-p.y));
    }

    public boolean equalsTo(Point2D p) {
        boolean bool = false;

        if (p != null) {
            if (this.x == p.getX() && this.y == p.getY()) {
                bool = true;
            }
        }

        return bool;
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
