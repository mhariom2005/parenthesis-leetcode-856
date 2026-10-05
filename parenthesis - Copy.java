import java.util.Stack;

public class parenthesis {
    public int score(String s) {
        int count = 0;
        Stack<Integer> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') st.push(0);
            else {
                int val = 0;
                while (st.peek() != 0) val += st.pop();
                st.pop();
                st.push(Math.max(2 * val, 1));
            }
        }

        while (!st.isEmpty()) count += st.pop();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new parenthesis().score("(()())"));
    }
}