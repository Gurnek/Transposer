package com.xyz.gbd.lib;

public class SansMachine {
    private static int pos = -1;
    private static String[] notes = new String[] {"d", "d", "d", "a"};

    public boolean input(String note) {
        if (note.equals(notes[pos + 1])) {
            pos++;
            return pos == 3;
        } else {
            pos = -1;
            return false;
        }
    }
}
