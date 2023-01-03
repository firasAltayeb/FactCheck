public class TypeCast {
    // Casting sequence is double -> float -> long -> int -> char -> short -> byte (Cannot go the other direction)
    // Byte stores the least amount of data
    public static void main(String[] args) {
        int numOne = 2;
        double dbOne = 3.3718;
        System.out.println("NumOne casted to a double is: " + (double) numOne);
        System.out.println("DbOne casted to an integer is: " + (int) dbOne);

        double dbTwo = numOne;
        System.out.println("DbTwo set equal to numOne is: " + dbTwo);
        System.out.println("DbTwo casted to a byte is: " + (byte) dbTwo);
        System.out.println("DbTwo casted to a character is: " + (char) dbTwo);
        System.out.println("DbOne casted to a character is: " + (char) dbOne);

        Object singleChar = "f";
        Object letter = "j";
        System.out.println("SingleChar casted to a string is: " + (String) singleChar);
        System.out.println("Letter casted to a string is: " + (String) letter);
    }
}