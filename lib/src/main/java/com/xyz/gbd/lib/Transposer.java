package com.xyz.gbd.lib;

import java.util.ArrayList;
import java.util.Arrays;

import jm.*;

public class Transposer {

    public int getSteps(String key1, String key2) {
        ArrayList<String> possibleKeys = new ArrayList<> (Arrays.asList(("C", "Db", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"));
        int firstPos = possibleKeys.indexOf(key1);
        int secondPos = possibleKeys.indexOf(key2);
        int steps = (Math.abs(firstPos - secondPos));
        if (firstPos > secondPos) {
            steps *= -1;
        }
        return steps;
    }
}
