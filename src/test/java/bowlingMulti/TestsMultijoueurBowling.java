package bowlingMulti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import classes.MultijoueurBowling;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedago
 */
public class TestsMultijoueurBowling {
    
    
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    
    /*  LES TESTS SONT ECRITS MAIS PAR MANQUE DE TEMPS LES FONCTIONS NE SONT 
       ACTUELLEMENT PAS ADAPTEES POUR LES PASSER !!!  */
    
    
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    
    /* partie de bowling multijoueur */
    MultijoueurBowling game = new MultijoueurBowling();
    
    /* noms des joueurs par défaut */
    private final String[] joueurs = {
        "Bugs Bunny",
        "Capitaine crochet",
        "Neil Armstrong",
        "Moi"
    };
    
    
    private final String[][] jeuDeTestDebutDePartie = 
    {
        {
            // test deux joueurs avec le même nom
            "ab", "ac", "aa", "ab", "ae"
        },
        
        {
            // test joueur avec un nom vide
            "", "a", "b", "c"
        },
            
        {
            // test jeu de valeurs nulles    
        }
    };
    
    
    
        @Before
	public void setUp() {
		game.startNewGame(joueurs);
	}
        
        
        
        /**
         * test de la fonction de début de partie
         */
        @Test
        public void testDebutPartieBowling(){
            for(int i =0; i < jeuDeTestDebutDePartie.length; i++ ){
                assertEquals("Erreur", 
                                 game.startNewGame(jeuDeTestDebutDePartie[i]));
            }
        }
    
        
      
        /**
         * test de lancer de boules avec une valeur erronnée
         */
        @Test
        public void testLancerFaux(){
            assertEquals("Erreur",game.lancer(-1));
            assertEquals("Erreur",game.lancer(18));
        }
    
}
