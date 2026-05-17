class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """

        if n == 1 and len(trust) == 0:
            return 1
            
        delta = defaultdict(int)

        for src, dst in trust:
            delta[src] -= 1
            delta[dst] += 1
        
        for i in range(n+1):
            if delta[i] == n-1:
                return i

        return -1