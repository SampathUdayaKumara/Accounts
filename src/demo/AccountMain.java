package demo;

import java.util.Scanner;

public class AccountMain {

	public  AccountMain() {
		//create scanner object
		Scanner scan = new Scanner(System.in);
		//get Facility Amount
		System.out.print("Enter Facility Amount : ");
		double fAmount = scan.nextDouble();
		//get Repayments period
		System.out.print("Enter Repayment Period : ");
		int rPeriod = scan.nextInt();
		//get annual interest rate
		System.out.print("Enter Annual Interest Rate (e.g, 7.25) : ");
		double rate = scan.nextDouble();
		//calculate monthly rate using annual rate
		double monthlyRate = rate/1200;
		//calculating monthly installment value
		double insValue;
		
		insValue=fAmount*monthlyRate/(1-1/Math.pow(1+monthlyRate,rPeriod));
		System.out.println("Instalment Value is "+ insValue);
		
		double iAmount,cAmount;
		double cBalance=fAmount;
		//Row Heddings
		System.out.println("Rental No\t Rental Value Interest Amount Capital Amount Capital Balance");
		//first Row
		System.out.println("0\t\t 0\t\t 0\t\t 0\t\t "+(int)(fAmount));
		
		for(int i=1; i<=rPeriod; i++) {
			iAmount=cBalance*monthlyRate;
			cAmount=insValue-iAmount;
			cBalance=cBalance-cAmount;
			//Creating Rows
			System.out.println(i+"\t\t"+ (int)(insValue) +"\t\t"+ (int)(iAmount) +"\t\t"+ (int)(cAmount) +"\t\t"+ (int)(cBalance));
		}
				
	}
	
	public static void main(String[] args) {
		new AccountMain();
	}
}
