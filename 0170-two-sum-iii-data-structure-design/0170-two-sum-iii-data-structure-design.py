class TwoSum(object):

    def __init__(self):
        self.ctr = {}

    def add(self, number):
        """
        :type number: int
        :rtype: None
        """
        if number in self.ctr:
            self.ctr[number] += 1
        else:
            self.ctr[number] = 1
        

    def find(self, value):
        """
        :type value: int
        :rtype: bool
        """
        ctr = self.ctr
        for num in ctr:
            if value - num in ctr and (value - num != num or ctr[num] > 1):
                return True
        return False        


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)