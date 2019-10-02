/*
 * Permet de créer des parties de bowling multijoueurs en utilisant le projet
 * BowlingMavenCorrection précédemment établi
 */
package classes;

import bowling.MultiPlayerGame;
import bowling.SinglePlayerGame;

/**
 * Gère une partie multijoueur de bowling
 * @author maxime.falc
 * @version 1.0
 */
public class MultijoueurBowling implements MultiPlayerGame {

    
    /**
     * Tableau contenant toutes les instances des joueurs de la partie
     */
    SinglePlayerGame [] joueurs;
    String [] nomJoueurs;

    
    /** 
     * Tableau de string contenant une partie des réponses renvoyées après 
     * chaque lancer des joueurs
     */
    private final String [] REPONSES = {
        "Prochain tir : joueur ",
        "lancer ",
        ", boule "
    };

    /**
     * Entier représentant le numéro du joueur dont le tour de jeu est en 
     * cours 
     */
    private int numeroJoueur;
    
    
    
    
    
    
    
    /**
     * Débute une nouvelle partie multi-joueurs de Bowling
     * @param playerName tableau de String contenant le nom de tout les joueurs 
     *                   de la partie
     * @return une chaine de caractère demandant au prmeier joueur de jouer
     */
    @Override
    public String startNewGame(String[] playerName) {
        
        
        /* vérifications si les noms sont corrects : */
        if(listeJoueursValide(playerName)){
            
            /* initialisation des parties personnelles de chaque joueurs */
            joueurs = new SinglePlayerGame[playerName.length];
        
            /* recuperation du nom des joueurs */
            nomJoueurs = playerName;
        
            /* le premier joueur à jouer est le joueur 0 */
            numeroJoueur = 0;
        
            
            return REPONSES[0] + nomJoueurs[numeroJoueur] 
                       + REPONSES[1] + joueurs[numeroJoueur].getFrameNumber() 
                           + REPONSES[2] 
                               + joueurs[numeroJoueur].getNextBallNumber();
        } else {
            /*La liste des noms passée en argument n'est pas valide !*/
            throw new IllegalArgumentException("La liste de joueurs doit"
                                                + " être une liste de String"
                                                + " non nulle");
        }
    }

    
    
    
    /**
     * Signale un nouveau lancer de la part des joueurs.
     * Traite le nombre de quilles renversées, puis signale le tour du joueur
     * suivant.
     * @param nombreDeQuillesAbattues nombre de quilles renversées sur le tir 
     *                                actuel
     * @return une chaine de caractère demandant au joueur suivant de jouer
     */
    
    @Override
    public String lancer(int nombreDeQuillesAbattues) {
        
        /* on signale le nombre de quilles renversées par le joueur */
        joueurs[numeroJoueur].lancer(nombreDeQuillesAbattues);
        
        /*
         * vérification si le tour du joueur est fini ou pas, puis si le tour
         * est fini passage au joueur suivant
         */
        if(joueurs[numeroJoueur].hasCompletedFrame()){
            
            /* vérifiaction si tout les joueurs ont joué */
            if(numeroJoueur == (joueurs.length-1)){
                numeroJoueur = 0;
                
                
                /* vérification si la partie est finie */
                if(verificationFinPartie()){
                    return "Partie finie !";
                }
                
            } else {
                numeroJoueur++;
            }
        }
        
        
        
        return REPONSES[0] + nomJoueurs[numeroJoueur] 
                   + REPONSES[1] + joueurs[numeroJoueur].getFrameNumber() 
                       + REPONSES[2] 
                           + joueurs[numeroJoueur].getNextBallNumber();
    }
    
    
    

    /**
     * Renvoie le cscore du joueur dont le nom est passé en argument
     * @param playerName nom du joueur dont on désire connaître le score
     * @return score du joueur
     */
    @Override
    public int scoreFor(String playerName) {
        
        /* parcours du tableau des noms pour trouver le bon joueur */
        for(int i = 0; i < nomJoueurs.length; i++){
            
            /* vérification des noms */
            if(nomJoueurs[i].equals(playerName)){
                return joueurs[i].score();
            }
        }
        /* Le joueur ne fait pas parti du tableau */
        return -1;
    }
    
    
    /**
     * Vérifie si la partie est finie pour les joueurs
     * @return boolean mis à false si la partie n'est pas finie
     *                       true sinon
     */
    private boolean verificationFinPartie(){
        
        return joueurs[numeroJoueur].isFinished();
    }
    
    
    
    /**
     * Vérifie que la liste des joueurs passée pour la partir est correcte
     * @param listeNomJoueurs tableau de String contenant les noms des joueurs
     * @return nomsCorrects booléen mis à true si la liste de noms est correcte
     *                                  false sinon
     */
    private boolean listeJoueursValide(String [] listeNomJoueurs){
        
        boolean valide = true;
        if(listeNomJoueurs.length < 1){
            valide = false;
        } else {
            for(String nomJoueur : listeNomJoueurs){
                if(nomJoueur.equals("")){
                    valide = false;
                }
            }
        }
        
        
        return valide;
    }
    
}
