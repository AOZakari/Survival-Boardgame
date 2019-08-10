import projecttools.Tools;
public abstract class Zone{
    
    public static final int NBTYPEZONE = 4;
    public static int countID=0;
    protected Player player;
    protected int id;
    protected String type;
    protected Pollution pollutionZone;
    protected int statPuri;
    protected Population population;
    protected DirtyEnergy dirtyEnergyZone;
    protected CleanEnergy cleanEnergyZone;
    protected Product productZone;
    protected int windTurbine;
    protected int waterTurbine;
    protected int panel;

    public Zone(int statPuri, Pollution pollution, Population population, DirtyEnergy dirtyEnergy, CleanEnergy cleanEnergy, Product product, Player player, String type, int windTurbine, int waterTurbine, int panel){
        countID++;
        id=countID;
        this.type = type;
        this.statPuri=statPuri;
        this.pollutionZone=pollution;
        this.population=population;
        this.dirtyEnergyZone = dirtyEnergy;
        this.cleanEnergyZone = cleanEnergy;
        this.productZone = product;
        this.player = player;
        this.windTurbine = windTurbine;
        this.waterTurbine = waterTurbine;
        this.panel = panel;
    }
    


    public static Zone newZone(){
        int k = (int)(Math.random()*NBTYPEZONE);
        switch(k){
            case 0: return new Desert();
            case 1: return new Mountain(); 
            case 2: return new Coast();
            case 3: return new City();
            default: return null; 
        }
    } 

    public void prodFood(int amount){
        if(player.getMoney() >= amount && productZone.getMatFood() >= amount && player.getProducedEnergy() >= amount && amount>0){
            //Mise à jour des attributs money et EnergyProduced dans Player et de l'attribut matFoodProd de productZone (classe Product)
            player.setMoney(player.getMoney()- amount);
            player.setProducedEnergy(player.getProducedEnergy() - amount);
            productZone.setMatFood(productZone.getMatFood()- amount);
            //On met à jour matFoodProd dans Player
            player.setProducedFood(player.getProducedFood() + amount);
        }
        //La fonction affiche un message d'erreur si la production n'a pas pu être faite. 
        else if (player.getMoney() < amount)
        {
            System.out.println("Vous n'avez pas assez d'argent pour produire de la nourriture !");
        }
        else if(productZone.getMatFood() < amount){
            System.out.println("Vous n'avez pas assez de matière première pour produire de la nourriture !");
        }
        else if(player.getProducedEnergy() < amount){
            System.out.println("Vous n'avez pas assez d'énergie pour produire de la nourriture !");
        }
    }

    public void buildStatPuri(){
        if(player.getMoney() >= 10000 && productZone.getMatPr() >= 50){
            //Mise à jour des attributs money dans Player et matPr de productZone (classe Product)
            player.setMoney(player.getMoney()- 10000);
            productZone.setMatPr(productZone.getMatPr() - 50);
            //On ajoute une station de purification à la zone 
            statPuri++;
        }
        //La fonction affiche un message d'erreur si la construction n'a pas pu être faite. 
        else if(player.getMoney() < 10000){
            System.out.println("Vous n'avez pas assez d'argent pour construire une station d'épuration !");
        }
        else if(productZone.getMatPr() < 50){
            System.out.println("Vous n'avez pas assez de matière première pour construire une station d'épuration !");
        }
    }

    public void purify(){
        if(pollutionZone.getTotalPollution() >= 10){
            // Mise à jour du taux de pollution
            pollutionZone.decreaseAirPollution(10);
            pollutionZone.decreaseAirPollution(10);
            pollutionZone.decreaseAirPollution(10);
        }
    }

    public int checkZoneNeeds(){
        // Retourne le nombre total de personnes habitant dans cette zone * leur besoin de nourriture
        return population.getNumber()*population.getFoodNeedsPP();
    }

    public int checkZonePollution(){
        // Retourne le taux de pollution de la zone 
        return pollutionZone.getTotalPollution();
    }

    public void callPoliticalCatastrophy(Game game){
        int nbCat= Tools.Calcul.randomRange(1, 4);
        switch(nbCat){
            case 1: 
                if(Math.random()< 0.4)
                Catastrophy.giletsJaunes(game, player);
                break;
            case 2: 
                Catastrophy.nineEleven(player);
                break;
            case 3: 
                Catastrophy.blackPlague(player);
                break;
            case 4: 
                Catastrophy.famine(player);
                break;
            default: //debug
                System.out.println("Pb fonction randomRange");
        }
    }

    public void airPollutionEffect(){
        if (pollutionZone.getAirPollution()>100) {
            population.kill((pollutionZone.getAirPollution()-100)*5);
            player.decreaseMoney((pollutionZone.getAirPollution()-100)*10);
        }
    }

    public void waterPollutionEffect(){
        if (pollutionZone.getWaterPollution()>100) productZone.decreaseMatFood((pollutionZone.getWaterPollution()-100)*50);
    }

    public void soilPollutionEffect(){
        productZone.decreaseMatPr((pollutionZone.getSoilPollution()-100)/2);
    }

    /* Méthodes abstraites de Zone */

    public abstract void regenerateMoney();
    public abstract void regenerateMatFood();
    public abstract void regenerateMatPr();
    public abstract void callNaturalCatastrophy();

    /* Getteurs, setteurs et toString de Zone */

    public void setPlayer(Player j){
        player = j;
    }

    public void setPopulation(Population p){
        population = p;
    }

    public void setPollution(Pollution p){
        pollutionZone = p;
    }

    public void setDirtyEnergy(DirtyEnergy de){
        dirtyEnergyZone = de;
    }

    public void setCleanEnergy(CleanEnergy ce){
        cleanEnergyZone = ce;
    }

    public void setProduct(Product pr){
        productZone = pr;
    }

    public void setStatPuri(){
        statPuri++;
    }

    public Player getPlayer(){
        return player ;
    }

    public Population getPopulation(){
        return population;
    }

    public Pollution getPollution(){
        return pollutionZone;
    }

    public DirtyEnergy getDirtyEnergy(){
        return dirtyEnergyZone;
    }

    public CleanEnergy getCleanEnergy(){
        return cleanEnergyZone;
    }

    public Product getProduct(){
        return productZone;
    }

    public int getstatPuri(){
        return statPuri;
    }

    public String getType(){
        return type;
    }

    public String toString(){
        return "Zone N°"+id + " " + type + " " + population.toString() + " | " + cleanEnergyZone.toString() + " | Eolienne:" + windTurbine + " | Turbine:" + waterTurbine + " | panneaux:" + panel + " | " + dirtyEnergyZone.toString() + " " + pollutionZone.toString() + " | " + productZone.toString();
    }
}