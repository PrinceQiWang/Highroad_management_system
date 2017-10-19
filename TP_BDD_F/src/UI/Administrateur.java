package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Classe.Usager;
import Dao.UserDao;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Administrateur extends JFrame {
private String ID;
	public void Obtenir(DefaultTableModel defaultTableModel_usager,int i){
		UserDao user=new UserDao();
		ArrayList<Usager> list=user.ListUsager(i);

		for(Usager u:list){
			String[] str={u.getUserID(),u.getUserPW()};
			defaultTableModel_usager.addRow(str);
		}
	}
	public Administrateur(String IDA) {
		UserDao user=new UserDao();
		JTextField jTextField_usager_1 = new JTextField();
		JTextField jTextField_usager_2 = new JTextField();
		JTextField jTextField_documentaliste_1 = new JTextField();
		JTextField jTextField_documentaliste_2 = new JTextField();
		
		JPasswordField password_field_securite_1 = new JPasswordField();
		JPasswordField password_field_securite_2 = new JPasswordField();
		JPasswordField password_field_securite_3 = new JPasswordField();

		final JFrame jFrame = new JFrame("Systeme de gestion de l'autoroute");
		jFrame.setSize(800, 600);
		jFrame.setResizable(false);// 窗体固定大小
		jFrame.setLocationRelativeTo(null);// 窗体出现在桌面中央
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		//////////////////////////////////////////////////////////////////////

		ImageIcon icon_1 = new ImageIcon("images/B00.jpg");// 加载图片
		final JLabel jLabel_BackGround_1 = new JLabel(icon_1);// 将图片放入label
		jLabel_BackGround_1.setBounds(0, 0, icon_1.getIconWidth(), icon_1.getIconHeight());// 设置label的大小
		jFrame.getLayeredPane().add(jLabel_BackGround_1, new Integer(Integer.MIN_VALUE)); // 获取窗口的第二层，并将label放入
		JPanel jPanel_BackGround_1 = (JPanel) jFrame.getContentPane(); // 获取jFrame的顶层容器
		jPanel_BackGround_1.setOpaque(false);// 设置jFrame为透明
		//////////////////////////////////////////////////////////////////////

		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent e) {
				JTabbedPane jTabbedPane = (JTabbedPane) e.getSource();
				int selectedIndex = jTabbedPane.getSelectedIndex();
				switch (selectedIndex) {
				case 0: 
					break;
				case 1: {
					 jTextField_usager_1.setText("");
					 jTextField_usager_2.setText("");
				}
					break;
				case 2: {
					 jTextField_documentaliste_1.setText("");
					 jTextField_documentaliste_2.setText("");
				}
					break;
				case 3: {
					password_field_securite_1.setText("");
					password_field_securite_2.setText("");
					password_field_securite_3.setText("");
				}
					break;
				}
			}
		});
		jFrame.add(jTabbedPane);

		//////////////////////////////////////////////////////////////////////
		// 第一个标签下的JPanel
		JPanel jPanel_bienvenue = new JPanel();
		jPanel_bienvenue.setLayout(null);
		jTabbedPane.addTab("Accueil", null, jPanel_bienvenue, null);// 加入第一个页面

		// 第二个标签下的JPanel
		JPanel jPanel_usager = new JPanel();
		jPanel_usager.setLayout(null);
		jTabbedPane.addTab("Usager", null, jPanel_usager, null);// 加入第一个页面

		// 第三个标签下的JPanel
		JPanel jPanel_documentaliste = new JPanel();
		jPanel_documentaliste.setLayout(null);
		jTabbedPane.addTab("Documentaliste", null, jPanel_documentaliste, null);// 加入第一个页面

		// 第四个标签下的JPanel
		final JPanel jPanel_securite = new JPanel();
		jPanel_securite.setLayout(null);
		jTabbedPane.addTab("Securite", null, jPanel_securite, null);// 加入第一个页面

		//////////////////////////////////////////////////////////////////////
		// 111111111111111111111111111111111111111111111111111111111111111111//
		//////////////////////////////////////////////////////////////////////

		JButton button_bienvenue_1 = new JButton("Deconnexion");// 用户登出
		button_bienvenue_1.setBounds(330, 400, 140, 30);
		jPanel_bienvenue.add(button_bienvenue_1);
		button_bienvenue_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
				new Login();
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 111111111111111111111111111111111111111111111111111111111111111111//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 222222222222222222222222222222222222222222222222222222222222222222//
		//////////////////////////////////////////////////////////////////////

		JLabel Label_usager_1 = new JLabel("Nom d'utilisateur:");
		Label_usager_1.setBounds(270, 360, 150, 30);
		jPanel_usager.add(Label_usager_1);

		JLabel Label_usager_2 = new JLabel("Mot de passe:");
		Label_usager_2.setBounds(270, 395, 150, 30);
		jPanel_usager.add(Label_usager_2);

		jTextField_usager_1.setBounds(400, 360, 150, 30);
		jPanel_usager.add(jTextField_usager_1);
		jTextField_usager_1.addKeyListener(new KeyListener() {// 添加事件
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

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

		jTextField_usager_2.setBounds(400, 395, 150, 30);
		jPanel_usager.add(jTextField_usager_2);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_usager = { "Nom d'utilisateur", "Mot de passe" };// 表格列名
		String[][] tableVales_usager = {};// 数据
		DefaultTableModel defaultTableModel_usager = new DefaultTableModel(tableVales_usager, columnNames_usager);
		Obtenir(defaultTableModel_usager,0);//==========================================
		JTable jTable_usager = new JTable(defaultTableModel_usager);
		jTable_usager.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_usager.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow_usager = jTable_usager.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_usager.getValueAt(selectedRow_usager, 0);
				Object object_b = defaultTableModel_usager.getValueAt(selectedRow_usager, 1);

				jTextField_usager_1.setText(object_a.toString());// 给文本框赋值
				jTextField_usager_2.setText(object_b.toString());
				ID=object_a.toString();
			}
		});

		JScrollPane scrollPane_usager = new JScrollPane(jTable_usager);// 添加滚动条
		getContentPane().add(scrollPane_usager, BorderLayout.CENTER);
		scrollPane_usager.setBounds(200, 50, 400, 300);
		scrollPane_usager.setOpaque(false);
		jPanel_usager.add(scrollPane_usager);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_usager = new JButton("Ajouter");// 按钮"添加"
		addButton_usager.setBounds(265, 430, 90, 30);
		jPanel_usager.add(addButton_usager);
		addButton_usager.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_usager_1.getText().trim().length() < 1 && jTextField_usager_2.getText().trim().length() > 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else if (jTextField_usager_1.getText().trim().length() > 1
						&& jTextField_usager_2.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else if (jTextField_usager_1.getText().trim().length() < 1
						&& jTextField_usager_2.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int f=user.AddUsager(jTextField_usager_1.getText(), jTextField_usager_2.getText(),0);
					if(f==1){
						String[] rowValues = { jTextField_usager_1.getText(), jTextField_usager_2.getText() };
						defaultTableModel_usager.addRow(rowValues); // 添加一行
						jTextField_usager_1.setText("");
						jTextField_usager_2.setText("");
					}
					else if(f==2){
						JOptionPane.showMessageDialog(null, "Des informations deja exist, impossible de ajouter", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}
					else if(f==3){
						JOptionPane.showMessageDialog(null, "Impossible de ajouter", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		final JButton updateButton_usager = new JButton("Modifier");// 按钮"修改"
		updateButton_usager.setBounds(365, 430, 90, 30);
		jPanel_usager.add(updateButton_usager);
		updateButton_usager.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_usager.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_usager_1.getText().trim().length() < 1 && jTextField_usager_2.getText().trim().length() > 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else if (jTextField_usager_1.getText().trim().length() > 1
							&& jTextField_usager_2.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else if (jTextField_usager_1.getText().trim().length() < 1
							&& jTextField_usager_2.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						user.UpdateUsager(jTextField_usager_1.getText(),jTextField_usager_2.getText(),ID);
						defaultTableModel_usager.setValueAt(jTextField_usager_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						defaultTableModel_usager.setValueAt(jTextField_usager_2.getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值
						jTextField_usager_1.setText("");
						jTextField_usager_2.setText("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_usager = new JButton("Supprimer");// 按钮"删除"
		delButton_usager.setBounds(465, 430, 90, 30);
		jPanel_usager.add(delButton_usager);
		delButton_usager.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_usager.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					user.DeleteUsager(jTextField_usager_1.getText());
					defaultTableModel_usager.removeRow(selectedRow);// 删除选中行
					jTextField_usager_1.setText("");
					jTextField_usager_2.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 222222222222222222222222222222222222222222222222222222222222222222//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 333333333333333333333333333333333333333333333333333333333333333333//
		//////////////////////////////////////////////////////////////////////

		JLabel jLabel_documentaliste_1 = new JLabel("Nom d'utilisateur:");
		jLabel_documentaliste_1.setBounds(270, 360, 150, 30);
		jPanel_documentaliste.add(jLabel_documentaliste_1);

		JLabel Label_documentaliste_2 = new JLabel("Mot de passe:");
		Label_documentaliste_2.setBounds(270, 395, 150, 30);
		jPanel_documentaliste.add(Label_documentaliste_2);

		jTextField_documentaliste_1.setBounds(400, 360, 150, 30);
		jPanel_documentaliste.add(jTextField_documentaliste_1);
		jTextField_documentaliste_1.addKeyListener(new KeyListener() {// 添加事件
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

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

		jTextField_documentaliste_2.setBounds(400, 395, 150, 30);
		jPanel_documentaliste.add(jTextField_documentaliste_2);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_documentaliste = { "Nom d'utilisateur", "Mot de passe" };// 表格列名
		String[][] tableVales_documentaliste = {};// 数据

		DefaultTableModel defaultTableModel_documentaliste = new DefaultTableModel(tableVales_documentaliste, columnNames_documentaliste);
		Obtenir(defaultTableModel_documentaliste,1);
		JTable jTable_documentaliste = new JTable(defaultTableModel_documentaliste);
		jTable_documentaliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_documentaliste.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_documentaliste.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_documentaliste.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_documentaliste.getValueAt(selectedRow, 1);
				jTextField_documentaliste_1.setText(object_a.toString());// 给文本框赋值
				jTextField_documentaliste_2.setText(object_b.toString());
				ID.toString();
			}
		});

		JScrollPane scrollPane_documentaliste = new JScrollPane(jTable_documentaliste);// 添加滚动条
		getContentPane().add(scrollPane_documentaliste, BorderLayout.CENTER);
		scrollPane_documentaliste.setBounds(200, 50, 400, 300);
		scrollPane_documentaliste.setOpaque(false);
		jPanel_documentaliste.add(scrollPane_documentaliste);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_documentaliste = new JButton("Ajouter");// 按钮"添加"
		addButton_documentaliste.setBounds(265, 430, 90, 30);
		jPanel_documentaliste.add(addButton_documentaliste);
		addButton_documentaliste.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_documentaliste_1.getText().trim().length() < 1 && jTextField_documentaliste_2.getText().trim().length() > 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else if (jTextField_documentaliste_1.getText().trim().length() > 1
						&& jTextField_documentaliste_2.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else if (jTextField_documentaliste_1.getText().trim().length() < 1
						&& jTextField_documentaliste_2.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int f=user.AddUsager(jTextField_documentaliste_1.getText(), jTextField_documentaliste_2.getText(),0);
					if(f==1){
						String[] rowValues = { jTextField_documentaliste_1.getText(), jTextField_documentaliste_2.getText() };
						defaultTableModel_documentaliste.addRow(rowValues); // 添加一行
						jTextField_documentaliste_1.setText("");
						jTextField_documentaliste_2.setText("");
					}
					else if(f==2){
						JOptionPane.showMessageDialog(null, "Des informations deja exist, impossible de ajouter", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}
					else if(f==3){
						JOptionPane.showMessageDialog(null, "Impossible de ajouter", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		final JButton updateButton_documentaliste = new JButton("Modifier");// 按钮"修改"
		updateButton_documentaliste.setBounds(365, 430, 90, 30);
		jPanel_documentaliste.add(updateButton_documentaliste);
		updateButton_documentaliste.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_documentaliste.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_documentaliste_1.getText().trim().length() < 1 && jTextField_documentaliste_2.getText().trim().length() > 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else if (jTextField_documentaliste_1.getText().trim().length() > 1
							&& jTextField_documentaliste_2.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else if (jTextField_documentaliste_1.getText().trim().length() < 1
							&& jTextField_documentaliste_2.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						user.UpdateUsager(jTextField_documentaliste_1.getText(), jTextField_documentaliste_2.getText(),ID);
						defaultTableModel_documentaliste.setValueAt(jTextField_documentaliste_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						defaultTableModel_documentaliste.setValueAt(jTextField_documentaliste_2.getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值
						jTextField_documentaliste_1.setText("");
						jTextField_documentaliste_2.setText("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_documentaliste = new JButton("Supprimer");// 按钮"删除"
		delButton_documentaliste.setBounds(465, 430, 90, 30);
		jPanel_documentaliste.add(delButton_documentaliste);
		delButton_documentaliste.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_documentaliste.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					user.DeleteUsager(jTextField_documentaliste_1.getText());
					defaultTableModel_documentaliste.removeRow(selectedRow);// 删除选中行
					jTextField_documentaliste_1.setText("");
					jTextField_documentaliste_2.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 333333333333333333333333333333333333333333333333333333333333333333//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 444444444444444444444444444444444444444444444444444444444444444444//
		//////////////////////////////////////////////////////////////////////

		JLabel label_securite_1 = new JLabel("Ancien mot de passe:");
		label_securite_1.setBounds(245, 180, 150, 30);
		jPanel_securite.add(label_securite_1);

		JLabel label_securite_2 = new JLabel("Nouveau mot de passe:");
		label_securite_2.setBounds(245, 220, 150, 30);
		jPanel_securite.add(label_securite_2);

		JLabel label_securite_3 = new JLabel("Confirmation:");
		label_securite_3.setBounds(245, 260, 150, 30);
		jPanel_securite.add(label_securite_3);

		password_field_securite_1.setBounds(395, 180, 150, 30);
		jPanel_securite.add(password_field_securite_1);
		
		password_field_securite_2.setBounds(395, 220, 150, 30);
		jPanel_securite.add(password_field_securite_2);
		
		password_field_securite_3.setBounds(395, 260, 150, 30);
		jPanel_securite.add(password_field_securite_3);

		JButton button_securite_1 = new JButton("Affirmer");
		button_securite_1.setBounds(315, 300, 100, 30);
		jPanel_securite.add(button_securite_1);
		button_securite_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (password_field_securite_1.getText().trim().length() < 1
						|| password_field_securite_2.getText().trim().length() < 1
						|| password_field_securite_3.getText().trim().length() < 1)
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
							"Erreur", JOptionPane.ERROR_MESSAGE);
				else {
					int f=user.ChangePW(password_field_securite_1.getText(), password_field_securite_2.getText(),IDA);
					if(f==1)
					{
						JOptionPane.showMessageDialog(null, "Success!",
								"Erreur", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Echec!",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					password_field_securite_1.setText("");
					password_field_securite_2.setText("");
					password_field_securite_3.setText("");
					
				}
			}
		});

		JButton button_securite_2 = new JButton("Vider");
		button_securite_2.setBounds(415, 300, 100, 30);
		jPanel_securite.add(button_securite_2);
		button_securite_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				password_field_securite_1.setText("");
				password_field_securite_2.setText("");
				password_field_securite_3.setText("");
			}
		});

		//////////////////////////////////////////////////////////////////////
		//444444444444444444444444444444444444444444444444444444444444444444//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		//iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii//
		//////////////////////////////////////////////////////////////////////

		ImageIcon imageIcon_bienvenue = new ImageIcon("images/A01.jpg");// 写入文件路径
		JLabel imageLabel_bienvenue = new JLabel(imageIcon_bienvenue);// 初始化JLabel
		jPanel_bienvenue.add(imageLabel_bienvenue);
		imageLabel_bienvenue.setBounds(0, 0, 800, 600);

		ImageIcon imageIcon_usager = new ImageIcon("images/A02.jpg");// 写入文件路径
		JLabel imageLabel_usager = new JLabel(imageIcon_usager);// 初始化JLabel
		jPanel_usager.add(imageLabel_usager);
		imageLabel_usager.setBounds(0, 0, 800, 600);

		ImageIcon imageIcon_documentaliste = new ImageIcon("images/A03.jpg");// 写入文件路径
		JLabel imageLabel_documentaliste = new JLabel(imageIcon_documentaliste);// 初始化JLabel
		jPanel_documentaliste.add(imageLabel_documentaliste);
		imageLabel_documentaliste.setBounds(0, 0, 800, 600);

		ImageIcon imageIcon_securite = new ImageIcon("images/A04.jpg");// 写入文件路径
		JLabel imageLabel_securite = new JLabel(imageIcon_securite);// 初始化JLabel
		jPanel_securite.add(imageLabel_securite);
		imageLabel_securite.setBounds(0, 0, 800, 600);

		//////////////////////////////////////////////////////////////////////
		// iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii//
		//////////////////////////////////////////////////////////////////////

	}

	public static void main(String[] args) {
		new Administrateur("3");
	}
}