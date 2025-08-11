package com.hexaware.cricketplayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketplayer.dto.PlayerDTO;
import com.hexaware.cricketplayer.entity.Player;
import com.hexaware.cricketplayer.exception.ResourceNotFoundException;
import com.hexaware.cricketplayer.repository.PlayerRepository;

@Service
public class PlayerServiceImpl  implements IPlayerService{
	
	@Autowired
	private PlayerRepository repo;

	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	@Override
	public Player getPlayerById(int id) {
		return repo.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Player with id " + id + " not found"));
			
	}

	@Override
	public Player createPlayer(PlayerDTO playerDTO) {
		Player player = new Player();
		player.setName(playerDTO.getName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setRole(playerDTO.getRole());
        player.setTotalMatches(playerDTO.getTotalMatches());
        player.setTeamName(playerDTO.getTeamName());
        player.setState(playerDTO.getState());
        player.setDescription(playerDTO.getDescription());
		return repo.save(player);
	}

	@Override
	public Player updatePlayer(int id, PlayerDTO playerDTO) {
		Player player = repo.findById(id)
		 .orElseThrow(() -> new ResourceNotFoundException("Player with id " + id + " not found"));

		player.setName(playerDTO.getName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setRole(playerDTO.getRole());
        player.setTotalMatches(playerDTO.getTotalMatches());
        player.setTeamName(playerDTO.getTeamName());
        player.setState(playerDTO.getState());
        player.setDescription(playerDTO.getDescription());
		return repo.save(player);

	}

	@Override
	public void deletePlayer(int id) {
		if(!repo.existsById(id)) {
	        throw new ResourceNotFoundException("Player with id " + id + " not found");
	    }
	    repo.deleteById(id);
	

}
}
