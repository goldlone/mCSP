package _180302;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int L = in.nextInt();
		int t = in.nextInt();
		Ball[] balls = new Ball[n];
		for(int i=0; i<n; i++)
			balls[i] = new Ball(i, in.nextInt());
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<n; j++) {
				if(balls[j].dir==1) {
					if(balls[j].loc==L) {
						balls[j].dir = 0;
						balls[j].loc--;
					} else {
						balls[j].loc++;
					}
					
				} else {
					if(balls[j].loc==0) {
						balls[j].dir = 1;
						balls[j].loc++;
					} else {
						balls[j].loc--;
					}
				}
			}
			for(int j=0; j<n; j++)
				for(int k=j+1; k<n; k++) {
					if(balls[j].dir==balls[k].dir)
						continue;
					if(balls[j].loc==balls[k].loc) {
						balls[j].dir = balls[j].dir==0?1:0;
						balls[k].dir = balls[k].dir==0?1:0;
					}
				}
		}
		
		for(int i=0; i<n; i++)
			System.out.print(balls[i].loc+" ");
		
		in.close();
	}
	
}
class Ball {
	public int no;
	public int loc;
	public int dir;
	public Ball(int no, int loc) {
		this.no = no;
		this.loc = loc;
		this.dir = 1;
	}
}

