package _141204;

//import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] pre;
	public static int find(int x) {
		if(pre[x] == x) return x;
		return pre[x] = find(pre[x]);
	}
	public static void link(int x, int y) {
		int xx = find(x);
		int yy = find(y);
		if(xx>yy) pre[xx] = yy;
		else pre[yy] = xx;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		pre = new int[n+1];
		for(int i=1; i<=n; i++) 
			pre[i] = i;
		int[] cost = new int[n+1];
		for(int i=2; i<=n; i++)
			cost[i] = Integer.MAX_VALUE;
		
//		Edge[] arr = new Edge[m];
		Queue<Edge> q = new PriorityQueue<Edge>();
		for(int i=0; i<m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int t = in.nextInt();
//			arr[i] = new Edge(x, y, t);
			q.add(new Edge(x, y, t));
		}
//		Arrays.sort(arr);
		int sum = 0;
		Edge temp = null;
		for(int i=0; i<m; i++) {
			temp = q.poll();
//			int x = arr[i].start;
//			int y = arr[i].end;
			int x = temp.start;
			int y = temp.end;
			if(find(x) == find(y))
				continue;
			link(x, y);
//			sum = sum + arr[i].cost;
			sum = sum + temp.cost;
		}
		
		System.out.println(sum);
		in.close();
	}
}
class Edge implements Comparable<Edge>{
	public int start;
	public int end;
	public int cost;
	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
//		if(this.cost<o.cost)
//			return -1;
//		else if(this.cost>o.cost)
//			return 1;
//		return 0;
		return this.cost-o.cost;
	}
}
