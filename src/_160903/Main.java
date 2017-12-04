package _160903;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int result = 0;
		String op = null;
		int addPos;
		int attacker;
		int defender;
		int inputNum = input.nextInt();
		boolean isFirst = true;
		
		ArrayList<Follower> firstMan = new ArrayList<Follower>(8);
		ArrayList<Follower> nextMan = new ArrayList<Follower>(8);
		firstMan.add(new Follower(0, 30));
		nextMan.add(new Follower(0, 30));
		for(int i=0; i<inputNum; i++) {
			if(result != 0)
				break;
			op = input.next();
			switch(op) {
				case "summon":
					addPos = input.nextInt();
					Follower follower = new Follower(input.nextInt(), input.nextInt());
					if(isFirst)
						firstMan.add(addPos, follower);
					else
						nextMan.add(addPos, follower);
					break;
				case "attack":
					attacker = input.nextInt();
					defender = input.nextInt();
					if(isFirst){
						firstMan.get(attacker).health -= nextMan.get(defender).attack;
						nextMan.get(defender).health -= firstMan.get(attacker).attack;
						if(defender==0 && nextMan.get(defender).health == 0){
							result = 1;
							break;
						}
						if(firstMan.get(attacker).health<=0)
							firstMan.remove(attacker);
						if(nextMan.get(defender).health<=0)
							nextMan.remove(defender);
						
					}
					else {
						nextMan.get(attacker).health -= firstMan.get(defender).attack;
						firstMan.get(defender).health -= nextMan.get(attacker).attack;
						if(defender==0 && firstMan.get(defender).health == 0){
							result = -1;
							break;
						}
						if(nextMan.get(attacker).health<=0)
							nextMan.remove(attacker);
						if(firstMan.get(defender).health<=0)
							firstMan.remove(defender);
					}
					break;
				case "end":
					isFirst = isFirst?false:true;
					break;
			}
		}
		
		System.out.println(result);
		
		System.out.println(firstMan.get(0).health);
		System.out.print((firstMan.size()-1));
		for(int i=1; i<firstMan.size(); i++)
			System.out.print(" "+firstMan.get(i).health);
		System.out.println();

		System.out.println(nextMan.get(0).health);
		System.out.print((nextMan.size()-1));
		for(int i=1; i<nextMan.size(); i++)
			System.out.print(" "+nextMan.get(i).health);
		input.close();
	}
}

class Follower {
	public int health;
	public int attack;
	
	public Follower(int attack, int health) {
		this.health = health;
		this.attack = attack;
	}
}
