import sys
import heapq


if __name__ == '__main__':
    input = sys.stdin.readline

    n = int(input())
    cards = []
    for i in range(n):
        heapq.heappush(cards, int(input()))

    result = 0

    if len(cards) == 1:
        print(result)

    else:
        for i in range(n - 1):  # 2개씩 꺼내기 떄문에 n-1
            previous = heapq.heappop(cards)
            current = heapq.heappop(cards)

            result += previous + current
            heapq.heappush(cards, previous + current)

        print(result)

### 처음에는 sort로 풀었었는데, 우선순위 큐 사용하면 그냥 큐에 push 하기만 해도 정렬이 된다