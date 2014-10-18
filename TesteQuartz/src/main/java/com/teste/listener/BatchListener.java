package com.teste.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.teste.batch.BatchScheduler;

public class BatchListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		System.out.println("PRIMEIRA CHAMADA");
		
		try {
			BatchScheduler.inicia();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
