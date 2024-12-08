package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public int[] Solution(int[] temperatures) {


        Deque<Weather> deque = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        deque.push(new Weather(0, temperatures[0]));

        for (int i = 1; i < temperatures.length; i++) {
            while (!deque.isEmpty() && deque.peek().temp < temperatures[i]) {
                Weather prevDay = deque.pop();
                answer[prevDay.day] = i - prevDay.day;
            }
            deque.push(new Weather(i, temperatures[i]));

        }

        return answer;
    }


    public int[] solution(int[] temperatures) {

        Deque<Weather> deque = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        deque.push(new Weather(0, temperatures[0]));

        for (int i = 1; i < temperatures.length; i++) {

            while (!deque.isEmpty() && deque.peek().temp < temperatures[i]) {
                Weather pop = deque.pop();
                answer[i] = i - pop.day;
            }

            deque.push(new Weather(i, temperatures[i]));
        }

        return answer;
    }



    static class Weather {
        int day;
        int temp;

        public Weather(int day, int temp) {
            this.day = day;
            this.temp = temp;
        }

    }


}
