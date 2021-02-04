package com.advent.days;

import com.util.Utils;
import java.util.List;
import java.io.File;

public class Day1 {

    public static void main(String[] args) {
        String path = "AdventOfCode/2020/data/day1.txt";
        List<Integer> intList = Utils.convertFileToIntList(new File(path));
        System.out.println(getProduct(intList));
        System.out.println(get3Product(intList));
    }

    public static int getProduct(List<Integer> intList) {

        for(int val: intList) {
            
            int reqVal = 2020 - val;
            if(intList.contains(reqVal)) {
                System.out.println(val + " + " + reqVal);
                return val * reqVal;
            }
        }

        return 0;
    }

    public static int get3Product(List<Integer> intList) {

        for(int i = 0; i < intList.size(); i++) {
            for(int j = i + 1 ; j < intList.size(); j++) {
                int reqVal = 2020 - (intList.get(i) + intList.get(j));
                if(intList.contains(reqVal)) {
                    System.out.println( intList.get(i) + " + " + intList.get(j) + " + " + reqVal);
                    return intList.get(i) * intList.get(j) * reqVal;
                }
            }
        }

        return 0;
    }

}