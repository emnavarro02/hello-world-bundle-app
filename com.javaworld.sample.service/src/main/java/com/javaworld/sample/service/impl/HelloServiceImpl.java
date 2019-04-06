/**
 * 
 */
package com.javaworld.sample.service.impl;

import com.javaworld.sample.service.HelloService;

/**
 * @author emerson
 *
 */
public class HelloServiceImpl implements HelloService {
	
	public String sayHello() {
		System.out.println("Inside the HelloServiceImpl class");
		return "You say goodbye, I say hello...";
	}

}
