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

	@Override
	public String sayHello(String name) {
		
		if (name.length() > 0) {
			System.out.println(".");
			return ("Hi, " + name);	
		}
		else {
			System.out.println("..");
			return ("Hi, unamed");
		}
	}

	@Override
	public int somaValores(int a, int b) {
		return a + b;
	}

}
