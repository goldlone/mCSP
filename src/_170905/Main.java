package _170905;

import java.io.File;
import java.util.Scanner;

/**
 * CSP11 - 第五题 除法
 * 运行超时 30分
 * Created by CN on 2017/10/22.
 */

public class Main {
    private int[] nums;
    private boolean[] oks;

    public void run() throws Exception {
        Scanner in = new Scanner(new File("./csp.txt"));
//        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int count = in.nextInt();
        int threadNum = 5000;
        nums = new int[len];
//        int num = 0;
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

                if((r-l)%threadNum == 0)
                    oks = new boolean[r/threadNum];
                else
                    oks = new boolean[r/threadNum+1];
                for(int i=l, time=0; i<=r; i+=threadNum,time++) {
                    if((r-i)>threadNum)
                        new CalcThread(nums, i, i+threadNum, v, time, oks).start();
                    else {
                        new CalcThread(nums, i, r+1, v, time, oks).start();
                    }
                }
                while (true) {
                    if(haveDone())
                        break;
                    else
                        Thread.sleep(10);
                }
            }
        }
        in.close();
    }

    public boolean haveDone() {
        for(int i=0; i<oks.length; i++){
            if(!oks[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        (new Main()).run();
    }
}

class CalcThread extends Thread {
    private int[] nums;
    private int start;
    private int end;
    private int v;
    private int time;
    private boolean[] oks;

    public CalcThread(int[] nums, int start, int end, int v, int time, boolean[] oks) {
        this.nums = nums;
        this.start = start;
        this.end = end;
        this.v = v;
        this.time = time;
        this.oks = oks;
    }
    @Override
    public void run() {
        for(int i=start; i<end; i++) {
            if(nums[i-1]%v == 0)
                nums[i-1] /= v;
        }
        oks[time] = true;
    }
}
