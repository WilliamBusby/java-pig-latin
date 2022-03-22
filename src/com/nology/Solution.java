package com.nology;

//Intro
//        To solve this challenge, feel free to use any and all resources available to you.
//        Once you start the exercise, you'll have two hours to complete and submit your solution.
//
//        Challenge - Pig Latin
//        Pig Latin is a farcical "language" used to entertain children, but also to teach them some valuable language concepts along the way.
//        Translating English to Pig Latin is simple:
//
//        Take the first consonant (or cluster of consonants) of a word, move it to the end of the word,
//        and add a suffix of "ay"
//        2) If a word begins with a vowel, just add "way" at the end
//        3) For the sake of readability, separate the Pig Latin-ized parts of the word with a dash -
//        Your challenge is to implement the method pigLatinize that takes a string phrase and translates it to Pig Latin.
//        You're free to add additional classes, variables, and methods if you would like.
//
//        The input phrase could be as short as a single word, or as long as multiple sentences or paragraphs.
//        Whitespace, capitalization, and punctuation should be honored and maintained in your final answer.
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
        System.out.println(pigLatinize("Pig Latin!"));
//        System.out.println(pigLatinize("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget pulvinar ligula. Nulla velit tortor, convallis vel ipsum sit amet, feugiat ullamcorper nibh. Mauris porttitor orci nec augue eleifend, id laoreet est maximus. In hac habitasse platea dictumst. Morbi eu egestas velit. Praesent efficitur nunc eget libero sagittis, et condimentum turpis semper. Morbi pulvinar elit erat, rhoncus placerat nisi vestibulum a. Nam interdum finibus lacus quis vestibulum. Vestibulum dignissim, diam a pharetra fringilla, lacus tellus sodales metus, eu pretium nisi ante ut risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus at massa at nulla pretium auctor. In ut euismod diam, sit amet posuere metus."));
    }

    // Implement this method:
    public static String pigLatinize(String phrase) {
        String[] words = phrase.split(" ");
        List<String> pigLatinedWords = new ArrayList<>();
        for(String word: words) {
            word = " " + word;
            String[] sets = word.split("(?i)(?=[aeiou])");
            for(int i = 2; i<sets.length;i++) {
                sets[1] += sets[i];
            }
            if(sets[0].length() == 1) {
                pigLatinedWords.add(punctuate(word.replace(" ","") + "-way"));
            } else {
                pigLatinedWords.add(punctuate(sets[1] + "-" + sets[0].replace(" ", "") + "ay"));
            }
        }
        return String.join(" ", pigLatinedWords);
    }

    public static String punctuate(String word) {
        for(int i = 0; i<word.length(); i++) {
            if(!Character.isLetter(word.charAt(i)) && word.charAt(i) != '-') {
                return word.substring(0,i) + word.substring(i+1) + word.charAt(i);
            }
        }
        return word;
    }
}