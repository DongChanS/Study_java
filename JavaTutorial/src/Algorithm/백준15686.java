package Algorithm;

/*
치킨 배달
크기가 N*N인 도시
    - 빈칸, 치킨집, 집
    - (r,c) 1부터 시작함
치킨거리
    - 집과 가장 가까운 치킨집 사이의 거리
    - 각각의 집은 치킨거리를 가지고 있음
    => 도시의 치킨거리 = 모든 집의 치킨거리의 합
굳이 BFS를 쓸 필요가 있을까?
- 최대 치킨집의 수 : 50*13 = 650
- 집의 수도 최대 650
 */
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 백준15686 {
    static int chicIdx, homeIdx, M, N, minRes;

    public static class Coord {
        int x;
        int y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int calDist(Coord c){
            return Math.abs(this.x - c.x) + Math.abs(this.y - c.y);
        }
        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }
    }

    public static void dfsTake(int idx, int prev, Coord[] chickens, Coord[] tempChic, Coord[] homes){
        if (idx == M){
            calcDist(tempChic, homes);
        } else {
            for (int p = prev+1; p < chicIdx; p ++){
                tempChic[idx] = chickens[p];
                dfsTake(idx+1, p, chickens, tempChic, homes);
            }
        }
    }

    public static void calcDist(Coord[] tempChic, Coord[] homes){
        int res = 0;
        for (int h=0; h < homeIdx; h++){
            int minDist = 2*N;
            Coord home = homes[h];
            for (int c=0; c < M; c++){
                Coord chic = tempChic[c];
                if (home.calDist(chic) < minDist){
                    minDist = home.calDist(chic);
                }
            }
            res += minDist;
        }

        if (res < minRes){
            minRes = res;
        }
    }

    public static void main(String[] args) throws IOException{
        String path = "baekjoon" + File.separator + "15686_input.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Coord[] chickens = new Coord[13];
        Coord[] homes = new Coord[2*N];
        Coord[] tempChic = new Coord[M];
        int[][] city = new int[N][N];
        minRes = 2 * N * N;

        // take input
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1){
                    homes[homeIdx++] = new Coord(i, j);
                } else if (city[i][j] == 2){
                    chickens[chicIdx++] = new Coord(i, j);
                }
            }
        }
//        System.out.println(Arrays.toString(homes));
//        System.out.println(Arrays.toString(chickens));
        // homeIdx : 집의 개수, chicIdx : 치킨집의 개수
        // 치킨집중에서 M개를 고르는 로직
        dfsTake(0, -1, chickens, tempChic, homes);
        System.out.println(minRes);
    }
}
