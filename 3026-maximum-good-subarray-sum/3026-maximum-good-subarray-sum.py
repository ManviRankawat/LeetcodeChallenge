class Solution(object):
    def maximumSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        prefix_left = defaultdict(lambda: float('inf'))
        res = float('-inf')
        cur = 0
        
        for x in nums:
            prefix_left[x] = min(prefix_left[x], cur)
            cur += x
            
            if x-k in prefix_left:
                res = max(res, cur - prefix_left[x-k])
            if x+k in prefix_left:
                res = max(res, cur - prefix_left[x+k])
        
        return res if res != float('-inf') else 0