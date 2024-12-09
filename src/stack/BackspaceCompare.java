package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {

        Deque<Character> compareS = compare(s);
        Deque<Character> compareT = compare(t);


        StringBuilder sb = new StringBuilder();
        for (Character c : compareS) {
            sb.append(c);
        }

        StringBuilder sb2 = new StringBuilder();
        for (Character c : compareT) {
            sb2.append(c);
        }


        String string1 = sb.toString();
        String string2 = sb2.toString();

        return string1.equals(string2);
    }

    private Deque<Character> compare(String s) {

        ArrayDeque<Character> answer = new ArrayDeque<>();


        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            if (c != '#') {
                answer.push(c);
            } else if (!answer.isEmpty()) {
                answer.pop();
            }
        }

        return answer;
    }
}
