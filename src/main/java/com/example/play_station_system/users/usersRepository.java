package com.example.play_station_system.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<users,Long> {


    @Query("select u from users u where u.username=?1")
   users findusersByEmail(String email);

}
