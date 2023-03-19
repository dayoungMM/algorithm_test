def solution(array):
    array = sorted(array)
    if len(array) % 2 == 0:
        middle = len(array)//2 - 1
    else:
        middle =  len(array)//2
    print(array[middle])
if __name__ == '__main__':
    n = input()
    array = list(map(int, input().split()))
    solution(array)