INF = 100000
n = int(input())
m = int(input())
graph = [[INF] * (n+1) for _ in range(n+1)]
#자기 자신까지의 거리 0
for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] = 0

#input 받아 간선 초기화
for _ in range(m):
    a, b, c = map(int, input().split())
    #가장 짧은 경우에만
    if(c < graph[a][b]):
        graph[a][b] = c

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for a in range(1, n+1):
    for b in range(1, n+1):
        cost = graph[a][b]
        if cost == INF:
            cost = 0
        print(cost, end=" ")
    print()

"""
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
"""