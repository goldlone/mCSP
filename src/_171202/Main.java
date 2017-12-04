package _171202;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 20171203 游戏
 * @author CN
 * 2017年12月5日 上午12:37:44
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<n+1; i++) {
			list.add(i);
		}
		
		int num = 0;
		int index = 0;
		while(list.size()>1) {
			num++;
			String str = String.valueOf(num);
			int x = Integer.parseInt(""+str.charAt(str.length()-1));
			if(num%k==0 || x==k) {
				list.remove(index);
				n--;
			} else {
				index = index+1;
			}
			index = index%n;
		}
		System.out.println(list.get(0));
		
		
		in.close();
	}
}
