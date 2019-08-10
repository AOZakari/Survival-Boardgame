public class DirtyEnergy extends Energy{ // Energies Polluantes (Dirty)

    private int oil;
    private int gaz;
    private int coal;

    // Constructeurs

    public DirtyEnergy(int oil, int gaz, int coal, int xp){

        super(xp, true);
        this.oil = oil;
        this.gaz = gaz;
        this.coal = coal;

    }

    public DirtyEnergy(int oil, int gaz, int coal){
        this(oil, gaz, coal, 1);
    }

    // Méthodes Set

    public void setOil(int oil){
        this.oil = oil;
    }

    public void setGaz(int gaz){
        this.gaz = gaz;
    }

    public void setCoal(int coal){
        this.coal = coal;
    }

    // Méthodes Get

    public int getOil(){
        return oil;
    }

    public int getGaz(){
        return gaz;
    }

    public int getCoal(){
        return coal;
    }

    // Méthodes Decrease

    public void decreaseOil(int o){
        oil -= o;
        updateUsable();
    }

    public void decreaseGaz(int g){
        gaz -= g;
        updateUsable();
    }

    public void decreaseCoal(int c){
        coal -= c;
        updateUsable();
    }

    // Autres méthodes

    public void updateUsable(){
        if (oil == 0 && coal == 0 && gaz == 0){
            usable = false;
        }
    }

    public String toString(){
        return "oil: " + oil + " | gaz: " + gaz + " | coal: " + coal;
    }
}