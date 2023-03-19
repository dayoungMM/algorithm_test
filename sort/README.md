## 정렬
1. 삽입정렬
- 시간복잡도 O(N<sup>2)
```python
array = [7,5,9,0,3,1,6,2,4,8]
for i in range(1, len(array)):
    for j in range(i, 0, -1): # 인덱스를 i부터 1 감소하며 반복
        if array[j] < array[j -i]: 
            array[j], array[j -i] = array[j - i], array[j]
        else: 
            break
print(array)
```
2. 퀵정렬
- 평균 시간복잡도 O(NlogN)
- 최악의 시간복잡도 O(N<sup>2)
```python
array = [5,7,9,0,3,1,6,2,4,8]
def quick_sort(array):
    if len(array) == 1:
        return array
    pivot = array[0]
    tail = array[1:]
    left_side = [x for x in tail if x <= pivot] 
    right_side = [x for x in tail if x > pivot]
    ## 각각 정렬
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)
print(quick_sort(array)
    
```
3. 계수정렬
- 평균/최악의 시간복잡도 O(N+K)

```python
# 모든 원소의 값이 0보다 크거나 같다고 가정
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
# 모든 범위를 포함하는 리스트 선언 (모든 값은 0으로 초기화)
count = [0] * (max(array) + 1)

for i in range(len(array)):
    count[array[i]] += 1 # 각 데이터에 해당하는 인덱스의 값 증가

for i in range(len(count)): # 리스트에 기록된 정렬 정보 확인
    for j in range(count[i]):
        print(i, end=' ') # 띄어쓰기를 구분으로 등장한 횟수만큼 인덱스 출력
```

## 문제
### 위에서 아래로 (top_down.py)
### 성적이 낮은 순대로 학생 출력 (low_score.py)
### 두배열의 원소 교체 (exchange_element.py)
### 안테나(antenna.py)
### 국영수(kr_en_math.py)
### 실패율(failure_rete.py)
### 카드 정렬 (sorting_card.py)
- 