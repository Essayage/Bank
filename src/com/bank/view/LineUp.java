package com.bank.view;
//选择业务排队界面，生成排队号:v（是否vip，不是则p）1（1：现金业务，2：转账业务，3：开户业务，4：对公业务，5：特色业务，6：其他业务）001（顺序号）

import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.JOptionPane;

import com.bank.controller.DispOperator;
import com.bank.controller.PersonOperator;
import com.bank.controller.UserOperator;
import com.bank.entity.Person;
import com.bank.entity.Queue;
import com.bank.service.PersonService;
import com.bank.service.PersonServiceImpl;
import com.bank.util.GetUserMesg;
import com.bank.util.ServiceDispatchImpl;

//需要从user表中读取用户信息比较是否为vip

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LineUp extends Application {
	PersonOperator personOperator;
	String qNo = null;// qNo，person实体的排队号
	int cNo = -1;// cNo,person实体的卡号
	String type = null; // 用户类型,是否vip：“vip”或者“common”
	int userId = 1;// person实体的顺序号，从1开始加
	private String businessType;// 业务类型:( '1'(现金） '2'（转账） '3'（开户）)（个人业务1） '4'（对公2） '5'（特色3）
	DispOperator dispch = new DispOperator();

	public void start(Stage primaryStage) {//主Stage传给此方法显示
		primaryStage.setX(0);
		primaryStage.setY(0);
		dispch.generateQueue("1", "2", "3");
		start_1(primaryStage);
	}

	private void start_1(Stage primaryStage) {//选择个人业务或对公业务或特殊业务

		Pane pane = new Pane();
		Image image = new Image("file:4.jpg");
		ImageView imageview = new ImageView(image);
		pane.getChildren().add(imageview);

		Label l1 = new Label("选择业务排队");
		l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		l1.setLayoutX(300);
		l1.setLayoutY(50);
		pane.getChildren().add(l1);

		Button b1 = new Button("个人业务");
		Button b2 = new Button("对公业务");
		Button b3 = new Button("特殊业务");

		b1.setLayoutX(295);
		b1.setLayoutY(150);
		b1.setPrefWidth(140);
		b1.setPrefHeight(80);
		b1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b1);

		b1.setOnAction(e -> {// 个人业务还需要再选
			primaryStage.setResizable(true);
			start_2(primaryStage);
			primaryStage.setTitle("Bank"); // Set the stage title
			primaryStage.show();
		});

		b2.setLayoutX(150);
		b2.setLayoutY(300);
		b2.setPrefWidth(140);
		b2.setPrefHeight(80);
		b2.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b2);
		b2.setOnAction(e -> {
			primaryStage.setResizable(true);
			start_3(primaryStage, "4");// “4”对公业务
			primaryStage.setTitle("Bank"); // Set the stage title
			primaryStage.show();
		});

		b3.setLayoutX(450);
		b3.setLayoutY(300);
		b3.setPrefWidth(140);
		b3.setPrefHeight(80);
		b3.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b3);
		b3.setOnAction(e -> {
			primaryStage.setResizable(true);
			start_3(primaryStage, "5");// “5”特殊业务
			primaryStage.setTitle("Bank"); // Set the stage title
			primaryStage.show();
		});

		Scene s = new Scene(pane, 750, 500);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片

		primaryStage.setScene(s);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	private void start_2(Stage primaryStage) {// 个人业务的还需再选
		
		Pane pane = new Pane();
		Image image = new Image("file:4.jpg");
		ImageView imageview = new ImageView(image);
		pane.getChildren().add(imageview);

		Label l1 = new Label("选择业务排队");
		l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		l1.setLayoutX(300);
		l1.setLayoutY(50);
		pane.getChildren().add(l1);

		Button b1 = new Button("现金业务");
		Button b2 = new Button("转账业务");
		Button b3 = new Button("开户业务");
		Button back = new Button("<<--返回");

		b1.setLayoutX(295);
		b1.setLayoutY(150);
		b1.setPrefWidth(140);
		b1.setPrefHeight(80);
		b1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b1);
		b1.setOnAction(e -> {
			primaryStage.setResizable(true);
			start_3(primaryStage, "1");// “1”现金业务
			primaryStage.setTitle("Bank"); // Set the stage title
			primaryStage.show();
		});

		b2.setLayoutX(150);
		b2.setLayoutY(300);
		b2.setPrefWidth(140);
		b2.setPrefHeight(80);
		b2.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b2);
		b2.setOnAction(e -> {
			primaryStage.setResizable(true);
			start_3(primaryStage, "2");// "2"转账业务
			primaryStage.setTitle("Bank"); // Set the stage title
			primaryStage.show();
		});

		b3.setLayoutX(450);
		b3.setLayoutY(300);
		b3.setPrefWidth(140);
		b3.setPrefHeight(80);
		b3.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b3);
		b3.setOnAction(e -> {
			primaryStage.setResizable(true);
			start_3(primaryStage, "3");// "3"开户业务
			primaryStage.setTitle("Bank"); // Set the stage title
			primaryStage.show();
		});

		back.setLayoutX(0);
		back.setLayoutY(450);
		back.setPrefWidth(150);
		back.setPrefHeight(50);
		back.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 15));
		pane.getChildren().add(back);
		back.setOnAction(e -> {
			start_1(primaryStage);// 返回主菜单
		});

		Scene s = new Scene(pane, 750, 500);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片

		primaryStage.setScene(s);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public void start_3(Stage primaryStage, String businessType) {//选择一个叫号方式（直接、银行卡、身份证、存折），需要保存上一步的业务类型，以便将其加入对应队列
		Pane pane = new Pane();
		Image image = new Image("file:4.jpg");
		ImageView imageview = new ImageView(image);
		pane.getChildren().add(imageview);

		Label l1 = new Label("选择业务排队");
		l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		l1.setLayoutX(300);
		l1.setLayoutY(50);
		pane.getChildren().add(l1);
//银行卡刷卡，身份证刷卡，卡折刷卡，普通叫号
		Button b1 = new Button("直接叫号");
		Button b2 = new Button("银行卡刷卡");
		Button b3 = new Button("身份证刷卡");
		Button b4 = new Button("卡折刷卡");
		Button back = new Button("<<--返回");

		b1.setLayoutX(295);
		b1.setLayoutY(100);
		b1.setPrefWidth(140);
		b1.setPrefHeight(50);
		b1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b1);
		b1.setOnAction(e -> {
			Format format = new DecimalFormat("000");
			String temp;
			temp = getPerBusines(businessType);
			this.qNo = "p" + temp + format.format(this.userId++);
			this.type = "common";
			cNo=-1;
			int i = personOperator.savePerson(qNo, cNo, userId - 1, type, temp);
			dispch.addPerson(new Person(qNo, cNo, userId - 1, type, temp));
			if (i > 0) {
				JOptionPane.showMessageDialog(null,"您的排队号为："+qNo, "提示", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "叫号失败", "警告", JOptionPane.WARNING_MESSAGE);
			}
			start_1(primaryStage);// 返回主菜单
		});

		b2.setLayoutX(295);
		b2.setLayoutY(180);
		b2.setPrefWidth(140);
		b2.setPrefHeight(50);
		b2.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b2);
		b2.setOnAction(e -> {
			inputMes(1, primaryStage, businessType);// 整型1代表刷银行卡
		});

		b3.setLayoutX(295);
		b3.setLayoutY(260);
		b3.setPrefWidth(140);
		b3.setPrefHeight(50);
		b3.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b3);
		b3.setOnAction(e -> {
			inputMes(2, primaryStage, businessType);// 整型2代表刷身份证
		});

		b4.setLayoutX(295);
		b4.setLayoutY(340);
		b4.setPrefWidth(140);
		b4.setPrefHeight(50);
		b4.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		pane.getChildren().add(b4);
		b4.setOnAction(e -> {
			inputMes(3, primaryStage, businessType);// 整型3代表刷折
		});

		back.setLayoutX(0);
		back.setLayoutY(450);
		back.setPrefWidth(150);
		back.setPrefHeight(50);
		back.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 15));
		pane.getChildren().add(back);
		back.setOnAction(e -> {
			start_1(primaryStage);// 返回主菜单
		});

		Scene s = new Scene(pane, 750, 500);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片

		primaryStage.setScene(s);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	
	//输入卡号界面，num为了知道用户选择的叫号方式
	private void inputMes(int num, Stage primaryStage, String businessType) {// businessType:1：现金业务，2：转账，3：开户，4：对公，5：特殊
		TextField in = new TextField();
		Format format = new DecimalFormat("000");
		Button back = new Button("<<--返回");

		if (num == 1) {
			Pane pane = new Pane();
			Image image = new Image("file:4.jpg");
			ImageView imageview = new ImageView(image);
			pane.getChildren().add(imageview);

			Label l1 = new Label("银行卡刷卡");
			l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
			l1.setLayoutX(300);
			l1.setLayoutY(50);
			pane.getChildren().add(l1);

			in.setLayoutX(180);
			in.setLayoutY(230);
			in.setMaxWidth(180);
			in.setMinHeight(50);
			pane.getChildren().add(in);

			Button b1 = new Button("确定刷卡");
			b1.setLayoutX(400);
			b1.setLayoutY(235);
			b1.setPrefWidth(150);
			b1.setPrefHeight(40);
			b1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
			pane.getChildren().add(b1);
			b1.setOnAction(e -> {
				this.type = new GetUserMesg().IsVip(in.getText());
				this.cNo = new GetUserMesg().getCno(in.getText());
				String temp;
				temp = getPerBusines(businessType);
				if (type.equals("vip")) {
					this.qNo = "v" + temp + format.format(this.userId++);

				} else
					this.qNo = "p" + temp + format.format(this.userId++);

				int i = personOperator.savePerson(qNo, cNo, userId - 1, type, temp);
				dispch.addPerson(new Person(qNo, cNo, userId - 1, type, temp));
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "您的排队号为："+qNo, "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "叫号失败", "警告", JOptionPane.WARNING_MESSAGE);
				}
				start_1(primaryStage);// 返回主菜单
			});

			back.setLayoutX(0);
			back.setLayoutY(450);
			back.setPrefWidth(150);
			back.setPrefHeight(50);
			back.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 15));
			pane.getChildren().add(back);
			back.setOnAction(e -> {
				start_3(primaryStage, businessType);// 返回选择叫号方式界面
			});

			Scene s = new Scene(pane, 750, 500);
			primaryStage.setTitle("");
			primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片
			primaryStage.setScene(s);
			primaryStage.show();
			primaryStage.setResizable(false);
		} else if (num == 2) {
			Pane pane = new Pane();
			Image image = new Image("file:4.jpg");
			ImageView imageview = new ImageView(image);
			pane.getChildren().add(imageview);

			Label l1 = new Label("身份证刷卡");
			l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
			l1.setLayoutX(300);
			l1.setLayoutY(50);
			pane.getChildren().add(l1);

			in.setLayoutX(180);
			in.setLayoutY(230);
			in.setMaxWidth(180);
			in.setMinHeight(50);
			pane.getChildren().add(in);

			Button b1 = new Button("确定刷证");
			b1.setLayoutX(400);
			b1.setLayoutY(235);
			b1.setPrefWidth(150);
			b1.setPrefHeight(40);
			b1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
			pane.getChildren().add(b1);
			b1.setOnAction(e -> {
				String temp;
				temp = getPerBusines(businessType);
				this.type = new GetUserMesg().IsVip(in.getText());
				this.cNo = new GetUserMesg().getCno(in.getText());
				if (type.equals("vip")) {
					this.qNo = "v" + temp + format.format(this.userId++);
				} else
					this.qNo = "p" + temp + format.format(this.userId++);
				int i = personOperator.savePerson(qNo, cNo, userId - 1, type, temp);
				dispch.addPerson(new Person(qNo, cNo, userId - 1, type, temp));
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "您的排队号为："+qNo, "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "叫号失败", "警告", JOptionPane.WARNING_MESSAGE);
				}
				start_1(primaryStage);// 返回主菜单
			});

			back.setLayoutX(0);
			back.setLayoutY(450);
			back.setPrefWidth(150);
			back.setPrefHeight(50);
			back.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 15));
			pane.getChildren().add(back);
			back.setOnAction(e -> {
				start_3(primaryStage, businessType);// 返回选择叫号方式界面
			});

			Scene s = new Scene(pane, 750, 500);
			primaryStage.setTitle("");
			primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片
			primaryStage.setScene(s);
			primaryStage.show();
			primaryStage.setResizable(false);
		} else if (num == 3) {
			Pane pane = new Pane();
			Image image = new Image("file:4.jpg");
			ImageView imageview = new ImageView(image);
			pane.getChildren().add(imageview);

			Label l1 = new Label("存折号叫号");
			l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
			l1.setLayoutX(300);
			l1.setLayoutY(50);
			pane.getChildren().add(l1);

			in.setLayoutX(180);
			in.setLayoutY(230);
			in.setMaxWidth(180);
			in.setMinHeight(50);
			pane.getChildren().add(in);

			Button b1 = new Button("确定刷折");

			b1.setLayoutX(400);
			b1.setLayoutY(235);
			b1.setPrefWidth(150);
			b1.setPrefHeight(40);
			b1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
			pane.getChildren().add(b1);
			
			b1.setOnAction(e -> {
				String temp;
				temp = getPerBusines(businessType);
				this.type = new GetUserMesg().IsVip(in.getText());
				this.cNo = new GetUserMesg().getCno(in.getText());
				
				if (type.equals("vip")) {
					this.qNo = "v" + temp + format.format(this.userId++);

				} else
					this.qNo = "p" + temp + format.format(this.userId++);
				int i = personOperator.savePerson(qNo, cNo, userId - 1, type, temp);
				dispch.addPerson(new Person(qNo, cNo, userId - 1, type, temp));
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "您的排队号为："+qNo, "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "叫号失败", "警告", JOptionPane.WARNING_MESSAGE);
				}
				start_1(primaryStage);// 返回主菜单
			});

			back.setLayoutX(0);
			back.setLayoutY(450);
			back.setPrefWidth(150);
			back.setPrefHeight(50);
			back.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 15));
			pane.getChildren().add(back);
			back.setOnAction(e -> {
				start_3(primaryStage, businessType);// 返回选择叫号方式界面
			});

			Scene s = new Scene(pane, 750, 500);
			primaryStage.setTitle("");
			primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片
			primaryStage.setScene(s);
			primaryStage.show();
			primaryStage.setResizable(false);
		}
	}

	private String getPerBusines(String BusinessType) {//将数据库中中文类型的数据转化为1、2、3以便类之间传递
		String temp = null;
		if (BusinessType.equals("1") || BusinessType.equals("2") || BusinessType.equals("3")) {
			temp = "1";
		} else if (BusinessType.equals("4")) {
			temp = "2";
		} else if (BusinessType.equals("5")) {
			temp = "3";
		}
		return temp;
	}

	//dispch为不同类型的业务队列数组，用于线程中时刻刷新同步其余地方对它的修改
	public void setWindOperat(DispOperator dispch) {// 设置一个队列
		this.dispch = dispch;
	}
	
	//返回dispch，用于线程中时刻返回此界面对其做的修改
	public DispOperator getWindOperat() {
		return this.dispch;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
