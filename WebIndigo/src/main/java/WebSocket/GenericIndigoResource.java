/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import com.mycompany.indigo.Analysis;
import javax.swing.JOptionPane;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author camran1234
 */
@Path("/")
public class GenericIndigoResource extends Application{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericIndigoResource
     */
    public GenericIndigoResource() {
    }

    // http://localhost:8080/WebIndigo/resources/sayHello
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sayHello")
    public String getHelloMsg(){
        return "Hello World";
    }
    
    /**
     * Retrieves representation of an instance of WebSocket.GenericIndigoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/example")
    public String getJson() {
        //TODO return proper representation object
        System.out.println("Hola JAJAJAJJAJ");
        JOptionPane.showMessageDialog(null, "Hi");
        return "Hola Mundo";
    }

    /**
     * PUT method for updating or creating an instance of GenericIndigoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        Analysis analysis = new Analysis();
        analysis.readText(content);
    }
}
