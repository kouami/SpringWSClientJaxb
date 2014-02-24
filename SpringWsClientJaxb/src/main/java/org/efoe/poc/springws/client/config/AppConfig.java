/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.axiom.AxiomSoapMessageFactory;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.CommonsHttpMessageSender;

/**
 *
 * @author Emmanuel
 */
@Configuration
public class AppConfig {
    
    @Bean
    public WebServiceTemplate template() {
        WebServiceTemplate t = new WebServiceTemplate();
        t.setDefaultUri("http://localhost:8080/swsj/services/customerServices");
        t.setMarshaller(jaxb2Marshaller());
        t.setUnmarshaller(jaxb2Marshaller());
        t.setMessageFactory(messageFactory());
        t.setMessageSender(messageSender());
        return t;
    }
    
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller m = new Jaxb2Marshaller();
        m.setContextPath("org.efoe.poc.springws.client.model");
        return m;
    }
    
    @Bean
    public CommonsHttpMessageSender messageSender(){
        return new CommonsHttpMessageSender();
    }
    
    @Bean
    public SaajSoapMessageFactory messageFactory(){
        return new SaajSoapMessageFactory();
    }
    
    /*
    @Bean
    public AxiomSoapMessageFactory axiomMessageFactory(){
        return new AxiomSoapMessageFactory();
    }*/
}
