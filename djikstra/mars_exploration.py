import heapq
import sys
input = sys.stdin.readline()
INF = int(1e9)

#상하좌우
dx = [-1, 0, 1, 0]
dy = [0, 1, 0 -1]

for node in range(int(input())):
    n = int(input())

    graph = []
    for i in range(n):
        graph.append(list(map(int, input().split())))

    distance = [[INF] * n for _ in range(n)]

    #start
    x, y = 0, 0
    #비용, x, y
    q = [(graph[x][y], x, y)]
    distance[x][y] = graph[x][y]

    while q:
        dist, x, y = heapq.heappop(q)
        if distance[x][y] < dist:
            continue
        #상하좌우
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0  or ny >= n:
                continue
            cost = dist + graph[nx][ny]
            #현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은경우
            if cost < distance[nx][ny]:
                distance[nx][ny] = cost
                heapq.heappush(q, (cost, nx, ny))
    print(distance[n - 1][n - 1])