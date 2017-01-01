package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.*;

import controller.LoginDAO;
import model.LocalizedButton;
import model.LocalizedFrame;
import model.LocalizedLabel;
import model.Login;
import model.Personeel;
import model.Settings;
import model.Strings;

public class LoginView {
	private JFrame parentJf;
	public LoginView(JFrame pjf) {
		parentJf = pjf;
		if (parentJf != null)
			parentJf.disable();
		LocalizedFrame jf = new LocalizedFrame(Strings.loginFrame);
		jf.setPreferredSize(new Dimension(300,150));

		jf.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                        if (parentJf != null)
                        	parentJf.enable();
                }
            });
		jf.setLayout(new GridLayout(3,1));
		JPanel jp_username = new JPanel();
		jp_username.add(new LocalizedLabel(Strings.loginUsername));
		JTextField jt_username = new JTextField();
		jt_username.setPreferredSize(new Dimension(100,20));
		jp_username.add(jt_username);
		jf.add(jp_username);
		
		JPanel jp_password = new JPanel();
		jp_password.add(new LocalizedLabel(Strings.loginPasword));
		JTextField jt_password = new JPasswordField();
		jt_password.setPreferredSize(new Dimension(100,20));
		jp_password.add(jt_password);
		jf.add(jp_password);
		
		JPanel jp_knoppen = new JPanel();
		JButton jb_login = new LocalizedButton(Strings.buttonLogin);
		jb_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDAO ldao = new LoginDAO();
				try {
					Login login = ldao.getLogin(jt_username.getText(),Login.Sha512(jt_password.getText()));
					if (login.getUsername() != null) {
						System.out.println("Ingelogd als " + login.getUsername() + "!");
						Settings.getInstance().setIngelogdPersoneelslid(new Personeel());
						if (parentJf != null) {
							parentJf.enable();
						}
						jf.dispose();	
					}
					else {
						System.out.println("Inloggen mislukt!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton jb_cancel = new LocalizedButton(Strings.buttonCancel);
		jb_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (parentJf != null) {
					parentJf.enable();
				}
				jf.dispose();	
			}
		});
		//jb_login.setLayout(new FlowLayout());
		jp_knoppen.add(jb_login);
		jp_knoppen.add(jb_cancel);
		jf.add(jp_knoppen);
		
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	public LoginView() {
		this(null);
	}
}
