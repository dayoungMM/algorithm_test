def fibo(x):
    if x == 1 or x ==2:
        return 1
    ## 이미 계산한 적이 있다면
    if d[x] != 0:
        return d[x]

    d[x] = fibo(x-1) + fibo(x-2)
    return d[x]
if __name__ == '__main__':
    d = [0] * 100
    print(fibo(99))


