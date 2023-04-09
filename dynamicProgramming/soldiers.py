if __name__ == '__main__':
    n = int(input())
    array = list(map(int, input().split()))
    #수열을 뒤집어 가장 긴 증가하는 브분 수열 문제로 변환
    array.revers()

    dp= [1] * n

    for i in range(1, n):
        for j in range(0, i):
            if array[j] < array[i]:
                dp[i] = max(dp[i], dp[j] + 1)
    #열외시켜야하는 병사의 최소 수
    print(n - max(dp))
