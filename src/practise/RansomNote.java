package practise;

import java.awt.event.ItemEvent;
import java.util.*;

class RansomNote {

    public static boolean canConstruct(String text, String note) {

        // time O(m) m is the length of character text
        // spaace O(1) as its possible only alphabet
        text = text.trim();
        note = note.trim();
        if (note.length() > text.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c: text.toCharArray()) {
            if (map.containsKey(c) || c.charValue() == ' ') {
                continue;
            }
            map.put(c, map.getOrDefault(c, 1));
        }

        int uniqueCharacterMapSize = map.size();

        for (Character c: note.toCharArray()) {
            if (c == ' ') continue;
            if (map.containsKey(c)) {
                map.remove(c);
            }
        }
        int afterRemoveNoteMapSize = map.size();
        if (afterRemoveNoteMapSize + note.length() == uniqueCharacterMapSize) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog The quick brown fox jumps over the lazy dog";
        String note = "visa";
        System.out.println(canConstruct(text, note));
    }
}

