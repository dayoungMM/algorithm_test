# 탐색
- DFS (Depth-First Search): 깊이 우선 탐색.
  - 재귀로 노드 끝까지 가보기
- BFS (Breadth First Search): 너비 우선 탐색
  - 큐로 인근 노드 다 넣어놓고 순서대로 다 가보 
- reculsive function: 재귀함수

### 재귀문제
- 별찍기(Tree.py, Tree.kt)
> https://www.acmicpc.net/problem/2448
- 하노이 탑 이동 순서(Hanoi.kt)
> https://www.acmicpc.net/problem/11729
- 별찍기2 (Stars2.kt)
> https://www.acmicpc.net/problem/10994
- 별찍기3 (Stars3.kt)
> https://www.acmicpc.net/problem/10993

### 스택문제
- 균형잡힌 세상 (OpenClosed.kt)
> https://www.acmicpc.net/problem/4949
- 단어 뒤집기 2 (WordFlip2.kt)
> https://www.acmicpc.net/problem/17413

### 큐 문제
- 요세푸스 문제 0 (Josephus.kt)
> https://www.acmicpc.net/problem/11866
- 트럭(Truck.kt)
> https://www.acmicpc.net/problem/13335

## DFS
- 음료수 얼려먹기 (IceCream.kt)
> N * M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다. 구멍이 뚫려있는 부분끼리 상,하,좌,우로 붙어있는 경우 서로 연결되어 있는것으로 간주한다. 이 때 생성되는 총 아이스크림 개수를 구하시오
- input
  - 15 14
    00000111100000
    11111101111110
    11011101101110
    11011101100000
    11011111111111
    11011111111100
    11000000011111
    01111111111111
    00000000011111
    01111111111000
    00011111111000
    00000001111000
    11111111111011
    11000111111111
    11100011111111
  - 답: 8
  