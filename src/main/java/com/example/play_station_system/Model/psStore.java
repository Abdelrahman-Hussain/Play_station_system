package com.example.play_station_system.Model;
import lombok.Data;


import java.sql.Time;
import javax.persistence.*;
import java.util.List;
import java.util.Vector;
@Data
@Entity
public class psStore  {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    String name;
    String location;
    int numberOfDevice;
    Time openHour;
    Time closeHour;
     List<String> images;
//    @OneToMany
//    @JoinColumn(name = "owner_username")
//    SiteUser owner;
    int rate=5;
    int numberOfRates=0;
    Vector<String>Feedbacks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Vector<psDevice>myPsDevices;
    //Vector<screenDevice>myScreenDevices;
    //Vector<Controllers>myControllers;
}
