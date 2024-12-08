import linkedlist.BrowserHistory;
import linkedlist.BrowserHistory2;
import stack.DailyTemperatures;

public class Main {
    public static void main(String[] args) {

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] solution = dailyTemperatures.Solution(new int[]{73, 74, 75, 71, 69, 72, 76, 73});

        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
}