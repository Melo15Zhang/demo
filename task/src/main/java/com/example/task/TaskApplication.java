package com.example.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 最简单的定时任务
 */
@SpringBootApplication
@EnableTask
public class TaskApplication {

	private Random random = new Random();

	@Bean
	public CommandLineRunner commandLineRunner() {

		int randomInt = random.nextInt(10);
		return strings -> task(randomInt);
	}

	public void task(int randomInt){
		System.out.println("Executed at-----------" + randomInt + "-----------" +
				new SimpleDateFormat().format(new Date()));
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
}
