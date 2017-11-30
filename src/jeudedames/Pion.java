/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

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
     * Constructeur d'un pion selon la position voulue
     * @param pos
     */
    public Pion(Point2D pos) {
        this.pos = pos;
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
     * equals : teste si deux pions ont la même position
     */
    public boolean equals(Pion p){
        if(this.getPos().equals(p.getPos())){
            return true;
        }else{
            return false;
        }
    }
    
}
