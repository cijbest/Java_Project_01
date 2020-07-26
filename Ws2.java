package str;

/*
1. ���α׷� �䱸����
-Lotto ��ȣ ���� ���� (1���� 45������ ��, 6��)
-�� ��� ���� ���� (1~100��)
-����� ��÷�� �ȳ�
-�޴� ���� (1. ���ӽ���, 2. ����)
-��÷�� ��� ��Ģ(����, 1��:80%, 2��:15%, 3��:4%, 4��:0.9%, 5��:0.1%)
-������� lotto ��ȣ �Է�
-��ȣ�� ��÷ ���� Ȯ�� (�ڸ��� ������� 1�� 6��, 2�� 5��, 3�� 4��, 4�� 3��, 5�� 2�� ��ġ)
-������� ��ȣ�� ���� ��� �ȳ� �� ��÷�� ����
-��÷�� ���α׷� ����
-�� ��÷ �� ��ȣ �� �Է� �Ǵ� ���� ����
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ws {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
      String s = "";

      int totalamount = r.nextInt(1000000000) + 80000000; // 1 ~ 1.8 billion
      // 1st : 50%, 2st: 30%, 3st: 10%, 4st: 8%, 5st: 2%
      System.out.println("-------------------Program Start-------------------");
      System.out.printf("1st prize amount is %.0f \n", totalamount * 0.5); // �Ҽ��� �ڸ� ����
      System.out.printf("2st prize amount is %.0f \n", totalamount * 0.3);// �Ҽ��� �ڸ� ����
      System.out.printf("3st prize amount is %.0f \n", totalamount * 0.1);// �Ҽ��� �ڸ� ����
      System.out.printf("4st prize amount is %.0f \n", totalamount * 0.08);// �Ҽ��� �ڸ� ����
      System.out.printf("5st prize amount is %.0f \n", totalamount * 0.02);// �Ҽ��� �ڸ� ����
      
      System.out.println("Input Menu: C(Check My Number), Q(Quit)");

      while (true) { // Program Start
         // LOTTO ���� ����(����)
         int lotto[] = new int[6];
         for (int i = 0; i < 6; i++) {
            lotto[i] = r.nextInt(45) + 1;
            if(i != 0) {
               for(int j = 0; j < i; j++) {
                  if(lotto[i] == lotto[j]) {
                     i--; // ������ ���ܼ� �ٽ� �Է¹��� (i-- -> i++ ó���� �� ����)
                     break;
                  }
               }
            }
         }

         // �޴� ����
         s = sc.nextLine();

         if (s.equals("Q") || s.equals("q")) { // Quit Menu Selected -> Program Quit
            break;
         } else if (s.equals("C") || s.equals("c") || s.equals("R") || s.equals("r")) { // Check Menu Selected
        	 
            // ����� ��ȣ �Է�
        	int user[] = new int[6];
        	out:
        	while (true) {
				// ����� ��ȣ �Է�
				System.out.println("1 ~ 45 ������ ���� 6���� �Է��� �ּ���.");
				for (int i = 0; i < 6; i++) {
					user[i] = sc.nextInt();
				}
				sc.nextLine(); // ���๮�� ���� (nextInt ��� �� ���๮�ڰ� ���� �������� ���� ����)
				
				// ����ڰ� �Է��� ��ȣ �˼�
				for (int i = 0; i < 6; i++) {
					if (user[i] < 1 || user[i] > 45) {
						System.out.println("1 ~ 45 ������ ���ڸ� �Է��� �ּ���!");
						break;
					}
					if(i == 5) {
						break out;
					}
				}
			}
        	
            // LOTTO ���ڿ� ����� ���� ��
            int count = 0;
            for (int i = 0; i < 6; i++) {
               for (int j = 0; j < 6; j++) {
                  if (lotto[i] == user[i]) { // �´� ���ڰ� ���� ��
                     count += 1;
                     break;
                  }
               }
            }
            System.out.println("count : " + count);

            // ��� Ȯ��
            if(count > 1) { // ��÷�� �����ڿ��Ը� ��ȣ �˸� ǥ��
               System.out.print("������ Lotto��ȣ : ");
               for (int i = 0; i < 6; i++) {
                  System.out.print(lotto[i] + " ");
               }
               System.out.println();
               System.out.print("���� Lotto��ȣ : ");
               for (int i = 0; i < 6; i++) {
                  System.out.print(user[i] + " ");
               }
               System.out.println();
            }
            if (count == 6) { // 1��
               System.out.println("�����մϴ�! 1� ��÷�Ǽ̽��ϴ�!");
               System.out.printf("��÷���� %.0f�� �Դϴ�!!\n", totalamount * 0.5);
               break;
            } else if (count == 5) { // 2��
               System.out.println("�����մϴ�! 2� ��÷�Ǽ̽��ϴ�!");
               System.out.printf("��÷���� %.0f�� �Դϴ�!!\n", totalamount * 0.3);
               break;
            } else if (count == 4) { // 3��
               System.out.println("�����մϴ�! 3� ��÷�Ǽ̽��ϴ�!");
               System.out.printf("��÷���� %.0f�� �Դϴ�!!\n", totalamount * 0.1);
               break;
            } else if (count == 3) { // 4��
               System.out.println("�����մϴ�! 4� ��÷�Ǽ̽��ϴ�!");
               System.out.printf("��÷���� %.0f�� �Դϴ�!!\n", totalamount * 0.08);
               break;
            } else if (count == 2) { // 5��
               System.out.println("�����մϴ�! 5� ��÷�Ǽ̽��ϴ�!");
               System.out.printf("��÷���� %.0f�� �Դϴ�!!\n", totalamount * 0.02);
               break;
            } else { // ��
               System.out.println("�ƽ����� ���Դϴ٤Ф�");
               System.out.println("�ٽ� �����Ͻðھ��?");
               System.out.println("Input Menu: R(Retry Check My Number), Q(Quit)");
            }


         } else {
            System.out.println("Invalid Menu Selected"); // Invalid Menu Selected(Error)
         }
      }
      sc.close();
      System.out.println("---------Program completely Turned Off---------");

   }

}