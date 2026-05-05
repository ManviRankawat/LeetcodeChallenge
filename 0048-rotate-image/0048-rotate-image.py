class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
    
        n = len(matrix)

        for i in range((n + 1) // 2):
            for j in range(n // 2):
                # temp = bottom left
                temp = matrix[n - 1 - j][i]

                # bottom left = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]

                # bottom right = top right
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]

                # top right = top left
                matrix[j][n - 1 - i] = matrix[i][j]

                # top left = temp
                matrix[i][j] = temp