package stack;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {


        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            if (!deque.isEmpty()) {
                Character peek = deque.peek();

                if (peek == c) {
                    deque.pop();
                    deque.push(c);
                } else {
                    deque.push(c);
                }

            } else if (c == '(') {
                deque.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character c : deque) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public String removeOuterParentheses2(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {


            if (c == '(') {

                if (!deque.isEmpty()) {
                    sb.append(c);
                }

                deque.push(c);
            } else {

                deque.pop();
                if (!deque.isEmpty()) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public String removeOuterParentheses3(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            if (c == '(') {

                if (!deque.isEmpty()) {
                    sb.append(c);
                }

                deque.push(c);
            } else {
                deque.pop();
                if (!deque.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

}
