package com.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class JoinerTest {
    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("123","456","789",null);

        //不使用guava
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            if(word==null){
                sb.append("default");
            }else {
                sb.append(word);
            }
            sb.append(",");
        }
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
        //输出：123,456,789,default

        //使用guava
        System.out.println(Joiner.on(",").useForNull("default").join(words));
        //输出：123,456,789,default
        System.out.println(Joiner.on(",").skipNulls().join(words));
        //输出：123,456,789

        Map<String, String> data = ImmutableMap.of("a", "1", "b", "2");
        System.out.println(Joiner.on(",").withKeyValueSeparator("-").join(data));
        //output:a-1,b-2
        Map<String, Integer> data2 = ImmutableMap.of("a", 1, "b", 2);
        System.out.println(Joiner.on(",").withKeyValueSeparator("-").join(data2));
        //output:a-1,b-2

    }
}
