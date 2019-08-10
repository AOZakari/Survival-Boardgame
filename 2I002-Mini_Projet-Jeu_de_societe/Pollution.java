public class Pollution{
    
    private int totalPollution;
    private int airPollution;
    private int waterPollution;
    private int soilPollution;

    public Pollution(int airPollution, int waterPollution, int soilPollution){
        this.airPollution = airPollution;
        this.waterPollution = waterPollution;
        this.soilPollution = soilPollution;
        this.totalPollution = (airPollution + waterPollution + soilPollution)/3;
    }

    public Pollution(){
        this(0,0,0);
    }

    public int getAirPollution(){
        return airPollution;
    }

    public int getWaterPollution(){
        return waterPollution;
    }

    public int getSoilPollution(){
        return soilPollution;
    }

    public int getTotalPollution(){
        return totalPollution;
    }

    public void setAirPollution(int amount){
        airPollution += amount;
        updateTotalPollution();
    }

    public void setWaterPollution(int amount){
        waterPollution += amount;
        updateTotalPollution();
    }
    
    public void setSoilPollution(int amount){
        soilPollution += amount;
        updateTotalPollution();
    }

    public void decreaseAirPollution(int amount){
        airPollution -= (airPollution>=amount)?amount:airPollution;
        updateTotalPollution();
    }

    public void decreaseWaterPollution(int amount){
        waterPollution -= (waterPollution>=amount)?amount:waterPollution;
        updateTotalPollution();
    }

    public void decreaseSoilPollution(int amount){
        soilPollution -= (soilPollution>=amount)?amount:soilPollution;
        updateTotalPollution();
    }

    public void increaseAirPollution(int amount){
        airPollution += amount;
        updateTotalPollution();
    }

    public void increaseWaterPollution(int amount){
        waterPollution += amount;
        updateTotalPollution();
    }

    public void increaseSoilPollution(int amount){
        soilPollution += amount;
        updateTotalPollution();
    }

    public void updateTotalPollution(){
        totalPollution = (airPollution+waterPollution+soilPollution)/3;
    }

    public String toString(){
        return "Total Pollution: " + totalPollution + " | Air Pollution: " + airPollution + " | Water Pollution: " + waterPollution + " | Soil Pollution: " + soilPollution;
    }

}