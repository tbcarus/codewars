package MostFrequentlyUsedWordsInAText;

/*Write a function that, given a string of text (possibly with punctuation and line-breaks),
returns an array of the top-3 most occurring words, in descending order of the number of occurrences.

        Assumptions:
        A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
        Apostrophes can appear at the start, middle or end of a word ('abc, abc', 'abc', ab'c are all valid)
        Any other characters (e.g. #, \, / , . ...) are not part of a word and should be treated as whitespace.
        Matches should be case-insensitive, and the words in the result should be lowercased.
        Ties may be broken arbitrarily.
        If a text contains fewer than three unique words, then either the top-2 or top-1 words should be returned,
        or an empty array if a text contains no words.
        Examples:
        top_3_words("In a village of La Mancha, the name of which I have no desire to call to
        mind, there lived not long since one of those gentlemen that keep a lance
        in the lance-rack, an old buckler, a lean hack, and a greyhound for
        coursing. An olla of rather more beef than mutton, a salad on most
        nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
        on Sundays, made away with three-quarters of his income.")
        # => ["a", "of", "on"]

        top_3_words("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e")
        # => ["e", "ddd", "aa"]

        top_3_words("  //wont won't won't")
        # => ["won't", "wont"]
        For java users, the calls will actually be in the form: TopWords.top3(String s), expecting you to return
        a List<String>.

        Bonus points (not really, but just for fun):
        Avoid creating an array whose memory footprint is roughly as big as the input text.
        Avoid sorting the entire array of unique words.*/

import java.util.*;

public class TopWords {

    public static List<String> top3(String s) {
        String[] ss = s.toLowerCase()
                .replaceAll("[^a-zA-Z\\d\\s']|(\\s'+\\s)|(\\s'$)", " ")
                .replaceAll("\\s+", " ")
                .replaceAll("^\\s+|$\\s+", "")
                .split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String str : ss) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        List<String> words = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            words.add(entry.getKey());
            counts.add(entry.getValue());
        }

        List<String> list = new ArrayList<>();
        int n = Math.min(words.size(), 3);
        for (int i = 0; i < n; i++) {
            int max = Collections.max(counts);
            int index = counts.indexOf(max);
            list.add(words.remove(index));
            counts.remove(index);
        }


        if (list.get(0).isEmpty()) {
            list = new ArrayList<>();
        }
        return list;
    }
}
