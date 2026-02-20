class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        left, right = 1, max(piles)

        while left < right:
            mid = (left + right) // 2
            hour_spent = sum(math.ceil(pile / float(mid)) for pile in piles)

            if hour_spent <= h:
                right = mid       # mid might be the answer, but try slower
            else:
                left = mid + 1    # too slow, must go faster

        return left