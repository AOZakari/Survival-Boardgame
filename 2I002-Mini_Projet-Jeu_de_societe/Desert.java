import projecttools.Tools;

public class Desert extends Zone implements Windy, Sunny{ // Zone d type désert
    
    // COnstructeurs

    public Desert(int statPuri, Pollution pollution, Population population, DirtyEnergy dirtyEnergy, CleanEnergy cleanEnergy, Product product, Player player){
        super(statPuri, pollution, population, dirtyEnergy, cleanEnergy, product, player, "Desert",0,0,0);

    }

    public Desert(){
        this(0, new Pollution(), new Population(Tools.Calcul.randomRange(100, 500), 80, Tools.Calcul.randomRange(1, 3)), new DirtyEnergy(50,50,0,1), new CleanEnergy(Tools.Calcul.randomRange(500, 1000), Tools.Calcul.randomRange(1000, 2000), 0), new Product(Tools.Calcul.randomRange(150, 300), Tools.Calcul.randomRange(100, 150)), null);
    }

    // COnstruction d'éolienne

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

    // Regéneration des ressources

    public void regenerateMoney(){
        player.increaseMoney(1000);
    }

    public void regenerateMatFood(){
        productZone.increaseMatFood(1000);
    }
    public void regenerateMatPr(){
        productZone.increaseMatPr(50);

    } 

    // Méthodes Get

    public int getWindTurbine(){
        return windTurbine;
    }

    public int getPanel(){
        return panel;
    }

    // Méthodes decrease

    public void decreaseWindTurbine(){
        if(windTurbine > 0)
            windTurbine--;
    }
    public void decreasePanel(){
        if(panel > 0)
            panel--;
    }

    // Zppel des catastrophes naturelles

    public void callNaturalCatastrophy(){
        int nbCat = Tools.Calcul.randomRange(1, 2);
        switch(nbCat){
            case 1: 
                Catastrophy.earthquake(this);
                break;
            case 2: 
                Catastrophy.sandStorm(this);
                break;
            default: //debug
                System.out.println("Pb fonction randomRange");
        }
    }
}