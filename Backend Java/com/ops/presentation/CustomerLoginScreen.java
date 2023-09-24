package com.ops.presentation;

import java.util.Scanner;

public class CustomerLoginScreen {
	public int getInputCustomerId() {
		System.out.print("Enter Customer ID: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public String getInputPassword() {
		System.out.print("Enter Password: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
