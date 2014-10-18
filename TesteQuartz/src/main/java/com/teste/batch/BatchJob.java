package com.teste.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BatchJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("enviando email para evisar mudanca de senha...");
	    // acessar api de e-mail aqui
		
	}
	
	

}
