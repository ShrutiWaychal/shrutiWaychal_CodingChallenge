package com.hexaware.cricketplayer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketplayer.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	@Query("SELECT p FROM Player p WHERE p.totalMatches > " +
		       "(SELECT p2.totalMatches FROM Player p2 WHERE p2.name = :playerName)")
		List<Player> findPlayersWithMoreMatchesThan(@Param("playerName") String playerName);
	
}
