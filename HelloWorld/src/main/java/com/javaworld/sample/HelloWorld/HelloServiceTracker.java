package com.javaworld.sample.HelloWorld;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.javaworld.sample.service.HelloService;

public class HelloServiceTracker extends ServiceTracker{

	/**
	 * We are passing the name of the interface HelloService to the constructor, 
	 * which means that we want to Track services that are registered under this 
	 * interface name.
	 * */
	public HelloServiceTracker(BundleContext context) {
		super(context, HelloService.class.getName(),null);
	}
	
	/**
	 * Called when a bundle registers a service under the given interface name, in this case
	 * " HelloService" 
	 * */
	public Object addingService(ServiceReference reference) {
		System.out.println("Inside HelloServiceTracker.addingService " + reference.getBundle());
		return super.addingService(reference);
	}
	
	/**
	 * Called when a bundle unregisters a service under the given interface name. 
	 * */
	public void removedService(ServiceReference reference, Object service) {
		System.out.println("Inside HelloServiceTracker.removedService "+ reference.getBundle());
		super.removedService(reference, service);
	}
	

}
