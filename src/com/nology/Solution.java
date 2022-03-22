package com.nology;

//Intro
//        To solve this challenge, feel free to use any and all resources available to you. Once you start the exercise, you'll have two hours to complete and submit your solution.
//
//        Challenge - Pig Latin
//        Pig Latin is a farcical "language" used to entertain children, but also to teach them some valuable language concepts along the way. Translating English to Pig Latin is simple:
//
//        Take the first consonant (or cluster of consonants) of a word, move it to the end of the word, and add a suffix of "ay" 2) If a word begins with a vowel, just add "way" at the end 3) For the sake of readability, separate the Pig Latin-ized parts of the word with a dash -
//        Your challenge is to implement the method pigLatinize that takes a string phrase and translates it to Pig Latin. You're free to add additional classes, variables, and methods if you would like.
//
//        The input phrase could be as short as a single word, or as long as multiple sentences or paragraphs. Whitespace, capitalization, and punctuation should be honored and maintained in your final answer.
//
//        Examples
//        "pig" => "ig-pay" 2) "pig latin" => "ig-pay atin-lay" 3) "Pig Latin" => "ig-Pay atin-Lay"
//        Starting Code

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(pigLatinize("pig")); // should print out "ig-pay"
        System.out.println(pigLatinize("pig latin"));
        System.out.println(pigLatinize("Pig Latin"));
        System.out.println(pigLatinize("Atest"));
    }

    // Implement this method:
    public static String pigLatinize(String phrase) {
        List<String> vowels = new ArrayList<>(List.of("a","e","i","o","u"));
        String[] words = phrase.split(" ");
        List<String> pigLatinedWords = new ArrayList<>();
        for(String word: words) {
            String[] sets = word.split("(?=[aeiou])");
            if(sets[0].length()==0) {
                pigLatinedWords.add(word + "-way");
            } else {
                pigLatinedWords.add(sets[1] + "-" + sets[0] + "ay");
            }
        }
        return String.join(" ", pigLatinedWords);
    }
}