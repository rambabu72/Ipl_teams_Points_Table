package com.ram.ipl1;

import java.util.Arrays;

public class Team {
	
	
	String teamName;
	int teamPoints;
	String[] statusOfTeam;
	
	
	public Team() {}
	
	public Team(String teamName,int teamPoints, String[] statusOfTeam) {
		this.teamName = teamName;
		this.teamPoints = teamPoints;
		this.statusOfTeam = statusOfTeam;
	}
	
	
	
	public String  toString() {
		return (" "+this.teamName+"  "+this.teamPoints+"  "+Arrays.toString(this.statusOfTeam));
	}

		
	

	public String getStatusOfTeam(int n) {
		return statusOfTeam[n];
	}

	public void setStatusOfTeam(String[] statusOfTeam) {
		this.statusOfTeam = statusOfTeam;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamPoints() {
		return teamPoints;
	}

	public void setTeamPoints(int teamPoints) {
		this.teamPoints = teamPoints;
	}

}
