package _160403;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
//		Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("./csp.txt"));
		int n = in.nextInt();
		in.nextLine();
		String now = in.nextLine();
		String dir = null;
		String[] arr = null;
		String[] arr1 = null;
		Stack<String> s = new Stack<String>();
		for(int i=0; i<n; i++) {
			dir = in.nextLine();
			arr = dir.split("/");
			if(" ".equals(dir) || "".equals(dir)) {
				arr1 = now.split("/");
				send(s, arr1, 0);
			}
			else if(dir.startsWith("..")) {
				arr1 = now.split("/");
				send(s, arr1, 0);
				s.pop();
				send(s, arr, 1);
			} 
			else if(dir.startsWith(".")) {
				arr1 = now.split("/");
				send(s, arr1, 0);
				send(s, arr, 1);
			}
			else {
				send(s, arr, 0);
			}
			if(s.isEmpty()) {
				System.out.println("/");
			}
			else {
				StringBuilder sb = new StringBuilder();
				Stack<String> s2 = new Stack<String>();
				while(!s.isEmpty()){
					s2.push(s.pop());
				}
				while(!s2.isEmpty()) {
					sb.append("/");
					sb.append(s2.pop());
				}
				System.out.println(sb.toString());
			}
		}
		
		
		in.close();
	}
	
	public static void send(Stack<String> s, String[] arr, int j) {
		for(; j<arr.length; j++) {
			if(arr[j].equals("") || arr[j].equals("."))
				continue;
			else if(arr[j].equals("..")) {
				if(!s.isEmpty())
					s.pop();
			}
			else
				s.push(arr[j]);
		}
	}
}
