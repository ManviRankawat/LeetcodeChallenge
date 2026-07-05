class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        preMap = {i: [] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)

        output = []
        visiting = set()   # recursion stack
        visited = set()    # already processed

        def dfs(crs):
            if crs in visiting:
                return False      # cycle

            if crs in visited:
                return True       # already added

            visiting.add(crs)

            for pre in preMap[crs]:
                if not dfs(pre):
                    return False

            visiting.remove(crs)
            visited.add(crs)
            output.append(crs)

            return True

        for crs in range(numCourses):
            if not dfs(crs):
                return []

        return output