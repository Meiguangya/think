package leetcode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            StringBuilder str = new StringBuilder();
            for(int j = 0;j<word.length();j++){
                char c = word.charAt(j);
                str.append(codes[c-'a']);
            }
            set.add(str.toString());
        }
        return set.size();
    }

}
