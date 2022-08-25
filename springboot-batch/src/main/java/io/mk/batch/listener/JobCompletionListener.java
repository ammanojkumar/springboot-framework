package io.mk.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("afterJob status " + jobExecution.getStatus());
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("Job has completed");
		}
	}

}
