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

	// 인출
	public String withdraw(double money) {
		String msg = "";
		if(money <= 0) {
			msg = "음수 입력 잘 하세요..";
			return msg;
		}
		if(balance < money) {
			msg = "잔액 부족 잘 하세요..";
			return msg;
		}
		balance -= money;
		msg = "정상 출금 하였습니다.";
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
	// 입금
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
