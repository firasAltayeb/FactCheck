public class Switcher {
    public static void main(String[] args) {
        char letter = 'a';
        String vowelsString = "aeiou";

        // if (vowelsString.contains(Character.toString(letter))) {
        //     System.out.println(letter + " is vowel");
        // } else {
        //     System.out.println(letter + " is consonant");
        // }

        //String result = (vowelsString.contains("z")) ? "vowel" : "consonant";
        System.out.println(vowelsString.contains(""+letter) ? "vowel" : "consonant");

        // char[] vowelsArray = new char[5];
        // vowelsArray[0] = 'a';
        // vowelsArray[1] = 'e';
        // vowelsArray[2] = 'i';
        // vowelsArray[3] = 'o';
        // vowelsArray[4] = 'u';

        char[] vowelsArray = {'a', 'e', 'i', 'o', 'u'};
        boolean isVowel = false;
        for (char placeHolder : vowelsArray) {
            if (letter == placeHolder) {
                System.out.println("The letter " + letter + " is a vowel!");
                isVowel = true;
            }
        }
        if (!isVowel) {
            System.out.println("The letter " + letter + " is not a vowel!");
        }

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
    }
}
