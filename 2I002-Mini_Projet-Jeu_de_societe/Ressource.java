public abstract class Ressource{

    protected int xp;

    public Ressource(int xp){
        this.xp = xp;
    }

    public Ressource(){
        this(0);
    }

    public int getXp(){
        return xp;
    }

}
