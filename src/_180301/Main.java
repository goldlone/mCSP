package _180301;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		int add = 0;
		int score = 0;
		while(true) {
			num = in.nextInt();
			if(num==0)
				break;
			if(num==1) {
				add = 0;
				score = score+1;
			} 
			else if(num==2) {
				add = add+2;
				score = score + add;
			}
				
		}
		
		System.out.println(score);
		in.close();
	}
}