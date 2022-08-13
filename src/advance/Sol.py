def powe(a, b):
    res = 1
    while(b):
        if(b % 2):
            res = (res * a) % mod
            b -= 1
        else:
            a = (a * a) % mod
            b = b // 2
    return res % mod
class Solution:
    # @param A : integer
    # @return an integer
    def solve(self, A):
        ans = powe(3, A - 2)
        ans = (ans * A) % mod
        return int((ans * (A - 1)) % mod)