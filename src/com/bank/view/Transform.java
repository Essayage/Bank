package com.bank.view;

import javax.swing.JOptionPane;
import com.bank.controller.DispOperator;
import com.bank.entity.Person;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Transform extends Application {
	DispOperator dispch = new DispOperator();
	Person person;// 当前窗口
	int x,y;
	
	
	public void start(Stage primaryStage) {
		Image image = new Image("file:5.png");
		ImageView imageview = new ImageView(image);

		Pane p = new Pane();
		p.getChildren().add(imageview);
		Button b = new Button("确定");
		ComboBox cb1 = new ComboBox();
		cb1.getItems().addAll("一号窗口", "二号窗口", "三号窗口");
		cb1.setStyle("-fx-color:green");
		cb1.setValue("一号窗口");

		cb1.setLayoutX(100);
		cb1.setLayoutY(50);
		b.setLayoutX(120);
		b.setLayoutY(130);
		p.getChildren().add(cb1);
		p.getChildren().add(b);

		b.setOnAction(e -> {
			String type1 = null;
			if (cb1.getValue().equals("一号窗口")) {
				type1 = "1";
			} else if (cb1.getValue().equals("二号窗口")) {
				type1 = "2";
			} else {
				type1 = "3";
			}
			person.setbusinessType(type1);
			if (person != null) {
				dispch.addPerson(person);
				JOptionPane.showMessageDialog(null, "转移成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				primaryStage.close();
			}
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

	public void setWindOperat(DispOperator dispch, Person person) {// 设置一个队列
		this.dispch = dispch;
		this.person = person;
	}
	
	public void setX_Y(int x,int y) {
		this.x = x;
		this.y = y;
	}

	public DispOperator getWindOperat() {
		return this.dispch;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
