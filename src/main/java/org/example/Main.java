package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Main class where object of HashMap,SynchronisedHashMap and ConcurrentHashMap is made.
 * Object of Class ExecuterServices is made.
 * Method of Class ExecuterServices is used.
 * @author Jasvinder Singh
 * @version 1
 * @since 20/07/2022
 */
public class Main {
    /**
     * This is the main method which makes use of executerServices method and pass each and every map as argument.
     * @param args Unused.
     * @throws  Exception On input error.
     */
    public static void main(String[] args) throws Exception {

        //Object of ExecuterServices where ThreadPool is made and Implementation of get/retrieve data is done.
        ExecuterServices services=new ExecuterServices();

        //Object of HashMap
        Map<String,Integer> hashMap=new HashMap<>();
        services.executerServices(hashMap); //passing object of HashMap as argument in method of ExecuterService class

        Map<String,Integer> synchronisedHashMap= Collections.synchronizedMap(new HashMap<>());
        services.executerServices(synchronisedHashMap);

        Map<String,Integer> concurrentHashMap=new ConcurrentHashMap<>();
        services.executerServices(concurrentHashMap);

        System.out.println("Hello world!");
    }
}