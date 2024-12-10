package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeGood {
    public String makeGood(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (!deque.isEmpty() && Math.abs(c - deque.peek()) == 32) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : deque) {
            sb.insert(0, c);
        }

        return sb.toString();
    }
}
