package com.bank.view;


import javax.swing.JOptionPane;

import com.bank.controller.UserOperator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class PersonLogin extends Application{

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Image image = new Image("file:3.jpg");

		Label label = new Label(" 登   录");
		label.setTextFill(Color.WHITE);
		
		TextField account = new TextField();
		final TextField out = new TextField();
		Button pp = new Button("登录");
		Button al = new Button("退出");
		Button common = new Button("普通用户入口");
		ImageView imageview = new ImageView(image);
		imageview.fitHeightProperty();
		imageview.fitWidthProperty();
		imageview.setLayoutX(0);
		imageview.setLayoutY(0);

		label.setLayoutX(645);
		label.setLayoutY(255);
		account.setLayoutX(700);
		account.setLayoutY(250);
		account.setMaxWidth(180);
		account.setMinHeight(20);
		out.setLayoutX(700);
		out.setLayoutY(300);
		out.setMaxWidth(180);
		out.setMinHeight(20);
		pp.setLayoutX(700);
		pp.setLayoutY(350);
		pp.setMinWidth(80);
		pp.setMinHeight(30);
		al.setLayoutX(800);
		al.setLayoutY(350);
		al.setMinWidth(80);
		al.setMinHeight(30);
		common.setLayoutX(700);
		common.setLayoutY(400);
		common.setMinWidth(180);
		common.setMinHeight(30);
		common.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				primaryStage.hide();
				CommonBusiness common=new CommonBusiness();
			}
		});
		
		pane.getChildren().add(imageview);
		pane.getChildren().addAll(pp,al,out,account,label,common);
		Scene scene = new Scene(pane, 1000, 510);
		primaryStage.setX(0);
		primaryStage.setY(400);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();
		pp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			if(out.getText().equals("")||account.getText().equals("")){
				JOptionPane.showMessageDialog(null, "账号或密码为空","警告",JOptionPane.WARNING_MESSAGE);
				
			}
			else{
				String ac = account.getText();
				int cno = Integer.parseInt(ac);
				String password = out.getText();
				
				int i = UserOperator.verification(cno, password);
				if (i>0){
					primaryStage.hide();
					new PersonalBusiness(cno);
				}else {
					JOptionPane.showMessageDialog(null, "账号或密码错误","警告",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		}
	});
	al.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "退出成功","提示",JOptionPane.WARNING_MESSAGE); 
				System.exit(0);
			}
		});
		primaryStage.setResizable(false);
	}
	
		  
	public static void main(String[] args) {
		launch(args);
		
	}
}
