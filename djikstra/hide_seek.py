#다익스트라로 출발지~ 모든노드의 최단거리 찾고, 가장 거리가 긴 노드 찾기
import heapq
import sys
# input = sys.stdin.readline()
INF = int(1e9)

n, m = map(int, input().split())
start = 1
graph = [[] for i in range(n + 1)]
distance = [[INF] * (n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    #양방향이라서
    graph[a].apppend((b,1))
    graph[b].append((a,1))


