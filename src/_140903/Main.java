package _140903;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String strObj = in.next();
		int order = in.nextInt();
		int n = in.nextInt();
		List<String> list = new ArrayList<String>();
		if(order!=1)
			strObj = strObj.toLowerCase();
		for(int i=0; i<n; i++) {
			String rec = in.next();
			if(order!=1)
				rec = rec.toLowerCase();
			if(rec.contains(strObj))
				list.add(rec);
		}
		
		for(String str: list)
			System.out.println(str);
		in.close();
	}
}
