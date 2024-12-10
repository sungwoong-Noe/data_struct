import linkedlist.BrowserHistory;
import linkedlist.BrowserHistory2;
import stack.BackspaceCompare;
import stack.BaseballGame;
import stack.DailyTemperatures;
import stack.RemoveOuterParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        String s = removeOuterParentheses.removeOuterParentheses("(()())(())(()(()))");
        System.out.println("s = " + s);


    }
}