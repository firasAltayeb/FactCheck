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

        System.out.println("Enter your birth month to find its horoscope: ");
        String birthMonth = sc.nextLine().toLowerCase();
        Month currentMonth = LocalDate.now().getMonth();
        String shortName = currentMonth.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        boolean isBirthDayMonth = birthMonth.equals(currentMonth.toString()) ||
                birthMonth.equals(currentMonth.getValue() + "") ||
                birthMonth.equals(shortName.toLowerCase());
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
                System.out.println("it is not your birth month!");
        }
    }
}
