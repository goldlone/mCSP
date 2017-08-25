package cn.goldlone.csp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @ClassName: Exp_170304
 * @Description: TODO 
 * @author: CN
 * 创建时间: 2017年8月25日 下午1:13:52
 */
public class Exp_170304 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Node temp;
		int lastLen = 0;
		
		int n = in.nextInt();
		int m = in.nextInt();
		List<Node> list = new ArrayList<Node>();
		boolean[][] arcs = new boolean[n][n];
		
		for(int i=0; i<m; i++){
			int row = in.nextInt();
			int col = in.nextInt();
			list.add(new Node(row>col?col:row, row>col?row:col, in.nextInt()));
		}
		
		boolean[][] t = new boolean[n][n];
		Collections.sort(list);
		
		
		while(!judgeEnd(arcs, t)){
			temp = list.get(0);
			arcs[temp.x-1][temp.y-1] = true;
			lastLen = list.get(0).len;
			list.remove(0);
		}
		
		System.out.println(lastLen);
		
	}
	
	public static boolean judgeEnd(boolean[][] arcs, boolean[][] t){
		for(int i=0;i<arcs.length;i++)
			for(int j=i;j<arcs.length;j++){
				if(t[i][j])
					continue;
				if((i==j)||(arcs[i][j])){
					t[i][j]=true;
					t[j][i]=true;
				}
			}

		for(int k=0;k<arcs.length;k++)
			for(int i=0;i<arcs.length;i++)
				for(int j=0;j<arcs.length;j++){
					t[i][j]=t[i][j]||(t[i][k]&&t[k][j]);
					if(t[0][arcs.length-1])
						return true;
				}
		
		return false;
	}
}

class Node implements Comparable{
	public int x;
	public int y;
	public int len;
	
	public Node(int x, int y, int len){
		this.x = x;
		this.y = y;
		this.len = len;
	}

	@Override
	public int compareTo(Object o) {
		if(this.len > ((Node)o).len)
			return 1;
		else if(this.len < ((Node)o).len)
			return -1;
		
		return 0;
	}
}
