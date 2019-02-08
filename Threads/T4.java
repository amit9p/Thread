package com.capitalone.spring.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T4 {

    public static void main(String[] args)throws Exception {


        Map<String , Object> map1 = new HashMap<>();
        Map<String , Object> map2 = new HashMap<>();
        Map<String , Object> map3 = new HashMap<>();
        Map<String , Object> map4 = new HashMap<>();


        map1.put("1", 1);
        map1.put("2", 2);
        map1.put("3", 3);
        map1.put("4", 4);
        map1.put("5", 5);
        map1.put("6", 6);


        map2.put("7", 7);
        map2.put("8", 8);
        map2.put("9", 9);
        map2.put("10", 10);
        map2.put("11", 11);
        map2.put("12", 12);

        map3.put("13", 13);
        map3.put("14", 14);
        map3.put("15", 15);
        map3.put("16", 16);
        map3.put("17", 17);
        map3.put("18", 18);

        map4.put("19", 19);
        map4.put("20", 20);
        map4.put("21", 21);
        map4.put("22", 22);
        map4.put("23", 23);
        map4.put("24", 24);

        List<Map<String,Object>> list = new ArrayList<>();

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        int size = list.size();
        System.out.println("size ="+size);

        Multi obj[]= new Multi[size];
        int count = 0;

        for(Map O : list)
        {
            obj[count]= new Multi(O);
            obj[count].start();

            count++;

        }

        for (Multi t :obj)
        {
            t.join();
            System.out.println(Thread.currentThread().getName()+"======joining");
        }

        System.out.println("#######################");

    }
}

class Multi extends Thread{
    Map O ;
    public Multi()
    {

    }
    public Multi(Map O)
    {
        this.O = O;
    }
    public void run(){

        this.O.forEach((k,v)->{
            System.out.println(Thread.currentThread().getName()+"---------Key : " + k + " Val : " + v);

        });
    }

}
