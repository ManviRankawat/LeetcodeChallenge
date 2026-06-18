class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        stones = [-stone for stone in stones]
        heapq.heapify(stones)

        while len(stones) > 1:
            x = -heapq.heappop(stones)  # largest
            y = -heapq.heappop(stones)  # second largest

            if x != y:
                heapq.heappush(stones, -(x - y))

        return -stones[0] if stones else 0