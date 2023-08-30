// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

public int maximalRectangle(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int maxA = 0;
    int hgt[] = new int[m];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(matrix[i][j] == '1'){
                hgt[j]++;
            }
            else{
                hgt[j] = 0;
            }
        }
        int area = lra(hgt);
        maxA = Math.max(maxA, area);
    }
    return maxA;
}

public int lra(int[] nums) {
    Stack<Integer> s = new Stack<>();
    int maxA = 0;
    int n = nums.length;
    for(int i = 0; i <= n; i++){
        while(!s.isEmpty() && (i == n || nums[s.peek()] >= nums[i])){
            int height = nums[s.peek()];
            s.pop();
            
            int width = 0;
            if(s.isEmpty()){
                width = i;
            }
            else{
                width = i - s.peek() - 1;
            }
            maxA = Math.max(maxA, width * height);
        }
        s.push(i);
    }
    return maxA;
}
