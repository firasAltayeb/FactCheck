public class FunctionalFaces {

    @FunctionalInterface
    interface MyInterface {
        double getPi();
    }

    // @FunctionalInterface
    // interface StringInterface {
    //     String reverse(String input);
    // }

    @FunctionalInterface
    interface GenericInterface<T> {
        T function(T t);
    }

    public static void main(String[] args) {
        MyInterface ref = () -> 3.14159;
        System.out.println("Value of pi is equal to: " + ref.getPi());
        ref = () -> 3.1415926535897932384626433832795028841971;
        System.out.println(ref.getPi());

        GenericInterface<String> strRef = (input) -> {
            String result = "";
            for (int i = input.length()-1; i >= 0; i--)
                result += input.charAt(i);
            return result;
        };
        String exStr = "Lambda";
        System.out.println(exStr + " reversed = " + strRef.function(exStr));

        int exInt = 5;
        int exIntTwo = 9;
        GenericInterface<Integer> factorial = (n)
                -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result *= i;
            return result;
        };
        System.out.println("Factorial of " + exInt + " = " + factorial.function(exInt));
        System.out.println("Factorial of " + exIntTwo + " = " + factorial.function(exIntTwo));
    }
}