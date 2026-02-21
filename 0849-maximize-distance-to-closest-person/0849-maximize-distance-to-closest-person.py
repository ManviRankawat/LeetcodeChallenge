class Solution(object):
    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        lastPersonIndex = -1
        maxDist = 0
        for i in range(len(seats)):
            if seats[i] == 1:
                if lastPersonIndex == -1:
                    maxDist = max(maxDist, i)
                else:
                    maxDist = max(maxDist, (i - lastPersonIndex) //2)
                lastPersonIndex = i
        
        maxDist = max(maxDist, len(seats) - lastPersonIndex - 1)

        return maxDist

        