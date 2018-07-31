package com.qianmi.yqqlm.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 行为参数化
 *
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/30
 */
public class MyLambda {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }


    /**
     * 什么是Lambda表达式
     * - 可传递的匿名函数
     */
    private static Predicate<Apple> FIND_GOOD_APPLE = apple -> "Red".equals(apple.getColor());

    private static BiPredicate<List<Apple>, Apple> CONTAINS_MY_APPLE = (list, apple) -> list.contains(apple);

    private static Consumer<String> c = x -> System.out.println(x.toUpperCase());
    private static Consumer<String> l = x -> System.out.println(x.toLowerCase());


    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(new BigDecimal(100), "Red")
                , new Apple(new BigDecimal(50), "Red")
                , new Apple(new BigDecimal(108), "Red")
                , new Apple(new BigDecimal(180), "Green"));


        // 这不是low逼写法吗
        List<Apple> goodAppleList1 = filter(apples, FIND_GOOD_APPLE);


        List<Apple> goodAppleList2 = apples.stream().filter(FIND_GOOD_APPLE).collect(Collectors.toList());

        for (Apple apple : goodAppleList1) {
            System.out.println(String.format("Weight: %s,  Color: %s", apple.getWeight(), apple.getColor()));
        }
        System.out.println("---");
        for (Apple apple : goodAppleList2) {
            System.out.println(String.format("Weight: %s,  Color: %s", apple.getWeight(), apple.getColor()));
        }


        Apple myApple = new Apple(new BigDecimal(51), "Red");
        Boolean isContainer = CONTAINS_MY_APPLE.test(apples, myApple);
        System.out.println("是否存在我的苹果: " + isContainer);


        c.andThen(l).accept("hello,World!");


    }
}
