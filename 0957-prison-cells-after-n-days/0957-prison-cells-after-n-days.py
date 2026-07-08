class Solution(object):
    def prisonAfterNDays(self, cells, n):
        """
        :type cells: List[int]
        :type n: int
        :rtype: List[int]
        """
        n = (n - 1) % 14 + 1
        
        for _ in range(n):
            prev = cells[0]
            # Update only inner cells since edges lack double neighbors
            for i in range(1, len(cells) - 1):
                current = cells[i]
                # If left neighbor (prev) matches right neighbor, set to 1
                if prev == cells[i + 1]:
                    cells[i] = 1
                else:
                    cells[i] = 0
                prev = current
                
            # Boundary cells always become 0 after day 1
            cells[0] = 0
            cells[-1] = 0
            
        return cells