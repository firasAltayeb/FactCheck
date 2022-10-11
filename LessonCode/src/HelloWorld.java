import java.util.Scanner;

public class HelloWorld {

    public static Scanner reader;
    public static int number;

    public static void main(String[] args) {
        /*for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }*/

        for (String arg : args) {
            System.out.println(arg);
        }

        // System.out.println(new Greeter().getGreeting());
        Greeter greeter = new Greeter("hi");
        greeter.caller("hello there");
        greeter.printMessage();

         System.out.println(greeter.getGreeting());
         System.out.println(new Greeter("hey").getGreeting());

        reader = new Scanner(System.in);
        System.out.print("Enter a number: ");

        number = reader.nextInt();
        printDate();
    }

    public static void printDate(){
        System.out.println("You entered: " + number);
    }

    public static void printPassedDate(String s){
        System.out.println("You entered: " + s);
    }
}