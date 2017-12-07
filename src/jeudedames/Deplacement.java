/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe représentant un déplacement avec les positions et les pions mangés.
 * @author Quentin GIBAUD, Yann BRIANCON, Justin BOUDIER
 */
class Deplacement {
    /**
     * Pions mangés
     */
    private List<Pion> pionManges;
    
    /**
     * Position initiale.
     */
    private Point2D posInit;
    
    /**
     * Position finale.
     */
    private Point2D posFinale;

    /**
     * Constructeur de la classe Deplacement.
     * @param pionManges
     * @param posInit
     * @param posFinale 
     */
    public Deplacement(List<Pion> pionManges, Point2D posInit, Point2D posFinale) {
        this.pionManges = pionManges;
        this.posInit = new Point2D(posInit);
        this.posFinale = new Point2D(posFinale);
    }

    /**
     * Constructeur par défaut de la classe Deplacement.
     */
    public Deplacement() {
        this.pionManges = new ArrayList<>();
        this.posInit = new Point2D();
        this.posFinale = new Point2D();
    }
    
    /**
     * Constructeur de la classe Deplacement.
     * @param posInit
     * @param posFinale 
     */
    public Deplacement(Point2D posInit, Point2D posFinale) {
        this.pionManges = new ArrayList<>();
        this.posInit = posInit;
        this.posFinale = posFinale;
    }
    
    public List<Pion> getPionManges() {
        return pionManges;
    }

    public void setPionManges(List<Pion> pionManges) {
        this.pionManges = new ArrayList<>(pionManges);
    }

    public Point2D getPosInit() {
        return posInit;
    }

    public void setPosInit(Point2D posInit) {
        this.posInit = new Point2D(posInit);
    }

    public Point2D getPosFinale() {
        return posFinale;
    }

    public void setPosFinale(Point2D posFinale) {
        this.posFinale = new Point2D(posFinale);
    }
    
    
    /**
     * Test si un objet et le déplacement sont identiques
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        boolean res = true;
        if((obj == null) || !(obj instanceof Deplacement)){
            res = false;
        }
        else{
            Deplacement dep = (Deplacement)obj;
            if(dep.pionManges.size()==this.pionManges.size()){
                for(Pion p : this.pionManges){
                    if (!dep.pionManges.contains(p)) {
                        res = false;
                    }
                }
            }
            else{
                res = false;
            }
            if(!dep.posFinale.equals(this.posFinale)){
                res = false;
            }
            if(!dep.posInit.equals(this.posInit)){
                res = false;
            } 
        }

        return res;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.pionManges);
        hash = 83 * hash + Objects.hashCode(this.posInit);
        hash = 83 * hash + Objects.hashCode(this.posFinale);
        return hash;
    }
}
