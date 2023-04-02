from bisect import bisect_left, bisect_right

## python에 이미 구현된 이진탐색 사용하는 경우 (답보고 작성)
##
def count(array, left_value, right_value):
    right_index = bisect_right(array, right_value)
    left_index = bisect_left(array, left_value)
    return right_index - left_index

if __name__ == '__main__':
    n, x = map(int, input().split())
    arr = list(map(int, input().split()))

    count = count(arr, x, x)

    if count == 0:
        print(-1)
    else:
        print(count)