package Algorithm;

/*
지도
    - N*N
    - 활주로 건설
    - 각 숫자는 지형의 높이

활주로
    - 가로방향이나 세로방향으로 건설가능?
    - [높이가 동일한 구간]에서 건설이 가능
    - 높이가 다른 구간이라면, 경사로를 설치해야함.
        - 반드시 높이가 1임.
        - 경사로의 길이 X는 주어짐.

제약사항
    - 경사로가 지도 바깥을 넘어가면 안됨.
    - 경사로가 스무스하게 설치되어야함.
        - 스무스하게???
 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SWEA4014 {
    static int T, N, X, res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        String path = "swea" + File.separator + "4014_input.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++){
            // take input
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            for (int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<N; k++){
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
                // 각 row 를 판단하는 함수
                determine(map[j]);
            }

            int[] temp = new int[N];
            for (int k=0; k<N; k++){
                for (int j=0; j<N; j++){
                    temp[j] = map[j][k];
                }
                determine(temp);
            }

            System.out.println(res);
        }

    }
}
