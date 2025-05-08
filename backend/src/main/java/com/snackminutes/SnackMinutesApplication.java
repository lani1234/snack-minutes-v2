package com.snackminutes;

import com.snackminutes.model.Activity;
import com.snackminutes.model.Snack;
import com.snackminutes.model.User;
import com.snackminutes.repository.ActivityRepository;
import com.snackminutes.repository.SnackRepository;
import com.snackminutes.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SnackMinutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnackMinutesApplication.class, args);
	}

	/**
	 commandLineRunner that will create a Snack object and save it to the database
	 */
//	@Bean
//	public CommandLineRunner run(SnackRepository snackRepository) {
//		return args -> {
//			// Insert sample snack
//			Snack snack = Snack.builder()
//					.name("Chocolate Chip Cookie")
//					.servingSize("1")
//					.caloriesPerServing(220)
//					.build();
//
//			snackRepository.save(snack);
//
//			// Fetch all snacks
//			snackRepository.findAll().forEach(System.out::println);
//		};
//	}

	/**
	 commandLineRunner that will create an Activity object and save it to the database
	 */
//	@Bean
//	public CommandLineRunner run(ActivityRepository activityRepository) {
//		return args -> {
//			// Insert sample snack
//			Activity activity = Activity.builder()
//					.name("Walking")
//					.met(3)
//					.build();
//
//			activityRepository.save(activity);
//
//			// Fetch all snacks
//			activityRepository.findAll().forEach(System.out::println);
//		};
//	}

//	@Bean
//	public CommandLineRunner run(UserRepository userRepository) {
//		return args -> {
//			// Insert sample snack
//			User user = User.builder()
//					.firstName("TestFirst")
//					.lastName("TestLast")
//					.email("test@test.com")
//					.weightLbs(126)
//					.build();
//
//			userRepository.save(user);
//
//			// Fetch all snacks
//			userRepository.findAll().forEach(System.out::println);
//		};
//	}

}
