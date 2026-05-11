class Solution(object):
    def separateDigits(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans=[]
        for i in nums:
            i=str(i) 
            for j in i: 
                ans.append(int(j))
        return ans 