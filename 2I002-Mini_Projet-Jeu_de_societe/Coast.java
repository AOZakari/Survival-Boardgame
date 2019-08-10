import projecttools.Tools;

public class Coast extends Zone implements Windy, Moist, Sunny{ // Zone de type côte (Coast)

    // Constructeurs

    public Coast(int statPuri, Pollution pollution, Population population, DirtyEnergy dirtyEnergy, CleanEnergy cleanEnergy, Product product, Player player){
        super(statPuri, pollution, population, dirtyEnergy, cleanEnergy, product, player, "Coast",0,0,0);
    }

    public Coast(){
        this(0, new Pollution(), new Population(Tools.Calcul.randomRange(500, 1500), 90, Tools.Calcul.randomRange(1, 3)), new DirtyEnergy(25,25,25,1), new CleanEnergy(Tools.Calcul.randomRange(500, 1000), Tools.Calcul.randomRange(500, 1000), Tools.Calcul.randomRange(1000, 2000)), new Product(Tools.Calcul.randomRange(10000, 15000), Tools.Calcul.randomRange(75, 100)), null);
    }

    // Construction d'éolienne

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

    // Régeneration des ressources

    public void regenerateMoney(){
        player.increaseMoney(2000);
    }

    public void regenerateMatFood(){
        productZone.increaseMatFood(4000);
    }
    public void regenerateMatPr(){
        productZone.increaseMatPr(25);

    }

    // Méthodes Get

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

    // APpel des catastrophes naturelles

    public void callNaturalCatastrophy(){
        int nbCat = Tools.Calcul.randomRange(1, 2);
        switch(nbCat){
            case 1: 
                Catastrophy.earthquake(this);
                break;
            case 2: 
                Catastrophy.tsunami(this);
                break;
            default: //debug
                System.out.println("Pb fonction randomRange");
        }
    }



}