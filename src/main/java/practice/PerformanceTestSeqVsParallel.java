package practice;

import java.util.Collections;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PerformanceTestSeqVsParallel {

    public static void main(String[] args) {

        // To check no. of core in the machine
        System.out.println("No of core:" + Runtime.getRuntime().availableProcessors());

        // To print the thread
        System.out.println("Current Thread: " + Thread.currentThread().getName());

        // To check performance

        System.out.println("Time taken during the sequential operation: " + checkPerformance(PerformanceTestSeqVsParallel::getSumUsingSequentialStream, 25));
        System.out.println("Time taken during the parallel operation: " + checkPerformance(PerformanceTestSeqVsParallel::getSumUsingParallelStream, 25));

        Random random = new Random();

        System.out.println("random: " + random.nextInt(5));

    }

    private static long checkPerformance(Supplier<Integer> sum, int noOfTimes) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i <= noOfTimes; i++) {
            sum.get();
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static int getSumUsingSequentialStream() {
        return IntStream.rangeClosed(0, 100000000).sequential().sum(); // default also its sequential no need to mention sequential()
    }

    private static int getSumUsingParallelStream() {
        return IntStream.rangeClosed(0, 100000000).parallel().sum();
    }
}
