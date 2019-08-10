import projecttools.Tools;

public class City extends Zone implements Windy, Moist, Sunny{ //Classe de la zone de type ville


    // Constructeurs

    public City(int statPuri, Pollution pollution, Population population, DirtyEnergy dirtyEnergy, CleanEnergy cleanEnergy, Product product, Player player){
        super(statPuri, pollution, population, dirtyEnergy, cleanEnergy, product, player, "City",0,0,0);
        windTurbine = 0;
        waterTurbine = 0;
        panel = 0;
    }

    public City(){
        this(0, new Pollution(), new Population(Tools.Calcul.randomRange(1500, 2000), 100, Tools.Calcul.randomRange(1, 3)), new DirtyEnergy(15,15,15,1), new CleanEnergy(Tools.Calcul.randomRange(500, 1000), Tools.Calcul.randomRange(0, 500), Tools.Calcul.randomRange(500, 1000)), new Product(Tools.Calcul.randomRange(300, 3000), Tools.Calcul.randomRange(50, 75)), null);
    }

    // Construction de Station de purification

    public void buildWindTurbine(){
        if (population.getIQ()>= 120 && cleanEnergyZone.getUsable()==false) cleanEnergyZone.setUsable(true);
        if (player.getMoney()>=20000 && productZone.getMatPr()>=100 && cleanEnergyZone.getUsable()==true){ 
            windTurbine++;
            player.decreaseMoney(20000);
            productZone.decreaseMatPr(100);
        }
        else if(cleanEnergyZone.getUsable()==false){
            System.out.println("Le QI de votre population n'est pas assez élevé");
        }
        else{
            System.out.println("Il vous faut plus d'argent et/ou de ressources");
        }
    }

    // Construction de Panneau Solaire

    public void buildPanel(){
        if (population.getIQ()>= 120 && cleanEnergyZone.getUsable()==false) cleanEnergyZone.setUsable(true);
        if (player.getMoney()>=20000 && productZone.getMatPr()>=100 && cleanEnergyZone.getUsable()==true){ 
            panel++;
            player.decreaseMoney(20000);
            productZone.decreaseMatPr(100);
        }
        else if(cleanEnergyZone.getUsable()==false){
            System.out.println("Le QI de votre population n'est pas assez élevé");
        }
        else{
            System.out.println("Il vous faut plus d'argent et/ou de ressources");
        }
    }

    // Construction de Turbine

    public void buildWaterTurbine(){
        if (population.getIQ()>= 120 && cleanEnergyZone.getUsable()==false) cleanEnergyZone.setUsable(true);
        if (player.getMoney()>=20000 && productZone.getMatPr()>=100 && cleanEnergyZone.getUsable()==true){ 
            waterTurbine++;
            player.decreaseMoney(20000);
            productZone.decreaseMatPr(100);
        }
        else if(cleanEnergyZone.getUsable()==false){
            System.out.println("Le QI de votre population n'est pas assez élevé");
        }
        else{
            System.out.println("Il vous faut plus d'argent et/ou de ressources");
        }
    }

    // Regeneration des ressources

    public void regenerateMoney(){
        player.increaseMoney(10000);
    }

    public void regenerateMatFood(){
        productZone.increaseMatFood(2500);
    }
    public void regenerateMatPr(){
        productZone.increaseMatPr(10);

    }

    //  Méthodes Get

    public int getWaterTurbine(){
        return waterTurbine;
    }    
    
    public int getWindTurbine(){
        return windTurbine;
    }

    public int getPanel(){
        return panel;
    }

    // Méthodes Decrease

    public void decreaseWindTurbine(){
        if(windTurbine > 0)
            windTurbine--;
    }
    public void decreaseWaterTurbine(){
        if(waterTurbine > 0)
            waterTurbine--;
    }
    public void decreasePanel(){
        if(panel > 0)
            panel--;
    }

    // Appel de catastrophes naturelles

    public void callNaturalCatastrophy(){
        int nbCat = Tools.Calcul.randomRange(1, 2);
        switch(nbCat){
            case 1: 
                Catastrophy.earthquake(this);
                break;
            case 2: 
                Catastrophy.tornado(this);
                break;
            default: //debug
                System.out.println("Pb fonction randomRange");
        }
    }



}