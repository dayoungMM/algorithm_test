#특정 원소가 속한 집합 찾기
# 방법 1: 재귀적으로 부모 찾기
# def find_parent(parent, x):
#     #루트 노드가 아니라면, 루트 노드를 찾을 때 까지 재귀적으로 호출
#     #자기 자신이 루트 노드일 때 까지 반복
#     if parent[x] != x:
#         return find_parent(parent, parent[x])
#     return x

# 방법 2: 경로 압축 기법으로 부모 찾기
# 부모테이블 자체를 바꿈
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    #parent[x] == x 이면 x가, 새로운 parent 이면 find_parent 결과물이
    return parent[x]
# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    #인덱스가 더 낮은 쪽이 parent 되기
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
#노드의 개수와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
# index 1부터 시작하는 부모 리스트
parent = [0] * (v + 1)

#부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
    parent[i] = i
#union
for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

#각 원소가 속한 집한 출력
print('각 원소가 속한 집합', end="")
for i in range(1, v+1):
    print(find_parent(parent, i), end=' ')
print()

#부모 테이블
print('부모 테이블:', end='')
for i in range(1, v + 1):
    print(parent[i], end=' ')