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
        if (Character.isLetter(letter))
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
        else
            System.out.println("The input " + letter + " is not a letter");

        System.out.println("Enter your desired number to check if its even or odd: ");
        var input =  sc.nextLine();
        if (Character.isDigit(input.charAt(0))) {
            final var value = Integer.parseInt(input) % 2.0;
            if (value == 0.0) {
            System.out.println("Input is even!");
            } else if (value == 1.0) {
                System.out.println("Input is odd!");
            } else {
                System.out.println("Input is odd, & input % 3 is equal to " + value % 3);
            }
        }  else
            System.out.println("The input " + input + " is not a digit");

        System.out.println("Enter your birth month to find its horoscope: ");
        String birthMonth = sc.nextLine().toLowerCase();
        Month currentMonth = LocalDate.now().getMonth();
        String shortHand = currentMonth.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        boolean isBirthDayMonth = birthMonth.equals(currentMonth.toString()) ||
                birthMonth.equals(currentMonth.getValue() + "") ||
                birthMonth.equals(shortHand.toLowerCase());
        switch (birthMonth) {
            case "october":
            case "oct":
            case "10":
                System.out.println("October horoscope is Libra and Scorpio!");
                if (isBirthDayMonth)
                    System.out.println("Your birth day is in this month, happy birthday!");
                break;
            case "november":
            case "nov":
            case "11":
                System.out.println("November horoscope is Scorpio and Sagittarius!");
                if (isBirthDayMonth)
                    System.out.println("Your birth day is in this month, happy birthday!");
                break;
            case "december":
            case "dec":
            case "12":
                System.out.println("December horoscope is Sagittarius and Capricorn!");
                if (isBirthDayMonth)
                    System.out.println("Your birth day is in this month, happy birthday!");
                break;
            default:
                System.out.println("Your birth month is not in the system");
        }
    }
}
