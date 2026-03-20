class Solution(object):
    def shuffle(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: List[int]
        """
        res = []

        for i in range(n):
            res+= [nums[i]]
            res+=[nums[i+n]]

        return res