package projecttools;

public class Tools{

    public static class Calcul{
        public static int randomRange(int min, int max){
            return (int)(Math.random()*(max-min)+min);
        }
    }

}