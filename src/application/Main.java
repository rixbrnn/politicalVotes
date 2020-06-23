package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import util.Election;
import util.IU.ElectionIU;

public class Main {
	public static void main(String[]args) {
		Election election = new Election();
		ElectionIU IU = new ElectionIU(election);
		Scanner sc = new Scanner(System.in);
		int option = -1;
		
		do {
			System.out.println("OPTIONS");
			System.out.println("[1] Add candidate");
			System.out.println("[2] Remove candidate");
			System.out.println("[3] Show list of candidates");
			System.out.println("[4] Sort list");
			System.out.println("[5] See statistics");
			System.out.println("[6] Turn off");
			
			try {
				option = Integer.parseInt(sc.nextLine());
				if(option<1 || option>6)
					throw new InputMismatchException();
			}catch(InputMismatchException | NumberFormatException e2) {
				System.out.println("INVALID OPTION!");
				System.out.println("Select a valid option");
				System.out.println("---------------------");
			}
			
			if(option==1)
				IU.addCandidate();
			if(option==2)
				IU.removeCandidate();
			if(option==3)
				IU.showCandidates();
			if(option==4)
				IU.sortList();
			if(option==5)
				IU.showStats();
					
		}while(option!=6);
		
		System.out.println("Finishing program...");
		sc.close();	
	}
}
