package _170903;

import java.util.HashMap;
import java.util.Scanner;

/**
 * CSP11 - 第三题 JSON解析
 * 运行出现错误，10分
 * Created by CN on 2017/10/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineNum = in.nextInt();
        int selectNum = in.nextInt();

        String[] inStr = new String[lineNum];

        for(int i=0; i<lineNum; i++) {
            if((inStr[i] = in.nextLine()).equals(""))
                inStr[i] = in.nextLine();
        }

        String[] temp;
        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, String> obj = new HashMap<String, String>();
        boolean open = false;
        String ObjName = null;
        for(int i=0; i<lineNum; i++){
            inStr[i] = inStr[i].replace(",", "");
            if(inStr[i].contains("\\\\"))
                inStr[i] = inStr[i].replace("\\\\", "\\");
            if(inStr[i].contains("}")){
                open = false;
            }
            if(inStr[i].contains(":")){
                temp = inStr[i].split(":");
                if(temp[1].contains("{")){
                    map.put(temp[0].replace("\"", "").trim(), "OBJECT");
                    open = true;
                    ObjName = temp[0].replace("\"", "").trim();
                } else if(temp[1].contains("\\\"")){
                    map.put(temp[0].replace("\"", ""), temp[1].replace("\\\"", "").trim());
                    if(open) {
                        obj.put(temp[0].replace("\"", "").trim(), ObjName);
                    }
                } else {
                    map.put(temp[0].replace("\"", ""), temp[1].replace("\"", "").trim());
                    if(open) {
                        obj.put(temp[0].replace("\"", "").trim(), ObjName);
                    }
                }
            }
        }

        String[] selectStr = new String[selectNum];
        for(int i=0; i<selectNum; i++){
            selectStr[i] = in.nextLine();
        }

        for(int i=0; i<selectNum; i++) {
            if (selectStr[i].contains(".")) {
                temp = new String[2];
                temp[0] = selectStr[i].substring(0, selectStr[i].indexOf("."));
                temp[1] = selectStr[i].substring(selectStr[i].indexOf(".") + 1);
                if (!map.containsKey(temp[1].trim())) {
                    System.out.println("NOTEXIST");
                } else if (!obj.get(temp[1].trim()).equals(temp[0])) {
                    System.out.println("NOTEXIST");
                } else {
                    System.out.println("STRING " + map.get(temp[1].trim()));
                }
            } else if (!map.containsKey(selectStr[i].trim())) {
                System.out.println("NOTEXIST");
            } else {
                if (map.get(selectStr[i].trim()).equals("OBJECT"))
                    System.out.println("OBJECT");
                else
                    System.out.println("STRING " + map.get(selectStr[i].trim()));
            }
        }

        in.close();
    }
}
