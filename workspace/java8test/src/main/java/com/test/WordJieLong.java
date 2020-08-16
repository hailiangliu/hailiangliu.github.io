package com.test;

/**
 * 农行社招 笔试算法
 * 给定一个 数组 word  ["happy","taxi","yes"]
 * 按照规则返回一下接龙
 * 从第0个开始，为cur_word  从cur_word的最后一个字母char，去word中查找
 * 从左到右查找，查找以char为靠头的单词并汇总，如果查不到，则按字典递增，如a为b, z变更为a
 * <p>
 * 最终返回["happy","yes","taxi"]
 */
public class WordJieLong {


    public static void main(String[] args) {
        WordJieLong test = new WordJieLong();
        String[] result =test.solution(new String[]{"happy","taxi","yes"});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public String[] solution(String[] word) {

        String[] result = new String[word.length];

        result[0] = word[0];

        word[0] = null;

        String currString = result[0];

        for (int i = 1; i < result.length; i++) {

            char toFindChar = currString.charAt(currString.length() - 1);

            String toFindString = findStr(0,word, toFindChar);

            result[i] = toFindString;

            currString = result[i];

        }
        return result;

    }

    public static String findStr(int index, String[] word, char toFindChar){
        String toFindString = null;
        for (int i = index; i < word.length; i++) {
            if(word[i]==null) continue;
            if (word[i].charAt(0) == toFindChar) {
                toFindString = word[i];
                word[i] = null;
            }
        }
        if (toFindString == null){
            toFindChar = addChar(toFindChar);
            return findStr(index, word, toFindChar);
        }
        return toFindString;

    }
    public static char addChar(char c){
        if (c=='a') return 'b';
        if (c=='b') return 'c';
        if (c=='c') return 'd';
        if (c=='d') return 'e';
        if (c=='e') return 'f';
        if (c=='f') return 'g';
        if (c=='g') return 'h';
        if (c=='h') return 'i';
        if (c=='i') return 'j';
        if (c=='j') return 'k';
        if (c=='k') return 'l';
        if (c=='l') return 'm';
        if (c=='m') return 'n';
        if (c=='n') return 'o';
        if (c=='o') return 'p';
        if (c=='p') return 'q';
        if (c=='q') return 'r';
        if (c=='r') return 's';
        if (c=='s') return 't';
        if (c=='t') return 'u';
        if (c=='u') return 'v';
        if (c=='v') return 'w';
        if (c=='w') return 'x';
        if (c=='x') return 'y';
        if (c=='y') return 'z';
        if (c=='z') return 'a';
        throw  new RuntimeException("data error");
    }

}
