/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

/**

 * Classe Simple représentant le pion de base
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Simple extends Pion{

    
    /**
     * Constructeur d'un simple selon les coordonnées voulues
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Simple(int x, int y) {
        super(x, y);
    }
    
    
    /**
     * Constructeur avec la position voulue
     * @param pos
     */
    public Simple(Point2D pos) {
        super(pos);
    }

    /**
     * Constructeur par défaut
     */
    public Simple() {
        super();
    }
    
}
