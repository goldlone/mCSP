package _180303;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String[] names = new String[n];
		String[][] p = new String[n][];
		String[][] q = new String[m][];
		for(int i=0; i<n; i++) {
			p[i] = in.next().split("/");
			names[i] = in.next();
		}
		
		for(int i=0; i<m; i++) {
			q[i] = in.next().split("/");
		}
		
		Result res = null;
		for(int i=0; i<m; i++) {
			if((res=start(p, q[i])).no!=-1) {
				System.out.print(names[res.no]);
				int ss = 0;
				for(String str: res.param){
					if(str.indexOf('/')!=-1) {
						if(ss==0)
							System.out.print(" "+str.substring(1));
						else
							System.out.print(str);
						ss++;
					} else {
						System.out.print(" "+str);
					}
				}
				System.out.println();
			} else {
				System.out.println("404");
			}
		}
		
		in.close();
	}
	
	public static Result start(String[][] p, String[] q) {
		Result res = new Result();
		for(int i=0; i<p.length; i++) {
			int pos = 1;
			boolean ok = true;
			res.param.removeAll(res.param);
			for(int j=1; j<q.length; j++) {
				if(pos>=p[i].length || p[i][pos] == null) {
					ok = false;
					break;
				}
				else if(q[j].equals(p[i][pos])) {
					pos++;
					continue;
				}
				else if(p[i][pos].equals("<int>")) {
					try{
						Integer.parseInt(q[j]);
						pos++;
						res.param.add(q[j]);
						continue;
					} catch(Exception e) {
						ok = false;
						break;
					}
				} else if(p[i][pos].equals("<str>")) {
					pos++;
					res.param.add(q[j]);
					continue;
				} else if(p[i][pos].equals("<path>")) {
					if((pos+1)<p[i].length && q[j].equals(p[i][pos+1])) {
						pos=pos+2;
						continue;
					}
					res.param.add("/"+q[j]);
				} else {
					break;
				}
			}
			if(pos<p[i].length) {
				if(p[i][pos].equals("<path>"))
					pos++;
				if(ok && pos<p[i].length) {
					ok = false;
				}
			}
			
			if(ok) {
				res.no = i;
				return res;
			}
		}
		
		return res;
	}
	
}
class Result {
	public int no;
	public ArrayList<String> param;
	public Result() {
		no = -1;
		param = new ArrayList<String>(100);
	}
}