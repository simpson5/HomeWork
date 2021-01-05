package com.collection.map.student;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

public class StudentProperties {
	public static void main(String[] args) {
		StudentProperties s = new StudentProperties();
		List<Student> sList = s.readFile();
		s.printConsole(sList);;
		s.saveXMLFile(sList);
	}

	public List<Student> readFile(){
		List<Student> stdtList = new ArrayList<>();
		//1. Properties 객체 생성score.txt 파일의 내용을 읽어
		Properties prop = new Properties();
		//2. score.txt 파일의 내용을 읽어 리스트 만듦
		try {
			prop.load(new FileReader("score.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//3. 키를 사용하여, 객체정보를 List<Student>에 저장하여 리턴함
		Enumeration<?> en = prop.propertyNames();
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = prop.getProperty(name);
			//System.out.println(name + " = " + value);
			// => ", " 으로 문자열 분리처리
			StringTokenizer st = new StringTokenizer(value, ",");
			// => 분리된 문자열을 각 자료형 필드의 값으로 형변환 대입 저장함
			stdtList.add(new Student(Integer.parseInt(st.nextToken()),
					st.nextToken(),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		return stdtList;
	}
	
	public void printConsole(List<Student> stdtList){
		Iterator<Student> iter = stdtList.iterator();
		int mathSum = 0;
		int korSum = 0;
		int engSum = 0;
		double mathAvg;
		double korAvg;
		double engAvg;
		while(iter.hasNext()) {
			Student std = iter.next();
			//1. 전달받은 값 출력
			System.out.println(std);
			//2. 각 객체의 국어합계, 영어합계, 수학합계를 구하고
			mathSum += std.getMath();
			korSum += std.getKor();
			engSum += std.getEng();
		}
		//3. 과목별 평균점수를 출력함
		mathAvg = mathSum / 5.0;
		korAvg = korSum / 5.0;
		engAvg = engSum / 5.0;
		System.out.println("수학 평균 : " + cutDecimal(2, mathAvg));
		System.out.println("국어 평균 : " + cutDecimal(2, korAvg));
		System.out.println("영어 평균 : " + cutDecimal(2, engAvg));
	}
	
	public void saveXMLFile(List<Student> stdtList){
		//1. "student.xml" 파일에 번호필드를 key로 객체가 가진 값 기록 저장함.
		Properties prop = new Properties();
		Iterator<Student> iter = stdtList.iterator();
		while(iter.hasNext()) {
			Student s = iter.next();
			String key = Integer.toString(s.getSno());
			prop.setProperty(key, s.toString());
		}
		
		try {
			prop.storeToXML(new FileOutputStream("student.xml"),"student.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//소수점 자리 바꾸는 함수
	public String cutDecimal(int cutSize, double value) { 
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(cutSize);
		nf.setGroupingUsed(false);
		return nf.format(value); }
}
