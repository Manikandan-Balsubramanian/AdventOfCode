package com.advent.days;

import com.util.Utils;
import java.util.List;
import java.io.File;

public class Day3 {
    
    public static void main (String[] args) {
        String path = "AdventOfCode/2020/data/day3.txt";
        List<String> list = Utils.convertFileToStringList(new File(path));
        int s1 = treeCount(list, 1, 1);
        int s2 = treeCount(list, 3, 1);
        int s3 = treeCount(list, 5, 1);
        int s4 = treeCount(list, 7, 1);
        int s5 = treeCount(list, 1, 2);

        System.out.println(s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5);
        System.out.println(s1*s2*s3*s4*s5);
    }


    public static int treeCount(List<String> list, int right, int down) {
        int treeCounter = 0;
        int width = list.get(0).length();
        int currW = right;

        for(int i = down; i < list.size(); i+=down) {

            if(currW >= width) {
                currW = currW % width;
            }

            if(list.get(i).charAt(currW) == '#'){
                treeCounter++;
            }

            currW += right;
        }

        return treeCounter;
    }

}