package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Dao.VilleDao;
import Dao.SocieteDao;
import Dao.UserDao;
import Dao.FermesDao;
import Dao.NodeDao;
import Dao.PeageDao;
import Dao.RoutesDao;
import Dao.TronconDao;

public class Documentaliste extends JFrame {
	private VilleDao ville;
	private SocieteDao societe;
	private FermesDao fermes;
	private NodeDao node;
	private PeageDao peage;
	private RoutesDao routes;
	private TronconDao troncon;
	private UserDao user;
	
	private int VS ;//Ville 主键
	private String SS;//Societe 主键
	private int FS ;//Fermes 主键
	private int PS;//Peage 主键
	private String NS;//Node 主键
	private String RS;//Routes 主键
	private String TS;//Troncon 主键
	
	public Documentaliste(String IDD) {
		ville=new VilleDao();
		user=new UserDao();
		fermes= new FermesDao();
		societe=new SocieteDao();
		peage=new PeageDao();
		node=new NodeDao();
		routes=new RoutesDao();
		troncon=new TronconDao();
		
		
		
		JTextField jTextField_ville_1 = new JTextField();
		JTextField jTextField_ville_2 = new JTextField();
		JTextField jTextField_ville_3 = new JTextField();
		JTextField jTextField_autoroute_1 = new JTextField();
		JTextField jTextField_autoroute_2 = new JTextField();
		JTextField jTextField_autoroute_3 = new JTextField();
		JTextField jTextField_autoroute_4 = new JTextField();
		JTextField jTextField_autoroute_5 = new JTextField();
		JTextField jTextField_node_1 = new JTextField();
		JTextField jTextField_tronçon_1 = new JTextField();
		JTextField jTextField_tronçon_5 = new JTextField();
		JTextField jTextField_tronçon_6 = new JTextField();
		JTextField jTextField_societe_1 = new JTextField();
		JTextField jTextField_societe_2 = new JTextField();
		JTextField jTextField_peage_1 = new JTextField();
		JTextField jTextField_peage_4 = new JTextField();
		JTextField jTextField_peage_5 = new JTextField();
		JTextField jTextField_peage_6 = new JTextField();
		JTextField jTextField_fermer_1 = new JTextField();
		JTextField jTextField_fermer_3 = new JTextField();
		JTextField jTextField_fermer_4 = new JTextField();

		JTextArea jTextArea_fermer_1 = new JTextArea();

		ArrayList<String> list_ville=new ArrayList<String>();
		ArrayList<String> list_node=new ArrayList<String>();
		ArrayList<String> list_route=new ArrayList<String>();
		ArrayList<String> list_societe=new ArrayList<String>();
		ArrayList<String> list_troncon=new ArrayList<String>();
		
		JComboBox<String> jComboBox_node_2 = new JComboBox<String>();
		JComboBox<String> jComboBox_tronçon_2 = new JComboBox<String>();
		JComboBox<String> jComboBox_tronçon_3 = new JComboBox<String>();
		JComboBox<String> jComboBox_tronçon_4 = new JComboBox<String>();
		JComboBox<String> jComboBox_peage_2 = new JComboBox<String>();
		JComboBox<String> jComboBox_peage_3 = new JComboBox<String>();
		JComboBox<String> jComboBox_fermer_2 = new JComboBox<String>();

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

		// 设置标签栏
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent e) {
				JTabbedPane jTabbedPane = (JTabbedPane) e.getSource();
				int selectedIndex = jTabbedPane.getSelectedIndex();
				switch (selectedIndex) {
				case 1: {
					jTextField_ville_1.setText("");
					jTextField_ville_2.setText("");
					jTextField_ville_3.setText("");
				}
					break;
				case 2: {
					jTextField_autoroute_1.setText("");
					jTextField_autoroute_2.setText("");
					jTextField_autoroute_3.setText("");
					jTextField_autoroute_4.setText("");
					jTextField_autoroute_5.setText("");
				}
					break;
				case 3: {
					jTextField_node_1.setText("");
					jComboBox_node_2.setSelectedItem("");
				}
					break;
				case 4: {
					jTextField_tronçon_1.setText("");
					jComboBox_tronçon_2.setSelectedItem("");
					jComboBox_tronçon_3.setSelectedItem("");
					jComboBox_tronçon_4.setSelectedItem("");
					jTextField_tronçon_5.setText("");
					jTextField_tronçon_6.setText("");
				}
					break;
				case 5: {
					jTextField_societe_1.setText("");
					jTextField_societe_2.setText("");
				}
					break;
				case 6: {
					jTextField_peage_1.setText("");
					jTextField_peage_4.setText("");
					jTextField_peage_5.setText("");
					jTextField_peage_6.setText("");
					jComboBox_peage_2.setSelectedItem("");
					jComboBox_peage_3.setSelectedItem("");
				}
					break;
				case 7: {
					jTextField_fermer_1.setText("");
					jTextField_fermer_3.setText("");
					jTextField_fermer_4.setText("");
					jTextArea_fermer_1.setText("Cause: ");
					jComboBox_fermer_2.setSelectedItem("");
				}
					break;
				case 8: {
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
		JPanel jPanel_ville = new JPanel();
		jPanel_ville.setLayout(null);
		jTabbedPane.addTab("Ville", null, jPanel_ville, null);// 加入第二个页面

		// 第三个标签下的JPanel
		JPanel jPanel_autoroute = new JPanel();
		jPanel_autoroute.setLayout(null);
		jTabbedPane.addTab("Autoroute", null, jPanel_autoroute, null);// 加入第三个页面

		// 第四个标签下的JPanel
		final JPanel jPanel_node = new JPanel();
		jPanel_node.setLayout(null);
		jTabbedPane.addTab("Node", null, jPanel_node, null);// 加入第四个页面

		// 第五个标签下的JPanel
		final JPanel jPanel_tronçon = new JPanel();
		jPanel_tronçon.setLayout(null);
		jTabbedPane.addTab("Tronçon", null, jPanel_tronçon, null);// 加入第五个页面

		// 第六个标签下的JPanel
		final JPanel jPanel_societe = new JPanel();
		jPanel_societe.setLayout(null);
		jTabbedPane.addTab("Societe", null, jPanel_societe, null);// 加入第八个页面

		// 第七个标签下的JPanel
		final JPanel jPanel_peage = new JPanel();
		jPanel_peage.setLayout(null);
		jTabbedPane.addTab("Peage", null, jPanel_peage, null);// 加入第六个页面

		// 第八个标签下的JPanel
		final JPanel jPanel_fermer = new JPanel();
		jPanel_fermer.setLayout(null);
		jTabbedPane.addTab("Fermeture", null, jPanel_fermer, null);// 加入第七个页面

		// 第九个标签下的JPanel
		final JPanel jPanel_securite = new JPanel();
		jPanel_securite.setLayout(null);
		jTabbedPane.addTab("Securite", null, jPanel_securite, null);// 加入第九个页面

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

		JLabel jLabel_ville_1 = new JLabel("Code postal:");
		jLabel_ville_1.setBounds(405, 90, 100, 30);
		jPanel_ville.add(jLabel_ville_1);

		JLabel jLabel_ville_2 = new JLabel("Nom:");
		jLabel_ville_2.setBounds(405, 130, 100, 30);
		jPanel_ville.add(jLabel_ville_2);

		JLabel jLabel_ville_3 = new JLabel("Node:");
		jLabel_ville_3.setBounds(405, 170, 100, 30);
		jPanel_ville.add(jLabel_ville_3);

		jTextField_ville_1.setBounds(495, 90, 255, 30);
		jPanel_ville.add(jTextField_ville_1);

		jTextField_ville_2.setBounds(495, 130, 255, 30);
		jPanel_ville.add(jTextField_ville_2);

		jTextField_ville_3.setBounds(495, 170, 255, 30);
		jPanel_ville.add(jTextField_ville_3);
		jTextField_ville_1.addKeyListener (new KeyListener (){//添加事件
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

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_ville = { "Code postal", "Nom", "Nodes" };// 表格列名
		String[][][] tableVales_ville = {};// 数据

		DefaultTableModel defaultTableModel_ville = new DefaultTableModel(tableVales_ville, columnNames_ville);
		ville.Obtenir(defaultTableModel_ville,list_ville);
		JTable jTable_ville = new JTable(defaultTableModel_ville);
		
		jTable_ville.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_ville.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_ville.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_ville.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_ville.getValueAt(selectedRow, 1);
				Object object_c = defaultTableModel_ville.getValueAt(selectedRow, 2);

				jTextField_ville_1.setText(object_a.toString());// 给文本框赋值
				jTextField_ville_2.setText(object_b.toString());
				jTextField_ville_3.setText(object_c.toString());
				VS=Integer.parseInt(object_a.toString());
			}
		});

		JScrollPane scrollPane_ville = new JScrollPane(jTable_ville);// 添加滚动条
		getContentPane().add(scrollPane_ville, BorderLayout.CENTER);
		scrollPane_ville.setBounds(50, 50, 345, 400);
		scrollPane_ville.setOpaque(false);
		jPanel_ville.add(scrollPane_ville);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_ville = new JButton("Ajouter");// 按钮"添加"
		addButton_ville.setBounds(445, 420, 90, 30);
		jPanel_ville.add(addButton_ville);
		addButton_ville.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_ville_1.getText().trim().length() < 1 || jTextField_ville_2.getText().trim().length() < 1
						|| jTextField_ville_3.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ville.AddVille(Integer.parseInt(jTextField_ville_1.getText()), jTextField_ville_2.getText(),
							jTextField_ville_3.getText() );
					String[] rowValues = { jTextField_ville_1.getText(), jTextField_ville_2.getText(),
							jTextField_ville_3.getText() };
					defaultTableModel_ville.addRow(rowValues); // 添加一行
					////////// **********//////////**********//////////**********//////////
//=======================================jComboBox_node_1.addItem(jTextField_ville_2.getText());
					////////// **********//////////**********//////////**********//////////
					jTextField_ville_1.setText("");
					jTextField_ville_2.setText("");
					jTextField_ville_3.setText("");
				}
			}
		});

		final JButton updateButton_ville = new JButton("Modifier");// 按钮"修改"
		updateButton_ville.setBounds(545, 420, 90, 30);
		jPanel_ville.add(updateButton_ville);
		updateButton_ville.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_ville.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_ville_1.getText().trim().length() < 1
							|| jTextField_ville_2.getText().trim().length() < 1
							|| jTextField_ville_3.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						ville.Update(Integer.parseInt(jTextField_ville_1.getText()), jTextField_ville_2.getText(),
								jTextField_ville_3.getText(),VS);

						////////// **********//////////**********//////////**********//////////

						defaultTableModel_ville.setValueAt(jTextField_ville_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						defaultTableModel_ville.setValueAt(jTextField_ville_2.getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值
						defaultTableModel_ville.setValueAt(jTextField_ville_3.getText(), selectedRow, 2);// 将表格中的值修改为输入框中的值
						jTextField_ville_1.setText("");
						jTextField_ville_2.setText("");
						jTextField_ville_3.setText("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_ville = new JButton("Supprimer");// 按钮"删除"
		delButton_ville.setBounds(645, 420, 90, 30);
		jPanel_ville.add(delButton_ville);
		delButton_ville.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_ville.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					ville.Delete(VS);
					defaultTableModel_ville.removeRow(selectedRow);// 删除选中行
					////////// **********//////////**********//////////**********//////////
					jComboBox_node_2.removeItem(jTextField_ville_2.getText());
					////////// **********//////////**********//////////**********//////////
					jTextField_ville_1.setText("");
					jTextField_ville_2.setText("");
					jTextField_ville_3.setText("");
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

		JLabel jLabel_autoroute_1 = new JLabel("Code:");
		jLabel_autoroute_1.setBounds(405, 90, 100, 30);
		jPanel_autoroute.add(jLabel_autoroute_1);

		JLabel jLabel_autoroute_2 = new JLabel("Nom:");
		jLabel_autoroute_2.setBounds(405, 130, 100, 30);
		jPanel_autoroute.add(jLabel_autoroute_2);

		JLabel jLabel_autoroute_3 = new JLabel("VilleP:");
		jLabel_autoroute_3.setBounds(405, 170, 100, 30);
		jPanel_autoroute.add(jLabel_autoroute_3);

		JLabel jLabel_autoroute_4 = new JLabel("VilleT:");
		jLabel_autoroute_4.setBounds(405, 210, 100, 30);
		jPanel_autoroute.add(jLabel_autoroute_4);
		
		JLabel jLabel_autoroute_5 = new JLabel("Longueur:");
		jLabel_autoroute_5.setBounds(405, 250, 100, 30);
		jPanel_autoroute.add(jLabel_autoroute_5);
		
		jTextField_autoroute_1.setBounds(495, 90, 255, 30);
		jPanel_autoroute.add(jTextField_autoroute_1);

		jTextField_autoroute_2.setBounds(495, 130, 255, 30);
		jPanel_autoroute.add(jTextField_autoroute_2);

		jTextField_autoroute_3.setBounds(495, 170, 255, 30);
		jPanel_autoroute.add(jTextField_autoroute_3);
		
		jTextField_autoroute_4.setBounds(495, 210, 255, 30);
		jPanel_autoroute.add(jTextField_autoroute_4);
		
		jTextField_autoroute_5.setBounds(495, 250, 255, 30);
		jPanel_autoroute.add(jTextField_autoroute_5);
		jTextField_autoroute_5.addKeyListener (new KeyListener (){//添加事件
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


		
		//////////////////////////////////////////////////////////////////////

		String[] columnNames_autoroute = { "Code", "Nom","VilleP","VilleT","Longueur"};// 表格列名
		String[][] tableVales_autoroute = {};// 数据

		DefaultTableModel defaultTableModel_autoroute = new DefaultTableModel(tableVales_autoroute,
				columnNames_autoroute);
		routes.Obtenir(defaultTableModel_autoroute,list_route);
		JTable jTable_autoroute = new JTable(defaultTableModel_autoroute);

		jTable_autoroute.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_autoroute.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_autoroute.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_autoroute.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_autoroute.getValueAt(selectedRow, 1);
				Object object_c = defaultTableModel_autoroute.getValueAt(selectedRow, 2);
				Object object_d = defaultTableModel_autoroute.getValueAt(selectedRow, 3);
				Object object_e = defaultTableModel_autoroute.getValueAt(selectedRow, 4);
				jTextField_autoroute_1.setText(object_a.toString());// 给文本框赋值
				jTextField_autoroute_2.setText(object_b.toString());
				jTextField_autoroute_3.setText(object_c.toString());
				jTextField_autoroute_4.setText(object_d.toString());
				jTextField_autoroute_5.setText(object_e.toString());
				RS=object_a.toString();
			}
		});

		JScrollPane scrollPane_autoroute = new JScrollPane(jTable_autoroute);// 添加滚动条
		getContentPane().add(scrollPane_autoroute, BorderLayout.CENTER);
		scrollPane_autoroute.setBounds(50, 50, 345, 400);
		scrollPane_autoroute.setOpaque(false);
		jPanel_autoroute.add(scrollPane_autoroute);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_autoroute = new JButton("Ajouter");// 按钮"添加"
		addButton_autoroute.setBounds(445, 420, 90, 30);
		jPanel_autoroute.add(addButton_autoroute);
		addButton_autoroute.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_autoroute_1.getText().trim().length() < 1
						|| jTextField_autoroute_2.getText().trim().length() < 1
						|| jTextField_autoroute_3.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					routes.Add(jTextField_autoroute_1.getText(), jTextField_autoroute_2.getText(),
							jTextField_autoroute_3.getText() ,jTextField_autoroute_4.getText(),jTextField_autoroute_5.getText());
					String[] rowValues = { jTextField_autoroute_1.getText(), jTextField_autoroute_2.getText(),
							jTextField_autoroute_3.getText() ,jTextField_autoroute_4.getText(),jTextField_autoroute_5.getText()};
					
					defaultTableModel_autoroute.addRow(rowValues); // 添加一行
					////////// **********//////////**********//////////**********//////////
					jComboBox_node_2.addItem(jTextField_autoroute_1.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_2.addItem(jTextField_autoroute_2.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_peage_2.addItem(jTextField_autoroute_2.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////


					jTextField_autoroute_1.setText("");
					jTextField_autoroute_2.setText("");
					jTextField_autoroute_3.setText("");
					jTextField_autoroute_4.setText("");
					jTextField_autoroute_5.setText("");
				}
			}
		});

		final JButton updateButton_autoroute = new JButton("Modifier");// 按钮"修改"
		updateButton_autoroute.setBounds(545, 420, 90, 30);
		jPanel_autoroute.add(updateButton_autoroute);
		updateButton_autoroute.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_autoroute.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_autoroute_1.getText().trim().length() < 1
							|| jTextField_autoroute_2.getText().trim().length() < 1
							|| jTextField_autoroute_3.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						Object object = defaultTableModel_autoroute.getValueAt(selectedRow, 0);
						routes.Update(jTextField_autoroute_1.getText(),jTextField_autoroute_2.getText(),jTextField_autoroute_3.getText(),jTextField_autoroute_4.getText(),jTextField_autoroute_5.getText(),RS);

						////////// **********//////////**********//////////**********//////////
						
						jComboBox_node_2.removeItem(object.toString());
						jComboBox_node_2.addItem(jTextField_autoroute_1.getText());
						////////// **********//////////**********//////////**********//////////

						////////// **********//////////**********//////////**********//////////
						// Object object =
						////////// defaultTableModel_autoroute.getValueAt(selectedRow,
						////////// 1);
						jComboBox_tronçon_2.removeItem(object.toString());
						jComboBox_tronçon_2.addItem(jTextField_autoroute_2.getText());
						////////// **********//////////**********//////////**********//////////

						////////// **********//////////**********//////////**********//////////
						// Object object =
						////////// defaultTableModel_autoroute.getValueAt(selectedRow,
						////////// 1);
						jComboBox_peage_2.removeItem(object.toString());
						jComboBox_peage_2.addItem(jTextField_autoroute_2.getText());
						////////// **********//////////**********//////////**********//////////

						////////// **********//////////**********//////////**********//////////
						// Object object =
						////////// defaultTableModel_autoroute.getValueAt(selectedRow,
						////////// 1);
						////////// **********//////////**********//////////**********//////////

						defaultTableModel_autoroute.setValueAt(jTextField_autoroute_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						defaultTableModel_autoroute.setValueAt(jTextField_autoroute_2.getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值
						defaultTableModel_autoroute.setValueAt(jTextField_autoroute_3.getText(), selectedRow, 2);// 将表格中的值修改为输入框中的值
						defaultTableModel_autoroute.setValueAt(jTextField_autoroute_4.getText(), selectedRow, 3);// 将表格中的值修改为输入框中的值
						defaultTableModel_autoroute.setValueAt(jTextField_autoroute_5.getText(), selectedRow, 4);// 将表格中的值修改为输入框中的值
						jTextField_autoroute_1.setText("");
						jTextField_autoroute_2.setText("");
						jTextField_autoroute_3.setText("");
						jTextField_autoroute_4.setText("");
						jTextField_autoroute_5.setText("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_autoroute = new JButton("Supprimer");// 按钮"删除"
		delButton_autoroute.setBounds(645, 420, 90, 30);
		jPanel_autoroute.add(delButton_autoroute);
		delButton_autoroute.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_autoroute.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					routes.Delete(jTextField_autoroute_1.getText());
					defaultTableModel_autoroute.removeRow(selectedRow);// 删除选中行
					////////// **********//////////**********//////////**********//////////
					jComboBox_node_2.removeItem(jTextField_autoroute_2.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_2.removeItem(jTextField_autoroute_2.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_peage_2.removeItem(jTextField_autoroute_2.getText());
					////////// **********//////////**********//////////**********//////////
					////////// **********//////////**********//////////**********//////////
					jTextField_autoroute_1.setText("");
					jTextField_autoroute_2.setText("");
					jTextField_autoroute_3.setText("");
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

		JLabel jLabel_node_1 = new JLabel("Code:");
		jLabel_node_1.setBounds(405, 90, 100, 30);
		jPanel_node.add(jLabel_node_1);

		JLabel jLabel_node_2 = new JLabel("Autoroute:");
		jLabel_node_2.setBounds(405, 130, 100, 30);
		jPanel_node.add(jLabel_node_2);

		jTextField_node_1.setBounds(495, 90, 255, 30);
		jPanel_node.add(jTextField_node_1);

		// JTextField jTextField_node_2 = new JTextField();
		// jTextField_node_2.setBounds(445, 130, 305, 30);
		// jPanel_node.add(jTextField_node_2);

		////////// **********//////////**********//////////**********//////////
		jComboBox_node_2.addItem("");
		jComboBox_node_2.setBounds(495, 130, 255, 30);
		jPanel_node.add(jComboBox_node_2);
		for(String s:list_route){
			jComboBox_node_2.addItem(s);
		}
		////////// **********//////////**********//////////**********//////////

		/*
		jTextField_node_3.addKeyListener (new KeyListener (){//添加事件
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
		});*/

		////////// **********//////////**********//////////**********//////////

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_node = { "Code", "Autoroute" };// 表格列名
		String[][]tableVales_node = {};// 数据

		DefaultTableModel defaultTableModel_node = new DefaultTableModel(tableVales_node, columnNames_node);
		node.Obtenir(defaultTableModel_node, list_node);
		JTable jTable_node = new JTable(defaultTableModel_node);

		jTable_node.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_node.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_node.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_node.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_node.getValueAt(selectedRow, 1);

				jTextField_node_1.setText(object_a.toString());// 给文本框赋值
				// jTextField_node_2.setText(object_b.toString());
				jComboBox_node_2.setSelectedItem(object_b.toString());
				NS=object_a.toString();
			}
		});

		JScrollPane scrollPane_node = new JScrollPane(jTable_node);// 添加滚动条
		getContentPane().add(scrollPane_node, BorderLayout.CENTER);
		scrollPane_node.setBounds(50, 50, 345, 400);
		scrollPane_node.setOpaque(false);
		jPanel_node.add(scrollPane_node);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_node = new JButton("Ajouter");// 按钮"添加"
		addButton_node.setBounds(445, 420, 90, 30);
		jPanel_node.add(addButton_node);
		addButton_node.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_node_1.getText().trim().length() < 1
						/* || jTextField_node_2.getText().trim().length() < 1 */
						|| jComboBox_node_2.getSelectedItem().toString() == ""
						) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					node.Add(jTextField_node_1.getText(),jComboBox_node_2.getSelectedItem().toString());
					String[] rowValues = { jTextField_node_1.getText(),
							/* jTextField_node_2.getText(), */
							jComboBox_node_2.getSelectedItem().toString() };
					defaultTableModel_node.addRow(rowValues); // 添加一行
					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_3.addItem(jTextField_node_1.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_4.addItem(jTextField_node_1.getText());
					////////// **********//////////**********//////////**********//////////
					jTextField_node_1.setText("");
					/* jTextField_node_2.setText(""); */
					jComboBox_node_2.setSelectedItem("");
				}
			}
		});

		final JButton updateButton_node = new JButton("Modifier");// 按钮"修改"
		updateButton_node.setBounds(545, 420, 90, 30);
		jPanel_node.add(updateButton_node);
		updateButton_node.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_node.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_node_1.getText().trim().length() < 1
							/*
							 * || jTextField_node_2.getText().trim().length() <
							 * 1
							 */
							|| jComboBox_node_2.getSelectedItem().toString() == ""
						) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						
						Object object = defaultTableModel_node.getValueAt(selectedRow, 1);
						node.Update(jTextField_node_1.getText(),jComboBox_node_2.getSelectedItem().toString(),NS);

						////////// **********//////////**********//////////**********//////////
						
						jComboBox_tronçon_3.removeItem(object.toString());
						jComboBox_tronçon_3.addItem(jTextField_node_1.getText());
						////////// **********//////////**********//////////**********//////////

						////////// **********//////////**********//////////**********//////////
						// Object object =
						////////// defaultTableModel_node.getValueAt(selectedRow,
						////////// 1);
						jComboBox_tronçon_4.removeItem(object.toString());
						jComboBox_tronçon_4.addItem(jTextField_node_1.getText());
						////////// **********//////////**********//////////**********//////////

						defaultTableModel_node.setValueAt(jTextField_node_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						/*
						 * defaultTableModel_node.setValueAt(jTextField_node_2.
						 * getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值
						 */
						defaultTableModel_node.setValueAt(jComboBox_node_2.getSelectedItem().toString(), selectedRow,
								1);// 将表格中的值修改为输入框中的值
			
						jTextField_node_1.setText("");
						/* jTextField_node_2.setText(""); */
						jComboBox_node_2.setSelectedItem("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_node = new JButton("Supprimer");// 按钮"删除"
		delButton_node.setBounds(645, 420, 90, 30);
		jPanel_node.add(delButton_node);
		delButton_node.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_node.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					// Delete_Node();
					defaultTableModel_node.removeRow(selectedRow);// 删除选中行

					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_2.removeItem(jTextField_node_1.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_3.removeItem(jTextField_node_1.getText());
					////////// **********//////////**********//////////**********//////////

					jTextField_node_1.setText("");
					/* jTextField_node_2.setText(""); */
					jComboBox_node_2.setSelectedItem("");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 444444444444444444444444444444444444444444444444444444444444444444//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 555555555555555555555555555555555555555555555555555555555555555555//
		//////////////////////////////////////////////////////////////////////

		JLabel jLabel_tronçon_1 = new JLabel("Code:");
		jLabel_tronçon_1.setBounds(405, 90, 100, 30);
		jPanel_tronçon.add(jLabel_tronçon_1);

		JLabel jLabel_tronçon_2 = new JLabel("Autoroute:");
		jLabel_tronçon_2.setBounds(405, 130, 100, 30);
		jPanel_tronçon.add(jLabel_tronçon_2);

		JLabel jLabel_tronçon_3 = new JLabel("Node de debut:");
		jLabel_tronçon_3.setBounds(405, 170, 100, 30);
		jPanel_tronçon.add(jLabel_tronçon_3);

		JLabel jLabel_tronçon_4 = new JLabel("Node de fin:");
		jLabel_tronçon_4.setBounds(405, 210, 100, 30);
		jPanel_tronçon.add(jLabel_tronçon_4);
		
		JLabel jLabel_tronçon_5 = new JLabel("Longeur:");
		jLabel_tronçon_5.setBounds(405, 250, 100, 30);
		jPanel_tronçon.add(jLabel_tronçon_5);
		
		JLabel jLabel_tronçon_6 = new JLabel("Type:");
		jLabel_tronçon_6.setBounds(405, 290, 100, 30);
		jPanel_tronçon.add(jLabel_tronçon_6);

		jTextField_tronçon_1.setBounds(505, 90, 245, 30);
		jPanel_tronçon.add(jTextField_tronçon_1);
		
		jComboBox_tronçon_2.addItem("");
		jComboBox_tronçon_2.setBounds(505, 130, 245, 30);
		jPanel_tronçon.add(jComboBox_tronçon_2);
		for(String s:list_route){
			jComboBox_tronçon_2.addItem(s);
		}
	
		jComboBox_tronçon_3.addItem("");
		jComboBox_tronçon_3.setBounds(505, 170, 245, 30);
		jPanel_tronçon.add(jComboBox_tronçon_3);

		jComboBox_tronçon_4.addItem("");
		jComboBox_tronçon_4.setBounds(505, 210, 245, 30);
		jPanel_tronçon.add(jComboBox_tronçon_4);
		
		for(String s:list_node){
			jComboBox_tronçon_3.addItem(s);
			jComboBox_tronçon_4.addItem(s);
		}
		
		jTextField_tronçon_5.setBounds(505, 250, 245, 30);
		jPanel_tronçon.add(jTextField_tronçon_5);
		jTextField_tronçon_5.addKeyListener (new KeyListener (){//添加事件
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
		
				
		jTextField_tronçon_6.setBounds(505, 290, 245, 30);
		jPanel_tronçon.add(jTextField_tronçon_6);
		jTextField_tronçon_6.addKeyListener (new KeyListener (){//添加事件
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
		////////// **********//////////**********//////////**********//////////

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_tronçon = { "Code", "Autoroute", "debut", "fin" ,"longeur","Type"};// 表格列名
		String[][] tableVales_tronçon = {};// 数据

		DefaultTableModel defaultTableModel_tronçon = new DefaultTableModel(tableVales_tronçon, columnNames_tronçon);
		troncon.Obtenir(defaultTableModel_tronçon,list_troncon);
		JTable jTable_tronçon = new JTable(defaultTableModel_tronçon);

		jTable_tronçon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_tronçon.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_tronçon.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_tronçon.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_tronçon.getValueAt(selectedRow, 1);
				Object object_c = defaultTableModel_tronçon.getValueAt(selectedRow, 2);
				Object object_d = defaultTableModel_tronçon.getValueAt(selectedRow, 3);
				Object object_e = defaultTableModel_tronçon.getValueAt(selectedRow, 4);
				Object object_f = defaultTableModel_tronçon.getValueAt(selectedRow, 5);

				jTextField_tronçon_1.setText(object_a.toString());// 给文本框赋值
				//jTextField_tronçon_2.setText(object_b.toString());
				// jTextField_tronçon_3.setText(object_c.toString());
				// jTextField_tronçon_4.setText(object_d.toString());
				jComboBox_tronçon_2.setSelectedItem(object_b.toString());
				jComboBox_tronçon_3.setSelectedItem(object_c.toString());
				jComboBox_tronçon_4.setSelectedItem(object_d.toString());
				jTextField_tronçon_5.setText(object_e.toString());
				jTextField_tronçon_6.setText(object_f.toString());
				TS=object_a.toString();
			}
		});

		JScrollPane scrollPane_tronçon = new JScrollPane(jTable_tronçon);// 添加滚动条
		getContentPane().add(scrollPane_tronçon, BorderLayout.CENTER);
		scrollPane_tronçon.setBounds(50, 50, 345, 400);
		scrollPane_tronçon.setOpaque(false);
		jPanel_tronçon.add(scrollPane_tronçon);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_tronçon = new JButton("Ajouter");// 按钮"添加"
		addButton_tronçon.setBounds(445, 420, 90, 30);
		jPanel_tronçon.add(addButton_tronçon);
		addButton_tronçon.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_tronçon_1.getText().trim().length() < 1
						/*
						 * || jTextField_tronçon_2.getText().trim().length() <
						 * 1 || jTextField_tronçon_3.getText().trim().length()
						 * < 1 ||
						 * jTextField_tronçon_4.getText().trim().length() < 1
						 */
						|| jComboBox_tronçon_4.getSelectedItem().toString() == ""
						|| jComboBox_tronçon_2.getSelectedItem().toString() == ""
						|| jComboBox_tronçon_3.getSelectedItem().toString() == "") {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					troncon.Add(jTextField_tronçon_1.getText(), 
							jComboBox_tronçon_2.getSelectedItem().toString(),
							jComboBox_tronçon_3.getSelectedItem().toString(),
							jComboBox_tronçon_4.getSelectedItem().toString(),
							jTextField_tronçon_5.getText(),
							jTextField_tronçon_6.getText()
							);

					////////// **********//////////**********//////////**********//////////
				
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_fermer_2.addItem(jTextField_tronçon_1.getText());
					////////// **********//////////**********//////////**********//////////

					String[] rowValues = { jTextField_tronçon_1.getText()
							/*
							 * , jTextField_tronçon_2.getText()
							 * ,jTextField_tronçon_3.getText() ,
							 * jTextField_tronçon_4.getText()
							 */
							, jComboBox_tronçon_2.getSelectedItem().toString(),
							jComboBox_tronçon_3.getSelectedItem().toString(),
							jComboBox_tronçon_4.getSelectedItem().toString(),
							jTextField_tronçon_5.getText(),
							jTextField_tronçon_6.getText()};
					defaultTableModel_tronçon.addRow(rowValues); // 添加一行
					jTextField_tronçon_1.setText("");
					// jTextField_tronçon_2.setText("");
					// jTextField_tronçon_3.setText("");
					// jTextField_tronçon_4.setText("");
					jComboBox_tronçon_4.setSelectedItem("");
					jComboBox_tronçon_2.setSelectedItem("");
					jComboBox_tronçon_3.setSelectedItem("");
					jTextField_tronçon_5.setText("");
					jTextField_tronçon_6.setText("");
				}
			}
		});

		final JButton updateButton_tronçon = new JButton("Modifier");// 按钮"修改"
		updateButton_tronçon.setBounds(545, 420, 90, 30);
		jPanel_tronçon.add(updateButton_tronçon);
		updateButton_tronçon.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_tronçon.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_tronçon_1.getText().trim().length() < 1
							/*
							 * ||
							 * jTextField_tronçon_2.getText().trim().length() <
							 * 1 ||
							 * jTextField_tronçon_3.getText().trim().length() <
							 * 1 ||
							 * jTextField_tronçon_4.getText().trim().length() <
							 * 1
							 */
							|| jComboBox_tronçon_4.getSelectedItem().toString() == ""
							|| jComboBox_tronçon_2.getSelectedItem().toString() == ""
							|| jComboBox_tronçon_3.getSelectedItem().toString() == "") {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						troncon.Update(jTextField_tronçon_1.getText(), 
								jComboBox_tronçon_2.getSelectedItem().toString(),
								jComboBox_tronçon_3.getSelectedItem().toString(),
								jComboBox_tronçon_4.getSelectedItem().toString(),
								jTextField_tronçon_5.getText(),
								jTextField_tronçon_6.getText(),TS);

						////////// **********//////////**********//////////**********//////////
						Object object = defaultTableModel_tronçon.getValueAt(selectedRow, 0);
						jComboBox_tronçon_3.removeItem(object.toString());
						jComboBox_tronçon_3.addItem(jTextField_tronçon_1.getText());
						////////// **********//////////**********//////////**********//////////

						////////// **********//////////**********//////////**********//////////
						// Object object =
						////////// defaultTableModel_tronçon.getValueAt(selectedRow,
						////////// 0);
						jComboBox_fermer_2.removeItem(object.toString());
						jComboBox_fermer_2.addItem(jTextField_tronçon_1.getText());
						////////// **********//////////**********//////////**********//////////

						defaultTableModel_tronçon.setValueAt(jTextField_tronçon_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						/*
						 * defaultTableModel_tronçon.setValueAt(
						 * jTextField_tronçon_2.getText(), selectedRow, 1);//
						 * 将表格中的值修改为输入框中的值
						 * defaultTableModel_tronçon.setValueAt(
						 * jTextField_tronçon_3.getText(), selectedRow, 2);//
						 * 将表格中的值修改为输入框中的值
						 * defaultTableModel_tronçon.setValueAt(
						 * jTextField_tronçon_4.getText(), selectedRow, 3);//
						 * 将表格中的值修改为输入框中的值
						 */
						defaultTableModel_tronçon.setValueAt(jComboBox_tronçon_2.getSelectedItem().toString(),
								selectedRow, 1);// 将表格中的值修改为输入框中的值
						defaultTableModel_tronçon.setValueAt(jComboBox_tronçon_3.getSelectedItem().toString(),
								selectedRow, 2);// 将表格中的值修改为输入框中的值
						defaultTableModel_tronçon.setValueAt(jComboBox_tronçon_4.getSelectedItem().toString(),
								selectedRow, 3);// 将表格中的值修改为输入框中的值
						jTextField_tronçon_1.setText("");
						// jTextField_tronçon_2.setText("");
						// jTextField_tronçon_3.setText("");
						// jTextField_tronçon_4.setText("");
						jComboBox_tronçon_2.setSelectedItem("");
						jComboBox_tronçon_3.setSelectedItem("");
						jComboBox_tronçon_4.setSelectedItem("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_tronçon = new JButton("Supprimer");// 按钮"删除"
		delButton_tronçon.setBounds(645, 420, 90, 30);
		jPanel_tronçon.add(delButton_tronçon);
		delButton_tronçon.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_tronçon.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					troncon.Delete(jTextField_tronçon_1.getText());

					////////// **********//////////**********//////////**********//////////
					jComboBox_tronçon_3.removeItem(jTextField_tronçon_1.getText());
					////////// **********//////////**********//////////**********//////////

					////////// **********//////////**********//////////**********//////////
					jComboBox_fermer_2.removeItem(jTextField_tronçon_1.getText());
					////////// **********//////////**********//////////**********//////////

					defaultTableModel_tronçon.removeRow(selectedRow);// 删除选中行
					jTextField_tronçon_1.setText("");
					/*
					 * jTextField_tronçon_2.setText("");
					 * jTextField_tronçon_3.setText("");
					 * jTextField_tronçon_4.setText("");
					 */
					jComboBox_tronçon_2.setSelectedItem("");
					jComboBox_tronçon_3.setSelectedItem("");
					jComboBox_tronçon_4.setSelectedItem("");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 555555555555555555555555555555555555555555555555555555555555555555//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 666666666666666666666666666666666666666666666666666666666666666666//
		//////////////////////////////////////////////////////////////////////

		JLabel jLabel_societe_1 = new JLabel("Code:");
		jLabel_societe_1.setBounds(405, 90, 100, 30);
		jPanel_societe.add(jLabel_societe_1);

		JLabel jLabel_societe_2 = new JLabel("Nom:");
		jLabel_societe_2.setBounds(405, 130, 100, 30);
		jPanel_societe.add(jLabel_societe_2);

		jTextField_societe_1.setBounds(495, 90, 255, 30);
		jPanel_societe.add(jTextField_societe_1);

		jTextField_societe_2.setBounds(495, 130, 255, 30);
		jPanel_societe.add(jTextField_societe_2);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_societe = { "Code", "Nom" };// 表格列名
		String[][] tableVales_societe = {};// 数据

		DefaultTableModel defaultTableModel_societe = new DefaultTableModel(tableVales_societe, columnNames_societe);
		societe.Obtenir(defaultTableModel_societe,list_societe);
		JTable jTable_societe = new JTable(defaultTableModel_societe);
		

		jTable_societe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_societe.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_societe.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_societe.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_societe.getValueAt(selectedRow, 1);
				jTextField_societe_1.setText(object_a.toString());// 给文本框赋值
				jTextField_societe_2.setText(object_b.toString());
				SS=object_a.toString();
			}
		});

		JScrollPane scrollPane_societe = new JScrollPane(jTable_societe);// 添加滚动条
		getContentPane().add(scrollPane_societe, BorderLayout.CENTER);
		scrollPane_societe.setBounds(50, 50, 345, 400);
		scrollPane_societe.setOpaque(false);
		jPanel_societe.add(scrollPane_societe);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_societe = new JButton("Ajouter");// 按钮"添加"
		addButton_societe.setBounds(445, 420, 90, 30);
		jPanel_societe.add(addButton_societe);
		addButton_societe.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_societe_1.getText().trim().length() < 1
						|| jTextField_societe_2.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					societe.Add(jTextField_societe_1.getText(), jTextField_societe_2.getText() );
					String[] rowValues = { jTextField_societe_1.getText(), jTextField_societe_2.getText() };

					////////// **********//////////**********//////////**********//////////
					jComboBox_peage_3.addItem(jTextField_societe_2.getText());
					////////// **********//////////**********//////////**********//////////
					defaultTableModel_societe.addRow(rowValues); // 添加一行
					jTextField_societe_1.setText("");
					jTextField_societe_2.setText("");

				}
			}
		});

		final JButton updateButton_societe = new JButton("Modifier");// 按钮"修改"
		updateButton_societe.setBounds(545, 420, 90, 30);
		jPanel_societe.add(updateButton_societe);
		updateButton_societe.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_societe.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_societe_1.getText().trim().length() < 1
							|| jTextField_societe_2.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						Object object = defaultTableModel_societe.getValueAt(selectedRow, 1);
						societe.Update(jTextField_societe_1.getText(), jTextField_societe_2.getText(),SS);

						////////// **********//////////**********//////////**********//////////
						
						jComboBox_peage_3.removeItem(object.toString());
						jComboBox_peage_3.addItem(jTextField_societe_2.getText());
						////////// **********//////////**********//////////**********//////////

						defaultTableModel_societe.setValueAt(jTextField_societe_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						defaultTableModel_societe.setValueAt(jTextField_societe_2.getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值

						jTextField_societe_1.setText("");
						jTextField_societe_2.setText("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_societe = new JButton("Supprimer");// 按钮"删除"
		delButton_societe.setBounds(645, 420, 90, 30);
		jPanel_societe.add(delButton_societe);
		delButton_societe.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_societe.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					societe.Delete(jTextField_societe_1.getText());
					defaultTableModel_societe.removeRow(selectedRow);// 删除选中行

					////////// **********//////////**********//////////**********//////////
					jComboBox_peage_3.removeItem(jTextField_societe_2.getText());
					////////// **********//////////**********//////////**********//////////

					jTextField_societe_1.setText("");
					jTextField_societe_2.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 666666666666666666666666666666666666666666666666666666666666666666//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 777777777777777777777777777777777777777777777777777777777777777777//
		//////////////////////////////////////////////////////////////////////

		JLabel jLabel_peage_1 = new JLabel("Code:");
		jLabel_peage_1.setBounds(405, 90, 100, 30);
		jPanel_peage.add(jLabel_peage_1);

		JLabel jLabel_peage_2 = new JLabel("Node:");
		jLabel_peage_2.setBounds(405, 130, 100, 30);
		jPanel_peage.add(jLabel_peage_2);

		JLabel jLabel_peage_3 = new JLabel("Societe:");
		jLabel_peage_3.setBounds(405, 170, 100, 30);
		jPanel_peage.add(jLabel_peage_3);

		JLabel jLabel_peage_4 = new JLabel("Frais:");
		jLabel_peage_4.setBounds(405, 210, 100, 30);
		jPanel_peage.add(jLabel_peage_4);
		
		JLabel jLabel_peage_5 = new JLabel("Date de debut:");
		jLabel_peage_5.setBounds(405, 250, 100, 30);
		jPanel_peage.add(jLabel_peage_5);

		JLabel jLabel_peage_6 = new JLabel("Date de fin:");
		jLabel_peage_6.setBounds(405, 290, 100, 30);
		jPanel_peage.add(jLabel_peage_6);

		jTextField_peage_1.setBounds(495, 90, 255, 30);
		jPanel_peage.add(jTextField_peage_1);
		jTextField_peage_1.addKeyListener (new KeyListener (){//添加事件
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

		jComboBox_peage_2.addItem("");
		jComboBox_peage_2.setBounds(495, 130, 255, 30);
		jPanel_peage.add(jComboBox_peage_2);
		
		for(String s:list_node){
			jComboBox_peage_2.addItem(s);
		}
		
		jComboBox_peage_3.addItem("");
		jComboBox_peage_3.setBounds(495, 170, 255, 30);
		jPanel_peage.add(jComboBox_peage_3);
		for(String s:list_societe){
			jComboBox_peage_3.addItem(s);
		}
		
		jTextField_peage_4.setBounds(495, 210, 255, 30);
		jPanel_peage.add(jTextField_peage_4);
		jTextField_peage_4.addKeyListener (new KeyListener (){//添加事件
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
		
		jTextField_peage_5.setBounds(495, 250, 255, 30);
		jPanel_peage.add(jTextField_peage_5);

		jTextField_peage_6.setBounds(495, 290, 255, 30);
		jPanel_peage.add(jTextField_peage_6);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_peage = { "Code", "Node", "Societe", "Frais", "Debut", "Fin" };// 表格列名
		String[][] tableVales_peage = {};// 数据
		
		DefaultTableModel defaultTableModel_peage = new DefaultTableModel(tableVales_peage, columnNames_peage);
		peage.Obtenir(defaultTableModel_peage);
		JTable jTable_peage = new JTable(defaultTableModel_peage);

		jTable_peage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_peage.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_peage.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_peage.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_peage.getValueAt(selectedRow, 1);
				Object object_c = defaultTableModel_peage.getValueAt(selectedRow, 2);
				Object object_d = defaultTableModel_peage.getValueAt(selectedRow, 3);
				Object object_e = defaultTableModel_peage.getValueAt(selectedRow, 4);
				Object object_f = defaultTableModel_peage.getValueAt(selectedRow, 5);

				jTextField_peage_1.setText(object_a.toString());// 给文本框赋值		
				jComboBox_peage_2.setSelectedItem(object_b.toString());
				jComboBox_peage_3.setSelectedItem(object_c.toString());
				jTextField_peage_4.setText(object_d.toString());
				jTextField_peage_5.setText(object_e.toString());
				jTextField_peage_6.setText(object_f.toString());

				PS=Integer.parseInt(object_a.toString());
			}
		});

		JScrollPane scrollPane_peage = new JScrollPane(jTable_peage);// 添加滚动条
		getContentPane().add(scrollPane_peage, BorderLayout.CENTER);
		scrollPane_peage.setBounds(50, 50, 345, 400);
		scrollPane_peage.setOpaque(false);
		jPanel_peage.add(scrollPane_peage);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_peage = new JButton("Ajouter");// 按钮"添加"
		addButton_peage.setBounds(445, 420, 90, 30);
		jPanel_peage.add(addButton_peage);
		addButton_peage.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_peage_1.getText().trim().length() < 1
						/*
						 * || jTextField_peage_2.getText().trim().length() < 1
						 */
						|| jComboBox_peage_2.getSelectedItem().toString() == ""
				/* || jTextField_peage_3.getText().trim().length() < 1 */
						|| jComboBox_peage_3.getSelectedItem().toString() == ""
				/* || jTextField_peage_5.getText().trim().length() < 1 */
						|| jTextField_peage_4.getText().trim().length() < 1
						|| jTextField_peage_5.getText().trim().length() < 1
						|| jTextField_peage_6.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					peage.Add(Integer.parseInt(jTextField_peage_1.getText()), jComboBox_peage_2.getSelectedItem().toString(),
							jComboBox_peage_3.getSelectedItem().toString(), Integer.parseInt(jTextField_peage_4.getText()), 
							jTextField_peage_5.getText(), jTextField_peage_6.getText());
					String[] rowValues = { jTextField_peage_1.getText(),
							jComboBox_peage_2.getSelectedItem().toString(),
							jComboBox_peage_3.getSelectedItem().toString(),
							jTextField_peage_4.getText(),jTextField_peage_5.getText(),jTextField_peage_6.getText()};
					defaultTableModel_peage.addRow(rowValues); // 添加一行
					jTextField_peage_1.setText("");
					jComboBox_peage_2.setSelectedItem("");
					jComboBox_peage_3.setSelectedItem("");
					jTextField_peage_4.setText("");
					jTextField_peage_5.setText("");
					jTextField_peage_6.setText("");
				}
			}
		});

		final JButton updateButton_peage = new JButton("Modifier");// 按钮"修改"
		updateButton_peage.setBounds(545, 420, 90, 30);
		jPanel_peage.add(updateButton_peage);
		updateButton_peage.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_peage.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_peage_1.getText().trim().length() < 1
							/*
							 * || jTextField_peage_2.getText().trim().length() <
							 * 1
							 */
							|| jComboBox_peage_2.getSelectedItem().toString().length() < 1
					/* || jTextField_peage_3.getText().trim().length() < 1 */
							|| jComboBox_peage_3.getSelectedItem().toString().length() < 1
					/* || jTextField_peage_5.getText().trim().length() < 1 */
							|| jTextField_peage_6.getText().trim().length() < 1
							|| jTextField_peage_4.getText().trim().length() < 1
							|| jTextField_peage_5.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						peage.Update(Integer.parseInt(jTextField_peage_1.getText()), jComboBox_peage_2.getSelectedItem().toString(),
								jComboBox_peage_3.getSelectedItem().toString(), Integer.parseInt(jTextField_peage_4.getText()),jTextField_peage_5.getText(),jTextField_peage_6.getText(), 
								PS);
						defaultTableModel_peage.setValueAt(jTextField_peage_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						/*
						 * defaultTableModel_peage.setValueAt(jTextField_peage_2
						 * .getText(), selectedRow, 1);// 将表格中的值修改为输入框中的值
						 */
						defaultTableModel_peage.setValueAt(jComboBox_peage_2.getSelectedItem().toString(), selectedRow,
								1);// 将表格中的值修改为输入框中的值
						/*
						 * defaultTableModel_peage.setValueAt(jTextField_peage_3
						 * .getText(), selectedRow, 2);// 将表格中的值修改为输入框中的值
						 */
						defaultTableModel_peage.setValueAt(jComboBox_peage_3.getSelectedItem().toString(), selectedRow,
								2);// 将表格中的值修改为输入框中的值
						/*
						 * defaultTableModel_peage.setValueAt(jTextField_peage_5
						 * .getText(), selectedRow, 3);// 将表格中的值修改为输入框中的值
						 */
						defaultTableModel_peage.setValueAt(jTextField_peage_4.getText(), selectedRow, 3);// 将表格中的值修改为输入框中的值
						defaultTableModel_peage.setValueAt(jTextField_peage_5.getText(), selectedRow, 4);// 将表格中的值修改为输入框中的值
						defaultTableModel_peage.setValueAt(jTextField_peage_6.getText(), selectedRow, 5);// 将表格中的值修改为输入框中的值
						jTextField_peage_1.setText("");
						jComboBox_peage_2.setSelectedItem("");
						jComboBox_peage_3.setSelectedItem("");
						jTextField_peage_4.setText("");
						jTextField_peage_5.setText("");
						jTextField_peage_6.setText("");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_peage = new JButton("Supprimer");// 按钮"删除"
		delButton_peage.setBounds(645, 420, 90, 30);
		jPanel_peage.add(delButton_peage);
		delButton_peage.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_peage.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					peage.Delete(PS);
					defaultTableModel_peage.removeRow(selectedRow);// 删除选中行
					jTextField_peage_1.setText("");
					jComboBox_peage_2.setSelectedItem("");
					jComboBox_peage_3.setSelectedItem("");
					jTextField_peage_4.setText("");
					jTextField_peage_5.setText("");
					jTextField_peage_6.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 777777777777777777777777777777777777777777777777777777777777777777//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 888888888888888888888888888888888888888888888888888888888888888888//
		//////////////////////////////////////////////////////////////////////

		JLabel jLabel_fermer_1 = new JLabel("Code:");
		jLabel_fermer_1.setBounds(405, 90, 100, 30);
		jPanel_fermer.add(jLabel_fermer_1);


		JLabel jLabel_fermer_2 = new JLabel("Tronçon:");
		jLabel_fermer_2.setBounds(405, 130, 100, 30);
		jPanel_fermer.add(jLabel_fermer_2);

		JLabel jLabel_fermer_3 = new JLabel("Date de debut:");
		jLabel_fermer_3.setBounds(405, 170, 100, 30);
		jPanel_fermer.add(jLabel_fermer_3);

		JLabel jLabel_fermer_4 = new JLabel("Date de fin:");
		jLabel_fermer_4.setBounds(405, 210, 100, 30);
		jPanel_fermer.add(jLabel_fermer_4);

		jTextField_fermer_1.setBounds(495, 90, 255, 30);
		jPanel_fermer.add(jTextField_fermer_1);
		jTextField_fermer_1.addKeyListener (new KeyListener (){//添加事件
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

		////////// **********//////////**********//////////**********//////////
		jComboBox_fermer_2.addItem("");
		jComboBox_fermer_2.setBounds(495, 130, 255, 30);
		jPanel_fermer.add(jComboBox_fermer_2);
		for(String s:list_troncon){
			jComboBox_fermer_2.addItem(s);
		}
		////////// **********//////////**********//////////**********//////////

		jTextField_fermer_3.setBounds(495, 170, 255, 30);
		jPanel_fermer.add(jTextField_fermer_3);

		jTextField_fermer_4.setBounds(495, 210, 255, 30);
		jPanel_fermer.add(jTextField_fermer_4);

		jTextArea_fermer_1.setText("Cause: ");
		jTextArea_fermer_1.setLineWrap(true);// 激活自动换行功能
		JScrollPane scrollPane_fermer_jTextArea_fermer_1 = new JScrollPane(jTextArea_fermer_1);// 添加滚动条
		getContentPane().add(scrollPane_fermer_jTextArea_fermer_1, BorderLayout.CENTER);
		scrollPane_fermer_jTextArea_fermer_1.setBounds(405, 250, 345, 120);
		scrollPane_fermer_jTextArea_fermer_1.setOpaque(false);
		jPanel_fermer.add(scrollPane_fermer_jTextArea_fermer_1);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_fermer = { "Code", /*"Autoroute", */"Tronçon", "Debut", "Fin", "Cause" };// 表格列名
		String[][] tableVales_fermer = {};// 数据

		DefaultTableModel defaultTableModel_fermer = new DefaultTableModel(tableVales_fermer, columnNames_fermer);
		fermes.Obtenir(defaultTableModel_fermer);
		JTable jTable_fermer = new JTable(defaultTableModel_fermer);

		jTable_fermer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选
		jTable_fermer.addMouseListener(new MouseAdapter() {// 添加鼠标事件
			public void mouseClicked(MouseEvent e) {
				int selectedRow = jTable_fermer.getSelectedRow();// 获得选中行索引
				Object object_a = defaultTableModel_fermer.getValueAt(selectedRow, 0);
				Object object_b = defaultTableModel_fermer.getValueAt(selectedRow, 1);
				Object object_c = defaultTableModel_fermer.getValueAt(selectedRow, 2);
				Object object_d = defaultTableModel_fermer.getValueAt(selectedRow, 3);
				Object object_e = defaultTableModel_fermer.getValueAt(selectedRow, 4);

				jTextField_fermer_1.setText(object_a.toString());// 给文本框赋值
				jComboBox_fermer_2.setSelectedItem(object_b.toString());
				jTextField_fermer_3.setText(object_c.toString());
				jTextField_fermer_4.setText(object_d.toString());
				jTextArea_fermer_1.setText(object_e.toString());
				FS=Integer.parseInt(object_a.toString());

			}
		});

		JScrollPane scrollPane_fermer = new JScrollPane(jTable_fermer);// 添加滚动条
		getContentPane().add(scrollPane_fermer, BorderLayout.CENTER);
		scrollPane_fermer.setBounds(50, 50, 345, 400);
		scrollPane_fermer.setOpaque(false);
		jPanel_fermer.add(scrollPane_fermer);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_fermer = new JButton("Ajouter");// 按钮"添加"
		addButton_fermer.setBounds(445, 420, 90, 30);
		jPanel_fermer.add(addButton_fermer);
		addButton_fermer.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				if (jTextField_fermer_1.getText().trim().length() < 1
						|| jComboBox_fermer_2.getSelectedItem().toString() == ""
						|| jTextField_fermer_3.getText().trim().length() < 1
						|| jTextField_fermer_4.getText().trim().length() < 1
						|| jTextArea_fermer_1.getText().trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de ajouter", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					fermes.Add(Integer.parseInt(jTextField_fermer_1.getText()), jComboBox_fermer_2.getSelectedItem().toString(),
							jTextField_fermer_3.getText(), jTextField_fermer_4.getText(), 
							jTextArea_fermer_1.getText());
					String[] rowValues = { jTextField_fermer_1.getText(),
							/* jTextField_fermer_2.getText(), */
							jComboBox_fermer_2.getSelectedItem().toString(), jTextField_fermer_3.getText(),
							jTextField_fermer_4.getText(), jTextArea_fermer_1.getText() };
					defaultTableModel_fermer.addRow(rowValues); // 添加一行
					jTextField_fermer_1.setText("");
					jComboBox_fermer_2.setSelectedItem("");
					jTextField_fermer_3.setText("");
					jTextField_fermer_4.setText("");
					jTextArea_fermer_1.setText("Cause: ");
				}
			}
		});

		final JButton updateButton_fermer = new JButton("Modifier");// 按钮"修改"
		updateButton_fermer.setBounds(545, 420, 90, 30);
		jPanel_fermer.add(updateButton_fermer);
		updateButton_fermer.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_fermer.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					if (jTextField_fermer_1.getText().trim().length() < 1
							|| jComboBox_fermer_2.getSelectedItem().toString() == ""
							|| jTextField_fermer_3.getText().trim().length() < 1
							|| jTextField_fermer_4.getText().trim().length() < 1
							|| jTextArea_fermer_1.getText().trim().length() < 1) {
						JOptionPane.showMessageDialog(null, "Des informations incompletes, impossible de modifier",
								"Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						fermes.Update(Integer.parseInt(jTextField_fermer_1.getText()), jComboBox_fermer_2.getSelectedItem().toString(),
								jTextField_fermer_3.getText(), jTextField_fermer_4.getText(), 
								jTextArea_fermer_1.getText(),FS);
						defaultTableModel_fermer.setValueAt(jTextField_fermer_1.getText(), selectedRow, 0);// 将表格中的值修改为输入框中的值
						/*
						 * defaultTableModel_fermer.setValueAt(
						 * jTextField_fermer_2.getText(), selectedRow, 1);//
						 * 将表格中的值修改为输入框中的值
						 */
						defaultTableModel_fermer.setValueAt(jComboBox_fermer_2.getSelectedItem().toString(),
								selectedRow, 1);// 将表格中的值修改为输入框中的值
						defaultTableModel_fermer.setValueAt(jTextField_fermer_3.getText(), selectedRow, 2);// 将表格中的值修改为输入框中的值
						defaultTableModel_fermer.setValueAt(jTextField_fermer_4.getText(), selectedRow, 3);// 将表格中的值修改为输入框中的值
						defaultTableModel_fermer.setValueAt(jTextArea_fermer_1.getText(), selectedRow, 4);// 将表格中的值修改为输入框中的值
						jTextField_fermer_1.setText("");
						jComboBox_fermer_2.setSelectedItem("");
						jTextField_fermer_3.setText("");
						jTextField_fermer_4.setText("");
						jTextArea_fermer_1.setText("Cause: ");
					}
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de modifier", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		final JButton delButton_fermer = new JButton("Supprimer");// 按钮"删除"
		delButton_fermer.setBounds(645, 420, 90, 30);
		jPanel_fermer.add(delButton_fermer);
		delButton_fermer.addActionListener(new ActionListener() {// 添加事件
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable_fermer.getSelectedRow();// 获得选中行的索引
				if (selectedRow != -1)// 判断是否存在选中行
				{
					fermes.Delete(FS);
					defaultTableModel_fermer.removeRow(selectedRow);// 删除选中行
					jTextField_fermer_1.setText("");
					jComboBox_fermer_2.setSelectedItem("");
					jTextField_fermer_3.setText("");
					jTextField_fermer_4.setText("");
					jTextArea_fermer_1.setText("Cause: ");
				} else
					JOptionPane.showMessageDialog(null, "Pas de choix, impossible de supprimer", "Erreur",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		//////////////////////////////////////////////////////////////////////
		// 888888888888888888888888888888888888888888888888888888888888888888//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 999999999999999999999999999999999999999999999999999999999999999999//
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
					int f=user.ChangePW(password_field_securite_1.getText(), password_field_securite_2.getText(),IDD);
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
		// 999999999999999999999999999999999999999999999999999999999999999999//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii//
		//////////////////////////////////////////////////////////////////////

		// 给第一个Jpanel添加背景
		ImageIcon imageIcon_bienvenue = new ImageIcon("images/D01.jpg");// 写入文件路径
		JLabel imageLabel_bienvenue = new JLabel(imageIcon_bienvenue);// 初始化JLabel
		jPanel_bienvenue.add(imageLabel_bienvenue);
		imageLabel_bienvenue.setBounds(0, 0, 800, 600);

		//////////////////////////////////////////////////////////////////////

		// 给第二个Jpanel添加背景
		ImageIcon imageIcon_ville = new ImageIcon("images/D02.jpg");// 写入文件路径
		JLabel imageLabel_ville = new JLabel(imageIcon_ville);// 初始化JLabel
		jPanel_ville.add(imageLabel_ville);
		imageLabel_ville.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第三个Jpanel添加背景
		ImageIcon imageIcon_autoroute = new ImageIcon("images/D03.jpg");// 写入文件路径
		JLabel imageLabel_autoroute = new JLabel(imageIcon_autoroute);// 初始化JLabel
		jPanel_autoroute.add(imageLabel_autoroute);
		imageLabel_autoroute.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第四个Jpanel添加背景
		ImageIcon imageIcon_node = new ImageIcon("images/D04.jpg");// 写入文件路径
		JLabel imageLabel_node = new JLabel(imageIcon_node);// 初始化JLabel
		imageLabel_node.setBounds(0, 0, 800, 600);
		jPanel_node.add(imageLabel_node);
		//////////////////////////////////////////////////////////////////////

		// 给第五个Jpanel添加背景
		ImageIcon imageIcon_tronçon = new ImageIcon("images/D05.jpg");// 写入文件路径
		JLabel imageLabel_tronçon = new JLabel(imageIcon_tronçon);// 初始化JLabel
		jPanel_tronçon.add(imageLabel_tronçon);
		imageLabel_tronçon.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第六个Jpanel添加背景
		ImageIcon imageIcon_societe = new ImageIcon("images/D06.jpg");// 写入文件路径
		JLabel imageLabel_societe = new JLabel(imageIcon_societe);// 初始化JLabel
		jPanel_societe.add(imageLabel_societe);
		imageLabel_societe.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第七个Jpanel添加背景
		ImageIcon imageIcon_peage = new ImageIcon("images/D07.jpg");// 写入文件路径
		JLabel imageLabel_peage = new JLabel(imageIcon_peage);// 初始化JLabel
		jPanel_peage.add(imageLabel_peage);
		imageLabel_peage.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第八个Jpanel添加背景
		ImageIcon imageIcon_fermer = new ImageIcon("images/D08.jpg");// 写入文件路径
		JLabel imageLabel_fermer = new JLabel(imageIcon_fermer);// 初始化JLabel
		jPanel_fermer.add(imageLabel_fermer);
		imageLabel_fermer.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第九个Jpanel添加背景
		ImageIcon imageIcon_securite = new ImageIcon("images/D09.jpg");// 写入文件路径
		JLabel imageLabel_securite = new JLabel(imageIcon_securite);// 初始化JLabel
		jPanel_securite.add(imageLabel_securite);
		imageLabel_securite.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii//
		//////////////////////////////////////////////////////////////////////

	}

	public static void main(String[] args) {
		new Documentaliste("3");
	}
}
