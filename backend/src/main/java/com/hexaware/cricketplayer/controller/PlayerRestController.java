package com.hexaware.cricketplayer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketplayer.dto.PlayerDTO;
import com.hexaware.cricketplayer.entity.Player;
import com.hexaware.cricketplayer.exception.ResourceNotFoundException;
import com.hexaware.cricketplayer.service.IPlayerService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	
	@Autowired
	IPlayerService service;
	
	@PostMapping("/add")
	public Player addPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
		return service.createPlayer(playerDTO);
	}

	@PutMapping("/update/{id}")
	public Player updatePlayer(@PathVariable @Min(1)int id,@Valid @RequestBody PlayerDTO playerDTO) {
		return service.updatePlayer(id, playerDTO);
	}
	
	@GetMapping("/getAll")
	 public List<Player> getAllPlayers(){
		return service.getAllPlayers();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable @Min(1) int id) {
	    Player player = service.getPlayerById(id);
	    return ResponseEntity.ok(player);
	}

	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable @Min(1) int id) {
        service.deletePlayer(id);
        return ResponseEntity.ok("Player deleted successfully");
    }
	@GetMapping("/more-than/{name}")
    public List<Player> getPlayersMoreMatches(@PathVariable("name") String playerName) {
        return service.getPlayersWithMoreMatchesThan(playerName);
    }
	
	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<String> handlePlayerNotFound(ResourceNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	

}
