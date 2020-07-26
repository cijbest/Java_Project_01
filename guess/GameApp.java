package guess;

import java.util.Random;
import java.util.Scanner;

public class GameApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Guess g = new Guess();
        
        System.out.println("===============================");
        System.out.println("Game Start : s | Quit Game : q");
        System.out.println("===============================");
        while(true) {
            
            System.out.print("Enter the key : ");
            String menuKey = sc.nextLine();
            
            if(menuKey.equals("s") || menuKey.equals("r")) {
				int answer = r.nextInt(100) + 1;
				g.setAnswer(answer);
				//g.count = 0;
                while(true) {
                    System.out.print("Input Number : ");
                    int input = Integer.parseInt(sc.nextLine());
                    
                    if(g.isRange(input)) { // 범위 내에 있을 때
                    	String msg = g.checkNum(input);
						System.out.println(msg);
						if(msg.equals("Correct")) {
							System.out.println(g.count);
							
							System.out.println("===============================");
					        System.out.println("Restart : r | Quit Game : q");
					        System.out.println("===============================");
					        break;
                    	}
                    }
                }
            }else if(menuKey.equals("q")) {
            	System.out.println(g.totalCount);
                sc.close();
                break;    
            }else {
                System.out.println("Please Enter the key again... ");
            }
        }

	}

}
