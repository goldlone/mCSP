package _170902;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CSP11 - 第二题 公共钥匙盒
 * Created by CN on 2017/10/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int keyNum = in.nextInt();
        int inputNum = in.nextInt();
        int takeNum = 0;
        int backNum = 0;

        ArrayList<Integer> keys = new ArrayList<Integer>(keyNum);
        for(int i=0; i<keyNum; i++){
            keys.add(i+1);
        }

        KeyNode[] nodes = new KeyNode[inputNum];
        KeyNode node = null;
        for(int i=0; i<inputNum; i++) {
            node = new KeyNode(in.nextInt(), in.nextInt(), in.nextInt());
            node.end = node.start+node.end;
            nodes[i] = node;
        }

        KeyNode[] takeNodes = sort1(nodes);
        KeyNode[] nodes1 = nodes.clone();
        KeyNode[] backNodes = sort2(nodes1);

        for(int i=0; i<=backNodes[backNodes.length-1].end; i++) {
            while(backNum<backNodes.length && i==backNodes[backNum].end) {
                for(int j=0; j<keys.size(); j++){
                    if(keys.get(j)==0){
                        keys.remove(j);
                        keys.add(j, backNodes[backNum].id);
                        break;
                    }
                }
                backNum++;
            }
            while(takeNum<takeNodes.length && i==takeNodes[takeNum].start) {
                int index = keys.indexOf(takeNodes[takeNum].id);
                keys.remove(index);
                keys.add(index, 0);
                takeNum++;
            }
        }

        for(int i=0; i<keys.size(); i++){
            System.out.print(keys.get(i)+" ");
        }

        in.close();
    }

    public static KeyNode[] sort1(KeyNode[] list) {
        int pos = 0;
        for(int i=0; i<list.length; i++){
            pos = i;
            for(int j=i; j<list.length; j++) {
                if(list[j].start<list[pos].start)
                    pos = j;
            }
            if(i!=pos) {
                KeyNode temp = list[i];
                list[i] = list[pos];
                list[pos] = temp;
            }
        }

        return list;
    }

    public static KeyNode[] sort2(KeyNode[] list) {
        int pos = 0;
        for(int i=0; i<list.length; i++){
            pos = i;
            for(int j=i; j<list.length; j++) {
                if((list[j].end<list[pos].end) || (list[j].end==list[pos].end&&list[j].id<list[pos].id))
                    pos = j;
            }
            if(i!=pos) {
                KeyNode temp = list[i];
                list[i] = list[pos];
                list[pos] = temp;
            }
        }

        return list;
    }
}

class KeyNode {
    public int id;
    public int start;
    public int end;

    public KeyNode(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}
