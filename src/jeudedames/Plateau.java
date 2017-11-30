/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;

/**
 * Classe Plateau
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Plateau {
    
    /**
     * Attribut joueurBlanc
     */
    private Joueur joueurBlanc ;
    
    /**
     * Attribut joueurNoir
     */
    private Joueur joueurNoir ;
    
    /**
     * taille du plateau
     */
    private static final int TAILLE = 10;

    

    /**
     * Constructeur du plateau qui génère deux joueurs
     * @param nom1
     * @param nom2
     */
    public Plateau(String nom1, String nom2) {
        System.out.println("Création du joueur blanc : ");
        this.joueurBlanc = new Joueur(nom1);
        System.out.println("Création du joueur noir : ");
        this.joueurNoir = new Joueur(nom2);
    }

    /**
     * Getter du joueurBlanc
     * @return joueurBlanc
     */
    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    /**
     * setter du joueurBlanc
     * @param joueurBlanc joueur par lequel on veut remplacer l'ancien
     */
    public void setJoueurBlanc(Joueur joueurBlanc) {
        this.joueurBlanc = joueurBlanc;
    }

    /**
     * getter du joueurNoir
     * @return joueurNoir
     */
    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    /**
     * Setter du joueurNoir
     * @param joueurNoir joueur par lequel on veut remplacer l'ancien
     */
    public void setJoueurNoir(Joueur joueurNoir) {
        this.joueurNoir = joueurNoir;
    }

    /**
     * getter de la taille du plateau
     * @return taille du plateau
     */
    public static int getTAILLE() {
        return TAILLE;
    }
    
    /**
     * Permet d'ajouter aux joueurs la liste de leurs pions aux cases initiales
     */
    public void initialisePlateau(){
        for (int i =0;i<4;i++){
            for (int j=0;j<5;j++){
                if (i % 2 == 0){
                    Point2D pointNoir = new Point2D(i, 2*j+1);
                    Point2D pointBlanc = new Point2D(i+6, 2*j+1);
                    joueurNoir.getPions().add(new Simple(pointNoir));
                    joueurBlanc.getPions().add(new Simple(pointBlanc));
                }
                else {
                    Point2D pointNoir = new Point2D(i, 2*j);
                    Point2D pointBlanc = new Point2D(i+6, 2*j);
                    joueurNoir.getPions().add(new Simple(pointNoir));
                    joueurBlanc.getPions().add(new Simple(pointBlanc));
                }
            }
        }
    }
    
    /**
     * Vérification que la position est libre
     * @param pos Position à vérifier.
     * @return Booléen confirmant ou non que la position est libre.
     */
    private boolean verifierPosLibre(Point2D pos){
        
        for(Pion p : this.joueurBlanc.getPions()){
            if(pos.equals(p.getPos())){
                return false;
            }
        }
        for(Pion p : this.joueurNoir.getPions()){
            if(pos.equals(p.getPos())){
                return false;
            }
        }
        
        return true;
    }

    /**
     * 
     * @param typeJoueur Type du joueur (Blanc ou Noir)
     * @return 
     */
    private ArrayList<Deplacement> trouverDeplacements(String typeJoueur){
        ArrayList<Deplacement> deplacements = new ArrayList<>();
        
        if(typeJoueur.equalsIgnoreCase("BLANC")){
            for(Pion p: this.joueurBlanc.getPions()){
                this.trouverDeplacementPion("Blanc", p, true);
            }
        }
        else if(typeJoueur.equalsIgnoreCase("NOIR")){
            for(Pion p: this.joueurNoir.getPions()){
                this.trouverDeplacementPion("Noir", p, true);
            }
        }
        else{
            System.err.println("Type du joueur incorrect. Valeurs possibles : Blanc, Noir.");
        }
        
    }
    
    /**
     * 
     * @param typeJoueur Type du joueur (Blanc ou Noir)
     * @param p 
     * @return 
     */
    private ArrayList<Deplacement> trouverDeplacementPion(String typeJoueur, Pion p, boolean premierAppel){
        int nbPionsMangesMax = 0;
        ArrayList<Deplacement> tabDeplacmt = new ArrayList<>();
        
        if(typeJoueur.equalsIgnoreCase("BLANC") || typeJoueur.equalsIgnoreCase("NOIR")){
            ArrayList<Pion> pions = new ArrayList<>();
            if(typeJoueur.equalsIgnoreCase("NOIR")){
                pions = this.joueurBlanc.getPions();
            }
            else{
                pions = this.joueurNoir.getPions();
            }
            if(p instanceof Simple){
                for(Pion pAdverse: pions){
                    if(pAdverse.getPos().distance(p.getPos()) == 1 
                        && this.verifierPosLibre(p.getPos())){
                        int new_x = 2 * pAdverse.getPos().getX() + p.getPos().getX();
                        int new_y = 2 * pAdverse.getPos().getY() + p.getPos().getY();
                        Simple s = new Simple(new Point2D(new_x, new_y));
                        ArrayList<Deplacement> tabDep = this.trouverDeplacementPion(typeJoueur, s, false);
                        if(tabDep.isEmpty()==false){
                            int size = tabDep.get(0).getPionManges().size();
                            if(size > nbPionsMangesMax-1){
                                tabDeplacmt.clear();
                                for(Deplacement dep : tabDep){
                                    dep.getPionManges().add(pAdverse);
                                    dep.getPosInit().setPosition(p.getPos().getX(), p.getPos().getY());
                                    tabDeplacmt.add(dep);
                                }
                                nbPionsMangesMax = size+1;
                            }
                            else if(size == nbPionsMangesMax-1){
                                for(Deplacement dep : tabDep){
                                    dep.getPionManges().add(pAdverse);
                                    dep.getPosInit().setPosition(p.getPos().getX(), p.getPos().getY());
                                    tabDeplacmt.add(dep);
                                }
                            }
                        }
                        
                    }
                }
                if(nbPionsMangesMax==0 && premierAppel){
                    Deplacement dep = new Deplacement();
                    if(typeJoueur.equalsIgnoreCase("NOIR")){
                        Point2D newPos = new Point2D(p.getPos().translate(1, 1));
                        if(this.verifierPosLibre(newPos)){
                            dep.setPosInit(p.getPos());
                            dep.setPosFinale(newPos);
                            tabDeplacmt.add(dep);
                        }
                        newPos = new Point2D(p.getPos().translate(1, -1));
                        if(this.verifierPosLibre(newPos)){
                            dep.setPosInit(p.getPos());
                            dep.setPosFinale(newPos);
                            tabDeplacmt.add(dep);
                        }
                    }
                    else{
                        Point2D newPos = new Point2D(p.getPos().translate(-1, 1));
                        if(this.verifierPosLibre(newPos)){
                            dep.setPosInit(p.getPos());
                            dep.setPosFinale(newPos);
                            tabDeplacmt.add(dep);
                        }
                        newPos = new Point2D(p.getPos().translate(-1, -1));
                        if(this.verifierPosLibre(newPos)){
                            dep.setPosInit(p.getPos());
                            dep.setPosFinale(newPos);
                            tabDeplacmt.add(dep);
                        }
                    }
                }
            }
            
        }
        else{
            System.err.println("Type du joueur incorrect. Valeurs possibles : Blanc, Noir.");
        }
        
        return tabDeplacmt;
    }
}
