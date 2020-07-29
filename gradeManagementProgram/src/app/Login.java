package app;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

import com.biz.StudentDb;
import com.biz.InstructorDb;
import com.frame.Db;
import com.vo.Instructor;
import com.vo.Student;

public class Login {

	Frame frame;
	Panel p1;
	TextField id, pwd;
	Button bt;
	Label label;
	Db<String, Student> studentDb;
	Db<String, Instructor> instructorDb;
	JCheckBox cb1, cb2;
	ButtonGroup bg = new ButtonGroup();
	String a = "";

	public Login() {
		makeUi();
		studentDb = new StudentDb("192.168.0.11", "db", "db");
		instructorDb = new InstructorDb("192.168.0.11", "db", "db");
	}

	public void makeUi() {
		p1 = new Panel();
		frame = new Frame("LOGIN");
		id = new TextField();
		pwd = new TextField();
		bt = new Button("LOGIN");
		label = new Label();
		cb1 = new JCheckBox("STUDENT");
		cb2 = new JCheckBox("INSTRUCTOR");

		bg.add(cb1);
		bg.add(cb2);
		p1.add(cb1);
		p1.add(cb2);

		cb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					a = "STUDENT";
				}
			}
		});

		cb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					a = "INSTRUCTOR";
				}
			}
		});

		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		frame.setLayout(new GridLayout(5, 1));
		frame.add(id);
		frame.add(pwd);
		frame.add(p1);
		frame.add(bt);
		frame.add(label);

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
		String tid = id.getText().trim();
		String tpwd = pwd.getText().trim();
		Student dbstudent = null;
		Instructor dbinstructor = null;
		
		// 로그인 시 체크박스로 사용자 판별 - Student 또는 Instructor
		if (a.equals("STUDENT")) {
			try {
				dbstudent = studentDb.select(tid);
				if (tpwd.equals(dbstudent.getPwd())) {
					frame.setVisible(false);
					SApp app = new SApp(studentDb, dbstudent.getId());
				} else {
					label.setText("Invalid PWD .. !!");
				}
			} catch (Exception e) {
				label.setText("Invalid ID .. !!");
			}
		} else if (a.equals("INSTRUCTOR")) {
			try {
				dbinstructor = instructorDb.select(tid);
				System.out.println(dbinstructor);
				System.out.println(dbinstructor);
				if (tpwd.equals(dbinstructor.getPwd())) {
					frame.setVisible(false);
					IApp app = new IApp(studentDb);
				} else {
					label.setText("Invalid PWD .. !!");
				}

			} catch (Exception e) {
				label.setText("Invalid ID .. !!");
			}
		}
	}

	public static void main(String[] args) {
		Login login = new Login();
	}

}