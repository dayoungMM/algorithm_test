

if __name__ == '__main__':
    n, m = 4, 6
    array = [19, 15, 10, 17]
    ## sort 해서 풀어도 되지만, max 값만 알아도 되기 때문에 연산 최소화를 위해 max 사용
    # array.sort()
    # end = array[-1]
    end = max(array)
    start = 0
    answer = 0
    while start <= end:
        mid = (start + end) // 2

        cutted_sum = sum(list(map(lambda x: x-mid if x > mid else 0, array)))
        if (cutted_sum == m):
            answer = mid
            break
        elif cutted_sum > m:
            ##오른쪽으로 움직여야해
            start = mid +1
        else:
            ##왼쪽으로 움직여야해
            end = mid -1
            answer = mid
    print(answer)


