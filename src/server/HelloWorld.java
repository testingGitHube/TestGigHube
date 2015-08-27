package server;

import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("/a")
public class HelloWorld {
	public HelloWorld() {
		System.out.println("Hello");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String getChildMessage() throws InterruptedException, Exception {
		System.out.println("this is ok!!!");
		 return "Hi";
	}

	public static void main(String[] args) {
		new HelloWorld();
		HttpServer server;
		try {
			server = HttpServerFactory.create("https://198.53.63.200:9998/");
			server.start();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}