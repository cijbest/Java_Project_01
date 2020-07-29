package app;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class Login {

	Frame frame;
	TextField id, pwd;
	Button bt;
	Label label;
	Db<String, User> userDb;

	public Login() {
		makeUi();
		userDb = new UserDb("127.0.0.1", "db", "db");
	}

	public void makeUi() {
		frame = new Frame("LOGIN");
		id = new TextField();
		pwd = new TextField();
		bt = new Button("LOGIN");
		label = new Label();
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		frame.setLayout(new GridLayout(4, 1));
		frame.add(id);frame.add(pwd);frame.add(bt);frame.add(label);
		
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.setLocation(300, 300);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
	
	public void login() {
		String tid = id.getText().trim(); // trim을 사용해서 반드시 공백을 없애준다.
		String tpwd = pwd.getText().trim();
		User dbuser = null;
		try {
			dbuser = userDb.select(tid);
			if(tpwd.equals(dbuser.getPwd())) {
				frame.setVisible(false); // 로그인 성공하면 화면 사라짐
				App app = new App(userDb);
			}else {
				label.setText("Invalid PWD .. !!");

			}
		} catch (Exception e) {
			label.setText("Invalid ID .. !!");
		}
		
	}

	public static void main(String[] args) {
		Login login = new Login();
	}

}
