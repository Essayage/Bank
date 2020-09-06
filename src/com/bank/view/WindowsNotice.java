package com.bank.view;
//通知叫号界面，3个窗口,每个窗口4个功能,1按顺序叫号,2将当前处理的排队号转移至其他窗口对应业务的队列尾,3指定叫某一号,4重新叫当前号

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import com.bank.controller.DispOperator;
import com.bank.controller.PersonOperator;
import com.bank.controller.WindowsOperator;
import com.bank.entity.Person;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WindowsNotice extends Application {
	DispOperator dispch = new DispOperator();
	Person person1=null;
	Person person2=null;
	Person person3=null;

	public void start(final Stage primaryStage) {
		// 初始化队列，生成3个业务队列
		dispch.generateQueue("1", "2", "3");

		Image image = new Image("file:4.png");
		ImageView imageview = new ImageView(image);

		Text t = new Text();
		Text t1 = new Text();
		Text t2 = new Text();
		t.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		t1.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));
		t2.setFont(Font.font("Time New Roman", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20));

		Label l = new Label(WindowsOperator.getWindow()[0]);

		Label l3 = new Label("(一号窗口)");
		l.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l3.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		Button b1 = new Button("顺呼");
		Button b2 = new Button("转移窗口");
		Button b3 = new Button("指定叫号");
		Button b4 = new Button("重呼");
		Button bflush1 = new Button("刷新");
		Button bflush2 = new Button("刷新");
		Button bflush3 = new Button("刷新");

		Label l1 = new Label(WindowsOperator.getWindow()[1]);
		Label l4 = new Label("(二号窗口)");
		l1.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l4.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

		Button b5 = new Button("顺呼");
		Button b6 = new Button("转移窗口");
		Button b7 = new Button("指定叫号");
		Button b8 = new Button("重呼");

		Label l2 = new Label(WindowsOperator.getWindow()[2]);
		Label l5 = new Label("(三号窗口)");
		l2.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		l5.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		Button b9 = new Button("顺呼");
		Button b10 = new Button("转移窗口");
		Button b11 = new Button("指定叫号");
		Button b12 = new Button("重呼");

		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Person person = dispch.deQueue(getWinTyp(1));// 1号窗口
				if (person != null) {
					person1=person;
					PersonOperator.deletePerson(person.getqNo());
					t.setText(person.getqNo());
					PersonLogin personlogin = new PersonLogin();
					personlogin.start(new Stage());
					
				}
			}
		});

		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(person1!=null) {
				Transform trans = new Transform();
				trans.setWindOperat(dispch, person1);
				trans.setX_Y(1110, 120);
				trans.start(new Stage());
				person1=null;
				}
			}
		});

		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Call c = new Call();
				c.setDispOpera(dispch, "1");
				c.setX_Y(1110, 120);
				c.start(new Stage());
				bflush1.setOnAction(e->{
					person1=c.getPerson();
					dispch = c.getDispOpera();
					if(person1!=null) {
						PersonOperator.deletePerson(person1.getqNo());
						t.setText(person1.getqNo());
						PersonLogin personlogin = new PersonLogin();
						personlogin.start(new Stage());
					}
				});
			}
		});
		
		b4.setOnAction(e->{
			if(person1!=null) {
			t.setText(person1.getqNo());
			PersonLogin personlogin = new PersonLogin();
			personlogin.start(new Stage());
			}
		});

		b5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Person person = dispch.deQueue(getWinTyp(2));// 2号窗口
				if (person != null) {
					person2=person;
					PersonOperator.deletePerson(person2.getqNo());
					t1.setText(person2.getqNo());
					PersonLogin personlogin = new PersonLogin();
					personlogin.start(new Stage());
				}
			}
		});

		b6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(person2!=null) {
				Transform trans = new Transform();
				trans.setWindOperat(dispch, person2);
				trans.setX_Y(1340, 120);
				trans.start(new Stage());
				person2=null;
				}
			}
		});

		b7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Call c = new Call();
				c.setDispOpera(dispch, "2");
				c.setX_Y(1340, 120);
				c.start(new Stage());
				bflush2.setOnAction(e->{
					PersonOperator.deletePerson(person2.getqNo());
					person2=c.getPerson();
					dispch = c.getDispOpera();
					if(person2!=null) {
						t1.setText(person2.getqNo());
						PersonLogin personlogin = new PersonLogin();
						personlogin.start(new Stage());
					}
				});
			}
		});
		
		b8.setOnAction(e->{
			if(person2!=null) {
			t1.setText(person2.getqNo());
			PersonLogin personlogin = new PersonLogin();
			personlogin.start(new Stage());
			}
		});

		b9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Person person = dispch.deQueue(getWinTyp(3));// 2号窗口
				if (person != null) {
					person3 = person;
					PersonOperator.deletePerson(person.getqNo());
					t2.setText(person.getqNo());
					PersonLogin personlogin = new PersonLogin();
					personlogin.start(new Stage());
				}
			}
		});

		b10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(person3!=null) {
				Transform trans = new Transform();
				trans.setWindOperat(dispch, person3);
				trans.setX_Y(1540, 120);
				trans.start(new Stage());
				person3=null;
				}
			}
		});

		b11.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Call c = new Call();
				c.setDispOpera(dispch, "3");
				c.setX_Y(1540, 120);
				c.start(new Stage());
				bflush3.setOnAction(e->{
					PersonOperator.deletePerson(person3.getqNo());
					person3=c.getPerson();
					dispch = c.getDispOpera();
					if(person3!=null) {
						t2.setText(person3.getqNo());
						PersonLogin personlogin = new PersonLogin();
						personlogin.start(new Stage());
					}
				});
			}
		});
		
		b12.setOnAction(e->{
			if(person3!=null) {
			t2.setText(person3.getqNo());
			PersonLogin personlogin = new PersonLogin();
			personlogin.start(new Stage());
			}
		});

		b1.setLayoutX(110);
		b1.setLayoutY(340);	
		b4.setLayoutX(170);
		b4.setLayoutY(340);
		bflush1.setLayoutX(230);
		bflush1.setLayoutY(340);
		b2.setLayoutX(110);
		b2.setLayoutY(390);
		b3.setLayoutX(200);
		b3.setLayoutY(390);
		
		b5.setLayoutX(300);
		b5.setLayoutY(340);	
		b8.setLayoutX(360);
		b8.setLayoutY(340);
		bflush2.setLayoutX(420);
		bflush2.setLayoutY(340);
		b6.setLayoutX(300);
		b6.setLayoutY(390);
		b7.setLayoutX(390);
		b7.setLayoutY(390);
		
		b9.setLayoutX(490);
		b9.setLayoutY(340);	
		b12.setLayoutX(550);
		b12.setLayoutY(340);
		bflush3.setLayoutX(610);
		bflush3.setLayoutY(340);
		b10.setLayoutX(490);
		b10.setLayoutY(390);
		b11.setLayoutX(580);
		b11.setLayoutY(390);
		
		l.setLayoutX(160);
		l.setLayoutY(100);
		l3.setLayoutX(155);
		l3.setLayoutY(125);
		t.setLayoutX(130);
		t.setLayoutY(220);
		t.minHeight(150);
		t.minHeight(150);
		l2.setLayoutX(530);
		l2.setLayoutY(100);
		l5.setLayoutX(525);
		l5.setLayoutY(125);
		t2.setLayoutX(510);
		t2.setLayoutY(220);
		t2.minHeight(150);
		t2.minHeight(150);
		l1.setLayoutX(340);
		l1.setLayoutY(100);
		l4.setLayoutX(330);
		l4.setLayoutY(125);
		t1.setLayoutX(320);
		t1.setLayoutY(220);
		t1.minHeight(150);
		t1.minHeight(150);

		Pane p = new Pane();
		p.getChildren().add(imageview);
		p.getChildren().add(t);
		p.getChildren().add(l);
		p.getChildren().add(l3);
		p.getChildren().add(b1);
		p.getChildren().add(b2);
		p.getChildren().add(b3);
		p.getChildren().add(bflush1);
		p.getChildren().add(bflush2);
		p.getChildren().add(bflush3);
		p.getChildren().add(b4);
		p.getChildren().add(t1);
		p.getChildren().add(l1);
		p.getChildren().add(l4);
		p.getChildren().add(b5);
		p.getChildren().add(b8);
		p.getChildren().add(b7);
		p.getChildren().add(b6);
		p.getChildren().add(t2);
		p.getChildren().add(l2);
		p.getChildren().add(l5);
		p.getChildren().add(b9);
		p.getChildren().add(b12);
		p.getChildren().add(b10);
		p.getChildren().add(b11);
		Scene s = new Scene(p, 750, 500);
		primaryStage.setX(1100);
		primaryStage.setY(0);
		primaryStage.setTitle("");
		primaryStage.getIcons().add(new Image("file:2.jpg"));// 设置窗体左上角显示的图片

		primaryStage.setScene(s);
		primaryStage.show();
	}

	private static String getWinTyp(int num) {
		String temp;

		if (WindowsOperator.getWindow()[num - 1].equals("个人业务")) {
			temp = "1";
		} else if (WindowsOperator.getWindow()[num - 1].equals("对公业务")) {
			temp = "2";
		} else {
			temp = "3";
		}
		return temp;
	}

	public void setDispch(DispOperator dispOperator) {
		this.dispch = dispOperator;
	}

	public void setWindOperat(DispOperator dispch) {// 设置一个队列
		this.dispch = dispch;
	}

	public DispOperator getWindOperat() {
		return this.dispch;
	}

	public static void main(String[] args) {
		launch(args);

	}
}
