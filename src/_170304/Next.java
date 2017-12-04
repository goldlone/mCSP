package _170304;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 地铁修建
 * 超时 85分
 * @author CN
 * 2017年12月2日 下午3:08:51
 */
public class Next {
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
		int len = in.nextInt();
		Queue<Nodes> q = new PriorityQueue<Nodes>();

		// 初始化并查集
		pre = new int[n+1];
		for(int i=1; i<=n; i++) 
			pre[i] = i;
		// 一般此处接一个优先队列，为了拿最小/大的元素
		while(len-->0) {
			int start = in.nextInt();
			int end = in.nextInt();
			int weight = in.nextInt();
			q.add(new Nodes(start, end, weight));
		}
		// 处理数据
		Nodes temp;
		int ans = 0;
		while(!q.isEmpty()) {
			temp = q.poll();
			int x = temp.start;
			int y = temp.end;
			if(find(x) == find(y))
				continue;
			link(x, y);
			ans = temp.weight;
			if(find(n) == 1)
				break;
		}
		System.out.println(ans);
		in.close();
	}
}
class Nodes implements Comparable<Nodes> {
	public int start = 0;
	public int end = 0;
	public int weight = 0;
	public Nodes(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Nodes o) {
		return this.weight-o.weight;
	}
}
