package _170904;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CSP11 - 第四题 通信网络
 * 运行错误，0分
 * Created by CN on 2017/10/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int inputNum = in.nextInt();

        int[][] arcs = new int[n][n];
        int[][] know = new int[n][n];

        int x,y;
        for(int i=0; i<inputNum; i++) {
            x = in.nextInt();
            y = in.nextInt();
            arcs[x-1][y-1] = 1;
        }
        for(int i=0; i<n; i++){
            arcs[i][i] = 1;
        }

        boolean[] mark = new boolean[n];
        ArrayList<Integer> que = new ArrayList<Integer>(n);
        que.add(0);
        int p = 0;
        while(!isOver(mark)) {
            if(que.isEmpty())
                que.add(getOne(mark));
            p = que.remove(0);
            mark[p] = true;
            for(int i=0; i<n; i++){
                if(arcs[p][i] == 1){
                    know[p][i] = 1;
                    know[i][p] = 1;
                    for(int j=0; j<n; j++){
                        if(arcs[j][p] == 1)
                            know[j][i] = 1;
                    }
                    if(!que.contains(i) && !mark[i])
                        que.add(i);
                }
            }
        }

        int[][] sum = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum[i][0] += know[i][j];
                sum[i][1] += know[j][i];
            }
        }

        int all = 0;
        for(int i=0;i<n;i++)
            if(sum[i][0]==n || sum[i][1]==n)
                all++;

        System.out.println(all);
        in.close();
    }

    public static boolean isOver(boolean[] mark) {
        for(int i=0; i<mark.length; i++){
            if(!mark[i])
                return false;
        }

        return true;
    }

    public static int getOne(boolean[] mark){
        for(int i=0; i<mark.length; i++){
            if(!mark[i])
                return i;
        }
        return 0;
    }
}
