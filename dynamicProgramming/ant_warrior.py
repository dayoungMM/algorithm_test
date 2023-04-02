# 결과가 나오는데, memorize 를 하지 않아서 메모리를 많이 사용
# if __name__ == '__main__':
#     n = int(input())
#     storage_list = list(map(int, input().split()))
#     def invade(x, sum, last_idx):
#         if x > last_idx:
#             return sum
#         sum += storage_list[x]
#         if x == last_idx - 1 or x == last_idx:
#             return sum
#         return max(invade(x + 2, sum, last_idx), invade(x + 3, sum, last_idx))
#
#     print(max(invade(0, 0, n-1), invade(1, 0, n-1)))

# 답안
if __name__ == '__main__':
    n = int(input())
    storage_list = list(map(int, input().split()))

    d = [0] * 100

    #bottom up
    d[0] = storage_list[0]
    d[1] = storage_list[1]
    for i in range(2, n):
        d[i] = max(d[i - 1], d[i - 2] + storage_list[i])
    print(d[n-1])



