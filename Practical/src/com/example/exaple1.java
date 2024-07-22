package com.example;
import java.util.Scanner;

public class exaple1 {
	public static void main(String ares[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number 1 : ");
		int no1 = sc.nextInt();		
		System.out.print("enter number 2 : ");
		int no2 = sc.nextInt();
		int sum = no1 +no2;
		System.out.print("sum : "+sum);
	}
}