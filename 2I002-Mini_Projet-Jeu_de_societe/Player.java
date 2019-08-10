import java.util.ArrayList;
import java.util.Scanner;

public class Player{

    public static int nbJoueurs = 0;
    private int id;
    private int cptClean;
    private int playerPollution;
    private int producedEnergy;
    private int producedFood;
    private int money;
    private int xp;
    private ArrayList<Zone> possession;

    // Constructeurs

    public Player(int cptClean, int playerPollution, int producedEnergy, int producedFood, int money, int xp, ArrayList<Zone> possession){
        
        nbJoueurs++;
        this.id = nbJoueurs;
        this.cptClean = cptClean;
        this.playerPollution = playerPollution;
        this.producedEnergy = producedEnergy;
        this.producedFood = producedFood;
        this.money = money;
        this.possession = possession;
        this.xp = xp;

    }

    public Player(){

        this(0,0,0,0,100000,0,new ArrayList<Zone>());

    }

    // Méthodes Get

    public int getID(){
        return id;
    }
    
    public int getCptClean(){
        return cptClean;
    }

    public int getPlayerPollution(){
        return playerPollution;
    }
    
    public int getProducedEnergy(){
        return producedEnergy;
    }

    public int getProducedFood(){
        return producedFood;
    }
    
    public int getMoney(){
        return money;
    }

    public int getXp(){
        return xp;
    }
    
    public ArrayList<Zone> getPossession(){
        return possession;
    }

    // Méthodes Set

    public void setID(int id){
        this.id = id;
    }
    
    public void setCptClean(int cptClean){
        this.cptClean = cptClean;
    }

    public void setPlayerPollution(int playerPollution){
        this.playerPollution = playerPollution;
    }
    
    public void updatePlayerPollution(){ // Mise à jour de la pollution totale
        int total =0;
        for (Zone zone: possession){
            total += zone.getPollution().getTotalPollution();
        }
        playerPollution = total/possession.size();
    }

    public void setProducedEnergy(int producedEnergy){
        this.producedEnergy = producedEnergy;
    }

    public void setProducedFood(int producedFood){
        this.producedFood = producedFood;
    }
    
    public void setMoney(int money){
        this.money = money;
    }

    public void setXp(int xp){
        this.xp = xp;
    }  

    // Méthodes Increase et Decrease

    public void increaseProducedEnergy(int amount){
        producedEnergy += amount;
    }

    public void decreaseProducedEnergy(int amount){
        producedEnergy -= amount;
    }

    public void increaseProducedFood(int amount){
        producedFood += amount;
    }

    public void decreaseProducedFood(int amount){
        producedFood -= amount;
    }

    public void increaseMoney(int amount){
        money += amount;
    }

    public void decreaseMoney(int amount){
        money -= amount;
    }

    // Utilisation des énergies renouvelables (Clean)

    public void useRenewable(){
        for (Zone zone : possession){
         switch(zone.getType()){
             case "Mountain": 
                producedEnergy+= ((Mountain)zone).getWindTurbine() * zone.getCleanEnergy().getWind();
                producedEnergy+= ((Mountain)zone).getWaterTurbine() * zone.getCleanEnergy().getWater();
                producedEnergy+= ((Mountain)zone).getPanel() * zone.getCleanEnergy().getSunlight();
                break;
             case "Coast": 
                producedEnergy+= ((Coast)zone).getWindTurbine() * zone.getCleanEnergy().getWind();
                producedEnergy+= ((Coast)zone).getWaterTurbine() * zone.getCleanEnergy().getWater();
                producedEnergy+= ((Coast)zone).getPanel() * zone.getCleanEnergy().getSunlight();
                break;
             case "City": 
                producedEnergy+= ((City)zone).getWindTurbine() * zone.getCleanEnergy().getWind();
                producedEnergy+= ((City)zone).getWaterTurbine() * zone.getCleanEnergy().getWater();
                producedEnergy+= ((City)zone).getPanel() * zone.getCleanEnergy().getSunlight();
                break;
             case "Desert": 
                producedEnergy+= ((Desert)zone).getWindTurbine() * zone.getCleanEnergy().getWind();
                producedEnergy+= ((Desert)zone).getPanel() * zone.getCleanEnergy().getSunlight();
                break;
             default: 
                System.out.println("Erreur type");
         }   
        }
    }

    // Augmentation du QI (Utillisation des points d'XP)

    public void useXP(int indexZone, int amount){
        Zone zone = possession.get(indexZone-1);
        if (xp>=amount && amount>0){
            zone.population.increaseIQ(amount);
            xp -= amount;
        }
    }

    // Utilisation des ressources polluantes (Dirty)

    public void useOil(int indexZone, int amount){
        Zone zone = possession.get(indexZone-1);
        if (money>=amount*100 && zone.getDirtyEnergy().getOil()>=amount && zone.getDirtyEnergy().getUsable() && amount>0){
            decreaseMoney(amount*100);
            zone.getDirtyEnergy().decreaseOil(amount);
            producedEnergy += amount * 200;
            zone.getPollution().increaseAirPollution(amount*2);
            zone.getPollution().increaseWaterPollution(amount*2);
            zone.getPollution().increaseSoilPollution(amount*2);
            zone.airPollutionEffect();
            zone.waterPollutionEffect();
            zone.soilPollutionEffect();
            xp += zone.getDirtyEnergy().getXp()*amount;
        }
        else{
            System.out.println("Opération impossible");
        }
    }

    public void useGaz(int indexZone, int amount){
        Zone zone = possession.get(indexZone-1);
        if (money>=amount*100 && zone.getDirtyEnergy().getGaz()>=amount && zone.getDirtyEnergy().getUsable() && amount>0){
            decreaseMoney(amount*100);
            zone.getDirtyEnergy().decreaseGaz(amount);
            producedEnergy += amount * 120;
            zone.getPollution().increaseAirPollution(amount*2);
            zone.getPollution().increaseSoilPollution(amount);
            zone.airPollutionEffect();
            zone.soilPollutionEffect();
            xp += zone.getDirtyEnergy().getXp()*amount;
        }
        else{
            System.out.println("Opération impossible");
        }
    }

    public void useCoal(int indexZone, int amount){
        Zone zone = possession.get(indexZone-1);
        if (money>=amount*100 && zone.getDirtyEnergy().getCoal()>=amount && zone.getDirtyEnergy().getUsable() && amount>0){
            decreaseMoney(amount*100);
            zone.getDirtyEnergy().decreaseCoal(amount);
            producedEnergy += amount * 50;
            zone.getPollution().increaseAirPollution(amount);
            zone.getPollution().increaseWaterPollution(amount);
            zone.getPollution().increaseSoilPollution(amount);
            zone.airPollutionEffect();
            zone.waterPollutionEffect();
            zone.soilPollutionEffect();
            xp += zone.getDirtyEnergy().getXp()*amount;
        }
        else{
            System.out.println("Opération impossible");
        }
    }

    // Affichage des infos reliées au joueur et ses zones

    public void showInfoPossession(){
        System.out.println("Joueur N°" + id + " Argent: " + money + " Nourriture: " + producedFood + " Energie: " + producedEnergy);
        System.out.println("Besoins: " + checkFoodNeeds());
        for (Zone zone : possession){
            System.out.println(zone.toString());
        }
    }

    // Méthode d'échange entre les joueurs

    public void exchange(Player opponent, int playerEnergy, int playerFood, int playerMoney, int opponentEnergy, int opponentFood, int opponentMoney){
        
        Scanner autho = new Scanner(System.in);
        int answer;

        if (producedEnergy>=playerEnergy && producedFood>=playerEnergy && money>=playerMoney && opponent.getProducedEnergy()>=opponentEnergy && opponent.getProducedFood()>=opponentFood && opponent.getMoney()>=opponentMoney){
            System.out.println("Veuillez passer le contrôle au joueur " + opponent.getID() + "\n");
            System.out.println("Souhaitez vous échanger avec le joueur " + opponent.getID() + "\n" + opponentEnergy + " energy, " +  opponentFood + " food et " + opponentMoney + " money en votre possession contre "+ playerMoney +" energy, "+ playerFood +" food et "+ playerMoney +" money?");
            System.out.println("Tapez 0 pour refuser ou 1 pour accepter");
            answer = autho.nextInt();

            if(answer==1){

                System.out.println("Arnaque réussie!");

                this.decreaseProducedEnergy(playerEnergy);
                this.decreaseProducedFood(playerFood);
                this.decreaseMoney(playerMoney);
                this.increaseProducedEnergy(opponentEnergy);
                this.increaseProducedFood(opponentFood);
                this.increaseMoney(opponentMoney);

                opponent.increaseProducedEnergy(playerEnergy);
                opponent.increaseProducedFood(playerFood);
                opponent.increaseMoney(playerMoney);
                opponent.decreaseProducedEnergy(opponentEnergy);
                opponent.decreaseProducedFood(opponentFood);
                opponent.decreaseMoney(opponentMoney);

            }

            else{
                System.out.println("Echange refusé");
            }
        
        
        }
        else{
            System.out.println("Echange impossible");
        }
    }

    // Régeneration des ressources

    public void regenerateRessources(){
        for (Zone zone: possession){
            zone.regenerateMatFood();
            zone.regenerateMatPr();
            zone.regenerateMoney();
        }
    }

    // Retourne les besoins des zones

    public int checkFoodNeeds(){
        int totalNeeds = 0;
        for(Zone zone : possession){
            totalNeeds += zone.checkZoneNeeds();
        }
        return totalNeeds;
    }

    // Check les besoins des zones

    public void checkNeedsPP(){
        int totalNeeds = 0;
        int diff;
        for(Zone zone : possession){
            totalNeeds += zone.checkZoneNeeds();
        }
        if (producedFood>=totalNeeds){
            producedFood-=totalNeeds;
        }
        else{
            diff = totalNeeds - producedFood;
            producedFood = 0;
            for (Zone zone: possession){
                zone.getPopulation().kill(diff/possession.size());
            }
        }
    }

    // Check si le joueur a gagné

    public boolean checkWin(){
        updatePlayerPollution();
        if (cptClean>=3 && playerPollution<=10){
            return true;
        }
        return false;
    }

    // Check si le joueur a perdu

    public boolean checkLoss(){
        for (Zone zone: possession){
            if(zone.getPollution().getTotalPollution()>80 || zone.getPopulation().getNumber()==0){
                return true;
            }
        }
        return false;
    }


}