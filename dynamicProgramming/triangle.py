# 왼쪽 위, 바로 위에서만 내려올 수 있음
if __name__ == '__main__':
    n = input()
    dp = []
    for _ in range(n):
        dp.append(list(map(int, input().split())))
    for i in range(1, n):
        for j in range(i + 1):
            #왼쪽 위
            if j == 0:
                up_left = 0
            else:
                upleft = dp[i-1][j-1]
            #위
            if j == i:
                up = 0
            else:
                up = dp[i - 1][j]
            dp[i][j] = dp[i][j] + max(upleft, up)
    print(max(dp[n-1]))