/**
 * 
 */
package com.javaworld.sample.service.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.javaworld.sample.service.HelloService;

/**
 * @author emerson
 *
 */
public class HelloServiceActivator implements BundleActivator {

	ServiceRegistration helloServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
			
		/**
		 * The register service method needs:
		 * 1) The name of the interface under which you want to register the service 
		 *    -- If you want to register the service under multiple interfaces then 
		 *       you should create a String[] of interface names and pass it as the
		 *       first argument. 
		 *       Here we want to export the service under the name HelloService interface 
		 *       
		 *  
		 * 2) The actual Java object that you want to register as a service
		 *    -- Here we are exporting objects of the HelloServiceImpl class as a service.
		 *       
		 *    
		 * 3) Properties of the service, in this case a Dictionary object. 
		 *     -- If more than one bundle exports a service under the same interface
		 *        then the target object can use these properties to filter out the 
		 *        service that it is interested in.
		*/
		
		HelloService helloService = new HelloServiceImpl();
		
		System.out.println(HelloService.class.getName());
		
		helloServiceRegistration = context.registerService(HelloService.class.getName(), helloService, null);
	

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		helloServiceRegistration.unregister();

	}

}
