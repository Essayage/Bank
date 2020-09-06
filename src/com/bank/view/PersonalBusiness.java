package com.bank.view;
//处理个人业务时要实现的2级界面，功能有：1查询账户信息，2存储钱款，3取出金钱，4转账，5开立新户，6修改密码，使用卡片界面

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.bank.controller.UserOperator;
import com.bank.entity.User;

public class PersonalBusiness {
	CardLayout card = new CardLayout();
	JPanel panel = new JPanel();
	private int flag = 0;
	private User user;

	public PersonalBusiness(int cno) {
		JFrame frameIndex = new JFrame();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(245, 255, 250));

		menuBar.setPreferredSize(new Dimension(40, 60));

		final JMenu search = new JMenu("查询账户信息");
		search.setBackground(new Color(240, 255, 240));
		search.setFont(new Font("宋体", Font.BOLD, 20));
		search.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				card.show(panel, "searchPanel");
			}
		});
		menuBar.add(search);

		JMenu save = new JMenu("存/取钱款");
		save.setFont(new Font("宋体", Font.BOLD, 20));

		save.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object[] obj2 = { "存款", "取款" };
				String string = (String) JOptionPane.showInputDialog(null, "请做出选择:\n", "存/取金额",
						JOptionPane.PLAIN_MESSAGE, new ImageIcon("src//1.jpg"), obj2, "存款");
				if (string != null) {
					if ("存款".equals(string) || "取款".equals(string)) {
						card.show(panel, "addPanel");
						if ("存款".equals(string)) {
							flag = 1;
						} else {
							flag = 2;
						}
					} else
						card.show(panel, "searchPanel");
				}
			}
		});

		menuBar.add(save);

		JMenu zz = new JMenu("转账");
		zz.setFont(new Font("宋体", Font.BOLD, 20));
		zz.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				card.show(panel, "zzPanel");
			}
		});
		menuBar.add(zz);

		JMenu kh = new JMenu("开户");
		kh.setFont(new Font("宋体", Font.BOLD, 20));
		kh.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				card.show(panel, "khPanel");
			}
		});
		menuBar.add(kh);

		JMenu xg = new JMenu("修改密码");
		xg.setFont(new Font("宋体", Font.BOLD, 20));
		xg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				card.show(panel, "xgPanel");
			}
		});
		menuBar.add(xg);

		frameIndex.setJMenuBar(menuBar);
		panel.setBackground(Color.WHITE);

		// 添加面板
		panel.setLayout(card);

		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(240, 255, 240));
		searchPanel.setLayout(null);
		// 添加表格组件
		// 定义二维数组作为表格数据

		// 添加存/取钱面板
		JPanel addPanel = new JPanel();
		addPanel.setBackground(new Color(240, 255, 240));
		addPanel.setLayout(null);

		// 添加转账面板
		JPanel zzPanel = new JPanel();
		zzPanel.setBackground(new Color(240, 255, 240));
		zzPanel.setLayout(null);

		// 修改密码面板
		JPanel xgPanel = new JPanel();
		xgPanel.setBackground(new Color(240, 255, 240));
		xgPanel.setLayout(null);

		// 开户面板
		JPanel khPanel = new JPanel();
		khPanel.setBackground(new Color(240, 255, 240));
		khPanel.setLayout(null);

		// 开户界面添加组件
		JLabel txsfzh_label = new JLabel("身份证号:");
		txsfzh_label.setFont(new Font("宋体", Font.BOLD, 20));
		txsfzh_label.setBounds(160, 30, 96, 40);
		khPanel.add(txsfzh_label);
		final JTextField txsfzh_field = new JTextField();
		txsfzh_field.setPreferredSize(new Dimension(430, 28));
		txsfzh_field.setBounds(270, 37, 200, 30);
		khPanel.add(txsfzh_field);

		JLabel yhID_label = new JLabel("用户名称:");
		yhID_label.setFont(new Font("宋体", Font.BOLD, 20));
		yhID_label.setBounds(160, 100, 100, 40);
		khPanel.add(yhID_label);
		final JTextField yhID_field = new JTextField();
		yhID_field.setPreferredSize(new Dimension(430, 28));
		yhID_field.setBounds(270, 107, 200, 30);
		khPanel.add(yhID_field);

		JLabel mm_label = new JLabel("用户密码:");
		mm_label.setFont(new Font("宋体", Font.BOLD, 20));
		mm_label.setBounds(160, 170, 96, 40);
		khPanel.add(mm_label);
		final JTextField mm_field = new JTextField();
		mm_field.setPreferredSize(new Dimension(430, 28));
		mm_field.setBounds(270, 177, 200, 30);
		khPanel.add(mm_field);

		JLabel choice = new JLabel("选择用户类型:");
		choice.setFont(new Font("宋体", Font.BOLD, 20));
		choice.setBounds(110, 241, 142, 45);
		khPanel.add(choice);

		// 查询用户信息界面添加组件
		user = UserOperator.find(cno);
		JLabel kh2_label = new JLabel("卡号:");
		kh2_label.setFont(new Font("宋体", Font.BOLD, 20));
		kh2_label.setBounds(240, 10, 100, 100);
		searchPanel.add(kh2_label);
		TextField userCno = new TextField();
		String userC = null;
		if (user != null) {
			userC = user.getID() + "";
		}

		userCno.setText(userC);
		userCno.setFont(new Font("宋体", Font.BOLD, 20));
		userCno.setBounds(340, 50, 150, 30);
		searchPanel.add(userCno);

		JLabel yhmc_label = new JLabel("用户名称:");
		yhmc_label.setFont(new Font("宋体", Font.BOLD, 20));
		yhmc_label.setBounds(200, 50, 100, 100);
		searchPanel.add(yhmc_label);
		TextField userName = new TextField();
		if (user != null) {
			userName.setText(user.getName());
		}
		userName.setFont(new Font("宋体", Font.BOLD, 20));
		userName.setBounds(340, 88, 150, 30);
		searchPanel.add(userName);

		JLabel sfzh_label = new JLabel("身份证号:");
		sfzh_label.setFont(new Font("宋体", Font.BOLD, 20));
		sfzh_label.setBounds(200, 90, 100, 100);
		searchPanel.add(sfzh_label);
		TextField userID = new TextField();
		if (user != null) {
			userID.setText(user.getIDNo());
		}
		userID.setFont(new Font("宋体", Font.BOLD, 20));
		userID.setBounds(340, 126, 150, 30);
		searchPanel.add(userID);

		JLabel kzbh_label = new JLabel("卡折编号:");
		kzbh_label.setFont(new Font("宋体", Font.BOLD, 20));
		kzbh_label.setBounds(200, 130, 100, 100);
		searchPanel.add(kzbh_label);
		TextField userPno = new TextField();
		if (user != null) {
			userPno.setText(user.getPno());
		}
		userPno.setFont(new Font("宋体", Font.BOLD, 20));
		userPno.setBounds(340, 164, 150, 30);
		searchPanel.add(userPno);

		JLabel zhye_label = new JLabel("账户余额:");
		zhye_label.setFont(new Font("宋体", Font.BOLD, 20));
		zhye_label.setBounds(200, 170, 100, 100);
		searchPanel.add(zhye_label);
		String ac = null;
		if (user != null) {
			ac = user.getAmount() + "";
		}
		TextField userAmount = new TextField();
		userAmount.setText(ac);
		userAmount.setFont(new Font("宋体", Font.BOLD, 20));
		userAmount.setBounds(340, 205, 150, 30);
		searchPanel.add(userAmount);

		JLabel type_label = new JLabel("用户类型:");
		type_label.setFont(new Font("宋体", Font.BOLD, 20));
		type_label.setBounds(200, 210, 100, 100);
		searchPanel.add(type_label);
		TextField userType = new TextField();
		if (user != null) {
			userType.setText(user.getType());
		}
		userType.setFont(new Font("宋体", Font.BOLD, 20));
		userType.setBounds(340, 246, 150, 30);
		searchPanel.add(userType);

		// 修改密码界面添加组件

		JLabel ymm_label = new JLabel("原密码:");
		ymm_label.setFont(new Font("宋体", Font.BOLD, 20));
		ymm_label.setBounds(188, 49, 84, 40);
		xgPanel.add(ymm_label);
		final JTextField ymm_field = new JTextField();
		ymm_field.setPreferredSize(new Dimension(430, 28));
		ymm_field.setBounds(286, 56, 200, 30);
		xgPanel.add(ymm_field);

		JLabel xmm_label = new JLabel("新密码:");
		xmm_label.setFont(new Font("宋体", Font.BOLD, 20));
		xmm_label.setBounds(188, 119, 84, 40);
		xgPanel.add(xmm_label);
		final JTextField xmm_field = new JTextField();
		xmm_field.setPreferredSize(new Dimension(430, 28));
		xmm_field.setBounds(286, 126, 200, 30);
		xgPanel.add(xmm_field);

		// 转账界面添加组件
		JLabel ykh_label = new JLabel("转账卡号:");
		ykh_label.setFont(new Font("宋体", Font.BOLD, 20));
		ykh_label.setBounds(160, 44, 100, 43);
		zzPanel.add(ykh_label);
		final JTextField ykh_field = new JTextField();
		ykh_field.setPreferredSize(new Dimension(430, 28));
		ykh_field.setBounds(292, 52, 200, 30);
		zzPanel.add(ykh_field);

		JLabel xkh_label = new JLabel("密码:");
		xkh_label.setFont(new Font("宋体", Font.BOLD, 20));
		xkh_label.setBounds(200, 109, 60, 43);
		zzPanel.add(xkh_label);
		final JTextField xkh_field = new JTextField();
		xkh_field.setPreferredSize(new Dimension(430, 28));
		xkh_field.setBounds(292, 117, 200, 30);
		zzPanel.add(xkh_field);

		JLabel zzje_label = new JLabel("转账金额:");
		zzje_label.setFont(new Font("宋体", Font.BOLD, 20));
		zzje_label.setBounds(165, 169, 95, 43);
		zzPanel.add(zzje_label);
		final JTextField zzje_field = new JTextField();
		zzje_field.setPreferredSize(new Dimension(430, 28));
		zzje_field.setBounds(292, 177, 200, 30);
		zzPanel.add(zzje_field);

		// 存取款界面添加组件

		JLabel yhmm_label = new JLabel("用户密码:");
		yhmm_label.setFont(new Font("宋体", Font.BOLD, 20));
		yhmm_label.setBounds(196, 28, 100, 100);
		addPanel.add(yhmm_label);
		final JTextField yhmm_field = new JTextField();
		yhmm_field.setBounds(318, 65, 200, 30);
		yhmm_field.setPreferredSize(new Dimension(430, 28));
		addPanel.add(yhmm_field);

		JLabel je_label = new JLabel("金额:");
		je_label.setFont(new Font("宋体", Font.BOLD, 20));
		je_label.setBounds(236, 88, 100, 100);
		addPanel.add(je_label);
		final JTextField je_field = new JTextField();
		je_field.setBounds(318, 125, 200, 30);
		je_field.setPreferredSize(new Dimension(430, 28));
		addPanel.add(je_field);

		JButton btn = new JButton("确定");// 添加按钮
		btn.setBackground(new Color(152, 251, 152));
		JButton btn1 = new JButton("确定");// 添加按钮
		btn1.setBackground(new Color(152, 251, 152));
		JButton btn2 = new JButton("确定");// 添加按钮
		btn2.setBackground(new Color(144, 238, 144));
		JButton btn3 = new JButton("普通用户");// 添加按钮
		btn3.setBackground(new Color(152, 251, 152));
		JButton btn4 = new JButton("VIP用户");
		btn4.setBackground(new Color(152, 251, 152));

		btn.setBounds(354, 191, 122, 30);
		addPanel.add(btn);
		btn.addActionListener(new ActionListener() {// 存钱/取钱事件

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String password = yhmm_field.getText();
				String str = je_field.getText();
				int num = Integer.parseInt(str);
				int i = UserOperator.verification(cno, password);
				if (i > 0 && flag == 1) {
					UserOperator.deposit(cno, num);
					user = UserOperator.find(cno);
					String acc = user.getAmount() + "";
					userAmount.setText(acc);
					JOptionPane.showMessageDialog(null, "存款成功！", "恭喜", JOptionPane.INFORMATION_MESSAGE);
				} else if (i > 0 && flag == 2) {
					if (user.getAmount() >= num) {
						UserOperator.withdraw(cno, num);
						user = UserOperator.find(cno);
						String acc = user.getAmount() + "";
						userAmount.setText(acc);
						JOptionPane.showMessageDialog(null, "取款成功！", "恭喜", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "账户余额不足！", "警告", JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "密码错误！", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btn1.setBounds(324, 190, 126, 30);// btn1的绝对定位
		xgPanel.add(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String password = ymm_field.getText();
				String newPassword = xmm_field.getText();
				int i = UserOperator.verification(cno, password);
				if (i > 0) {
					UserOperator.updatePassword(cno, newPassword);
					JOptionPane.showMessageDialog(null, "密码修改成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "密码错误", "警告", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btn2.setBounds(336, 239, 128, 30);// btn2的绝对定位
		zzPanel.add(btn2);
		btn2.addActionListener(new ActionListener() {// 转账事件

			@Override
			public void actionPerformed(ActionEvent e) {
				String account2 = ykh_field.getText();
				int cno2 = Integer.parseInt(account2);
				String password = xkh_field.getText();
				String str = zzje_field.getText();
				System.out.println(str);
				int num = Integer.parseInt(str);
				int i = UserOperator.verification(cno, password);
				if (i > 0) {
					if (UserOperator.find(cno2) != null) {
						if (user.getAmount() >= num) {
							UserOperator.transfer(cno, cno2, num);
							user = UserOperator.find(cno);
							String acc = user.getAmount() + "";
							userAmount.setText(acc);
							JOptionPane.showMessageDialog(null, "转账成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "账户余额不足！", "警告", JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "该卡号不存在", "警告", JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "密码错误", "警告", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btn3.setBounds(270, 245, 100, 40);
		khPanel.add(btn3);
		btn3.addActionListener(new ActionListener() {// 开户（普通用户）

			@Override
			public void actionPerformed(ActionEvent e) {

				String IDno = txsfzh_field.getText();
				String name = yhID_field.getText();
				String password = mm_field.getText();
				String type = "common";
				if (!"".equals(IDno) && !"".equals(name) && !"".equals(password)) {
					UserOperator.saveUser(name, IDno, password, type);
					JOptionPane.showMessageDialog(null, "开户成功！\r\n卡号：" + UserOperator.findUserID(IDno).getID(), "恭喜",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "身份证号、姓名或密码为空", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btn4.setBounds(414, 245, 100, 41);
		khPanel.add(btn4);
		btn4.addActionListener(new ActionListener() {// 开户（VIP）

			@Override
			public void actionPerformed(ActionEvent e) {
				String IDno = txsfzh_field.getText();
				String name = yhID_field.getText();
				String password = mm_field.getText();
				String type = "vip";
				if (!"".equals(IDno) && !"".equals(name) && !"".equals(password)) {
					UserOperator.saveUser(name, IDno, password, type);
					JOptionPane.showMessageDialog(null, "开户成功！\r\n卡号：" + UserOperator.findUserID(IDno).getID(), "恭喜",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "身份证号、姓名或密码为空", "警告", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		panel.add(searchPanel, "searchPanel");
		panel.add(addPanel, "addPanel");
		panel.add(zzPanel, "zzPanel");
		panel.add(xgPanel, "xgPanel");
		panel.add(khPanel, "khPanel");

		frameIndex.getContentPane().add(panel, BorderLayout.CENTER);
		frameIndex.setSize(750, 500);// 设置窗口的大小

		frameIndex.setLocation(500, 100);// 设置坐标
		frameIndex.setResizable(false);// 设置是否可以改变窗体大小
		frameIndex.setIconImage(Toolkit.getDefaultToolkit().createImage("src/2.jpg"));// 设置窗体左上角显示的图片
		//frameIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 添加窗体关闭事件
		frameIndex.setVisible(true);// 设置窗口是否可见
	}

}