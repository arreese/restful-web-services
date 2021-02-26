package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    //fetch = FetchType.LAZY does not fetch the details
    //of User unless you call post.getUser()
    @ManyToOne(fetch = FetchType.LAZY )
    @JsonIgnore
    private User user;


    //Here we don't want to print the details of the user
    //because the User will try to print post and it will cause
    //a memory leak
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
