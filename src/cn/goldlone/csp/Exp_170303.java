package cn.goldlone.csp;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @ClassName: Exp_170303
 * @Description: TODO 
 * @author: CN
 * 创建时间: 2017年8月25日 下午1:10:11
 */
public class Exp_170303 {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("./csp.txt"));
        String line = null;
        String preline = null;
        String text = "";
        int start,end;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            if(line == null || line.length() == 0){
                if(preline == null){//�������У�����
                    continue;
                }
                //�������У�˵����������ˣ�������������ת�������
                if(preline.contains("<h")){
                    System.out.print(preline);
                }else if(preline.contains("<ul>")){
                    preline += "\n"+"</ul>"+"\n";
                    System.out.print(preline);
                }else if(preline.contains("<p>")){
                    preline += "</p>"+"\n";
                    System.out.print(preline);
                }
                //ÿ�����һ�����鶼Ҫ��ǰ���preline��Ϊnull
                preline = null;
                continue;
            }
            //ǿ��
            while((start = line.indexOf("_")) != -1){
                end = line.indexOf("_",start+1);
                text = line.substring(start, end+1);
                line = line.replace(text,"<em>"+text.substring(1,text.length()-1)+"</em>");
            }
            //������
            while((start = line.indexOf("[")) != -1){
                end = line.indexOf("]",start+1);
                text = line.substring(start+1, end);
                int khstart = line.indexOf("(",end);
                int khend = line.indexOf(")",khstart);
                String link = line.substring(khstart+1,khend);
                line = line.replace("["+text+"]"+"("+link+")","<a href=\""+link+"\""+">"+text+"</a>");
            }
            //��������
            //����
            int num = 0;
            if(line.startsWith("#")){
                while(line.startsWith("#") && num <=6){
                    line = line.substring(1);
                    num++;
                }
                //���Ա���ǰ�Ŀո�
                while(line.startsWith(" ")){
                    line = line.replaceFirst(" ","");
                }
                preline = "<h"+num+">"+line+"</h"+num+">"+"\n";
            //�����б�
            }else if(line.startsWith("*")){
                //�����Ǻ�
                line = line.replace("*", "");
                //�����Ǻź����һ�������ո�
                while(line.startsWith(" ")){
                    line = line.substring(1);
                }
                if(preline == null){
                    preline = "<ul>"+"\n"+"<li>"+line+"</li>";
                }else{
                    preline += "\n"+"<li>"+line+"</li>";
                }
            }else{//����
                if(preline == null){
                    preline = "<p>"+line;
                }else{
                    preline += "\n"+line;
                }
            }
        }
        
        //���������Ҫ������һ�������ת�����
        if(preline.contains("<h")){
            System.out.print(preline);
        }else if(preline.contains("<ul>")){
            preline += "\n"+"</ul>"+"\n";
            System.out.print(preline);
        }else if(preline.contains("<p>")){
            preline += "</p>"+"\n";
            System.out.print(preline);
        }
	}
	
}
