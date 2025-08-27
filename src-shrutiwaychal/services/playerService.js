import http from "../http-common";


class PlayerService{
    getAllPlayers(){
        return http.get('/getAll');

    }

    getPlayer (id){
        return http.get(`/getById/${id}`);
    }

   createPlayer(player) {
    return http.post('/add', player);
  }

    updatePlayer(id, player) {
    return http.put(`/update/${id}`, player);
  }

   deletePlayer(id){
    return http.delete(`/delete/${id}`);
   }

   
   getPlayersWithMoreMatches(playerName) {
  return http.get(`/more-than/${playerName}`);
}

}

export default new PlayerService();