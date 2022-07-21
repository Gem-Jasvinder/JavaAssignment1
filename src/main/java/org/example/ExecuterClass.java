package org.example;

import java.util.Map;

/**
 * Class implement task to add/retrieve data.
 * @author Jasvinder Singh
 * @version 1
 * @since 20/07/2022
 */
public class ExecuterClass {
    /**
     * Adding and retrieving data.
     * @param map key-String value-Integer
     * @return Runnable
     */
    public Runnable newRunnable(Map<String,Integer> map){
        return  new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<500000;i++){
                    Integer randomNumber=(int)Math.ceil(Math.random()*500000);

                    //Put value
                    map.put(String.valueOf(randomNumber),randomNumber);

                    //Retrieve value which will not be used anywhere
                    Integer randomValue2=map.get(String.valueOf(randomNumber));
                }
            }
        };
    }
}
