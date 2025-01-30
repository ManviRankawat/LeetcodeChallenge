class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s.split():
            return len(s.split()[-1])
        return 0
        
        