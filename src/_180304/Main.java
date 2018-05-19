package _180304;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] chess = new int[3][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++)
				for(int k=0; k<3; k++)
					chess[j][k] = in.nextInt();
			
			System.out.println(start(chess));
		}
		in.close();
	}
	
	public static int start(int[][] arr) {
		int rec = 0;
		if((rec=checkOK(arr))!=6) {
			return rec;
		}
		
		for(int j=0; j<3; j++)
			for(int k=0; k<3; k++)
				if(arr[j][k]==0 && checkHere(arr, j, k))
					return getRec(arr);
		
		return 0;
	}
	
	public static int checkOK(int[][] arr) {
		for(int i=0; i<3; i++) {
			if(arr[i][0]==arr[i][1] && arr[i][0]==arr[i][2]) {
				if(arr[i][0]==1)
					return getRec(arr)+1;
				else if(arr[i][0]==2)
					return -(getRec(arr)+1);
			}
			if(arr[0][i]==arr[1][i] && arr[0][i]==arr[2][i]) {
				if(arr[0][i]==1)
					return getRec(arr)+1;
				else if(arr[0][i]==2)
					return -(getRec(arr)+1);
			}
		}
		if(arr[0][2]==arr[1][1] && arr[0][2]==arr[2][0]) {
			if(arr[0][2]==1)
				return getRec(arr)+1;
			else if(arr[0][2]==2)
				return -(getRec(arr)+1);
		}
		if(arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2]) {
			if(arr[0][0]==1)
				return getRec(arr)+1;
			else if(arr[0][0]==2)
				return -(getRec(arr)+1);
		}
		return 6;
	}
	
	public static boolean checkHere(int[][] arr, int row, int col) {
		switch(row) {
			case 0:
				switch(col) {
					case 0:
						if(arr[0][1]==1 && arr[0][2]==1)
							return true;
						if(arr[1][0]==1 && arr[2][0]==1)
							return true;
						if(arr[1][1]==1 && arr[2][2]==1)
							return true;
						break;
					case 1:
						if(arr[0][0]==1 && arr[0][2]==1)
							return true;
						if(arr[1][1]==1 && arr[2][1]==1)
							return true;
						break;
					case 2:
						if(arr[0][0]==1 && arr[0][1]==1)
							return true;
						if(arr[1][2]==1 && arr[2][2]==1)
							return true;
						if(arr[1][1]==1 && arr[2][0]==1)
							return true;
						break;
				}
				break;
			case 1:
				switch(col) {
					case 0:
						if(arr[1][1]==1 && arr[1][2]==1)
							return true;
						if(arr[0][0]==1 && arr[2][0]==1)
							return true;
						break;
					case 1:
						if(arr[1][0]==1 && arr[1][2]==1)
							return true;
						if(arr[0][1]==1 && arr[2][1]==1)
							return true;
						if(arr[0][0]==1 && arr[2][2]==1)
							return true;
						if(arr[2][0]==1 && arr[0][2]==1)
							return true;
						break;
					case 2:
						if(arr[1][0]==1 && arr[1][1]==1)
							return true;
						if(arr[0][2]==1 && arr[2][2]==1)
							return true;
						break;
				}
				break;
			case 2:
				switch(col) {
					case 0:
						if(arr[2][1]==1 && arr[2][2]==1)
							return true;
						if(arr[0][0]==1 && arr[1][0]==1)
							return true;
						if(arr[1][1]==1 && arr[0][2]==1)
							return true;
						break;
					case 1:
						if(arr[2][0]==1 && arr[2][2]==1)
							return true;
						if(arr[0][1]==1 && arr[1][1]==1)
							return true;
						break;
					case 2:
						if(arr[2][0]==1 && arr[2][1]==1)
							return true;
						if(arr[0][2]==1 && arr[1][2]==1)
							return true;
						if(arr[0][0]==1 && arr[1][1]==1)
							return true;
						break;
				}
				break;
		}
		
		return false;
	}
	
	public static int getRec(int[][] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			for(int j=0; j<arr[i].length; j++)
				if(arr[i][j]==0)
					sum++;
		return sum;
	}
}