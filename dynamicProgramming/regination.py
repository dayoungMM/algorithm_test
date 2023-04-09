#뒤쪽날짜부터 확인
# 현재상담일자의 이윤 + 현재 상담을 마친 날짜부터 최대의 이윤 중 최댓값
if __name__ == '__main__':
    n = int(input())
    t = []
    p = []
    dp = [0] * (n + 1)
    max_value = 0

    for _ in range(n):
        x, y = map(int, input().split())
        t.append(x)
        p.append(y)

    ##뒤에서부터 확인
    for i in range(n -1, -1, -1):
        time = t[i] + i
        if time <= n:
            dp[i] = max(p[i] + dp[time], max_value)
            max_value = dp[i]
        else:
            dp[i] = max_value
    print(max_value)