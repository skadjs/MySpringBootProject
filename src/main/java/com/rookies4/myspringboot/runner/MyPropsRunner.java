package com.rookies4.myspringboot.runner;

import java.util.Arrays;
import java.util.function.Consumer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyPropsRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("VM Arguments = " + args.containsOption("foo"));
        System.out.println("Program Arguments = " + args.containsOption("bar"));

        // Program Argument의 모든 이름을 출력하기
        for (String argName : args.getOptionNames()) {
            System.out.println("아규먼트 이름 = " + argName);
        }

        // args.getOptionNames()의 리턴타입: Set<String>
        // Iterable의 foreach() 메서드 호출하기
        // Consumer의 추상메서드 void accept(T t)
        // 1. 익명의 Inner class (Anonymous Inner Class)
        args.getOptionNames().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Inner Class 아규먼트 이름 = " + s);
            }
        });
    }
}