package com.bank.view;

//管理员登录界面，登录成功跳转至管理员配置排队参数界面

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import com.bank.controller.AdminOperator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MangerLogin extends Application {
	AdminOperator adminOperator;

	@Override
	public void start(final Stage primaryStage) {
		Pane pane = new Pane();
		Image image = new Image("file:1.png");
		final TextField in = new TextField();
		final TextField out = new TextField();
		Button pp = new Button("登录");
		Button al = new Button("退出");
		ImageView imageview = new ImageView(image);
		imageview.fitHeightProperty();
		imageview.fitWidthProperty();
		imageview.setLayoutX(0);
		imageview.setLayoutY(0);
		in.setLayoutX(700);
		in.setLayoutY(270);
		in.setMaxWidth(180);
		in.setMinHeight(20);
		out.setLayoutX(700);
		out.setLayoutY(310);
		out.setMaxWidth(180);
		out.setMinHeight(20);
		pp.setLayoutX(700);
		pp.setLayoutY(350);
		pp.setMinWidth(80);
		pp.setMinHeight(30);
		al.setLayoutX(800);
		al.setLayoutY(350);
		al.setMinWidth(80);
		al.setMinHeight(28);
		pane.getChildren().add(imageview);
		pane.getChildren().addAll(pp, al, in, out);
		// pane.getChildren().add(in);
		Scene scene = new Scene(pane, 1000, 510);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();
		pp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (in.getText().equals("") || out.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空", "警告", JOptionPane.WARNING_MESSAGE);
				} else {
					if (adminOperator.match(in.getText(), out.getText())) {
						MangerConfigure open = new MangerConfigure();
						open.start(new Stage());
						primaryStage.hide();
					}else{
						JOptionPane.showMessageDialog(null, "账号密码不匹配", "警告", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		al.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "退出成功", "提示", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		});
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
