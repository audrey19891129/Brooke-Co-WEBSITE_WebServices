package config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ServicesWSImpl;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	
	
	
	@Bean
	public Endpoint endpoint() {
		ServicesWSImpl services = new ServicesWSImpl();
		Endpoint endpoint = new EndpointImpl(bus, services);
		endpoint.publish("/BrookeAndCo");
		//endpoint.setMetadata(Arrays.asList(sourceFromResource("/src/main/resources/complexes.xsd")));
		return endpoint;
	}
	
	private static Source sourceFromResource(String name) {
        URL resource = WebServiceConfig.class.getResource(name);
        String systemId = resource.toExternalForm();
        InputStream inputStream;
        try {
            inputStream = resource.openStream();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create InputStream from resource \""+ name +"\"", e);
        }
        return new StreamSource(inputStream, systemId);
    }
}