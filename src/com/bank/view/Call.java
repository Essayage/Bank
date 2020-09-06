package com.bank.view;

import javax.swing.JOptionPane;

import com.bank.controller.DispOperator;
import com.bank.entity.Person;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Call extends Application {
	DispOperator dispch = new DispOperator();
	String num;
	Person person;
	int x,y;
	
	public void start(Stage primaryStage) {
		Image image = new Image("file:5.png");
		ImageView imageview = new ImageView(image);
		Pane p = new Pane();
		p.getChildren().add(imageview);
		Label l = new Label("请输入指定的号码:");
		l.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l.setLayoutX(20);
		l.setLayoutY(20);
		Button b = new Button("确定");
		TextField t = new TextField();
		t.setLayoutX(55);
		t.setLayoutY(80);

		b.setLayoutX(120);
		b.setLayoutY(130);
		p.getChildren().add(l);
		p.getChildren().add(t);
		p.getChildren().add(b);

		b.setOnAction(e -> {
			person = dispch.deQueueByQno(t.getText(), num);
			if (person == null) 
				JOptionPane.showMessageDialog(null, "号码不存在", "提示", JOptionPane.INFORMATION_MESSAGE);
			primaryStage.close();
		});

		Scene s = new Scene(p, 295, 200);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片
		primaryStage.setScene(s);
		primaryStage.setX(x);
		primaryStage.setY(y);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public void setDispOpera(DispOperator disp, String num) {
		this.dispch = disp;
		this.num = num;
	}

	public DispOperator getDispOpera() {
		return this.dispch;
	}

	public void setX_Y(int x,int y) {
		this.x = x;
		this.y =y;
	}
	
	public Person getPerson() {
		return this.person;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
