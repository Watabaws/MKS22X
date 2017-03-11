import java.util.*;
public class Quiz2Redux{

    public static ArrayList<String> combinations(String s){
        ArrayList<String>words = new ArrayList<String>();
        //words.add("");
        char[] word = s.toCharArray();
        help("", word, words, -1);
        Collections.sort(words);
        return words;
    }

    public static void help(String word, char[] s, ArrayList<String> words, int ind){
        System.out.println(words);
        ind += 1;
        if(ind < s.length){
            help(word + s[ind], s, words, ind);
            help(word, s, words, ind);
        }
        else{
            words.add(word);
        }

    }

    public static void main(String[] args){
        System.out.println(combinations(args[0]));
    }

}
