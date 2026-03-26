class Solution(object):
    def numTilings(self, n):
        MOD = 1000000007

        if n == 1:
            return 1
        if n == 2:
            return 2

        f = [0] * (n + 1)
        p = [0] * (n + 1)

        f[1] = 1
        f[2] = 2
        p[2] = 1

        for i in range(3, n + 1):
            p[i] = (p[i - 1] + f[i - 2]) % MOD
            f[i] = (f[i - 1] + f[i - 2] + 2 * p[i - 1]) % MOD

        return f[n]