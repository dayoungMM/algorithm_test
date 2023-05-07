#사이클 여부 판별

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

cycle = False

for i in range(e):
    a, b = map(int, input().split())
    #사이클이 발생한 경우 종료
    #루트 노드가 같다면 사이클이 발생한 것
    if find_parent(parent, a) == find_parent(parent, b):
        cycle = True
        break
    # 루트 노드가 다르다면 union 연산 실행
    else:
        union_parent(parent, a, b)
if cycle:
    print("사이클 발생")
else:
    print("사이클 미발생")
