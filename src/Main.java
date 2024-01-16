import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        if (s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');
        int i = 0;

        while (i!=s.length()) {
            if (s.charAt(i) != ')' && s.charAt(i) != '}' && s.charAt(i) != ']') {
                stack.add(s.charAt(i));
                i++;
            } else {
                char closingBracket = s.charAt(i);
                if (stack.isEmpty() || !(stack.pop() == brackets.get(closingBracket))) return false;
                else i++;
            }
        }
        return stack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "()[]{}";
        //true
        System.out.println(Solution.isValid(s));

        String s1 = "((";
        //false
        System.out.println(Solution.isValid(s1));

        String s2 = "(({[]}))";
        //true
        System.out.println(Solution.isValid(s2));
    }
}