public class Greeter {

    public String msg;

    public Greeter(String arg){
        msg = arg;
    }

    public String getGreeting() {
        return "Hello world";
    }

    public void caller(String msg) {
        HelloWorld.printPassedDate(msg);
    }

    public void printMessage() {
        System.out.println("msg");
    }
}
