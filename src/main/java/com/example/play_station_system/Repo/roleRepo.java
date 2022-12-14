package com.example.play_station_system.Repo;

import com.example.play_station_system.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepo  extends JpaRepository<Role,Long> {
    @Query("select r from Role r where r.name=?1")
    Role findByName(String name);
}
