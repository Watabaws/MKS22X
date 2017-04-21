public class eval{

    public static double eval(String s){
        String[] tokens = s.split(" ");
        stack values = new stack();
        for(String token : tokens){
            if(isNum(tokens[i])){
                Double.parseDouble(values.push(tokens[i]));
            }
            else{
                values.push(apply(tokens[i]), values.pop(), values.pop());
            }
        }
        return values.pop();
    }

    public static boolean isNum(String iq){
        try{
            Double.parseDouble(iq);
            return true;
        }
        catch(//someexceptionimtootiredtolokup){
            return false;
        }
    }

    public static double apply(String op, Double a, Double b){
        
    }
}
