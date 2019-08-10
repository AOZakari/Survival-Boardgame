public class Energy extends Ressource{
    
    protected boolean usable; 

    // COntructeurs

    public Energy(int xp, boolean use){
        super(xp);
        usable = use;
    }
    
    public Energy(){
        super();
        usable = true;
    }

    // Méthodes Get ET Set

    public boolean getUsable(){
        return usable;
    }

    public void setUsable(boolean use){
        usable = use;
    }
    
}