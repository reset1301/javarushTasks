package com.javarush.task.task35.task3503;

import org.apache.log4j.Logger;

/*
Несколько суперклассов для дженерика
*/
public class Solution<T extends ClassForGenerics & InterfaceForGenerics> {
    private static final Logger log = Logger.getLogger(Solution.class);
    public static void main(String[] args) {
        log.debug("Start");
        Solution<TestClassGood> testClassSolution = new Solution<>();
        log.info("Create");
        testClassSolution.check();
        log.warn("Check");

        //!!! Следующие оба варианта не должны работать, закомментируй их:
//        Solution<TestClassWrong1> wrong1Solution = new Solution<>();
//        wrong1Solution.check();

//        Solution<TestClassWrong2> wrong2Solution = new Solution<>();
//        wrong2Solution.check();
    }

    public void check() {
        System.out.println("Works!");
    }

    public static class TestClassGood extends ClassForGenerics implements InterfaceForGenerics {

    }

    public static class TestClassWrong1 extends ClassForGenerics {

    }

    public static class TestClassWrong2 implements InterfaceForGenerics {

    }

}
