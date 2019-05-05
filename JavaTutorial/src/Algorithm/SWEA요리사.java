package Algorithm;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
두명의 손님
    - 최대한 비슷한 맛의 음식

식재료
    - N개
    - N/2개씩 나눠서 두개의 요리
    - A 음식과 B 음식의 맛의 차이가 최소가 되도록 재료를 배분해야함.
 */


public class SWEA요리사 {
    static int T, N, minDiff;
    static int[][] arr;
    static int[] firstIndices;

    public static void calculate(int[] indices){
        int[] secIndices = new int[N/2];
        int prev = -1;
        int curr;
        int secIdx = 0;
        int diff = 0;
        for (int q = 0; q < N/2; q++){
            curr = indices[q];
            for (; (prev + 1) < curr; prev++){
                secIndices[secIdx++] = prev + 1;
            }
            prev += 1;
        }
        for (; (prev + 1) < N; prev++){
            secIndices[secIdx++] = prev + 1;
        }
//        System.out.println(Arrays.toString(indices) + " and " + Arrays.toString(secIndices));
        // 이제 계산하기
        for (int q=0; q<N/2; q++){
            for(int r=q+1; r<N/2; r++){
                diff += arr[firstIndices[q]][firstIndices[r]];
                diff += arr[firstIndices[r]][firstIndices[q]];
                diff -= arr[secIndices[q]][secIndices[r]];
                diff -= arr[secIndices[r]][secIndices[q]];
            }
        }
//        System.out.println("diff :" + diff);
        if (Math.abs(diff) < minDiff){
            minDiff = Math.abs(diff);
        }

    }

    public static void dfs_split(int arr_idx, int prev_idx){
        if (arr_idx == (N/2)){
            calculate(firstIndices);
        } else {
            for (int p = prev_idx + 1; p < N; p ++){
                firstIndices[arr_idx] = p;
                dfs_split(arr_idx+1, p);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        String path = "swea" + File.separator + "4012_input.txt";
        File f = new File(path);
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            // take input
            for (int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k=0; k<N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    minDiff += arr[j][k];
                }
            }
//            for (int l=0; l<N ; l++){
//                System.out.println(Arrays.toString(arr[l]));
//            }
            // split the data
            firstIndices = new int[N/2];
            /*
                - 인덱스를 받을 배열을 지정해준다.
                - 재귀함수를 통해서 인덱스를 높여가면서 배열의 값을 받는다.
             */
            dfs_split(0, -1);
            System.out.println("#"+(i+1)+" "+minDiff);
        }


    }
}
