package com.javaworld.sample.service.impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import com.javaworld.sample.service.HelloService;

public class HelloServiceFactory implements ServiceFactory {

	private int usageCounter = 0;
	
	/**
	 * The OSGi Framework invokes this method the first time the specified bundle requests a 
	 * service object using the BundleContext.getService(ServiceReference) method. In this
	 * example we use this method to create a different object of HelloServiceImpl for every
	 * bundle, and we return that object. The OSGi framework caches the value returned (unless
	 * it is null), and will return the same service object on any future calls to 
	 * BundleContext.getService() from the same bundle.  
	 * */
	@Override
	public Object getService(Bundle bundle, ServiceRegistration registration) {
		System.out.println("Create object of HelloService for " + bundle.getSymbolicName());
		usageCounter++;
		System.out.println("Bundles using service: " + usageCounter);
		HelloService hs = new HelloServiceImpl();
		return hs;
	}
	
	/**
	 * The OSGi container invokes this method when a service has been released by a bundle. The 
	 * service object may then be destroyed. Here, we use this method to reduce the "usageCount"
	 * of the service and print the number of client for the service.
	 * */
	@Override
	public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
		System.out.println("Release object of HelloService for " + bundle.getSymbolicName());
		usageCounter--;
		System.out.println("Bundles using service: " + usageCounter);
	}

}
