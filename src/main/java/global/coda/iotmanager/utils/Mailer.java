/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.coda.iotmanager.utils;

/**
 *
 * @author main
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.util.*;


import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
public class Mailer {
   public static ClientResponse SendSimpleMessage(String to,String subject,String message) {
    Client client = Client.create();
    client.addFilter(new HTTPBasicAuthFilter("api", "key-ac62a2b1a584f198ee9bb7c13547b686"));
    WebResource webResource = (WebResource) client.resource("https://api.mailgun.net/v3/sandbox91769ec2153044dd8d63ae20093a5093.mailgun.org/messages");
    MultivaluedMapImpl formData = new MultivaluedMapImpl();
    formData.add("from", "Mailgun Sandbox <postmaster@sandbox91769ec2153044dd8d63ae20093a5093.mailgun.org>");
    formData.add("to", to);
    formData.add("subject", subject);
    formData.add("text", message);
    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                                        post(ClientResponse.class, formData);
    }
   
    public static void Send(String to,String subject,String message) {
    
        SendSimpleMessage(to,subject,message);
    }
}

