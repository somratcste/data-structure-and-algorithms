package practise;

import java.util.HashMap;
import java.util.Map;

public class MS1 {

    public static Map<String, Boolean> removeAdjacentString(String string, boolean isRemove) {
        StringBuilder removeCharacters = new StringBuilder();
        int i = 0;
        while ( i < string.length() - 1) {
            if((string.charAt(i)== 'A' && string.charAt(i+1) == 'B') || (string.charAt(i) == 'B' && string.charAt(i+1) == 'A')) {
                removeCharacters.append(string.charAt(i)).append(string.charAt(i+1));
                i += 2;
                isRemove = true;
            } else if((string.charAt(i)== 'C' && string.charAt(i+1) == 'D') || (string.charAt(i) == 'D' && string.charAt(i+1) == 'C')) {
                removeCharacters.append(string.charAt(i)).append(string.charAt(i+1));
                i += 2;
                isRemove = true;
            } else {
                i++;
            }
        }

        Map<String, Boolean> result = new HashMap<>();
        result.put(string.replace(removeCharacters, ""), isRemove);
        return result;
    }

    public static void main(String[] args) {
//        String string = "CBACD";
        String string = "CABABD";
//        String string = "ACBDACBD";
        if (string == null) {
            System.out.println("null");
        }

        Map<String, Boolean> result = removeAdjacentString(string, false);

        String finalString = (String) result.keySet().toArray()[0];
        boolean isRemove = result.get(finalString);

        if (isRemove) {
            result = removeAdjacentString(finalString, false);
            finalString = (String) result.keySet().toArray()[0];
            isRemove = result.get(finalString);
        }

        System.out.println("result " + finalString);

    }
}
