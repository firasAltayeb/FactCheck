import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Switcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your a character if vowel: ");
        char letter = sc.nextLine().charAt(0);
        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(letter + " is vowel");
                break;
            default:
                System.out.println(letter + " is consonant");
        }

        System.out.println("Enter your desired number to check if its even or odd: ");
        int input = Integer.parseInt(sc.nextLine());
        switch (input % 2) {
            case 0:
                System.out.println("Input is even!");
                break;
            case 1:
                System.out.println("Input is odd!");
                break;
            default:
                System.out.println("Input is odd, & input % 2 is equal to " + input % 2);
                break;
        }

        System.out.println("Enter your birth month: ");
        String birthMonth = sc.nextLine().toLowerCase();
        Month currentMonth = LocalDate.now().getMonth();
        String shortName = currentMonth.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        boolean value = birthMonth.equals(currentMonth.toString()) ||
                birthMonth.equals(currentMonth.getValue() + "") ||
                birthMonth.equals(shortName.toLowerCase());
        switch (birthMonth) {
            case "october":
            case "oct":
            case "10":
                if (value)
                    System.out.println("Your birth day is in October!");
                break;
            default:
                System.out.println("it is not your birth month!");
        }
    }
}
