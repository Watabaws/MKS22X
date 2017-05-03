public class TestModulo{

    public static void mystery(int x){
        System.out.println(x%10);
        System.out.println(x/10);
        if((x/10) != 0){
            mystery(x/10);
        }
        System.out.println(x%10);
    }
    public static void main(String[] args){
	       System.out.println("mod 10 is: " + Integer.parseInt(args[0]) % 10);

           System.out.println("slash 10 is: " + Integer.parseInt(args[0]) / 10);

           System.out.println("mystery is: ");
           mystery(Integer.parseInt(args[0]));
    }
}
