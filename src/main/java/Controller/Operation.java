package Controller;

import java.util.Scanner;

import DAO.Connection;
import DTO.StudentData;

public class Operation {
	public static void main(String[] args) {
		System.out.println("1.Display details ");
		System.out.println("2.New Admission");
		System.out.println("3.Pay fee");
		System.out.println("4.Edit Student Profile");
		System.out.println("5.Close Student profile");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		Connection connection = new Connection();

		switch (option) {
		case 1: {
			System.out.println("Enter the roll number of the student");
			int roll_num = scanner.nextInt();
			StudentData fetchstudentData = connection.find(roll_num);
			System.out.println("Roll Number: " + fetchstudentData.getRoll_Nom());
			System.out.println("\t" + "Name: " + fetchstudentData.getName());
			System.out.println("\t" + "Mobile number: " + fetchstudentData.getPh_No());
			System.out.println("\t" + "Standard: " + fetchstudentData.getStd() + " std");
			System.out.println("\t" + "Fee : " + fetchstudentData.getBalance() + "/-");
			System.out.println("\t" + "Fee Balance: " + fetchstudentData.getBalance() + "/-");
			break;
		}
		case 2: {
			StudentData newStudent = new StudentData();
			System.out.println("Enter the Student full Name");
			newStudent.setName(scanner.next());
			System.out.println("Enter the Standard");
			newStudent.setStd(scanner.nextInt());
			System.out.println("Enter the parents mobile number");
			newStudent.setPh_No(scanner.nextLong());
			System.out.println("Enter the permenent address ");
			newStudent.setAddress(scanner.next());
			connection.insert(newStudent);

			System.out.println("Student Data uploded sucessfully");
			break;
		}
		case 3: {
			System.out.println("enter the roll number of the student");
			int roll_num = scanner.nextInt();
			StudentData fetchstudentData = connection.find(roll_num);
			System.out.println("Name: " + fetchstudentData.getName());
			System.out.println("Balanceto be paid: " + fetchstudentData.getBalance() + "/-");
			System.out.println("Enter the amount paid: ");
			int pay = scanner.nextInt();
			pay = fetchstudentData.getBalance() - pay;
			fetchstudentData.setBalance(pay);
			connection.pay(fetchstudentData);
			System.out.println("fee paid sucessfully");
			System.out.println("balance:" + fetchstudentData.getBalance() + "/-");
			break;
		}
		case 4: {
			System.out.println("enter the roll number of the student");
			int roll_num = scanner.nextInt();
			StudentData updatestudentData = connection.find(roll_num);
			System.out.println("Roll Number: " + updatestudentData.getRoll_Nom());
			System.out.println("\t" + "1.Name: " + updatestudentData.getName());
			System.out.println("\t" + "2.Mobile number: " + updatestudentData.getPh_No());
			System.out.println("\t" + "3.Standard" + updatestudentData.getStd() + "th Class");
			System.out.println("select the option which has to be changed");
			int key = scanner.nextInt();
			switch (key) {
			case 1: {
				System.out.println("Enter the name to be changed: ");
				updatestudentData.setName(scanner.next());
				connection.update(updatestudentData);
				System.out.println("data updated sucessfully");
				break;
			}
			case 2: {
				System.out.println("enter the mobile number: ");
				updatestudentData.setPh_No(scanner.nextLong());
				connection.update(updatestudentData);

				System.out.println("data updated sucessfully");
				break;
			}
			case 3: {
				System.out.println("enter the standard: ");
				updatestudentData.setStd(scanner.nextInt());
				connection.update(updatestudentData);
				System.out.println("data updated sucessfully");
			}
			default: {
				System.out.println("invalid data");
				break;
			}

			}
		}
		case 5: {
			System.out.println("Enter the roll number of the student");
			int roll_num = scanner.nextInt();

			StudentData deleteStudentData = connection.find(roll_num);
			if (deleteStudentData != null) {
				connection.deleteStudentData(deleteStudentData);
				System.out.println("Student data deleted sucessuflly");
			} else
				System.out.println("student data doesn't exist");
			break;
		}
		default: {
			System.out.println("Please enter the correct option !");
			break;

		}

		}
	}
}
