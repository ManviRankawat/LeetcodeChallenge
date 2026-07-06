class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        lastSeen = {}
        left = 0
        maxLen = 0

        for right, char in enumerate(s):
            if char in lastSeen and lastSeen[char] >= left:
                left = lastSeen[char] + 1
            lastSeen[char] = right
            maxLen = max(maxLen, right - left + 1)

        return maxLen