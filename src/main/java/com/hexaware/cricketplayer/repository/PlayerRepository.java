package com.hexaware.cricketplayer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketplayer.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
