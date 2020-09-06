package com.bank.view;
//管理员配置叫号规则参数界面，参数有默认值，从文件中读取参数，配置成功将参数传给排队算法类，并将参数存储进文件夹

import javax.swing.JOptionPane;

import com.bank.controller.WindowsOperator;
import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MangerConfigure extends Application {
	String windows[] = WindowsOperator.getWindow();//按顺序分别是1、2、3号窗口对应的业务
	public void start(Stage primaryStage) {
		Image image = new Image("file:4.jpg");
		ImageView imageview = new ImageView(image);

		Label l = new Label("叫号规则配置");
		Label l1 = new Label("一号窗口");
		Label l2 = new Label("二号窗口");
		Label l3 = new Label("三号窗口");
		l.setFont(Font.font("Time New Roman", FontWeight.LIGHT, FontPosture.ITALIC, 30));
		l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		l2.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		l3.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));

		l.setLayoutX(270);
		l.setLayoutY(30);
		l1.setLayoutX(160);
		l1.setLayoutY(140);
		l2.setLayoutX(160);
		l2.setLayoutY(220);
		l3.setLayoutX(160);
		l3.setLayoutY(300);

		ComboBox cb1 = new ComboBox();
		cb1.getItems().addAll("个人业务", "对公业务", "特殊业务");
		cb1.setStyle("-fx-color:green");
		cb1.setValue("个人业务");

		cb1.setLayoutX(350);
		cb1.setLayoutY(150);

		ComboBox cb2 = new ComboBox();
		cb2.getItems().addAll("个人业务", "对公业务", "特殊业务");
		cb2.setStyle("-fx-color:green");
		cb2.setValue("个人业务");

		cb2.setLayoutX(350);
		cb2.setLayoutY(230);

		ComboBox cb3 = new ComboBox();
		cb3.getItems().addAll("个人业务", "对公业务", "特殊业务");
		cb3.setStyle("-fx-color:green");
		cb3.setValue("个人业务");

		cb3.setLayoutX(350);
		cb3.setLayoutY(310);

		Button btn1 = new Button("配置");
		Button btn2 = new Button("配置");
		Button btn3 = new Button("配置");

		btn1.setLayoutX(530);
		btn1.setLayoutY(150);

		btn2.setLayoutX(530);
		btn2.setLayoutY(230);

		btn3.setLayoutX(530);
		btn3.setLayoutY(310);

		Pane p = new Pane();

		p.getChildren().add(imageview);// 添加背景图片
		p.getChildren().add(l);
		p.getChildren().add(l1);
		p.getChildren().add(cb1);
		p.getChildren().add(btn1);
		p.getChildren().add(l2);
		p.getChildren().add(cb2);
		p.getChildren().add(btn2);
		p.getChildren().add(l3);
		p.getChildren().add(cb3);
		p.getChildren().add(btn3);

		btn1.setOnAction(e->{
			windows[0]=(String) cb1.getValue();
			windows[1]=(String) cb2.getValue();
			windows[2]=(String) cb3.getValue();
			WindowsOperator.updateWindow(windows);
			JOptionPane.showMessageDialog(null, "配置成功", "提示", JOptionPane.INFORMATION_MESSAGE);
		});
		btn2.setOnAction(e->{
			windows[0]=(String) cb1.getValue();
			windows[1]=(String) cb2.getValue();
			windows[2]=(String) cb3.getValue();
			WindowsOperator.updateWindow(windows);
			JOptionPane.showMessageDialog(null, "配置成功", "提示", JOptionPane.INFORMATION_MESSAGE);

		});
		btn3.setOnAction(e->{
			windows[0]=(String) cb1.getValue();
			windows[1]=(String) cb2.getValue();
			windows[2]=(String) cb3.getValue();
			WindowsOperator.updateWindow(windows);
			JOptionPane.showMessageDialog(null, "配置成功", "提示", JOptionPane.INFORMATION_MESSAGE);

		});
		
		Scene s = new Scene(p, 750, 500);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片

		primaryStage.setScene(s);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
}