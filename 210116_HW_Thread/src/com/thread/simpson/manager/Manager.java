package com.thread.simpson.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.thread.simpson.vo.Boss;
import com.thread.simpson.vo.Colleague;
import com.thread.simpson.vo.Monster;
import com.thread.simpson.vo.Player;
import com.thread.simpson.vo.Simpson;

public class Manager implements Battle{
	Simpson simp = new Player("simp", 100, 10);
	Simpson boss = new Boss("Boss", 1000, 30);
	Map<Integer, Colleague> collMap = new HashMap<>();
	Map<Integer, Monster> monMap = new HashMap<>();
	
	public void produceC() {
		Colleague highCol = new Colleague("h", 50, 5);
		Colleague nomalCol = new Colleague("n", 30, 3);
		Colleague lowCol = new Colleague("l", 15, 1);
		
		for(int i = 0; i <20; i++) {
			double ran = Math.random()*10;
			if(ran < 6) {
				collMap.put(i, lowCol);
			}
			else if(ran < 8) {
				collMap.put(i, nomalCol);
			}
			else {
				collMap.put(i, highCol);
			}
		}
	}

	public void produceM() {
		
	}
	
	public void battle() {
			while(boss.getHp() > 0 && collMap.size() > 0) {
				Set<Integer> collSet = collMap.keySet();
				//int randel = (int)(Math.random()* 200);
				int rannum = (int)(Math.random()* 20);
				
				System.out.println("남은 사람"+collMap.size());
				try {
					atk(boss, collMap.get(rannum));
				} catch(NullPointerException e) {
					continue;
				}
				for(int key : collSet) {
					atk(collMap.get(key), boss);
				}
				
				Iterator<Integer> iter = collSet.iterator();
				while(iter.hasNext()) {
					int key = iter.next();
					if(collMap.get(key).getHp() < 0) {
						iter.remove();
						break;
					}
				}
				
				System.out.println("보스 체력"+boss.getHp());
				
				delay(1000);
				
			}
			System.out.println("보스 사망?");
	}
	
	public void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void atk(Simpson s1, Simpson s2) {
		s2.setHp(s2.getHp()-s1.getAtk());
	}
}
