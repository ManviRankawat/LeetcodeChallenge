class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return nums[0]

        loot = [0] * len(nums)
        loot[0] = nums[0]
        loot[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            loot[i] = max(loot[i-2] + nums[i], loot[i-1])

        return loot[-1]