package account;

public class Account {
	String accNo;
	double balance;
	double rate;

	public Account() {
	}

	public Account(String accNo, double balance, double rate) {
		this.accNo = accNo;
		this.balance = balance;
		this.rate = rate;
	}

	// ����
	public String withdraw(double money) {
		String msg = "";
		if(money <= 0) {
			msg = "���� �Է� �� �ϼ���..";
			return msg;
		}
		if(balance < money) {
			msg = "�ܾ� ���� �� �ϼ���..";
			return msg;
		}
		balance -= money;
		msg = "���� ��� �Ͽ����ϴ�.";
		return msg;
	}
//	public void withdraw(double money) {
//		if(money <= 0) {
//			return;
//		}
//		if(balance < money) {
//			return;
//		}
//		balance -= money;
//	}
	// �Ա�
	public void deposit(double money) {
		if(money <= 0) {
			return;
		}
		balance += money;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + ", rate=" + rate + "]";
	}
	
}
