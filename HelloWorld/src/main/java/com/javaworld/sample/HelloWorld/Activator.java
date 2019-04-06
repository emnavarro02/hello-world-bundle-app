package com.javaworld.sample.HelloWorld;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.service.HelloService;

//import com.javaworld.sample.service.impl.HelloServiceImpl;

/**
 * Hello world!
 *
 * https://www.javaworld.com/article/2077837/java-se-hello-osgi-part-1-bundles-for-beginners.html?page=3
 */

public class Activator implements BundleActivator
{

	// ServiceReference helloServiceReference;
	HelloServiceTracker helloServiceTracker;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Hello World!!!");
		// obtem a refererencia do servico fornecido
		// helloServiceReference = context.getServiceReference(HelloService.class.getName());
		
		// obtem o servico atraves da referencia
		// HelloService hs = (HelloService) context.getService(helloServiceReference);
		
		helloServiceTracker = new HelloServiceTracker(context); // create a new HelloServiceTracker object
		helloServiceTracker.open(); // start to track services.
		
		HelloService hs = (HelloService) helloServiceTracker.getService(); // ask to HelloServiceTracker to get the service 
		                                                                   // instead of ask to the context
		
		// Executa o servico
		System.out.println("Enter username: ");
		Scanner myObj = new Scanner(System.in);
		String userName = myObj.nextLine();
		String hello = hs.sayHello(userName);
		System.out.println(hello);
		
		System.out.println("Enter values: ");
		int a = myObj.nextInt();
		int b = myObj.nextInt();
	
		int c = hs.somaValores(a, b);
		System.out.print("The value is: ");
		System.out.println(c);
		
		myObj.close();
		
		
	}

	public void stop(BundleContext context) throws Exception {
		//context.ungetService(helloServiceReference);
		helloServiceTracker.close();
		
		System.out.println("Goodbye Cruel World");
	}
	
	
}
