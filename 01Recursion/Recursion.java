public class Recursion {

    public static String name(){
        return "Abbas,Adam";
    }

    public static double sqrt(double n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        return newtSqrt(n, n/2);
    }

    private static double newtSqrt(double n, double tRy){
        if(isCloseEnough(n, tRy * tRy)){
            return tRy;
        }
        return newtSqrt(n, (((n / tRy) + tRy) / 2));
    }


    public static boolean isCloseEnough(double a,double b){
        if(a == 0.0 && b == 0.0){ return true; }
        if(a == 0.0){ return b < .0001; }
        if(b == 0.0){ return a < .001; }
        double percDif;
        percDif = Math.abs((a - b)) / ((a + b) / 2);
        return percDif < .0001;
    }

    public static void main(String[] args){
        System.out.println(sqrt(0));
    }

}
