package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {

        String stringS = compare(s);
        String stringT = compare(t);
        return stringS.equals(stringT);
    }

    private String compare(String s) {

        ArrayDeque<Character> answer = new ArrayDeque<>();


        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            if (c != '#') {
                answer.push(c);
            } else if (!answer.isEmpty()) {
                answer.pop();
            }
        }

        return String.valueOf(answer);
    }
}
