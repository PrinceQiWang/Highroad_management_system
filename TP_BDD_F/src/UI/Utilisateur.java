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

import Classe.GraphByMatrix;
import Classe.Node;
import Classe.Routes;
import Classe.Societe;
import Classe.Troncon;
import Classe.Ville;
import Dao.UserDao;

import Dao.VilleDao;
import Dao.SocieteDao;
import Dao.UserDao;
import Dao.FermesDao;
import Dao.NodeDao;
import Dao.PeageDao;
import Dao.RoutesDao;
import Dao.TronconDao;

public class Utilisateur extends JFrame {
	private VilleDao ville=new VilleDao();
	private RoutesDao route=new RoutesDao();
	private SocieteDao societe=new SocieteDao();
	private FermesDao fermes=new FermesDao();
	private NodeDao node=new NodeDao();
	private PeageDao peage=new PeageDao();
	private TronconDao troncon=new TronconDao();
	private UserDao user=new UserDao();
	
	public ArrayList<Integer> parcour(String str1,String str2) throws Exception{
		str1=ville.cherchenode(str1);
		str2=ville.cherchenode(str2);
		ArrayList<Node> list_node=node.NodeList();
		GraphByMatrix g=new GraphByMatrix(false,true,list_node.size());
		for(Node n:list_node){
			g.addVertex(n.getCodP());
		}
		ArrayList<Troncon> list_troncon=troncon.List();
		for(Troncon t:list_troncon){
			try {
				g.addEdge(t.getNodeP(), t.getNodeT(),t.getTKm());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<Object> par=g.Dijkstra(str1,str2);
		ArrayList<Integer> parcour=new ArrayList<Integer>();
		
		for(int i=par.size()-2;i>=0;i--){
			Object o=par.get(i);
			int j=peage.cherchepeage((String)o);
			if(j!=-1){
				parcour.add(j);
			}
		}
		parcour.add((int)par.get(par.size()-1));
		
		return parcour;
	}
	public Utilisateur(String IDU) {

		JTextField jTextField_ville_1 = new JTextField();
		
		JTextField jTextField_peage_1 = new JTextField();
		JTextField jTextField_peage_2 = new JTextField();
		JTextField jTextField_peage_3 = new JTextField();
		JTextField jTextField_peage_4 = new JTextField();
		JTextField jTextField_peage_5 = new JTextField();
		JTextField jTextField_peage_6 = new JTextField();
		
		JTextField jTextField_fermer_1 = new JTextField();
		JTextField jTextField_fermer_2 = new JTextField();
		JTextField jTextField_fermer_3 = new JTextField();
		JTextField jTextField_fermer_4 = new JTextField();

		JTextArea jTextArea_fermer_1 = new JTextArea();
	
		JComboBox<String> jComboBox_ville_1 = new JComboBox<String>();
		JComboBox<String> jComboBox_ville_2 = new JComboBox<String>();
		JComboBox<String> jComboBox_peage_1 = new JComboBox<String>();
		JComboBox<String> jComboBox_peage_2 = new JComboBox<String>();
		JComboBox<String> jComboBox_fermer_1 = new JComboBox<String>();
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
					jComboBox_ville_1.setSelectedItem("");
					jComboBox_ville_2.setSelectedItem("");
					jTextField_ville_1.setText("");	
				}
					break;
				case 2: {
					jComboBox_peage_1.setSelectedItem("");
					jComboBox_peage_2.setSelectedItem("");
					jTextField_peage_1.setText("");
					jTextField_peage_2.setText("");
					jTextField_peage_3.setText("");
					jTextField_peage_6.setText("");
					jTextField_peage_4.setText("");
					jTextField_peage_5.setText("");
				}
					break;
				case 3: {					
					jComboBox_fermer_1.setSelectedItem("");
					jComboBox_fermer_2.setSelectedItem("");
					jTextField_fermer_1.setText("");
					jTextField_fermer_2.setText("");
					jTextField_fermer_3.setText("");
					jTextField_fermer_4.setText("");
					jTextArea_fermer_1.setText("Cause: ");
				}
					break;
				case 4: {
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
		final JPanel jPanel_ville = new JPanel();
		jPanel_ville.setLayout(null);
		jTabbedPane.addTab("Parcours", null, jPanel_ville, null);// 加入第二个页面

		// 第三个标签下的JPanel
		final JPanel jPanel_peage = new JPanel();
		jPanel_peage.setLayout(null);
		jTabbedPane.addTab("Peage", null, jPanel_peage, null);// 加入第三个页面

		// 第四个标签下的JPanel
		final JPanel jPanel_fermer = new JPanel();
		jPanel_fermer.setLayout(null);
		jTabbedPane.addTab("Fermeture", null, jPanel_fermer, null);// 加入第四个页面

		// 第五个标签下的JPanel
		final JPanel jPanel_securite = new JPanel();
		jPanel_securite.setLayout(null);
		jTabbedPane.addTab("Securite", null, jPanel_securite, null);// 加入第五个页面

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

		JLabel jLabel_ville_1 = new JLabel("Le point de depart:");
		jLabel_ville_1.setBounds(405, 90, 150, 30);
		jPanel_ville.add(jLabel_ville_1);

		JLabel jLabel_ville_2 = new JLabel("La destination:");
		jLabel_ville_2.setBounds(405, 130, 150, 30);
		jPanel_ville.add(jLabel_ville_2);

		JLabel jLabel_ville_3 = new JLabel("Depart:");
		jLabel_ville_3.setBounds(405, 170, 150, 30);
		jPanel_ville.add(jLabel_ville_3);

//		jTextField_ville_1.setBounds(495, 90, 255, 30);
//		jPanel_ville.add(jTextField_ville_1);
		
		////////// **********//////////**********//////////**********//////////
		jComboBox_ville_1.addItem("");
		jComboBox_ville_1.setBounds(545, 90, 205, 30);
		jPanel_ville.add(jComboBox_ville_1);
		////////// **********//////////**********//////////**********//////////

//		jTextField_ville_2.setBounds(495, 130, 255, 30);
//		jPanel_ville.add(jTextField_ville_2);
		
		////////// **********//////////**********//////////**********//////////
		jComboBox_ville_2.addItem("");
		jComboBox_ville_2.setBounds(545, 130, 205, 30);
		jPanel_ville.add(jComboBox_ville_2);
		////////// **********//////////**********//////////**********//////////
		ArrayList<Ville> list_ville=ville.VilleList();
		for(Ville v:list_ville){
			jComboBox_ville_1.addItem(v.getNomV());
			jComboBox_ville_2.addItem(v.getNomV());
		}
		
		jTextField_ville_1.setBounds(545, 170, 205, 30);
		jPanel_ville.add(jTextField_ville_1);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_ville = { "nombre d'ordre", "Peage" };// 表格列名
		String[][] tableVales_ville = {};// 数据
		
		DefaultTableModel defaultTableModel_ville = new DefaultTableModel(tableVales_ville, columnNames_ville);
		JTable jTable_ville = new JTable(defaultTableModel_ville);

		final JButton Button = new JButton("Calculer");
		Button.setBounds(545, 420, 90, 30);
		Button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				while(defaultTableModel_ville.getRowCount()>0){
					defaultTableModel_ville.removeRow(defaultTableModel_ville.getRowCount()-1);
					}
				try {
					ArrayList<Integer> l=parcour(jComboBox_ville_1.getSelectedItem().toString(),jComboBox_ville_2.getSelectedItem().toString());
					for(int i=0;i<l.size()-1;i++){
						String[] str={String.valueOf(i+1),String.valueOf(l.get(i))};
						defaultTableModel_ville.addRow(str);
					}
					jTextField_ville_1.setText(String.valueOf(l.get(l.size()-1)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		jPanel_ville.add(Button);
		
		jTable_ville.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 表格中可进行单选

		JScrollPane scrollPane_ville = new JScrollPane(jTable_ville);// 添加滚动条
		getContentPane().add(scrollPane_ville, BorderLayout.CENTER);
		scrollPane_ville.setBounds(50, 50, 345, 400);
		scrollPane_ville.setOpaque(false);
		jPanel_ville.add(scrollPane_ville);

		//////////////////////////////////////////////////////////////////////

		final JButton addButton_ville = new JButton("rechercher");// 按钮"添加"
		addButton_ville.setBounds(545, 420, 90, 30);
		jPanel_ville.add(addButton_ville);

		//////////////////////////////////////////////////////////////////////
		// 222222222222222222222222222222222222222222222222222222222222222222//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 333333333333333333333333333333333333333333333333333333333333333333//
		//////////////////////////////////////////////////////////////////////
	
		JLabel jLabel_peage_1 = new JLabel("Societe:");
		jLabel_peage_1.setBounds(405, 90, 100, 30);
		jPanel_peage.add(jLabel_peage_1);
		
		JLabel jLabel_peage_2 = new JLabel("Autoroute:");
		jLabel_peage_2.setBounds(405, 130, 100, 30);
		jPanel_peage.add(jLabel_peage_2);

		JLabel jLabel_peage_3 = new JLabel("Code:");
		jLabel_peage_3.setBounds(405, 210, 100, 30);
		jPanel_peage.add(jLabel_peage_3);

		JLabel jLabel_peage_4 = new JLabel("Societe:");
		jLabel_peage_4.setBounds(405, 250, 100, 30);
		jPanel_peage.add(jLabel_peage_4);

		JLabel jLabel_peage_5 = new JLabel("Frais:");
		jLabel_peage_5.setBounds(405, 290, 100, 30);
		jPanel_peage.add(jLabel_peage_5);
		
		JLabel jLabel_peage_8 = new JLabel("Gain pour 100:");
		jLabel_peage_8.setBounds(405, 330, 100, 30);
		jPanel_peage.add(jLabel_peage_8);

		JLabel jLabel_peage_6 = new JLabel("Date de debut:");
		jLabel_peage_6.setBounds(405, 370, 100, 30);
		jPanel_peage.add(jLabel_peage_6);

		JLabel jLabel_peage_7 = new JLabel("Date de fin:");
		jLabel_peage_7.setBounds(405, 410, 100, 30);
		jPanel_peage.add(jLabel_peage_7);

		////////// **********//////////**********//////////**********//////////
		jComboBox_peage_1.addItem("");
		jComboBox_peage_1.setBounds(495, 90, 255, 30);
		jPanel_peage.add(jComboBox_peage_1);
		ArrayList<Societe> list_societe=societe.SocieteList();
		for(Societe n:list_societe){
			jComboBox_peage_1.addItem(n.getNomS());
		}
		////////// **********//////////**********//////////**********//////////
		////////// **********//////////**********//////////**********//////////
		jComboBox_peage_2.addItem("");
		jComboBox_peage_2.setBounds(495, 130, 255, 30);
		jPanel_peage.add(jComboBox_peage_2);
		ArrayList<Routes> list_routes =route.List();
		for(Routes n:list_routes){
			jComboBox_peage_2.addItem(n.getCodR());
		}
		////////// **********//////////**********//////////**********//////////
		
		jTextField_peage_1.setBounds(495, 210, 255, 30);
		jPanel_peage.add(jTextField_peage_1);

		jTextField_peage_2.setBounds(495, 250, 255, 30);
		jPanel_peage.add(jTextField_peage_2);

		jTextField_peage_3.setBounds(495, 290, 255, 30);
		jPanel_peage.add(jTextField_peage_3);
		
		jTextField_peage_4.setBounds(495, 330, 255, 30);
		jPanel_peage.add(jTextField_peage_4);

		jTextField_peage_5.setBounds(495, 370, 255, 30);
		jPanel_peage.add(jTextField_peage_5);
		 
		jTextField_peage_6.setBounds(495, 410, 255, 30);
			jPanel_peage.add(jTextField_peage_6);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_peage = { "Code", "Autoroute", "Societe", "Frais", "Debut", "Fin" };// 表格列名
		String[][] tableVales_peage = {};// 数据

		DefaultTableModel defaultTableModel_peage = new DefaultTableModel(tableVales_peage, columnNames_peage);
		JTable jTable_peage = new JTable(defaultTableModel_peage);
		peage.Obtenir(defaultTableModel_peage);
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

				//jComboBox_peage_1.setSelectedItem(object_d.toString());// 给文本框赋值
				jComboBox_peage_2.setSelectedItem(object_b.toString());
				jTextField_peage_1.setText(object_a.toString());
				jTextField_peage_2.setText(object_c.toString());
				jTextField_peage_3.setText(object_d.toString());
				jTextField_peage_4.setText(String.valueOf(Integer.parseInt(object_d.toString())*10));
				jTextField_peage_5.setText(object_e.toString());
				jTextField_peage_6.setText(object_f.toString());
			}
		});

		JScrollPane scrollPane_peage = new JScrollPane(jTable_peage);// 添加滚动条
		getContentPane().add(scrollPane_peage, BorderLayout.CENTER);
		scrollPane_peage.setBounds(50, 50, 345, 400);
		scrollPane_peage.setOpaque(false);
		jPanel_peage.add(scrollPane_peage);

		//////////////////////////////////////////////////////////////////////
		//333333333333333333333333333333333333333333333333333333333333333333//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		//444444444444444444444444444444444444444444444444444444444444444444//
		//////////////////////////////////////////////////////////////////////
		JLabel jLabel_fermer_1 = new JLabel("Autoroute:");
		jLabel_fermer_1.setBounds(405, 90, 100, 30);
		jPanel_fermer.add(jLabel_fermer_1);
		
		JLabel jLabel_fermer_2 = new JLabel("Code:");
		jLabel_fermer_2.setBounds(405, 170, 100, 30);
		jPanel_fermer.add(jLabel_fermer_2);

		JLabel jLabel_fermer_5 = new JLabel("Tronçon:");
		jLabel_fermer_5.setBounds(405, 210, 100, 30);
		jPanel_fermer.add(jLabel_fermer_5);

		JLabel jLabel_fermer_3 = new JLabel("Date de debut:");
		jLabel_fermer_3.setBounds(405, 250, 100, 30);
		jPanel_fermer.add(jLabel_fermer_3);

		JLabel jLabel_fermer_4 = new JLabel("Date de fin:");
		jLabel_fermer_4.setBounds(405, 290, 100, 30);
		jPanel_fermer.add(jLabel_fermer_4);
		
		////////// **********//////////**********//////////**********//////////
		jComboBox_fermer_1.addItem("");
		jComboBox_fermer_1.setBounds(495, 90, 255, 30);
		jPanel_fermer.add(jComboBox_fermer_1);
		for(Routes n:list_routes){
			jComboBox_fermer_1.addItem(n.getCodR());
		}
		////////// **********//////////**********//////////**********//////////	 
		
		jTextField_fermer_1.setBounds(495, 170, 255, 30);
		jPanel_fermer.add(jTextField_fermer_1);
		jTextField_fermer_1.setEditable(false);
		
		jTextField_fermer_2.setBounds(495, 210, 255, 30);
		jPanel_fermer.add(jTextField_fermer_2);
		jTextField_fermer_2.setEditable(false);

		jTextField_fermer_3.setBounds(495, 250, 255, 30);
		jPanel_fermer.add(jTextField_fermer_3);
		jTextField_fermer_3.setEditable(false);

		jTextField_fermer_4.setBounds(495, 290, 255, 30);
		jPanel_fermer.add(jTextField_fermer_4);
		jTextField_fermer_4.setEditable(false);

		jTextArea_fermer_1.setText("Cause: ");
		jTextArea_fermer_1.setEditable(false);
		jTextArea_fermer_1.setLineWrap(true);// 激活自动换行功能
		JScrollPane scrollPane_fermer_jTextArea_fermer_1 = new JScrollPane(jTextArea_fermer_1);// 添加滚动条
		getContentPane().add(scrollPane_fermer_jTextArea_fermer_1, BorderLayout.CENTER);
		scrollPane_fermer_jTextArea_fermer_1.setBounds(405, 330, 345, 120);
		scrollPane_fermer_jTextArea_fermer_1.setOpaque(false);
		jPanel_fermer.add(scrollPane_fermer_jTextArea_fermer_1);

		//////////////////////////////////////////////////////////////////////

		String[] columnNames_fermer = { "Code", "Tronçon", "Debut", "Fin", "Cause" };// 表格列名
		String[][]tableVales_fermer = {};// 数据

		DefaultTableModel defaultTableModel_fermer = new DefaultTableModel(tableVales_fermer, columnNames_fermer);
		JTable jTable_fermer = new JTable(defaultTableModel_fermer);
		fermes.Obtenir(defaultTableModel_fermer);
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
				jTextField_fermer_2.setText(object_b.toString());
				jTextField_fermer_3.setText(object_c.toString());
				jTextField_fermer_4.setText(object_d.toString());
				jTextArea_fermer_1.setText(object_e.toString());
			}
		});

		JScrollPane scrollPane_fermer = new JScrollPane(jTable_fermer);// 添加滚动条
		getContentPane().add(scrollPane_fermer, BorderLayout.CENTER);
		scrollPane_fermer.setBounds(50, 50, 345, 400);
		scrollPane_fermer.setOpaque(false);
		jPanel_fermer.add(scrollPane_fermer);
		
		//////////////////////////////////////////////////////////////////////
		// 444444444444444444444444444444444444444444444444444444444444444444//
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// 555555555555555555555555555555555555555555555555555555555555555555//
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
					int f=user.ChangePW(password_field_securite_1.getText(), password_field_securite_2.getText(),IDU);
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
		// 555555555555555555555555555555555555555555555555555555555555555555//
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
		ImageIcon imageIcon_ville = new ImageIcon("images/U02.jpg");// 写入文件路径
		JLabel imageLabel_ville = new JLabel(imageIcon_ville);// 初始化JLabel
		jPanel_ville.add(imageLabel_ville);
		imageLabel_ville.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第三个Jpanel添加背景
		ImageIcon imageIcon_peage = new ImageIcon("images/U03.jpg");// 写入文件路径
		JLabel imageLabel_peage = new JLabel(imageIcon_peage);// 初始化JLabel
		jPanel_peage.add(imageLabel_peage);
		imageLabel_peage.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第四个Jpanel添加背景
		ImageIcon imageIcon_fermer = new ImageIcon("images/U04.jpg");// 写入文件路径
		JLabel imageLabel_fermer = new JLabel(imageIcon_fermer);// 初始化JLabel
		jPanel_fermer.add(imageLabel_fermer);
		imageLabel_fermer.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		// 给第五个Jpanel添加背景
		ImageIcon imageIcon_securite = new ImageIcon("images/U05.jpg");// 写入文件路径
		JLabel imageLabel_securite = new JLabel(imageIcon_securite);// 初始化JLabel
		jPanel_securite.add(imageLabel_securite);
		imageLabel_securite.setBounds(0, 0, 800, 600);
		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////
		// iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii//
		//////////////////////////////////////////////////////////////////////

	}

	public static void main(String[] args) {
		new Utilisateur("1");
	}
}
