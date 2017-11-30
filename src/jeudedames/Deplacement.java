/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 * Classe représentant un déplacement avec les positions et les pions mangés.
 * @author Quentin GIBAUD, Yann BRIANCON, Justin BOUDIER
 */
class Deplacement {
    /**
     * Pions mangés
     */
    private ArrayList<Pion> pionManges;
    
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
    public Deplacement(ArrayList<Pion> pionManges, Point2D posInit, Point2D posFinale) {
        this.pionManges = pionManges;
        this.posInit = posInit;
        this.posFinale = posFinale;
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
    
    public ArrayList<Pion> getPionManges() {
        return pionManges;
    }

    public void setPionManges(ArrayList<Pion> pionManges) {
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
    
    
}
