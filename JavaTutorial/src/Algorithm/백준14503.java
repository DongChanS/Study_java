package Algorithm;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 백준14503 {
    static int[] move_x = {0, 1, 0, -1};
    static int[] move_y = {-1, 0, 1, 0};
    static int N, M, rx, ry, d, res;
    static int[][] cleaned, room;
    // 북 동 남 서
    /*
        북 => 서
        동 => 북
        남 => 동
        서 => 남
     */
    static boolean isWall(int y, int x){
        if (0 <= x && x < M && 0 <= y && y < N) {
            return (room[y][x] == 1);
        } return true;
    }
    static int leftDir(int d){return (d+3) % 4;}

    static boolean allCleaned(int y, int x){
        int rx, ry;
        int cnt = 0;
        for (int i = 0; i < 4; i ++){
            rx = x + move_x[i];
            ry = y + move_y[i];
            if ( isWall(ry, rx) || cleaned[ry][rx] >= 1 ){
                cnt += 1;
            }
        }
        return (cnt == 4);
    }

    static boolean canBackGo(int y, int x, int d){
        if (!isWall(y-move_y[d], x-move_x[d])) return true;
        return false;
    }
    static void clean(int y, int x, int d, boolean flag){
//        System.out.printf("%d, %d, %d, %d, \n", y, x, d, res);
        // 현재 위치를 청소하기
        if (flag) {
            res += 1;
            cleaned[y][x] = res;
        }
        int rx, ry, rd;
        if (allCleaned(y, x)){
            // 후진이 가능한지 확인
            if (canBackGo(y, x, d)){
                clean(y-move_y[d], x-move_x[d], d, false);
            }
        } else {
            // 왼쪽방향부터 탐색을 진행
            for (int i=0; i<4; i++){
                rd = leftDir(d);
                rx = x + move_x[rd];
                ry = y + move_y[rd];

                if (!isWall(ry, rx)) {
                    if (cleaned[ry][rx] == 0){
                        clean(ry, rx, rd, true);
                    } else {
                        clean(y, x, rd, false);
                    }
                    break;
                }
                d = rd;
            }
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
        cleaned = new int[N][M];
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
        clean(ry, rx, d, true);
//        for (int i=0; i<N; i++){
//            System.out.println(Arrays.toString(cleaned[i]));
//        }
        System.out.println(res);
    }
}
