# 탐색
- DFS (Depth-First Search): 깊이 우선 탐색.
  - 재귀로 노드 끝까지 가보기
- BFS (Breadth First Search): 너비 우선 탐색
  - 큐로 인근 노드 다 넣어놓고 순서대로 다 가보는 탐색법
  - 최대한 넓게 이동한 다음, 더 이상 갈 수 없을 때 아래로 이동
> DFS / BFS 비교
> 
- 특징
  - 모든 노드를 방문하고자 하는 경우에 DFS/BFS 모두 가능
  - 깊이 우선 탐색(DFS)이 너비 우선 탐색(BFS)보다 좀 더 간단함
  - 검색 속도 자체는 너비 우선 탐색(BFS)에 비해서 느림
- 언제 사용할까
  - 그래프의 모든 정점을 방문하는 것이 주요한 문제 : DFS/BFS
  - 경로의 특징을 저장해둬야 하는 문제 (경로마다 특징 저장해둬야 하는 경우 등) : DFS
  - 최단거리 구해야 하는 문제 : BFS
  - 검색 대상 그래프가 정말 크다면: DFS
  - 검색대상의 규모가 크지 않고, 검색 시작 지점으로부터 원하는 대상이 별로 멀지 않다면: BFS

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

input
```
15 14
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
```
answer
```
8
```
 
- 미로 탈출(Maze.kt)
> N * M 크기의 직사각형 형태의 미로에 갇혀있다. 출발 위치는 (1,1) 미로의 출구는 (N,M) 일 때 탈출에 필요한 최소 칸의 개수를 구하시오

- 특정 거리의 도시 찾기 (FindCity.kt)

거리가 모두 1인 최단거리 찾기는 BFS 
> https://www.acmicpc.net/problem/18352


- 연구소(Laboratory.kt)
> https://www.acmicpc.net/problem/14502

- 경쟁적 감염(Virus.kt)
> https://acmicpc.net/problem/18405
input
```
3 4
1 0 0
0 2 0
3 0 4
2 2 3
```
answer
```
2
```

- 괄호변환(ChangeBrackets.kt)
> https://school.programmers.co.kr/learn/courses/30/lessons/60058

- 연산자 끼워넣기(InsertOperator.kt)
> https://www.acmicpc.net/problem/14888

- 감시피하기 (AvoidSurveillance.kt)
> https://www.acmicpc.net/problem/18428

- 인구이동 (PopulationTransfer.kt)

- 블록 이동하기(move_block.py)
> https://school.programmers.co.kr/learn/courses/30/lessons/60063