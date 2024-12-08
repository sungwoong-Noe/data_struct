import linkedlist.BrowserHistory;
import linkedlist.BrowserHistory2;
import stack.BaseballGame;
import stack.DailyTemperatures;

public class Main {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();


        String[] strings = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        int i = baseballGame.calPoints(strings);


        System.out.println("i = " + i);


    }
}