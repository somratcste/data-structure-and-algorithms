package stack;
import java.util.*;

public class MinMaxStack {
    List<Map<String, Integer>> minMaxStack = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();

    // O(1) time | O(1) space
    public int peek() {
        return stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int pop() {
        minMaxStack.remove(minMaxStack.size()-1);
        return stack.remove(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
        Map<String, Integer> newMinMax = new HashMap<>();
        newMinMax.put("min", number);
        newMinMax.put("max", number);
        if (minMaxStack.size() > 0) {
            Map<String, Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size()-1));
            newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
            newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
        }
        minMaxStack.add(newMinMax);
        stack.add(number);
    }

    // O(1) time | O(1) space
    public int getMin() {
        return minMaxStack.get(minMaxStack.size()-1).get("min");
    }

    // O(1) time | O(1) space
    public int getMax() {
        return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
}
