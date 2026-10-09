
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // Every ')' must be part of a pair '))'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++;
                }

                // Match the pair with an opening '('
                if (open > 0) {
                    open--;
                } else {
                    // Insert a missing '('
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two ')'
        return insertions + open * 2;
    }
}
