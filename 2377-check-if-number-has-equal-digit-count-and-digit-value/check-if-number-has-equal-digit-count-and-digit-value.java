import java.util.*;

class Solution {
    public boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of digits
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        // Check condition
        for (int i = 0; i < num.length(); i++) {
            int expected = num.charAt(i) - '0';
            int actual = map.getOrDefault(i, 0);

            if (actual != expected) {
                return false;
            }
        }

        return true;
    }
}