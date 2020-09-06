package com.bank.client;

import com.bank.controller.DispOperator;
import com.bank.entity.Person;
import com.bank.view.LineUp;
import com.bank.view.MangerLogin;
import com.bank.view.WindowsNotice;
import com.sun.jmx.snmp.tasks.ThreadService;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {

	LineUp lineUp = new LineUp();
	WindowsNotice windowsNotice = new WindowsNotice();
	DispOperator dispchOperator = new DispOperator();

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		dispchOperator.generateQueue("1", "2", "3");// 对应3个业务队列

		lineUp.setWindOperat(dispchOperator);
		lineUp.start(new Stage());
		dispchOperator = lineUp.getWindOperat();

		windowsNotice.setDispch(dispchOperator);
		windowsNotice.start(new Stage());
		dispchOperator = windowsNotice.getWindOperat();

		final long timeInterval = 100;// 1毫秒运行一次
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					// ------- code for task to run
					dispchOperator = lineUp.getWindOperat();
					windowsNotice.setDispch(dispchOperator);
					// System.out.println(1);
					dispchOperator = windowsNotice.getWindOperat();
					lineUp.setWindOperat(dispchOperator);
					// ------- ends here
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
