class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []
        for i in range(numRows):
            row = [1] * (i + 1)          # Pre-fill with 1s (handles edges automatically)
            for j in range(1, i):        # Only inner elements need computing
                row[j] = ans[i-1][j-1] + ans[i-1][j]  # Sum from previous row
            ans.append(row)
        return ans
        