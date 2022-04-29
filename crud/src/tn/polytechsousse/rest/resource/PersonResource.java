package tn.polytechsousse.rest.resource;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Request;

import tn.polytechsousse.rest.model.Person;
 
 
@Path("/person")
public class PersonResource {
 
    private final static String NAME = "Name";
    private final static String FamNAME = "FamName";
    private final static String EMAIL = "email";
         
    private Person person = new Person(1, "first", "Person", "firstperson@gmail.com");
     
   
    @Context
    UriInfo uriInfo;
 
   
    @Context
    Request request;
     
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respondAsReady() {
        return "Demo service is ready!";
    }
 
    @GET
    @Path("sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getSamplePerson() {
         
        System.out.println("Returning sample person: " + person.getName() + " " + person.getFamName());
         
        return person;
    }
         
    // Use data from the client source to create a new Person object, returned in JSON format.  
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(
            MultivaluedMap<String, String> personParams
            ) {
         
        String Name = personParams.getFirst(NAME);
        String FamName = personParams.getFirst(FamNAME);
        String email = personParams.getFirst(EMAIL);
         
        System.out.println("Storing posted " + Name + " " + FamName + "  " + email);
         
        person.setName(Name);
        person.setFamName(FamName);
        person.setEmail(email);
         
        System.out.println("person info: " + person.getName() + " " + person.getFamName() + " " + person.getEmail());
         
        return person;
                         
    }
}