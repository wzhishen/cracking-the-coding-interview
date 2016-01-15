package chap09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class E01 {
    
    static ArrayList<String> letterCombinations(String digits) {
        if (digits == null) return null;
        ArrayList<String> ret = new ArrayList<String>();
        if (digits.isEmpty()) {
            ret.add("");
            return ret;
        }
        ArrayList<String> last = letterCombinations(digits.substring(1));
        for (String lastStr : last) {
            for (char letter : numToLetters(digits.charAt(0) - 48)) {
                ret.add(letter + lastStr);
            }
        }
        return ret;
    }
    
    private static Set<Character> numToLetters(int n) {
        Set<Character> ret = new HashSet<Character>();
        switch (n) {
            case 2: ret.add('a'); ret.add('b'); ret.add('c'); break;
            case 3: ret.add('d'); ret.add('e'); ret.add('f'); break;
            case 4: ret.add('g'); ret.add('h'); ret.add('i'); break;
            case 5: ret.add('j'); ret.add('k'); ret.add('l'); break;
            case 6: ret.add('m'); ret.add('n'); ret.add('o'); break;
            case 7: ret.add('p'); ret.add('q'); ret.add('r'); ret.add('s'); break;
            case 8: ret.add('t'); ret.add('u'); ret.add('v'); break;
            case 9: ret.add('w'); ret.add('x'); ret.add('y'); ret.add('z'); break;
        }
        return ret;
    }
    
    //----------------------------------------
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
