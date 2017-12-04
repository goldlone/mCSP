package _150302;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数字排序
 * @author CN
 * 2017年11月13日 下午7:06:02
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Node> list = new ArrayList<>(n);
		Node node = null;
		for(int i=0; i<n; i++) {
			node = new Node();
			node.no = in.nextInt();
			node.count = 1;
			if(list.contains(node)) {
				list.get(list.indexOf(node)).count++;
			} else {
				list.add(node);
			}
		}
		
		// 选择排序
		int pos = 0;
		for(int i=0; i<list.size(); i++) {
			pos = i;
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(pos).count<list.get(j).count) {
					pos = j;
				} else if(list.get(pos).count==list.get(j).count && list.get(pos).no>list.get(j).no) {
					pos = j;
				}
			}
			if(pos!=i) {
				list.add(i, list.remove(pos));
			}
		}
		
		for(Node node1: list) {
			System.out.println(node1.no+" "+node1.count);
		}
		
		in.close();
	}
}
class Node {
	public int no;
	public int count;
	
	@Override
	public boolean equals(Object obj) {
		if(this.no == ((Node)obj).no)
			return true;
		return false;
	}
}
