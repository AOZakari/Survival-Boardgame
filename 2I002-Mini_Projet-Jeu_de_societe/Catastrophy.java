import java.util.ArrayList;
import projecttools.Tools;

public class Catastrophy{ //Classe qui contient toutes les catastrophes politiques et naturelles

    // Catastrophes Politiques

    public static void giletsJaunes(Game game, Player j){
            System.out.println("Perte par Gilets Jaunes !");
            ArrayList<Zone> temp = j.getPossession();
            for(Zone z : temp){
                z.getPopulation().decreaseIQ(10);
            }
            game.eliminate(j.getID());
    }

    public static void nineEleven (Player j){
        System.out.println("Mince un attentat est survenu dans une de vos zones. Vous perdez 1/5 de votre argent");
        j.setMoney(j.getMoney()/5);
    }

    public static void blackPlague (Player j){
        System.out.println("Une épidémie de Peste Noire vous touche. Vous perdez la moitié de votre population");
        ArrayList<Zone> temp = j.getPossession();
        for(Zone z : temp){
            Population p= z.getPopulation();
            p.kill(p.getNumber()/2);
        }
    }

    public static void famine(Player j){
        System.out.println("Vous êtes touché par une famine. Vous perdez toutes vos récoltes.");
        j.setProducedFood(0);
    }

    // Guerre Mondiale

    public static void worldWar(Game g){
        System.out.println("Une guerre mondiale a été déclenchée. Vous perdez un tiers de votre population et "+50000/g.nbJoueurs+"euros sauf le vainqueur. Pas de chance :)");
        int vainqueur= Tools.Calcul.randomRange(1, g.nbJoueurs);
        Player [] temp = g.getPlayers();
        temp[vainqueur-1].increaseMoney(50000);
        for(int i=0 ; i<temp.length; i++){
            if(i != vainqueur-1){
                temp[i].decreaseMoney(50000/g.nbJoueurs);
                ArrayList<Zone> z= temp[i].getPossession();
                for (Zone t : z){
                    Population p= t.getPopulation();
                    p.kill(p.getNumber()/3);
                }
            }
        }
    }

    // Catastrophes Naturelles

    public static void sandStorm(Desert d){
        System.out.println("Une tempête de sable a touché un de vos déserts");
        d.decreaseWindTurbine();
        d.decreasePanel();
    }

    public static void tornado(City c){
        System.out.println("Une tornade a touché une de vos villes");
        c.decreasePanel();
    }

    public static void avalanche (Mountain m){
        System.out.println("Une avalanche a touché une de vos montagnes");
        m.decreaseWindTurbine(); 
    }

    public static void tsunami (Coast c){
        System.out.println("Un tsunami a devasté une de vos côtes");
        c.decreaseWaterTurbine();  
    }

    public static void earthquake (Zone z){
        System.out.println("Un tremblement de Terre a devasté une de vos zones");
        Population popu = z.getPopulation();
        double percent = 1 - Math.random();
        popu.kill((int)(popu.getNumber()*percent));  
    }
}