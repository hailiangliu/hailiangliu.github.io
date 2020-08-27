package com.guava;

import com.google.common.base.MoreObjects;
import org.junit.Test;

public class GuavaTest {

    @Test
    public void testMoreObjects(){
        // 输出： GuavaTest{key=val}
        System.out.println(MoreObjects.toStringHelper(this).add("key", "val").toString());
        //输出：{key=val}
        System.out.println(MoreObjects.toStringHelper("").add("key", "val").toString());

    }
}
