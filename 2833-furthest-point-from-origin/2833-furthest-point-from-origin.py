class Solution(object):
    def furthestDistanceFromOrigin(self, moves):
        """
        :type moves: str
        :rtype: int
        """
        return abs(moves.count("R") - moves.count("L")) + moves.count("_")