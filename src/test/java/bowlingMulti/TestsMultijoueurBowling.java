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
                try {
                    
                    game.startNewGame(jeuDeTestDebutDePartie[i]);
                    fail("On aurait du avoir une exception !");
                    
                } catch (IllegalArgumentException e) {
                }
            }
        }
    
        
        /**
         * test de la fonction donnant le score de chaque joueur
         */
        @Test
        public void testScoreFor(){
            
            /* début de partie, le score doit être nul */
            assertEquals(0, game.scoreFor("Bugs Bunny"));
            
            /*On effectue un premier lancer puis on vérifie le score */
            game.lancer(4);
            game.lancer(4);
            assertEquals(8, game.scoreFor("Bugs Bunny"));
            
            /* On joue le tour des autres joueurs jusqu'à ce que le premier ait 
               joué deux tours supplémentaires*/
            
            /*joueur 2*/
            game.lancer(4);
            game.lancer(5);
            
            /*joueur 3*/
            game.lancer(7);
            game.lancer(2);
            
            /*joueur 4*/
            game.lancer(4);
            game.lancer(1);
            
            /*joueur 1*/
            game.lancer(4);
            game.lancer(2);
            
            /*joueur 2*/
            game.lancer(4);
            game.lancer(5);
            
            /*joueur 3*/
            game.lancer(5);
            game.lancer(5);
            
            /*joueur 4*/
            game.lancer(1);
            game.lancer(3);
            
            /*joueur 1*/
            game.lancer(3);
            game.lancer(6);
            
            /* vérification que le score du joueur 1 est bien 23*/
            assertEquals(23, game.scoreFor("Bugs Bunny"));
            
            
            /* Test visuel du déroulement d'une partie */
            System.out.println(game.startNewGame(joueurs));
            System.out.println(game.lancer(10)); // strike pour le lapin
            System.out.println(game.lancer(3));
            System.out.println(game.lancer(7)); // Spare pour le pirate
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(0)); // 0 pour le rêveur
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(1)); // 1 pour moi (je refuse de mettre 0 points !)
            System.out.println(game.lancer(6));
            System.out.println(game.lancer(3)); // 9 pour le lapin, + strike bonus
            System.out.println(game.lancer(5));
            System.out.println(game.lancer(0)); // 5 pour le pirate, + spare bonus
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(0)); // 0 pour le rêveur
            System.out.println(game.lancer(10)); // strike pour moi
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(0)); // 0 pour le lapin
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(0)); // 0 pour le pirate (ici aussi ???)
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(0)); // 0 pour le rêveur (incroyable...)
            System.out.println(game.lancer(10)); // 10 pour moi ( a croire que quelqu'un a piraté la partie...)
            System.out.println(game.lancer(2));
            System.out.println(game.lancer(3)); // 5 pour le lapin
            System.out.println(game.lancer(7));
            System.out.println(game.lancer(2)); // 9 pour le pirate
            System.out.println(game.lancer(0));
            System.out.println(game.lancer(1)); // 1 pour le rêveur
            System.out.println(game.lancer(5));
            System.out.println(game.lancer(3)); // 8 pour moi
            
            /*
            Score attendus :
                "Bugs Bunny"            :   33
                "Capitaine crochet"     :   29
                "Neil Armstrong"        :   1
                "Moi"                   :   44
            */
            for (String playerName : joueurs)
                System.out.printf("Player: %s, score: %d %n",
                                    playerName,
                                       game.scoreFor(playerName));
            
        }
    
}
