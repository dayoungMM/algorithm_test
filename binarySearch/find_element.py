import sys

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid

        elif array[mid] > target:
            end = mid - 1

        else:
            start = mid + 1
    return None
    
if __name__ == '__main__':
    n = int(input())
    array = list(map(int, list(sys.stdin.readline().strip().split())))
    m = int(input())
    elements = list(map(int, list(sys.stdin.readline().strip().split())))

    array.sort()
    for i in elements:
        result = binary_search(array, i, 0, n - 1)
        if result != None:
            print('yes', end=' ')
        else:
            print('no', end=' ')
