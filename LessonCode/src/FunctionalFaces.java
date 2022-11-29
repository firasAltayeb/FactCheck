public class FunctionalFaces {

    @FunctionalInterface
    interface MyInterface {
        double getPiValue();
    }

    @FunctionalInterface
    interface GenericInterface<T> {
        T func(T t);
    }

    //@FunctionalInterface
    //interface MyInterface {
    //    // abstract method
    //    String reverse(String n);
    //}

    public static void main(String[] args) {
        MyInterface ref = () -> 3.1415;
        System.out.println("Value of Pi = " + ref.getPiValue());

        GenericInterface<String> reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed = " + reverse.func("Lambda"));

        GenericInterface<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("factorial of 5 = " + factorial.func(5));
    }
}

