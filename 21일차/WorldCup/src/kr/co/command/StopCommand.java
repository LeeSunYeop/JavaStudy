package kr.co.command;

import java.util.Scanner;

public class StopCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		return false;
	}

	@Override
	public String toString() {
		
		return "종료";
	}
	
	

}
