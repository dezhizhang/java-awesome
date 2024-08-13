package shop.xiaozhi.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public static void main(String[] args) {
        int n = 5;
        String[] vertexs = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);

        for (String value : vertexs) {
            graph.insertVertex(value);
        }

        // 添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

//        graph.showGraph();

        graph.bfs();


    }

    private ArrayList<String> vertexList; // 存储顶点集合
    private int[][] edges; // 存储图对应的邻结矩阵
    private int numOfEdges; // 表示边的数目
    private boolean[] isVisited;


    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        isVisited = new boolean[5];
        numOfEdges = 0;
    }

    // 获取邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根据前一个领接节点的下标获取下一个领接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 深度优先算法
    private void dfs(boolean[] isVisited, int i) {
        // 输出访问该节点
        System.out.printf(getValueByIndex(i) + "->");
        // 将节点设置为已经访问
        isVisited[i] = true;
        // 查找节点i的第一个领接节点
        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // 如果w节点已经被访问查找一个访问节点
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // 图的广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u; // 表示队列的头结点对应下标
        int w; // 领接结点

        // 队列记录访问的顺序
        LinkedList queue = new LinkedList();
        System.out.println(getValueByIndex(i) + "->");
        // 标记为已访问
        isVisited[i] = true;
        // 将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            // 取出队列头结点下标
            u = (Integer) queue.removeFirst();
            // 得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);

            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "->");
                    // 标记已访问
                    isVisited[w] = true;
                    // 入队
                    queue.addLast(w);
                }
                // 以u为前驱点，找到w后面的下一个邻结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    // 遍历所有节点都进行广度优先搜索
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 获取边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}


