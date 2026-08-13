class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        finalPosition = len(nums) - 1

        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= finalPosition:
                finalPosition = i

        return finalPosition == 0