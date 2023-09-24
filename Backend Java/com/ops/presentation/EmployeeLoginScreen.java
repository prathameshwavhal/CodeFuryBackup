package com.ops.presentation;

import java.util.Scanner;

public class EmployeeLoginScreen {

	public String getInputEmployeeId() {
		System.out.print("Enter Employee ID: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public String getInputPassword() {
		System.out.print("Enter Password: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
