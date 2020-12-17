package com.oop.emp.model;

import java.util.Scanner;

public class Employee {
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void empInput() {
		System.out.println("====정보 입력====");
		Scanner sc = new Scanner(System.in);
		System.out.print("사번:");
		empNo = sc.nextInt();
		System.out.print("이름:");
		empName = sc.next();
		System.out.print("소속부서:");
		dept = sc.next();
		System.out.print("직급:");
		job = sc.next();
		System.out.print("나이:");
		age = sc.nextInt();
		System.out.print("성별(M/F):");
		gender = sc.next().charAt(0);
		System.out.print("급여:");
		salary = sc.nextInt();
		System.out.print("보너스포인트:");
		bonusPoint = sc.nextDouble();
		System.out.print("핸드폰:");
		phone = sc.next();
		System.out.print("주소:");
		address = sc.next();
	}
	
	public void empOutput() {
		System.out.println("사번: "+empNo);
		System.out.println("이름: "+empName);
		System.out.println("소속부서: "+dept);
		System.out.println("직급: "+job);
		System.out.println("나이: "+age);
		System.out.println("성별: "+gender);
		System.out.println("급여: "+salary);
		System.out.println("보너스포인트: "+bonusPoint);
		System.out.println("핸드폰: "+phone);
		System.out.println("주소: "+address);
	}
}
