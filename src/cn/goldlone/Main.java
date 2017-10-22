package cn.goldlone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int count = in.nextInt();
        int[] nums = new int[len];
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
                l = in.nextInt();
                r = in.nextInt();
                for(int i=0; l+i<=r; i++) {
                    result += nums[l+i-1];
                }
                System.out.println(result);
            }
            else if(opt == 1) {
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
