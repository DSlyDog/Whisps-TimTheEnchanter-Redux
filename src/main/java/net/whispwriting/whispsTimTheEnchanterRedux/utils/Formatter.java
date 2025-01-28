package net.whispwriting.whispsTimTheEnchanterRedux.utils;

import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Formatter {

    private final static TreeMap<Integer, String> map = new TreeMap<>();
    private final static List<String> articles = Arrays.asList("a", "an", "the", "of");;

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    public static String enchantmentFormat(String text){
        return Arrays.stream(text.split(" "))
                .map(word -> {
                    if (articles.contains(word.toLowerCase()))
                        return word;
                    else return capitalizeFirstLetter(word);
                })
                .collect(Collectors.joining(" "));

    }

    private static String capitalizeFirstLetter(String word){
        if (word.isEmpty())
            return word;

        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
