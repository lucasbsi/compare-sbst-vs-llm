package app;

public class Calc {

    public int add(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("division by zero");
        return a / b;
    }

    public int clamp(int value, int min, int max) {
        if (min > max) throw new IllegalArgumentException("min > max");
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public int parseIntOrDefault(String s, int defaultValue) {
        if (s == null) return defaultValue;
        String t = s.trim();
        if (t.isEmpty()) return defaultValue;

        boolean neg = false;
        int i = 0;
        if (t.charAt(0) == '-') {
            neg = true;
            i++;
            if (i == t.length()) return defaultValue;
        }

        int n = 0;
        for (; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c < '0' || c > '9') return defaultValue;
            int digit = c - '0';
            n = n * 10 + digit;
        }
        return neg ? -n : n;
    }
}
