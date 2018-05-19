package _171204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 20171203 行车路线
 * @author CN
 * 2017年12月5日 上午12:36:05
 */
public class Main {
	private static int n;
	private final static int MAX = Integer.MAX_VALUE;
	private static boolean[] finalVex;
	private static int[] shortPath;
	private static List<LinkedList<Edge>> list;
	
	public static void shortPathDij() {
		Edge tmp = null;
		shortPath = new int[n];
		int[] tails = new int[n];
		int[] exp = new int[n];
		finalVex = new boolean[n];
		Arrays.fill(shortPath, MAX);
		Arrays.fill(finalVex, false);
		Arrays.fill(exp, 0);
		
		shortPath[0] = 0;
		tails[0] = 1;
		while(!finalVex[n-1]) {
			int index = min(shortPath);
			if(index == -1)
				break;
			LinkedList<Edge> p = list.get(index);
			Iterator<Edge> it = p.iterator();
			int j=0;
			while(it.hasNext()) {
				tmp = it.next();
				j = tmp.end;
				if(finalVex[j])
					continue;
				if(tmp.type==1) {
					int eee = exp[index]+tmp.weight;
					int sum = shortPath[index]-(int)Math.pow(exp[index], 2)+(int)Math.pow(eee, 2);
					if(sum<shortPath[j]) {
						shortPath[j] = sum;
						tails[j] = index+1;
						exp[j] = eee;
					}
				} else {
					if((shortPath[index]+tmp.weight)<shortPath[j]) {
						shortPath[j] = shortPath[index]+tmp.weight;
						tails[j] = index+1;
						exp[j] = 0;
					}
				}
			}
		}
	}
	private static int min(int[] arr) {
		int index = -1;
		for(int i=0; i<n; i++) 
			if(!finalVex[i])
				index = i;
		if(index==-1)
			return -1;
		for(int i=0; i<arr.length; i++)
			if(arr[index]>arr[i]&&!finalVex[i])
				index = i;
		finalVex[index] = true;
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int nums = in.nextInt();
		list = new ArrayList<>(n);
		for(int i=0; i<n; i++) {
			list.add(new LinkedList<Edge>());
		}
		for(int i=0; i<nums; i++) {
			int type = in.nextInt();
			int start = in.nextInt();
			int end = in.nextInt();
			int weight = in.nextInt();
			list.get(start-1).add(new Edge(type, start-1, end-1, weight));
			list.get(end-1).add(new Edge(type, end-1, start-1, weight));
		}
		shortPathDij();
		System.out.println(shortPath[n-1]);
		in.close();
	}
}

class Edge{
	public int type;
	public int start;
	public int end;
	public int weight;
	public Edge(int type, int start, int end, int weight) {
		this.type = type;
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
