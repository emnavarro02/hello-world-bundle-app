package com.javaworld.sample.HelloWorld;

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

	ServiceReference helloServiceReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("123...");
		
		// obtem a refererencia do servico fornecido
		helloServiceReference = context.getServiceReference(HelloService.class.getName());
		
		// obtem o servico atraves da referencia
		HelloService hs = (HelloService) context.getService(helloServiceReference);
		
		// Executa o servico
		System.out.println(hs.sayHello());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye Cruel World");
		context.ungetService(helloServiceReference);
	}
	
	
}
