import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프 구현
    static boolean[] check; // 정점 방문 여부 확인하는 배열

    static void dfs(int x) {
        if (check[x]) return; // 이미 방문한 정점이면 해당 정점에서는 탐색 안함
        check[x] = true; // 정점 방문 체크
        for (int y : graph[x]) {
            if (!check[y]) { // x와 연결된 정점 y를 방문하지 않았으면
                dfs(y); // 정점 y 방문해서 탐색 수행
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n = 정점의 개수
        int m = sc.nextInt(); // m = 간선의 개수
        // 그래프 구현
        graph = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i=1;i<=n;i++) graph[i] = new ArrayList<Integer>();
        for (int i=0;i<m;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean flag = true; // 모든 연결요소 확인했으면 true, 아니면 false
        int compNum = 0; // 연결 요소의 개수
        // 정점 방문 여부 초기화
        check = new boolean[n+1];
        for (int i=1;i<=n;i++) { // 모든 정점에 대해 반복문 돌림
            if (!check[i]) { // 방문 안한 정점이 있다는 것은 확인 안한 연결요소가 있다는 것
                compNum+=1; // 연결요소 수 추가
                dfs(i); // 해당 연결요소 탐색 수행
            }
        } // 모든 정점이 방문 처리되었으면 모든 연결요소를 확인한 것임
        // 확인된 연결요소의 개수 출력
        System.out.println(compNum);
    }
}
