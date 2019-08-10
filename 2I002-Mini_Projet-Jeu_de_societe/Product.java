public class Product extends Ressource{
    
    private int matFood;
    private int matPr;

    public Product(int matFood, int matPr){
        this.matFood = matFood;
        this.matPr = matPr;
    }

    public Product(){
        this(0,0);
    }

    public int getMatFood(){
        return matFood;
    }

    public int getMatPr(){
        return matPr;
    }

    public void setMatFood(int amount){
        matFood = amount;
    }

    public void setMatPr(int amount){
        matPr = amount;
    }

    public void increaseMatFood(int amount){
        matFood += amount;
    }

    public void increaseMatPr(int amount){
        matPr += amount;
    }

    public void decreaseMatFood(int amount){
        matFood -= amount;
    }

    public void decreaseMatPr(int amount){
        matPr -= amount;
    }

    public String toString(){
        return "Nourriture non traitée: " + matFood + " | Matière Première: " + matPr;
    }
}