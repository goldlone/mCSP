package cn.goldlone.csp11;

import java.io.File;
import java.util.Scanner;

/**
 * CSP11 - 第五题 除法
 * 运行超时 30分
 * Created by CN on 2017/10/22.
 */
public class Exp_170905 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("./csp.txt"));
//        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int count = in.nextInt();
        int[] nums = new int[len];
        int num = 0;
        int result = 0;
        for(int i=0; i<len; i++) {
            nums[i] = in.nextInt();
        }

        int l, r, v;
        int opt;
        for(int j=0; j<count; j++) {
            result = 0;
            opt = in.nextInt();
            if(opt == 2) {
                // 处理两个操作数
                l = in.nextInt();
                r = in.nextInt();
                for(int i=0; l+i<=r; i++) {
                    result += nums[l+i-1];
                }
                System.out.println(result);
            }
            else if(opt == 1) {
                // 处理三个操作数
                l = in.nextInt();
                r = in.nextInt();
                v = in.nextInt();
                for(int i=0; l+i<=r; i++) {
                    if(nums[l+i-1]%v == 0)
                        nums[l+i-1] /= v;
                }
            }
        }
        in.close();
    }
}
