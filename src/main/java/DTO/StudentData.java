package DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentData {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)//to auto generate roll number
int Roll_Nom;
String Name;
int Std;
long Ph_No;
String Address;
int fee=35000;
int balance=fee;

public int getRoll_Nom() {
	return Roll_Nom;
}
public void setRoll_Nom(int roll_Nom) {
	Roll_Nom = roll_Nom;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getStd() {
	return Std;
}
public void setStd(int std) {
	Std = std;
}



public long getPh_No() {
	return Ph_No;
}
public void setPh_No(long ph_No) {
	Ph_No = ph_No;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}

}
