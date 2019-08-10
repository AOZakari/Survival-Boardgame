public class CleanEnergy extends Energy{ // Classe d'énergies renouvelables (clean)
    
    private int wind, sunlight, water;

    // Constructeurs

    public CleanEnergy(int wind, int sunlight, int water, int xp){
        
        super(xp, false);
        this.wind = wind;
        this.sunlight = sunlight;
        this.water = water;

    }

    public CleanEnergy(int wind, int sunlight, int water){
        
        this(wind, sunlight, water, 3);

    }

    // Méthodes Get

    public int getWind(){
        return wind;
    }

    public int getSunlight(){
        return sunlight;
    }

    public int getWater(){
        return water;
    }

    // Méthode toString

    public String toString(){
        return "wind: " + wind +" | sunlight: " + sunlight + " | water: " + water;
    }
}