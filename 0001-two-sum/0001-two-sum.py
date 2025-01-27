class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index_map = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in index_map:
                return [index_map[complement], i]

            index_map[num]= i