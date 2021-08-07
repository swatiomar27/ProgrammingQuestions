package com.swati.programmingquestions;

public class RotationalCipher {


    /**
     * Program to encrypt given string replaced with rotational cipher or caesar cipher
     * ASCII 48 to 57 (0-9)
     * ASCII 65 to 90 (A-Z)
     * ASCII 97 to 122 (a-z)
     *
     * @param text            String that we have to encrypt
     * @param rotationalShift int number replaced with rotationalShift digits higher (wrapping
     *                        around from 9 to 0)
     * @return final encrypted string
     * <p>
     * Debug Process (For text -> "Zebra-493", rotationalShift -> 3)
     * For i=0, Z isUppercase
     * text.charAt(i) = Z (90 in ASCII)
     * Z + rotationalShift = 93
     * Rotate after Z but 93 not providing A and we have limit like A to Z,
     * So for A ASCII is 65, So subtract, 93 - 65 (Ascii value of A) = 28
     * 28 % 26 (Total alphabets) = 2
     * Convert to char, (2 + 65 = 67)
     * 67 -> "C" in ASCII
     * </p>
     */
    public static StringBuffer encrypt(String text, int rotationalShift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        rotationalShift - 48) % 10 + 48);
                result.append(ch);
            } else if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        rotationalShift - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        rotationalShift - 97) % 26 + 97);
                result.append(ch);
            } else {
                result.append(text.charAt(i));
            }
        }
        return result;
    }
}


