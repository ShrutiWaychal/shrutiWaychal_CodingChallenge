package com.hexaware.cricketplayer.service;

import java.util.List;
import com.hexaware.cricketplayer.dto.PlayerDTO;
import com.hexaware.cricketplayer.entity.Player;

public interface IPlayerService {
    List<Player> getAllPlayers();
    Player getPlayerById(int id);
    Player createPlayer(PlayerDTO dto);
    Player updatePlayer(int id, PlayerDTO dto);
    void deletePlayer(int id);
}
