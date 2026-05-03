class Solution(object):
    def rotateString(self, s, goal):
        """
        :type s: str
        :type goal: str
        :rtype: bool
        """
        if len (s) == len(goal) and goal in (s + s):
            return True
        return False

        

        