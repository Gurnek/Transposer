package com.xyz.gbd.lib;

public class SansMachine {
    private static int pos = -1;
    private static String[] notes = new String[]{"b4", "b4", "b5", "f#5"};

    public static boolean input(String note) {
        if (note.equals(notes[pos + 1])) {
            pos++;
            return true;
        } else {
            pos = -1;
            return false;
        }
    }
}
