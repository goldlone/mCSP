package _170901;

import java.util.Scanner;

/**
 * CSP11 - 第一题 打酱油
 * Created by CN on 2017/10/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num = 0;
        while(n>=30){
            if(n>=50){
                num = num+7;
                n = n-50;
            } else {
                num = num+4;
                n = n-30;
            }
        }
        num = num+n/10;

        System.out.println(num);
        in.close();
    }
}
