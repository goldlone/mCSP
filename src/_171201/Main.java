package _171201;

import java.util.Scanner;

/**
 * 20171203 最小差值
 * @author CN
 * 2017年12月5日 上午12:38:27
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = in.nextInt();
		}
		int sub = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n&&i!=j; j++) {
				int temp = Math.abs(nums[i]-nums[j]);
				if(temp<sub)
					sub = temp;
			}
		}
		System.out.println(sub);
		
		in.close();
	}
}
