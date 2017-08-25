package cn.goldlone.csp;

import java.util.Scanner;

/**
 * 
 * @ClassName: Exp_170301
 * @Description: TODO 
 * @author: CN
 * 创建时间: 2017年8月25日 下午1:09:57
 */
public class Exp_170301 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int count = 0;
		int kg = 0;
		
		for(int i=0; i<n; i++){
			kg += in.nextInt();
			if(kg >= k){
				count++;
				kg = 0;
			}
		}
		
		if(kg != 0)
			count++;
		
		System.out.println(count);
		
		
	}
}
