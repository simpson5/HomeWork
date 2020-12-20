package streamtest;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamMainTest {
	public static double atkAvg = 0;
	public static int sum = 0;
	public static int rewadrSum = 0;

	public static void main(String[] args) {
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		for(int i = 0; i <100; i++) {
			String name = String.valueOf(i+1);
			int atk = (int)(Math.random()*100)+1;
			int reward = (int)(Math.random()*100)+1;
			monsters.add(new Monster(name, atk, reward));
		}
		
		//Stream
		//1.모든 몬스터 출력
		//monsters.stream().forEach(m -> System.out.println(m));
		//2.공격력이 50이상인 몬스터만
		//monsters.stream().filter(a -> a.getAtk()>=50).forEach(s -> System.out.println(s));
		//3.공격력이 50이상 && 보상 50 이상
		monsters.stream()
		.filter(a -> a.getAtk()>=50)
		.filter(b -> b.getReward()>=50)
		.forEach(s -> System.out.println(s));
		//4.갯수
		long cnt = monsters.stream()
		.filter(a -> a.getAtk()>=50)
		.filter(b -> b.getReward()>=50)
		.count();
		System.out.println(cnt);
		// 5. 평균 공격력이랑 보상합계를 알아보자.
	    Double avg = monsters.stream().map(m-> m.getAtk()).collect(Collectors.averagingDouble(v -> v));
	    System.out.println("공격력 평균  : " + avg);
	    int sum = monsters.stream().map(m-> m.getReward()).collect(Collectors.summingInt(v -> v));
	    System.out.println("보상 합계  : " + sum);
	    
	    int[] sumAtk = {0};
	    monsters.stream().forEach(m -> sumAtk[0] += m.getAtk());
	    avg = sumAtk[0]/(double)monsters.size();
	    System.out.println("공격력 평균  : " + avg);
	    int[] sumReward = {0};
	    monsters.stream().forEach(m -> sumReward[0] += m.getReward());
	    System.out.println("보상 합계  : " + sumReward[0]);
	}
}
