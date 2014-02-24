package org.efoe.poc.springws.client;

import org.efoe.poc.springws.client.config.AppConfig;
import org.efoe.poc.springws.client.model.CustomerRequest;
import org.efoe.poc.springws.client.model.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Hello world!
 *
 */
public class App {
    
    
    
    public static void main( String[] args ){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WebServiceTemplate template = context.getBean(WebServiceTemplate.class);
        CustomerRequest request = new CustomerRequest();
        request.setSsn("111111111");
        CustomerResponse response = (CustomerResponse) template.marshalSendAndReceive(request);
        
        System.out.println(response.getFirstName());
        System.out.println(response.getLastName());
        System.out.println(response.getSsn());
    }
    
}
