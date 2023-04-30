# 최단거리
- 간단한 다익스트라(djikstra-simple.py)
  - 시간복잡도 O(V^2)
- 개선된 다익스트라(djikstra-fast.py)
  - PriorityQueue를 이용해 현재 노드로부터 거리가 가장 짧은 노드 순서를 나오도록 할 때 더 효율적으로 계산
  - 시간복잡도 O(ElogV)
- 플로이드 워셜 알고리즘(floyd-warshall.py)
  - 모든 지접에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우 사용
  - 현재 노드를 거쳐가는 모든 경로를 고려
  - 시간복잡도 O(N^3)

## 문제
- 미래 도시(future.py)
- 전보 (telegram.py)
- 플로이드(floyd.py)
- 정확한 순위(ranking.py)
- 화성 탐사(mars_exploration.py)
- 숨바꼭질(hide_seek.py)