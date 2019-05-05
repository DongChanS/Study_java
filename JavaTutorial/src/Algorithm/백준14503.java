package Algorithm;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
목적
    - 청소하는 영역의 개수
장소
    - N*M 크기
    - 벽 또는 빈칸
청소기
    - 방향 (동서남북)
청소
    1. 현재 위치를 청소
    2. [현재 방향을 기준으로] 왼쪽방향부터 탐색을 진행
        A. 아직 청소안한 공간이 존재
            => 그 방향으로 회전
            => 한칸 전진
            => 1번
        B. 왼쪽 방향에 청소할 공간이 없다면
            => 그 방향으로 회전
            => 2번
        C. 네 방향 모두가 청소되어있거나, 벽
            => 방향 유지
            => 한칸 후진
            => 2번
        D. 네 방향 모두가 청소되어있거나, 벽 & 후진 불가능
            => 중단
 */

public class 백준14503 {
    static int[] move_x = {0, 1, 0, -1};
    static int[] move_y = {1, 0, -1, 0};
    static int N, M, rx, ry, d, res;
    static int[][] cleaned, room;
    // 북 동 남 서
    /*
        북 => 서
        동 => 북
        남 => 동
        서 => 남
     */
    static boolean inRoom(int y, int x){
        if (0 <= x && x < N && 0 <= y && y < N) return false;
        return true;
    }
    static int leftDir(int d){return (d+3) % 4;}
    static boolean canBackGo(int y, int x, int d){
        if (inRoom(y-move_y[d], x-move_x[d])) return true;
        return false;
    }
    static void clean(int y, int x, int d){
        // 현재 위치를 청소하기
        if (cleaned[y][x] == 0 && room[y][x] == 0){
            cleaned[y][x] = 1;
            res += 1;
        }
        int rx, ry, rd;
        // 왼쪽방향부터 탐색을 진행
        for (int i=0; i<4; i++){
            rd = leftDir(d);
            rx = x + move_x[rd];
            ry = y + move_y[rd];

            if (inRoom(ry, rx) && room[ry][rx] == 0) {
                if (cleaned[ry][rx] == 0){
                    clean(ry, rx, rd);
                } else {
                    clean(y, x, rd);
                }
                break;
            }
            d = rd;
        }
        // 4번 바꾸니까 원래방향으로 되돌아왔음.
        // 후진이 가능한지 확인
        if (canBackGo(y, x, d)){
            clean(y-move_y[d], x-move_x[d], d);
        }
    }

    public static void main(String[] args) throws IOException{
        String path = "baekjoon" + File.separator + "14503_input.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        // take input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        cleaned = new int[N][N];
        st = new StringTokenizer(br.readLine());
        ry = Integer.parseInt(st.nextToken());
        rx = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i=0; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 청소 시작!
        clean(ry, rx, d);
        System.out.println(res);
    }
}
