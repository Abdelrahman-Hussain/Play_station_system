package com.example.play_station_system.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@Table
public class SiteUser implements Serializable {

    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "user_sequence"
    )

    private long id;
    @Id
    private String username;
    private String password;

    @ManyToMany(fetch =EAGER)
    private Collection<Role> roles=new ArrayList<>();


    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            if(obj == null || obj.getClass()!= this.getClass())
                return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        SiteUser p = (SiteUser) obj;
        return (p.id == this.id);
    }
    @Override
    public int hashCode()
    {
        return (int) this.id;
    }

    public SiteUser() {
        
    }

    public long getId() {
        return id;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public void setId(long id) {
        this.id = id;
    }



    public void setUsername(String email) {
        this.username = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public Collection<Role> getRoles() {
        return roles;
    }



    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }




    public SiteUser(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", email='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
