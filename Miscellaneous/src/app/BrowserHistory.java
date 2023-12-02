package app;

class BrowserNode{
    BrowserNode back;
    String url;
    BrowserNode forward;
    public BrowserNode(String url){
        this.url = url;
        back = forward = null;
    }
}

class BrowserHistory {

    BrowserNode head;
    BrowserNode current;

    public BrowserHistory(String homepage) {
        head = new BrowserNode(homepage);
        current = head;
    }

    public void visit(String url) {
        current.forward = new BrowserNode(url);
        current.forward.back = current;
        current = current.forward;
    }

    public String back(int steps) {
        while(steps>0 && current.back!=null){
            current = current.back;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while(steps>0 && current.forward!=null){
            current = current.forward;
            steps--;
        }
        return current.url;
    }
}