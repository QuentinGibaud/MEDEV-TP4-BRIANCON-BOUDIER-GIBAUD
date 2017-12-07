/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudedames;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Création du joueur blanc");
        this.joueurBlanc = new Joueur(nom1);
        System.out.println("Création du joueur noir");
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
    public boolean verifierPosLibre(Point2D pos){
        boolean res = true;
        
        if( pos.getX()<0 || pos.getX()>=10 ||
            pos.getY()<0 || pos.getY()>=10){
            res = false;
        }
        if(res){
            for(Pion p : this.joueurBlanc.getPions()){
                if(pos.equals(p.getPos())){
                    res = false;
                    break;
                }
            }
        }
        if(res){
            for(Pion p : this.joueurNoir.getPions()){
                if(pos.equals(p.getPos())){
                    res = false;
                    break;
                }
            }
        }
        
        return res;
    }
    
    /**
     * Vérification que la position est libre
     * @param pos Position à vérifier.
     * @param pions1
     * @param pions2
     * @return Booléen confirmant ou non que la position est libre.
     */
    public boolean verifierPosLibre(Point2D pos, List<Pion> pions1, List<Pion> pions2){
        boolean res = true;
        
        if( pos.getX()<0 || pos.getX()>=10 ||
            pos.getY()<0 || pos.getY()>=10){
            res = false;
        }
        if(res){
            for(Pion p : pions1){
                if(pos.equals(p.getPos())){
                    res = false;
                    break;
                }
            }
        }
        if(res){
            for(Pion p : pions2){
                if(pos.equals(p.getPos())){
                    res = false;
                    break;
                }
            }
        }
        
        return res;
    }

    /**
     * 
     * @param typeJoueur
     * @param p
     * @param deplacements
     * @param listRepas
     * @return Liste des déplacements possibles
     */
    public List<Deplacement> concatDeplacements(String typeJoueur, Pion p, List<Deplacement> deplacements, List<Deplacement> listRepas){
        if(!(listRepas.isEmpty())){
            if(!(deplacements.isEmpty())){
                int tempSize = listRepas.get(0).getPionManges().size();
                int size = deplacements.get(0).getPionManges().size();
                if(tempSize > size){
                    deplacements = listRepas;
                }
                else if(tempSize == size){
                    deplacements.addAll(listRepas);
                }
            }
            else{
                deplacements = listRepas;
            }
        }
        else {
            if (deplacements.isEmpty()){
                deplacements = trouverDeplacementsSimples(typeJoueur, p);
            }
            else if(deplacements.get(0).getPionManges().size() == 1){
                deplacements.addAll(trouverDeplacementsSimples(typeJoueur, p));
            }
        }
        
        return deplacements;
    }
    /**
     * 
     * @param typeJoueur Type du joueur (Blanc ou Noir)
     * @return Liste des déplacements possibles
     */
    public List<Deplacement> trouverDeplacements(String typeJoueur){
        List<Deplacement> deplacements = new ArrayList<>();
        
        if(typeJoueur.equalsIgnoreCase("BLANC")){
            for(Pion p: this.joueurBlanc.getPions()){
                List<Pion> pionsAmisHorsActuel = new ArrayList<>(this.joueurBlanc.getPions());
                pionsAmisHorsActuel.remove(p);
                List<Deplacement> listRepas = this.trouverRepasPion(
                        "Blanc", pionsAmisHorsActuel, this.joueurNoir.getPions(), p);
                deplacements = concatDeplacements(typeJoueur, p, deplacements, listRepas);
            }
        }
        else if(typeJoueur.equalsIgnoreCase("NOIR")){
            for(Pion p: this.joueurNoir.getPions()){
                List<Pion> pionsAmisHorsActuel = new ArrayList<>(this.joueurNoir.getPions());
                pionsAmisHorsActuel.remove(p);
                List<Deplacement> listRepas = this.trouverRepasPion(
                        "Noir", pionsAmisHorsActuel, this.joueurBlanc.getPions(), p);
                deplacements = concatDeplacements(typeJoueur, p, deplacements, listRepas);
            }
        }
        else{
            System.err.println("Type du joueur incorrect. Valeurs possibles : Blanc, Noir.");
        }
        return deplacements;
    }
    
    /**
     * 
     * @param typeJoueur Type du joueur (Blanc ou Noir)
     * @param p Pion pour lequel il faut trouver les déplacements
     * @return 
     */
    public List<Deplacement> trouverDeplacementsSimples(String typeJoueur, Pion p){
        List<Deplacement> tabDeplacmt = new ArrayList<>();
        Deplacement dep = new Deplacement();
        if(typeJoueur.equalsIgnoreCase("NOIR")){
            Point2D newPos = new Point2D(p.getPos().getX()+1, p.getPos().getY()+1);
            if(this.verifierPosLibre(newPos)){
                dep.setPosInit(p.getPos());
                dep.setPosFinale(newPos);
                tabDeplacmt.add(dep);
            }
            newPos = new Point2D(p.getPos().getX()+1, p.getPos().getY()-1);
            dep = new Deplacement();
            if(this.verifierPosLibre(newPos)){
                dep.setPosInit(p.getPos());
                dep.setPosFinale(newPos);
                tabDeplacmt.add(dep);
            }
        }
        else if(typeJoueur.equalsIgnoreCase("BLANC")){
            Point2D newPos = new Point2D(p.getPos().getX()-1, p.getPos().getY()+1);
            if(this.verifierPosLibre(newPos)){
                dep.setPosInit(p.getPos());
                dep.setPosFinale(newPos);
                tabDeplacmt.add(dep);
            }
            newPos = new Point2D(p.getPos().getX()-1, p.getPos().getY()-1);
            dep = new Deplacement();
            if(this.verifierPosLibre(newPos)){
                dep.setPosInit(p.getPos());
                dep.setPosFinale(newPos);
                tabDeplacmt.add(dep);
            }
        }
        
        return tabDeplacmt;
    }
    
    /**
     * 
     * @param typeJoueur Type du joueur (Blanc ou Noir)
     * @param pionsAmisHorsActuel Liste des pions amis sauf le pion que l'on veut déplacer
     * @param pionsAdverses Liste des pions adverses non mangés
     * @param p Pion pour lequel il faut trouver les déplacements
     * @return Liste des déplacements possibles
     */
    public List<Deplacement> trouverRepasPion(String typeJoueur, List<Pion> pionsAmisHorsActuel, List<Pion> pionsAdverses, Pion p){
        int nbPionsMangesMax = 0;
        List<Deplacement> tabDeplacmt = new ArrayList<>();
        
        if(p instanceof Simple){
            for(int i=0; i<pionsAdverses.size(); i++){
                Pion pAdverse = pionsAdverses.get(i);
                
                if(pAdverse.getPos().distance(p.getPos()) == 1){
                    int new_x = 2 * pAdverse.getPos().getX() - p.getPos().getX();
                    int new_y = 2 * pAdverse.getPos().getY() - p.getPos().getY();
                    Point2D nextPos = new Point2D(new_x, new_y);
                    if(this.verifierPosLibre(nextPos, pionsAmisHorsActuel, pionsAdverses)){
                        List<Pion> newPionsAdverses = new ArrayList<>(pionsAdverses);
                        newPionsAdverses.remove(i);
                        Simple s = new Simple(nextPos);
                        List<Deplacement> tabDep = this.trouverRepasPion(
                                typeJoueur, pionsAmisHorsActuel, newPionsAdverses, s);
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
                        else{
                            Deplacement dep = new Deplacement();
                            dep.getPionManges().add(pAdverse);
                            dep.getPosInit().setPosition(p.getPos().getX(), p.getPos().getY());
                            dep.getPosFinale().setPosition(nextPos);
                            tabDeplacmt.add(dep);
                            nbPionsMangesMax = 1;
                        }
                    }
                }
            }
        }
        
        return tabDeplacmt;
    }
}
