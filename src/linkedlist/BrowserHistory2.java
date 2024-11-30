package linkedlist;


public class BrowserHistory2 {


    Node head;
    Node current;

    public BrowserHistory2(String url) {
        current = new Node(null, url);
    }


    public void visit(String url) {

        Node now = current;
        Node newNode = new Node(now, url);

        now.next = newNode;
        current = newNode;

    }

    public void back(int steps) {


        while (current.prev != null && steps > 0) {
            steps--;
            current = current.prev;
        }

        System.out.println("back = " + current.url);
    }


    public void forward(int steps) {

        while(current.next != null && steps > 0) {
            steps--;
            current = current.next;
        }

        System.out.println("forward = " + current.url);
    }



    private static class Node {
        String url;
        Node prev;
        Node next;


        public Node(Node prev, String url) {
            this.url = url;
            this.prev = prev;
        }
    }
}
