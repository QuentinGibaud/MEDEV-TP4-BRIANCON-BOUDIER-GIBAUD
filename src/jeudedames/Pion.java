/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.Objects;

/**
 * Classe Pion : classe abstraite mère de Simple et Dame
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public abstract class Pion {
    
    /**
     * attribut de la position
     */
    private Point2D pos;

    /**
     * Constructeur d'un pion selon les coordonnées voulues
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Pion(int x, int y) {
        this.pos = new Point2D(x, y);
    }
    
    /**
     * Constructeur d'un pion selon la position voulue
     * @param pos
     */
    public Pion(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    
    /**
     * Constructeur d'un pion par défaut
     */
    public Pion(){
        this.pos = new Point2D();
    }

    /**
     * Getter position
     * @return position
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Setter position
     * @param pos nouvelle position voulue
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * equals : teste si un objet et le pion sont identiques
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        boolean res = false;
        if((obj!=null) && (obj instanceof Pion)){
            res = this.getPos().equals(((Pion)obj).getPos());
        }
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.pos);
        return hash;
    }
    
}
