from collections import deque
def move_position(position, board):
    next_pos = []
    ## 현재 위치 파싱
    current_pos = list(position)
    pos1_x, pos1_y, pos2_x, pos2_y = current_pos[0][0], current_pos[0][1], current_pos[1][0], current_pos[1][1]
    ## 상하좌우
    turn_x = [-1, 1, 0, 0]
    turn_y = [0, 0, -1, 1]
    for i in range(4):
        npos1_x, npos1_y, npos2_x, npos2_y = pos1_x + turn_x[i], pos1_y + turn_y[i], pos2_x + turn_x[i], pos2_y + turn_y[i]
        if (board[npos1_x][npos1_y] == 0 and board[npos2_x][npos2_y] == 0):
            next_pos.append({(npos1_x, npos1_y), (npos2_x, npos2_y)})
    ## 가로인 상태에서 회전
    if npos1_x == npos2_x:
        ##대각에 걸림돌 없다면 시계 또는 반시계 회전
        for i in [1,-1]:
            if board[pos1_x + i][pos1_y] == 0 and board[pos2_x + i][pos2_y] == 0:
                next_pos.append({(pos2_x + i, pos2_y), (pos2_x, pos2_y)})
                next_pos.append({(pos1_x, pos1_y), (pos1_x +i, pos1_y)})
    ## 세로인 상태에서 회전
    elif npos1_y == npos2_y:
        ## 대각에 걸림돌 없다면 시계 또는 반시계 회전
        for i in [1, -1]:
            if board[pos1_x][pos1_y + i] == 0 and board[pos2_x][pos2_y + i] == 0:
                next_pos.append({(pos1_x, pos1_y), (pos1_x, pos1_y + i)})
                next_pos.append({(pos2_x, pos2_y), (pos2_x, pos2_y + i)})
    return next_pos

def solution(board):
    ## 외곽에 모두 벽 두르기 (앞/뒤: +2, 상/하: +2)
    n = len(board)
    new_board = [[1] * (n+2) for i in range(n+2)]
    for i in range(n):
        for j in range(n):
            new_board[i+1][j+1] = board[i][j]
    ## bfs로 상하좌우 이동, 회전
    ## 도착지에 도착하면 몇번째인지 리턴
    ## q 타입: ({(x1, y1),(x2,y2)}, 몇번째경로인지)
    ## set을 쓰는 이유는 좌우가 변경되어도 똑같이 인식하려고
    q = deque()

    visited = []
    start = {(1, 1), (1, 2)}
    q.append((start, 0))
    visited.append(start)
    while q:
        current_pos, count = q.popleft()
        current_pos_list = list(current_pos)
        ## 목적지 도착
        if (n,n) in current_pos:
            return count
        new_position_list = move_position(current_pos, new_board)
        for npos in new_position_list:
            if npos not in visited:
                visited.append(npos)
                q.append((npos, count+1))





if __name__ == '__main__':
    board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
    print(solution(board))