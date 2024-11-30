package linkedlist;

public class BrowserHistory {

    public int size = 0;

    public Node first;
    public Node now;
    public Node last;

    public BrowserHistory(String url) {
        visit(url);
    }

    public void visit(String url) {


        Node newNode = new Node(null, url, null);

        if (now == null) {
            first = newNode;
            now = newNode;
            last = newNode;
        } else {
            Node prev = now.prev;
            if (prev == null) {
                now.next = newNode;
                newNode.prev = now;
            } else {
                newNode.prev = now;
                prev.next = newNode;
            }
            now = newNode;
        }
    }

    public String back(int n) {
        for (int i = 0; i < n; i++) {
            if (now.prev == null) {
                System.out.println("back, now.url = " + now.url);
                return now.url;
            }

            Node x = now;
            now = now.prev;
            now.next = x;


        }
        System.out.println("back, now.url = " + now.url);
        return now.url;
    }

    public String forward(int n) {
        for (int i = 0; i < n; i++) {
            if (now.next == null) {
                System.out.println("forward, now.url = " + now.url);
                return now.url;
            }
            now = now.next;
        }
        System.out.println("forward, now.url = " + now.url);
        return now.url;
    }

    public void printAll() {
        for (Node x = first; x != null; x = x.next) {
            System.out.println("x = " + x.url);
        }
    }

    private static class Node {
        String url;
        Node prev;
        Node next;

        public Node(Node prev, String url, Node next) {
            this.prev = prev;
            this.url = url;
            this.next = next;
        }

    }
}

