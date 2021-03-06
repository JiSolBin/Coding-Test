import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167 {
    static int V, res, leaf;
    static ArrayList<info> list[];

    static class info {
        int to;
        int wgt;

        public info(int to, int wgt) {
            this.to = to;
            this.wgt = wgt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine()); // 정점 개수
        list = new ArrayList[V+1];

        for (int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=V; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1)
                    break;
                int weight = Integer.parseInt(st.nextToken());
                list[from].add(new info(to, weight));
            }
        }

        // 특정 정점에서 가장 멀리 있는 노드의 지름과 정보 얻기
        dfs(1, 0, 0);

        // 리프 노드에서 올라오면서 가장 긴 지름 찾기
        dfs(leaf, 0, 0);

        System.out.println(res);
    }

    public static void dfs(int node, int parent, int wgt) {
        if (wgt > res) {
            res = wgt;
            leaf = node;
        }

        for (int i=0; i<list[node].size(); i++) {
            info next = list[node].get(i);

            // 부모 노드는 pass
            if (next.to == parent) continue;

            dfs(next.to, node, next.wgt + wgt);
        }
    }
}
