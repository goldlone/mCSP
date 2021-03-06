package _170302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CSP10 - 第二题 学生排队
 * Created by CN on 2017/10/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        Integer temp = new Integer(0);
        int index;
        int changeNum = 0;

        int stuNum = in.nextInt();
        int opNum = in.nextInt();

        for(int i=0; i<stuNum; i++){
            list.add(i+1);
        }

        for(int i=0; i<opNum; i++){
            temp = in.nextInt();
            changeNum = in.nextInt();

            index = list.indexOf(temp);
            list.remove(temp);
            if(index+changeNum < 0){
                list.add(0, temp);
            }
            else if(index+changeNum > stuNum-1){
                list.add(stuNum-1, temp);
            }
            else{
                list.add(index+changeNum, temp);
            }

        }

        for(int i=0; i<stuNum; i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        in.close();
    }
}