import linkedlist.BrowserHistory;
import linkedlist.BrowserHistory2;

public class Main {
    public static void main(String[] args) {

        BrowserHistory2 history = new BrowserHistory2("leetcode.com");

        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        history.back(1);
        history.back(1);
        history.forward(1);
        history.visit("linkedin.com");
        history.forward(2);
        history.back(2);
        history.back(7);

    }
}