package com.example.application2.recycler;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("  抖音小助手", "昨天"));
        result.add(new TestData("  三水", "星期日"));
        result.add(new TestData("  曹爱神", "07-04"));
        result.add(new TestData("  狸小牧", "07-02"));
        result.add(new TestData("  黑豆豆", "07-01"));
        result.add(new TestData("  系统消息", "05-21"));
        result.add(new TestData("  圆梦精灵", "03-26"));
        result.add(new TestData("  日系少年呦西桑", "03-22"));
        result.add(new TestData("  Do...", "10-20"));
        return result;
    }

}
