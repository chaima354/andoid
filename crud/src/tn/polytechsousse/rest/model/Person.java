package tn.polytechsousse.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
 
    public String getName() {
        return Name;
    }
    public void setName(String firstName) {
        this.Name = Name;
    }
    public String getFamName() {
        return FamName;
    }
    public void setFamName(String lastName) {
        this.FamName = FamName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
     
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
     
    public Person() {
         
        id = -1;
        Name = "";
        FamName = "";
        email = "";
         
    }
 
    public Person(long id, String firstName, String lastName, String email) {
 
        this.id = id;
        this.Name = Name;
        this.FamName = FamName;
        this.email = email;
    }
 
     
    private long id;
    private String Name;
    private String FamName;
    private String email;
         
}