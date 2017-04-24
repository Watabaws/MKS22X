import java.util.Stack;

public class StackCalc{

    public static double eval(String s){
        String[] tokens = s.split(" ");
        Stack<Double> values = new Stack<Double>();
        for(String token : tokens){
            if(isNum(token)){
               values.push(Double.parseDouble(token));
            }
            else{
                values.push(apply(token, (double)values.pop(), (double)values.pop()));
            }
        }
        return (double)values.pop();
    }

    public static boolean isNum(String iq){
        try{
            Double.parseDouble(iq);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
	}

    public static double apply(String op, Double a, Double b){
        if(op.equals("+")){
	    return a + b;
	}
	else if(op.equals("-")){
	    return b - a;
	}
	else if(op.equals("*")){
	    return a * b;
	}
	else if(op.equals("*")){
	    return a / b;
	}
	else{
	    return a % b;
	}
    }

    public static void main(String[] args){
    }
}
