package _170301;

import java.util.Scanner;

/**
 * CSP10 - 第一题 分蛋糕
 * Created by CN on 2017/10/22.
 */
public class Main {
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
        in.close();
    }
}
