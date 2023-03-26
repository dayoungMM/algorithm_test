def binary_search(array, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    ## 값이 인덱스와 동일한 경우
    if array[mid] == mid:
        return mid
    elif array[mid] > mid:
        return binary_search(array, start, mid - 1)
    else:
        return binary_search(array, mid + 1, end)

if __name__ == '__main__':
    n = int(input())
    array = list(map(int, input().split()))

    index = binary_search(array, 0, n - 1)

    if index == None:
        print(-1)
    else:
        print(index)