import java.util.Scanner;

public class HelloWorld {

    public static Scanner reader;
    public static int number;

    public static void main(String[] args) {
        System.out.println(new Greeter().getGreeting());

        reader = new Scanner(System.in);
        System.out.print("Enter a number: ");

        number = reader.nextInt();
        printDate();
    }

    public static void printDate(){
        System.out.println("You entered: " + number);
    }
}