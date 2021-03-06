public class Solution {
    public boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (c == ')' || c == ']' || c == '}') {
                    char topChar = stack.pop();
                    if (c == ')' && topChar != '(') {
                        return false;
                    }
                    if (c == ']' && topChar != '[') {
                        return false;
                    }
                    if (c == '}' && topChar != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("{哈哈()[阿松大]}"));
        System.out.println(solution.isValid("()({}[])[]{}"));
    }
}
