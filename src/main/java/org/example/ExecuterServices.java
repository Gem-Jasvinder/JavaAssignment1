package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class Uses Executor Service to run 5 threads in parallel and add/retrieve 500k entries from each Map Object
 * @author Jasvinder Singh
 * @version 1
 * @since 20/07/2022
 */
public class ExecuterServices {

    public static final Logger logger= LoggerFactory.getLogger(ExecuterServices.class);
    /**
     * Iterate each and every map number of times to calculate average time taken by each map.
     * Uses class ExecuterClass to implement task of add/retrieve data.
     * @param map key-String value-Integer
     * @throws Exception
     */
    public void executerServices(Map<String,Integer> map) throws Exception{
        long averageTime = 0;
        //Iterating each Map 5 times to measure AverageTime.
        for (int i = 0; i < 5; i++) {
            logger.info("Test Started for:" + map.getClass());//Receive class of Parameter
            long startTime = System.nanoTime();//Measuring starting time
            ExecutorService executorService = Executors.newFixedThreadPool(5);//Using ExecutorService to build ThreadPool of size 5
            ExecuterClass task = new ExecuterClass(); //Class where task to add/retrieve data is implemented.
            for (int j = 0; j < 5; j++) {
                executorService.execute(task.newRunnable(map));//Running Threads to do tasks.
            }
            executorService.shutdown();
            // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            long endTime = System.nanoTime();//measuring end time.
            long totalTime = (endTime - startTime) / 1000000L;//measuring total time
            averageTime += totalTime; //measuring average time of each type of Map.
            logger.info("500K entried added/retrieved in " + totalTime + " ms");//Displaying time of each iteration.
        }
        logger.info("For " + map.getClass() + " the average time is " + averageTime / 5 + " ms\n");//Comparing the performance.
    }
}
