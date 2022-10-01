public class CreateMatrix {
    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        System.out.println(output1);
    }
    public static int[][] createMatrix(int[][] edges) {
        // TODO:

        // 이중 for문을 이용해 edges 행렬 크기 구하기 -> 2차원 배열이기 때문에
        int max = 0;
        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                // max 변수를 사용해 max보다 큰 값이 나올 경우 max에 대입
                if(max < edges[i][j])
                    max = edges[i][j];
            }
        }
        // 인덱스값은 0부터 시작하기 때문에 int 타입을 가지는 max+1 크기의 graph 배열 생성
        int[][] graph = new int[max+1][max+1];

        // edge 순회 -> 방향이 있으면 두 간선에 1, 방향이 없으면 한 간선만 1
        for(int i=0; i<edges.length; i++) {
            // 변수 x, y, z 를 생성 후 for문을 이용해 각각 행, 열, 방향값 대입하기
            int x = edges[i][0];
            int y = edges[i][1];
            int z = edges[i][2];
            // 방향을 가지는 경우(끝자리 값이 0인 경우)
            if(z == 0) graph[x][y] = 1;
                // 방향을 가지지 않는 경우(끝자리 값이 1인 경우)
            else if(z == 1) {
                graph[x][y] = 1;
                graph[y][x] = 1;
            }
        }
        return graph;
    }
}
