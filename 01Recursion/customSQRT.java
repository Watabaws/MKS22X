public class customSQRT {

    public static String name(){
        return "Abbas,Adam";
    }

    public static double sqrt(double n){
        return newtSquRt(n, n/2, 1);
    }

    private static double newtSquRt(double n, double tRy, int guess){
        if(isCloseEnough(n, tRy * tRy)){
            return tRy;
        }
        return newtSquRt(n, (((n / tRy) + tRy) / 2), guess++);
    }


    public static boolean isCloseEnough(double a,double b){
        double percDif;
        percDif = Math.abs((a - b)) / ((a + b) / 2);
        return percDif < .0000000000001;
    }

    public static void main(String[] args){
        System.out.println(sqrt(7));
    }

}
