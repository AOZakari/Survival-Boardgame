public class Game{
    
    public static final int NBTOURSMAX = 15;
    private Player[] players; // Tableau des joueurs
    public int nbJoueurs;
    
    // COnstructeur

    public Game(int nbJoueurs){
        this.nbJoueurs = nbJoueurs;
        players = new Player[nbJoueurs];
        for (int i=0; i<nbJoueurs; i++){
            players[i] = new Player();
        }
    }

    // Méthodes Get

    public Player[] getPlayers(){
        return players;
    }

    // Elimination d'un joueur

    public void eliminate(int playerID){
        players[playerID-1] = null;
        nbJoueurs--;
    }

}