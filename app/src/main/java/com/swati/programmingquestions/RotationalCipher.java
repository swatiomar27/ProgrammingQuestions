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

        for (int index = 0; index < text.length(); index++) {
            if (Character.isDigit(text.charAt(index))) {
                result.append(rotationCipherLogic(index, text, rotationalShift, 48, 10));
            } else if (Character.isUpperCase(text.charAt(index))) {
                result.append(rotationCipherLogic(index, text, rotationalShift, 65, 26));
            } else if (Character.isLowerCase(text.charAt(index))) {
                result.append(rotationCipherLogic(index, text, rotationalShift, 97, 26));
            } else {
                result.append(text.charAt(index));
            }
        }
        return result;
    }

    /**
     * @param index           index start from 0 to text.length-1
     * @param text            String that we have to encrypt
     * @param rotationalShift int number replaced with rotationalShift digits higher (wrapping
     *                        around from 9 to 0)
     * @param startAscii      Ascii value of character or digit (e.g. 0 -> 48, A -> 65, a -> 97)
     * @param totalLength     length of characters or digits (e.g. numbers -> 10 (0-9),
     *                        characters -> 26 (A-Z | a-z))
     * @return encrypted character
     */
    private static char rotationCipherLogic(int index, String text, int rotationalShift,
                                            int startAscii, int totalLength) {
        return (char) (((int) text.charAt(index) +
                rotationalShift - startAscii) % totalLength + startAscii);
    }
}


