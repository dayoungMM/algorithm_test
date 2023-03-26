# 이진탐색
- 순차탐색
  - for문으로 순차적으로 일일이 탐색
  - 시간복잠도 O(N^2)
- 이진탐색
  - 중앙값을 기준으로 탐색 범위를 반으로 좁혀가며 탐색
  - 시간복잡도 : O(logN)
```python
# 재귀로 이진탐색 구현
def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end)//2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        ## 왼쪽
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid+1, end)

n, target = list()

```
## 문제
- 떡볶이떡 찾기 (cut_ttoek.py)
- 부품 찾기 (find_element.py)
- 정렬된 배열에서 특정 수의 개수 구하기(find_elements_count.py)