package com.xyz.gbd.transposer;

import java.util.ArrayList;
import java.util.Arrays;

public class Transposer {

    protected static final int MAX_STEPS = 5;

    public static int getSteps(String key1, String key2) {
        String modKey1 = key1.substring(0, 1);
        String modKey2 = key2.substring(0, 1);
        ArrayList<String> possibleKeys = new ArrayList<> (Arrays.asList("C", "D", "E", "F", "G", "A", "B"));
        int firstPos = possibleKeys.indexOf(key1);
        int secondPos = possibleKeys.indexOf(key2);
        int steps = (Math.abs(firstPos - secondPos));
        if (firstPos > secondPos) {
            steps *= -1;
        }
        return steps;
    }
    public static int transposeNote(int numSteps, int currentDist) {
        /**
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
         */
        int newDist = currentDist + (numSteps % 7);
        if (newDist > 5) {
            newDist -= 7;
        } else if (newDist < -5) {
            newDist += 7;
        }
        return newDist;
    }
}
