/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

/**
 * Classe Dame : représente un pion simple devenu Dame, hérite de Pion
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Dame extends Pion{

    /**
     * Constructeur de Dame à 1 paramètre : sa position
     * @param pos
     */
    public Dame(Point2D pos) {
        super(pos);
    }

    /**
     * Constructeur par défaut de Dame
     */
    public Dame() {
        super();
    }
    
}
