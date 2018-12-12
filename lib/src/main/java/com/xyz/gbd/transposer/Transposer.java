package com.xyz.gbd.transposer;

import java.util.ArrayList;
import java.util.Arrays;

public class Transposer {

    public int getSteps(String key1, String key2) {
        ArrayList<String> possibleKeys = new ArrayList<> (Arrays.asList("C", "Db", "Dd", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"));
        int firstPos = possibleKeys.indexOf(key1);
        int secondPos = possibleKeys.indexOf(key2);
        int steps = (Math.abs(firstPos - secondPos));
        if (firstPos > secondPos) {
            steps *= -1;
        }
        return steps;
    }
    public double transposeNote(double noteValue, int steps) {
        double noteTemp = noteValue;
        boolean isInteger = false;
        if (noteTemp % 1 == 0.0) {
            isInteger = true;
        }
        for (int i = 0; i < Math.abs(steps); i++) {
            if (steps > 0) {
                if (noteTemp % 7 == 2 || noteTemp % 7 == 6) {
                    noteTemp += 1;
                }
                else if (isInteger) {
                    noteTemp += 0.4;
                    isInteger = false;
                } else {
                    noteTemp += 0.6;
                    isInteger = true;
                }
            } else {
                if (noteTemp % 7 == 3 || noteTemp % 7 == 0) {
                    noteTemp -= 1;
                } else if (isInteger) {
                    noteTemp -= 0.4;
                    isInteger = false;
                } else {
                    noteTemp -= 0.6;
                    isInteger = true;
                }
            }
        }
        return noteTemp;
    }
}
