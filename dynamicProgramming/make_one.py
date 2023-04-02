def calculate(x, cnt):
    result = []
    if (x == 1):
        result.append(cnt)
    else :
        if x % 5 ==0 :
            result.append(calculate(x / 5, cnt + 1))
        if x % 3 == 0:
            result.append(calculate(x / 3, cnt + 1))
        if x % 2 == 0:
            result.append(calculate(x / 2, cnt + 1))
        result.append(calculate(x-1, cnt + 1))

    return min(result)

if __name__ == '__main__':
    print(calculate(26, 0))