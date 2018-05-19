//package _171203;
//
//import java.util.ArrayList;
//import java.util.Formatter;
//import java.util.Scanner;
//
//public class Test {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		String startTime = in.next();
//		String endTime = in.next();
//		ArrayList<Task> list = new ArrayList<Task>(n);
//	
//		while(n-->0) {
//			String minutes = in.next();
//			String hours = in.next();
//			String dayOfMonth = in.next();
//			String month = in.next();
//			String dayOfWeek = in.next();
//			String command = in.next();
////			list.add(new Task(minutes, hours, dayOfMonth, month, dayOfWeek, command));
//		}
//		
//		
//		
//		
//		
//		
//		in.close();
//	}
//
//}
//
//class Task implements Comparable<Task>{
//	public int minutes;
//	public int hours;
//	public int dayOfMonth;
//	public int month;
//	public int dayOfWeek;
//	public String command;
//	public long time;
//	public Task(int minutes, int hours, int dayOfMonth, int month,
//			int dayOfWeek, String command) {
//		this.minutes = minutes;
//		this.hours = hours;
//		this.dayOfMonth = dayOfMonth;
//		this.month = month;
//		this.dayOfWeek = dayOfWeek;
//		this.command = command;
//		
//	}
//	@Override
//	public int compareTo(Task o) {
//		return (int)(this.time-o.time);
//	}
//	
//	
//	
//	
//	
//	
////	public ArrayList<Integer> minutes;
////	public ArrayList<Integer> hours;
////	public ArrayList<Integer> dayOfMonth;
////	public ArrayList<Integer> month;
////	public ArrayList<Integer> dayOfWeek;
////	public String command;
////	public Task(String minutes, String hours, String dayOfMonth, String month,
////			String dayOfWeek, String command) {
////		this.minutes = new ArrayList<Integer>(60);
////		this.hours = new ArrayList<Integer>(24);
////		this.dayOfMonth = new ArrayList<Integer>(31);
////		this.month = new ArrayList<Integer>(12);
////		this.dayOfWeek = new ArrayList<Integer>(7);
////			
////		if(minutes.equals("*")) {
////			for(int i=0; i<60; i++)
////				this.minutes.add(i);
////		} else if(minutes.indexOf(",") != -1) {
////			String[] arr = minutes.split(",");
////			if(minutes.indexOf("-") != -1) {
////				
////				
////			} else {
////				for(int i=0; i<arr.length; i++)
////					this.minutes.add(Integer.parseInt(arr[i]));
////			}
////		} else if(minutes.indexOf("-") != -1) {
////			
////		} else {
////			this.minutes.add(Integer.parseInt(minutes));
////		}
////		
////		
////		
////		
////		this.command = command;
////	}
//	
//	
//	public long calcTime(int minutes, int hours, int dayOfMonth, int month, int year) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("0000");
//		sb.append(year);
//		if(month<10){
//			sb.append(0);
//			sb.append(month);
//		} else {
//			sb.append(month);
//		}
//		
//		
//		return 0;
//	}
//	
//	
//}
