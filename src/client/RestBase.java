package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class RestBase {
    public static void main(String[] args) {

        Client client = Client.create(new DefaultClientConfig());

        WebResource service = client.resource(UriBuilder.fromUri(
                "http://localhost:9998").build());
        String result = service.path("javad/akbar").queryParam("id", "2").queryParam("name", "16").accept(
                MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(result);




    }


}