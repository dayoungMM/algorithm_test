INF = 10000
n, m = map(int, input().split())
graph = [[INF] * n+1 for _ in range(n + 1)]

for a in range(n + 1):
    for b in range(n + 1):
        if a == b:
            graph[a][b] = 0

for _ in range(m):
    a, b = map(int, input().split())
    # a to b, cost 1
    graph[a][b] = 1
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
answer = 0
for i in range(1, n + 1):
    arrive = 0
    for j in range(1, n + 1):
        # 양방향으로 체크해주는 것을 잊지 말자
        if graph[i][j] != INF or graph[j][i] != INF:
            arrive += 1
    if arrive == n:
        answer += 1
print(answer)

