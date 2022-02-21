import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int[][] arr;
    static int zero; // 0
    static int one;  // 1
    static int mone; // -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(mone);	// -1
        System.out.println(zero);	// 0
        System.out.println(one);	// 1
    }

    private static void partition(int row, int col, int size) {
        // 만약 같은 숫자로 이루어져있다면 해당 숫자 카운트를 증가시킨다.
        if (colorCheck(row, col, size)) {
            if(arr[row][col] == -1) {
                ++mone;
            }
            else if(arr[row][col] == 0) {
                ++zero;
            }
            else {
                ++one;
            }

            return;
        }

        // 사이즈 줄이기
        int newSize = size / 3;

        partition(row, col, newSize);							    	// 왼쪽 위
        partition(row, col + newSize, newSize);						// 중앙 위
        partition(row, col + 2 * newSize, newSize);					// 오른쪽 위

        partition(row + newSize, col, newSize);						// 왼쪽 중간
        partition(row + newSize, col + newSize, newSize);			// 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize);		// 오른쪽 중간

        partition(row + 2 * newSize, col, newSize);					// 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize);		// 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize);	// 오른쪽 아래
    }

    // 해당 영역이 같은 숫자인지 검사하는 메소드
    public static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];

        // 각 블럭의 시작점(row, col)부터 블럭의 끝(row + size, col + size)까지 검사
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
