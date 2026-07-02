class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        hashmap = {
            "I" : 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        res = 0

        for i in range(len(s)):
            currVal = hashmap[s[i]]

            if i+1 < len(s) and currVal < hashmap[s[i+1]]:
                res -= currVal
            else:
                res += currVal

        return res