class Solution(object):
    def sortedSquares(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l, r = 0, len(nums) - 1
        res = []
        while l <= r:
            if nums[l] * nums[l] < nums[r] * nums[r]:
                res.append(nums[r] * nums[r])
                r -= 1
            else:
                res.append(nums[l] * nums[l])
                l += 1
        return res[::-1]