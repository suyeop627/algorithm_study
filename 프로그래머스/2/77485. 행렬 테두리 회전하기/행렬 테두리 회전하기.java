class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = generateMatrix(rows, columns);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotateAndFindMin(matrix, queries[i]);
        }
        return answer;
    }

    private int rotateAndFindMin(int[][] matrix, int[] query) {
        int top    = query[0] - 1;
        int left   = query[1] - 1;
        int bottom = query[2] - 1;
        int right  = query[3] - 1;

        //현재 값
        int nowValue = matrix[top][left];
        int minValue = nowValue;

        // 위쪽 (top, left+1) ~ (top, right)
        for (int col = left + 1; col <= right; col++) {
            int tmp = matrix[top][col];
            matrix[top][col] = nowValue;
            nowValue = tmp;
            minValue = Math.min(minValue, nowValue);
        }

        // 오른쪽 (top+1, right) ~ (bottom, right)
        for (int row = top + 1; row <= bottom; row++) {
            int tmp = matrix[row][right];
            matrix[row][right] = nowValue;
            nowValue = tmp;
            minValue = Math.min(minValue, nowValue);
        }

        // 아래쪽 (bottom, right-1) ~ (bottom, left)
        for (int col = right - 1; col >= left; col--) {
            int tmp = matrix[bottom][col];
            matrix[bottom][col] = nowValue;
            nowValue = tmp;
            minValue = Math.min(minValue, nowValue);
        }

        // 왼쪽 (bottom-1, left) ~ (top, left)
        for (int row = bottom - 1; row >= top; row--) {
            int tmp = matrix[row][left];
            matrix[row][left] = nowValue;
            nowValue = tmp;
            minValue = Math.min(minValue, nowValue);
        }

        return minValue;
    }

    private int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}