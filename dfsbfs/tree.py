

def main(k):
    answer = [[' '] * 2 * k for _ in range(k)]

    def star(x,y,N):
        if N == 3:
            answer[x][y] = "*"
            answer[x + 1][y - 1] = "*"
            answer[x + 1][y + 1] = "*"
            answer[x + 2][y - 2] = "*"
            answer[x + 2][y - 1] = "*"
            answer[x + 2][y] = "*"
            answer[x + 2][y + 1] = "*"
            answer[x + 2][y + 2] = "*"
            return
        else:
            newN = N // 2
            star(x,y,newN)
            star(x+newN, y-newN, newN)
            star(x+newN, y+newN, newN)

    star(0, k - 1, k)
    for i in answer:
        print("".join(i))

if __name__ == "__main__":
    k = int(input())
    main(k)