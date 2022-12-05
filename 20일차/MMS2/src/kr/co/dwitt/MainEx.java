package kr.co.dwitt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.co.command.Command;
import kr.co.command.DeleteCommand;
import kr.co.command.InsertCommand;
import kr.co.command.SelectByldCommand;
import kr.co.command.SelectCommand;
import kr.co.command.StopCommand;
import kr.co.command.UpdateCommand;

public class MainEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Command[] menus = {new InsertCommand(), new SelectCommand(), new SelectByldCommand(),
//				 new UpdateCommand(), new DeleteCommand(), new StopCommand()};
		
		List<Command> list = new ArrayList<Command>(); // list로 해서 만드는게 좋다
		list.add(new InsertCommand());
		list.add(new SelectCommand());
		list.add(new SelectByldCommand());
		list.add(new UpdateCommand());
		list.add(new DeleteCommand());
		list.add(new StopCommand());
				
		Command menu = null;
		
		boolean isTrue = true;
		
		while (isTrue) {
			System.out.println("메뉴를 선택하세요.");
			for(int i=0; i<list.size(); i++) {
				System.out.print(i);
				System.out.print(": ");
				System.out.print(list.get(i));
				System.out.print(", ");
				
			}
			
			System.out.println();
			
			int idx = sc.nextInt();
			sc.nextLine();
			
			menu = list.get(idx);
			isTrue = menu.execute(sc);
		}
				
		sc.close();

	}

}
