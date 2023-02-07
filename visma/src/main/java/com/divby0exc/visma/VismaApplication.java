package com.divby0exc.visma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class VismaApplication {

	public static void main(String[] args) {

		SpringApplication.run(VismaApplication.class, args);
	}

}

// TODO: 2023-01-25
/**
 * Implement edit and delete method in repo
 * done
 *
 * Implement methods from repo into edit and delete controller
 * done
 * Retrieve info from an invoice etc
 * done
 * Add rest of the repo methods in service and evaluate things
 * done
 * Design the pages a bit better
 * done
 * implement the new login page
 * done
 * implement the new register page
 * done
 * find a nicer form to register receipt
 * done
 */
// TODO
/***
 * Obvious flaws
 * back button on edit page still saves the edit -.-
 * i cannot move the back button form outside the save form without breaking design.
 */
// TODO 2023-02-07
/**
 * create a sidebar
 * implement a ws
 * create a representation class
 * push information that a crud operation has been made to the sidebar
 */