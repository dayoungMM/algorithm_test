from collections import deque
v, e = map(int, input().split())
indegree = [0] * (v + 1)
graph = [[] for i in range(v + 1)]

#방향그래프의 모든 간선 정보 입력받기
for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b) #행렬 A에서 B로 이동 가능
    #진입차수 1 증가
    indegree[b] += 1

#위상 정렬 함수
def topology_sort():
    result = []
    q = deque()

    for i in range(1, v + 1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        now = q.popleft()
        result.append(now)
        #해당 원소와 연결된 노드들의 진입차수에서 1 빼기
        for i in graph[now]:
            indegree[i] -= 1
            #새롭게 진입차수가 0이 되는 노드에 큐를 삽입
            if indegree[i] == 0:
                q.append(i)
    #rusult
    for i in result:
        print(i, end=' ')

topology_sort()
