package com.hexaware.cricketplayer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    private String name; 

    private int jerseyNumber; 

    private String role; 
   
    private int totalMatches; 

    private String teamName;

    private String state; 
    
    private String description;
    
    public Player() {
    	
    }
 public Player(int id, String name, int jerseyNumber,String role, int totalMatches, String teamName, String state, String description) {
     this.id= id;
     this.name =name;
     this.jerseyNumber = jerseyNumber;
	 this.role = role;
	 this.totalMatches = totalMatches;
	 this.teamName = teamName;
	 this.state	= state;
     this.description = description;
    }


	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", jerseyNumber=" + jerseyNumber + ", role=" + role
				+ ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", state=" + state + ", description="
				+ description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
}