package com.example.play_station_system.Repo;

import com.example.play_station_system.Model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<SiteUser,Long> {


    @Query("select u from SiteUser u where u.username=?1")
    SiteUser findusersByEmail(String email);

}
