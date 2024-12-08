package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {

    public int calPoints(String[] operations) {

        Deque<Integer> deque = new ArrayDeque<>();


        for (String operation : operations) {

            if (operation.equals("C")) {
                deque.pop();
            } else if (operation.equals("D")) {
                Integer pop = deque.peek();
                deque.push(pop << 1);
            } else if (operation.equals("+")) {
                Integer lastPop = deque.pop();
                Integer second = deque.pop();

                deque.push(second);
                deque.push(lastPop);
                deque.push(lastPop + second);
            }else {
                deque.push(Integer.parseInt(operation));
            }
        }

        return deque.stream().mapToInt(Integer::intValue).sum();
    }
}
