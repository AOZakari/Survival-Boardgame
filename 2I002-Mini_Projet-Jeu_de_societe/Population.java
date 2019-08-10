public class Population{
    
    private int number;
    private int iq; 
    private int foodNeedsPP;
    
    public Population(int number, int iq, int foodNeedsPP){
        this.number = number;
        this.iq = iq;
        this.foodNeedsPP = foodNeedsPP;
    }

	public void kill(int amount){
        number -= (number>amount) ? amount:number; 
    }

    public int getNumber(){
        return number;
    }

    public int getIQ(){
        return iq;
    }

    public int getFoodNeedsPP(){
        return foodNeedsPP;
    }

    public void increaseIQ(int amount){
        iq += amount;
    }

    public void decreaseIQ(int amount){
        iq -= amount;
    }

    public String toString(){
        return "Population: " + number + " | IQ: " + iq; 
    }
}