import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maximumPathQualityofaGraph {
    int[] values;
    int maxTime;
    Map<Integer, List<int []>> adjvex = new HashMap<>();
    boolean [] visited;
    int res = 0;

    public void backtrace(int x, int past_time, int cur_money){
        if(x == 0){
            res = Math.max(res, cur_money);
        }
        for(int[] y_cost : adjvex.getOrDefault(x, new ArrayList<>())){
            int y = y_cost[0], cost = y_cost[1];
            if(past_time + cost <= maxTime){
                if(visited[y] == false){
                    visited[y] = true;
                    backtrace(y, past_time + cost, cur_money + values[y]);
                    visited[y] = false;
                }else{
                    backtrace(y, past_time + cost, cur_money);
                }
            }
        }
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;
        int N = values.length;
        this.visited = new boolean[N];
        for(int[] edge : edges){
            int x = edge[0], y = edge[1], cost = edge[2];
            adjvex.putIfAbsent(x, new ArrayList<>());
            adjvex.putIfAbsent(y, new ArrayList<>());
            adjvex.get(x).add(new int[]{y, cost});
            adjvex.get(y).add(new int[]{x, cost});
        }
        visited[0] = true;
        backtrace(0, 0, values[0]);
        return res;
    }
}
