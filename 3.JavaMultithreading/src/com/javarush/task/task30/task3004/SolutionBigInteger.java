package com.javarush.task.task30.task3004;

import java.math.BigInteger;

/* 
Fork/Join
*/
public class SolutionBigInteger {
    private String binaryRepresentationMethod(BigInteger x) {
        BigInteger[] divideAndRemainder = x.divideAndRemainder(BigInteger.valueOf(2));
        String result = String.valueOf(divideAndRemainder[1]);
        if (divideAndRemainder[0].compareTo(BigInteger.ONE) > 0) {
            return binaryRepresentationMethod(divideAndRemainder[0]) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        long time_before = System.currentTimeMillis();
        SolutionBigInteger solution = new SolutionBigInteger();
        String result1 = solution.binaryRepresentationMethod(new BigInteger("123456789123456789123456789123456789123456789" +
                "123456789126789123456789123456789123912345678912345678912456789123456789123456789"));
        System.out.println(result1);

        /*System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);*/

        long time_after = System.currentTimeMillis();
        System.out.println("Time elapsed = " + (time_after - time_before));
    }

}
