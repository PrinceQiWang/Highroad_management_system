package UI;
import javax.swing.*;

import Classe.Usager;
import Dao.UserDao;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
	final JFrame jFrame = new JFrame("Systeme de gestion de l'autoroute");
	private Component frame;
	int SaveValueL;
	int SaveValueS;
	String ID=null;
	private UserDao dao =new UserDao();
	
	public void LogIn (String UserID, String UserPW,int UserType) {
	  Usager u=dao.LogIn(UserID);
	 if (UserType==u.getUserType()){
	  		if (UserPW.equals(u.getUserPW())) {
	  			if (UserType == 0){
	  				ID=UserID;
					JOptionPane.showMessageDialog(null, "Connexion succes!","Information", JOptionPane.INFORMATION_MESSAGE);
					new Utilisateur(ID);
					jFrame.dispose();
					}
					else if(UserType == 1){
						ID=UserID;
						JOptionPane.showMessageDialog(null, "Connexion succes!","Information", JOptionPane.INFORMATION_MESSAGE);
						new Documentaliste(ID);
						jFrame.dispose();
					}
					else if(UserType == 2){
						ID=UserID;
						JOptionPane.showMessageDialog(null, "Connexion succes!","Information", JOptionPane.INFORMATION_MESSAGE);
						new Administrateur(ID);
						jFrame.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Erreur de mot de passe!","Information", JOptionPane.ERROR_MESSAGE);
	  			}
	  		else
	  			JOptionPane.showMessageDialog(null, "Erreur de type d'utilisateur!","Information", JOptionPane.ERROR_MESSAGE);
	  		}
	 else
		 JOptionPane.showMessageDialog(null, "Erreur de nom d'utilisateur!","Information", JOptionPane.ERROR_MESSAGE);
	 }
	/*
	public void LogIn (String UserID, String UserPW,String UserType) {
		Connection con;
		java.sql.Statement sql;
		ResultSet rs;
		String RightPassword = null;
		String RightUserType = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ROUTES", "root", "123456");
			sql = con.createStatement();
			rs= sql.executeQuery(" select UserPW,UserType from Usager " + "where UserID = '" + UserID + "'");
			if (rs.next()){
				RightUserType = rs.getString("UserType");
				RightPassword = rs.getString("UserPW");
				if (UserType.equals(RightUserType)){
					if (UserPW.equals(RightPassword)) {
						if (UserType == "0"){
							ID=UserID;
							JOptionPane.showMessageDialog(null, "Connexion succes!","Information", JOptionPane.INFORMATION_MESSAGE);
							new Utilisateur();
							jFrame.dispose();
						}
						else if(UserType == "1"){
							ID=UserID;
							JOptionPane.showMessageDialog(null, "Connexion succes!","Information", JOptionPane.INFORMATION_MESSAGE);
							new Documentaliste();
							jFrame.dispose();
						}
						else if(UserType == "2"){
							ID=UserID;
							JOptionPane.showMessageDialog(null, "Connexion succes!","Information", JOptionPane.INFORMATION_MESSAGE);
							new Administrateur();
							jFrame.dispose();
						}	
					}
					else 
						JOptionPane.showMessageDialog(null, "Erreur de mot de passe!","Information", JOptionPane.ERROR_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(null, "Erreur de type d'utilisateur!","Information", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "Erreur de nom d'utilisateur!","Information", JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	public void SignIn(String UserID, String UserPW,String RUserPW,String UserType) {
		int i=dao.SignIn(UserID, UserPW, RUserPW, UserType);
		if(i==2){
			JOptionPane.showMessageDialog(null, "Le nom d'utilisateur existe dejà!","Information", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if (i==1){
				JOptionPane.showMessageDialog(null, "Enregistrer succes!!","Information", JOptionPane.INFORMATION_MESSAGE);
				}
			else 
				JOptionPane.showMessageDialog(null, "Erreur de confirmation de mot de passe!","Information", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	public void SignIn(String UserID, String UserPW,String RUserPW,String UserType) {
		Connection con;//
		java.sql.Statement sql;
		ResultSet rs_1;
		int rs_2;
		String ID = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ROUTES", "root", "123456");
			sql = con.createStatement();
			rs_1= sql.executeQuery(" select UserID from User " + "where UserID = '" + UserID + "'");
			if(rs_1.next()){
				JOptionPane.showMessageDialog(null, "Le nom d'utilisateur existe dejà!","Information", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if (UserPW.equals(RUserPW)){
					rs_2 = sql.executeUpdate(" insert into User (UserID,UserPW,UserType)  " + "values ( '"+UserID+"','"+UserPW+"','"+UserType+"')");
					//INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
					JOptionPane.showMessageDialog(null, "Enregistrer succes!!","Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(null, "Erreur de confirmation de mot de passe!","Information", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	public Login(){

		jFrame.setSize(800,600);
		jFrame.setResizable(false);//窗体固定大小
		jFrame.setLocationRelativeTo(null);//窗体出现在桌面中央
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     

		//////////////////////////////////////////////////////////////////////

		ImageIcon icon_1=new ImageIcon("images/L01.jpg");//加载图片
		final JLabel jLabel_BackGround_1=new JLabel(icon_1);//将图片放入label
		jLabel_BackGround_1.setBounds(0,0,icon_1.getIconWidth(),icon_1.getIconHeight());//设置label的大小
		jFrame.getLayeredPane().add(jLabel_BackGround_1,new Integer(Integer.MIN_VALUE)); //获取窗口的第二层，并将label放入
		JPanel jPanel_BackGround_1=(JPanel)jFrame.getContentPane(); //获取jFrame的顶层容器
		jPanel_BackGround_1.setOpaque(false);//设置jFrame为透明

		ImageIcon icon_2=new ImageIcon("images/L02.jpg");//加载图片
		final JLabel jLabel_BackGround_2=new JLabel(icon_2);//将图片放入label
		jLabel_BackGround_2.setBounds(0,0,icon_2.getIconWidth(),icon_2.getIconHeight());//设置label的大小
		jFrame.getLayeredPane().add(jLabel_BackGround_2,new Integer(Integer.MIN_VALUE)); //获取窗口的第二层，并将label放入
		JPanel jPanel_BackGround_2=(JPanel)jFrame.getContentPane(); //获取jFrame的顶层容器
		jPanel_BackGround_2.setOpaque(false);//设置jFrame为透明

		//////////////////////////////////////////////////////////////////////

		final JPanel jPanel_a=new JPanel();
		jPanel_a.setLayout(null);

		final JPanel jPanel_b=new JPanel();
		jPanel_b.setLayout(null);

		//////////////////////////////////////////////////////////////////////

		JLabel label_a_1 = new JLabel("Nom d'utilisateur:");
		label_a_1.setBounds(250, 300, 150, 30);
		jPanel_a.add(label_a_1);

		JLabel label_a_2 = new JLabel("Mot de passe:");
		label_a_2.setBounds(250, 340, 150, 30);
		jPanel_a.add(label_a_2);

		final JTextField text_field_a = new JTextField();
		text_field_a.setBounds(375, 300, 190, 30);
		jPanel_a.add(text_field_a);
		text_field_a.addKeyListener (new KeyListener (){//添加事件
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

				} else {
					e.consume(); 
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});


		final JPasswordField password_field_a = new JPasswordField();
		password_field_a.setBounds(375, 340, 190, 30);
		jPanel_a.add(password_field_a);

		final JRadioButton radio_button_a_1 = new JRadioButton("Utili");
		radio_button_a_1.setBounds(285, 380, 90, 30);
		radio_button_a_1.setOpaque(false);//JRadioButton背景色透明
		jPanel_a.add(radio_button_a_1);
		radio_button_a_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JRadioButton radio_button_a_1=(JRadioButton)e.getSource();
				if(radio_button_a_1.isSelected()){
					SaveValueL=0;
				}
			}
		});

		JRadioButton radio_button_a_2 = new JRadioButton("Docum");
		radio_button_a_2.setBounds(365, 380, 90, 30);
		radio_button_a_2.setOpaque(false);//JRadioButton背景色透明
		jPanel_a.add(radio_button_a_2);
		radio_button_a_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JRadioButton radio_button_a_2=(JRadioButton)e.getSource();
				if(radio_button_a_2.isSelected()){
					SaveValueL=1;
				}
			}
		});

		JRadioButton radio_button_a_3 = new JRadioButton("Admin");
		radio_button_a_3.setBounds(445, 380, 90, 30);
		radio_button_a_3.setOpaque(false);//JRadioButton背景色透明
		jPanel_a.add(radio_button_a_3);
		radio_button_a_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JRadioButton radio_button_a_3=(JRadioButton)e.getSource();
				if(radio_button_a_3.isSelected()){
					SaveValueL=2;
				}
			}
		});

		final ButtonGroup bGroup_a = new ButtonGroup();//建立ButtonGroup实现3选1
		bGroup_a.add(radio_button_a_1);
		bGroup_a.add(radio_button_a_2);
		bGroup_a.add(radio_button_a_3);

		JButton button_a_1 = new JButton("Connexion");
		button_a_1.setBounds(265, 420, 100, 30);
		jPanel_a.add(button_a_1);
		button_a_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(text_field_a.getText().trim().length()<1 || password_field_a.getText().trim().length()<1||bGroup_a.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de login", "Erreur", JOptionPane.ERROR_MESSAGE); 
				}
				else{
					LogIn(text_field_a.getText(),password_field_a.getText(),SaveValueL);
				}
			}
		});

		JButton button_a_2 = new JButton("Vider");
		button_a_2.setBounds(365, 420, 100, 30);
		jPanel_a.add(button_a_2);
		button_a_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text_field_a.setText("");
				password_field_a.setText("");	
				bGroup_a.clearSelection();//重置ButtonGroup
			}
		});

		JButton button_a_3 = new JButton("enregistrer");
		button_a_3.setBounds(465, 420, 100, 30);
		jPanel_a.add(button_a_3);
		button_a_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jPanel_a.setVisible(false);
				jFrame.add(jPanel_b);
				jPanel_b.setVisible(true);

				//↓切换页面自动重置输入框内容
				text_field_a.setText("");
				password_field_a.setText("");	
				bGroup_a.clearSelection();//重置ButtonGroup

				//↓切换页面背景图片
				jLabel_BackGround_1.setVisible(false);
				jLabel_BackGround_2.setVisible(true);

			}

		});

		jPanel_a.setVisible(true);
		jPanel_a.setOpaque(false);

		//////////////////////////////////////////////////////////////////////

		JLabel label_b_1 = new JLabel("Type d'utilisateur:");
		label_b_1.setBounds(265, 180, 150, 30);
		jPanel_b.add(label_b_1);

		JLabel label_b_2 = new JLabel("Nom d'utilisateur:");
		label_b_2.setBounds(265, 220, 150, 30);
		jPanel_b.add(label_b_2);

		JLabel label_b_3 = new JLabel("mot de passe:");
		label_b_3.setBounds(265, 260, 150, 30);
		jPanel_b.add(label_b_3);

		JLabel label_b_4 = new JLabel("Confirmation:");
		label_b_4.setBounds(265, 300, 150, 30);
		jPanel_b.add(label_b_4);

		JRadioButton radio_button_b_1 = new JRadioButton("Utili");
		radio_button_b_1.setBounds(380, 180, 80, 30);
		radio_button_b_1.setOpaque(false);//JRadioButton背景色透明
		jPanel_b.add(radio_button_b_1);
		radio_button_b_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JRadioButton radio_button_b_1=(JRadioButton)e.getSource();
				if(radio_button_b_1.isSelected()){
					SaveValueS=0;
				}
			}
		});

		JRadioButton radio_button_b_2 = new JRadioButton("Docum");
		radio_button_b_2.setBounds(455, 180, 80, 30);
		jPanel_b.add(radio_button_b_2);
		radio_button_b_2.setOpaque(false);//JRadioButton背景色透明
		radio_button_b_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JRadioButton radio_button_b_2=(JRadioButton)e.getSource();
				if(radio_button_b_2.isSelected()){
					SaveValueS=1;
				}
			}
		});

		final ButtonGroup bGroup_b = new ButtonGroup();
		bGroup_b.add(radio_button_b_1);
		bGroup_b.add(radio_button_b_2);

		final JTextField text_field_b = new JTextField();
		text_field_b.setBounds(380, 220, 150, 30);
		jPanel_b.add(text_field_b);
		text_field_b.addKeyListener (new KeyListener (){//添加事件
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

				} else {
					e.consume(); 
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

		final JPasswordField password_field_b_1 = new JPasswordField();
		password_field_b_1.setBounds(380, 260, 150, 30);
		jPanel_b.add(password_field_b_1);

		final JPasswordField password_field_b_2 = new JPasswordField();
		password_field_b_2.setBounds(380, 300, 150, 30);
		jPanel_b.add(password_field_b_2);

		JButton button_b_1 = new JButton("Valider");
		button_b_1.setBounds(245, 340, 100, 30);
		jPanel_b.add(button_b_1);
		button_b_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(text_field_b.getText().trim().length()<1 || password_field_b_1.getText().trim().length()<1 || password_field_b_2.getText().trim().length()<1||bGroup_b.isSelected(null))
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible d'enregistrer", "Erreur", JOptionPane.ERROR_MESSAGE); 
				else{
					//SignIn(text_field_b.getText(),password_field_b_1.getText(),password_field_b_2.getText(),SaveValueS);
					//bGroup_b.clearSelection();//重置ButtonGroup
					//text_field_b.setText("");
					password_field_b_1.setText("");	
					password_field_b_2.setText("");
				}
			}
		});

		JButton button_b_2 = new JButton("Vider");
		button_b_2.setBounds(345, 340, 100, 30);
		jPanel_b.add(button_b_2);
		button_b_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bGroup_b.clearSelection();//重置ButtonGroup
				text_field_b.setText("");
				password_field_b_1.setText("");	
				password_field_b_2.setText("");
			}
		});

		JButton button_b_3 = new JButton("retourner");
		button_b_3.setBounds(445, 340, 100, 30);
		jPanel_b.add(button_b_3);
		button_b_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jPanel_b.setVisible(false);
				jFrame.add(jPanel_a);
				jPanel_a.setVisible(true);

				//↓切换页面自动重置输入框内容
				bGroup_b.clearSelection();//重置ButtonGroup
				text_field_b.setText("");
				password_field_b_1.setText("");	
				password_field_b_2.setText("");

				//↓切换页面背景图片
				jLabel_BackGround_2.setVisible(false);
				jLabel_BackGround_1.setVisible(true);
			}
		});

		jPanel_b.setVisible(true);
		jPanel_b.setOpaque(false);

		//////////////////////////////////////////////////////////////////////

		//jFrame.add(jPanel_b);//后出现的JPanel覆盖上一个，此句可省略
		jFrame.add(jPanel_a);
		jFrame.setVisible(true);

	}

	public static void main(String[] args){
		new Login();
	}

}