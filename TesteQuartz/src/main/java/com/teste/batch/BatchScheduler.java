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
        // Gatilho - ou seja, quando irá chamar, neste caso, a cada 5 segundos
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(
                "gatilhoAloMundo", "group1").withSchedule(
                CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
 
        // Agenda e voa lá!
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
		
	}
	
}
