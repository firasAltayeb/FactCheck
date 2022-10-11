import java.util.Scanner;

public class Mathematics {

    public static void main(String[] args) {
        System.out.println("Hi Math");
        int amount_one = 10;
        int amount_two = 20;
        System.out.println(amount_one + " " + amount_two);
        System.out.println(amount_one + amount_two);

        float product = 1.5f * 2.0f;

        System.out.println("The product is: " + product);
        System.out.printf("%.2f", product);

        int dividend = 25, divisor = 4;

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        System.out.println(Integer.valueOf(quotient));
        System.out.println("Remainder = " + remainder);

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = reader.nextInt();
        if (num % 2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }
}
