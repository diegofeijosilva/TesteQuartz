package com.teste.batch;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class BatchScheduler {

	public static void inicia() throws Exception {
		
		// Detalhes da tarefa
        JobDetail job = JobBuilder.newJob(BatchJob.class).withIdentity(
                "tarefaAloMundo", "group1").build();
        
        // Gatilho - Faz a chamada todos os dias as 23:38
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(
                "gatilhoAloMundo", "group1").withSchedule(
                CronScheduleBuilder.cronSchedule("0 42 23 * * ?")).build();
 
        // Agenda e voa lá!
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
		
	}
	
	/*
	 * Para formar uma expressão cron, alguns requisitos devem ser satisfeitos. 
	 * Primeiramente, deve-se conhecer a ordem dos parâmetros:

			1. Segundos;
			2. Minutos;
			3. Horas;
			4. Dia do mês;
			5. Mês;
			6. Dia da semana;
			7. Ano (opcional).
			
			Por exemplo, uma expressão cron que será executada todas às quartas-feiras às 12:00pm é escrita da seguinte forma: “0 0 12 ? * WED”. 
			Outro exemplo de expressão demonstra uma tarefa executada todos os dias, às 08:00am e 12:00pm: “0 0 8,12 * * *”.
			
			Fonte: http://imasters.com.br/artigo/23593/java/entenda-como-funciona-o-quartz-enterprise-job-scheduler/
	 * */
	
}
