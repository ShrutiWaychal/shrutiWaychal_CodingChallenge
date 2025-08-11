package com.hexaware.cricketplayer.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PlayerDTO {

    private int id; 

    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @Min(1)
    @Max(99)
    private int jerseyNumber;

    @NotEmpty(message = "Role is required")
    @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder")
    private String role;

    @Min(value = 0, message = "Total matches cannot be negative")
    private int totalMatches;

    @NotEmpty
    private String teamName;

    @NotEmpty
    private String state;

    @Size(max = 500, message = "Description can be max 500 characters")
    private String description;

    public PlayerDTO() {}

    public PlayerDTO(Integer id, String name, Integer jerseyNumber, String role,
                     Integer totalMatches, String teamName, String state, String description) {
        this.id = id;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.state = state;
        this.description = description;
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

	@Override
	public String toString() {
		return "PlayerDTO [id=" + id + ", name=" + name + ", jerseyNumber=" + jerseyNumber + ", role=" + role
				+ ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", state=" + state + ", description="
				+ description + "]";
	}
}