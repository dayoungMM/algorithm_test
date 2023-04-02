if __name__ == '__main__':
    x = int(input())

    d = [0] * 30001

    for i in range(2, x+1):
        # 현재의 수에서 1을 빼는 경우 (무조건 계산)
        d[i] = d[i-1] +1
        # 현재의 수가 2로 나누어떨어지는 경우, 현재값이랑 2로 나누어서 계산한 결과랑 비교해서 min값
        if i % 2 == 0:
            d[i] = min(d[i], d[i // 2] + 1)
        if i % 3 == 0:
            d[i] = min(d[i], d[i // 3] + 1)
        if i % 5 == 0:
            d[i] = min(d[i], d[i // 5] + 1)
    print(d[x])