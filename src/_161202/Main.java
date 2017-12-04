package _161202;

import java.util.Scanner;

/**
 * 工资计算
 * @author CN
 * 2017年11月13日 下午7:04:00
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		double s = 0;
		
		t = t-3500;
		if(t>57505) {
			s = 80000+(t-57505)/0.55;
		}
		else if(t>41255) {
			s = 55000+(t-41255)/0.65;
		}
		else if(t>27255) {
			s = 35000+(t-27255)/0.7;
		}
		else if(t>7755) {
			s = 9000+(t-7755)/0.75;
		}
		else if(t>4155) {
			s = 4500+(t-4155)/0.8;
		}
		else if(t>1455) {
			s = 1500+(t-1455)/0.9;
		}
		else if(t>0) {
			s = t/0.97;
		}
		else {
			s = t;
		}
		
		s = s+3500;
		System.out.println((int)s);
		
		in.close();
	}

	/**
	 * 计算税后工资
	 * @param s
	 * @return
	 */
	public static double calc(int s) {
		double t = 0;
		s = s-3500;
		if(s>80000) {
			t = 1500*0.03+3000*0.1+4500*0.2+26000*0.25+20000*0.3+25000*0.35+(s-80000)*0.45;
		} else if(s>55000) {
			t = 1500*0.03+3000*0.1+4500*0.2+26000*0.25+20000*0.3+(s-55000)*0.35;
		} else if(s>35000) {
			t = 1500*0.03+3000*0.1+4500*0.2+26000*0.25+(s-35000)*0.3;
		} else if(s>9000) {
			t = 1500*0.03+3000*0.1+4500*0.2+(s-9000)*0.25;
		} else if(s>4500) {
			t = 1500*0.03+3000*0.1+(s-4500)*0.2;
		} else if(s>1500) {
			t = 1500*0.03+(s-1500)*0.1;
		} else if(s>0) {
			t = 1500*0.03;
		}
		
		t = (s-t)+3500;
		
		return t;
	}
}
