package ru.lemur.helpers;

import java.util.Random;

/**
 * Генераторы
 */
public class Generators {
    private static String chars= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString(int length) {
        Random rnd = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = chars.charAt(rnd.nextInt(chars.length()));
        }

        return new String(text);
    }
}
