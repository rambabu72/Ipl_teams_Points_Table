package com.ram.ipl1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Team> teamList;

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teamList = new ArrayList<Team>();
		
		teamList.add(new Team("RCB",23, new String[] {"L","W","L","W","W"}));
		teamList.add(new Team("GT",22, new String[] {"W","L","W","L","L"}));
		teamList.add(new Team("LSG",24, new String[] {"W","W","L","W","L"}));
		teamList.add(new Team("RR",18, new String[] {"L","L","W","L","W"}));
		teamList.add(new Team("DC",16, new String[] {"L","W","W","L","W"}));
		teamList.add(new Team("KKR",20, new String[] {"W","L","L","W","L"}));
		teamList.add(new Team("PBKS",23, new String[] {"W","L","W","W","L"}));
		teamList.add(new Team("SRH",12, new String[] {"L","W","L","L","W"}));
		teamList.add(new Team("CSK",14, new String[] {"L","L","L","L","L"}));
		teamList.add(new Team("MI",22, new String[] {"L","L","L","L","L"}));
		
		
		
		
		int totalPointsOfConsecutiveTeams=0;//variable to add the points of teams comes under requested consecutive category
		
		List<String> teamsWithMatchingConsecutives=new ArrayList<String>();// a list to store requested consecutive teams 
		
		int teamPoints = 0;
		
		List<String> matchingConsecutives = new ArrayList<String>();

		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.show teamspointtable\n2.enter consecutive win or lose\n3.Average points\n4.Total Wins or Loses");
			
			System.out.println("\n Enter your choice");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				//sorting the Team objects based on their points and printing them
				teamList.sort(Comparator.comparing(Team::getTeamPoints));
				System.out.println(" Teams\tPoints\tLast5Status \n");
				for(int i=teamList.size()-1;i>=0;i--) {
					System.out.println(teamList.get(i));
				}
				
				
				
				
				
				break;
				
			case 2:
				//taking the input to perform 2 consecutive win or loss
				Scanner input=new Scanner(System.in);
				System.out.println("Enter the team with 2 consecutive wins or loss u want please enter W or L :\n");
				String consecutiveUserInput=input.nextLine().toUpperCase();
				
								
				for(int j=0;j<teamList.size();j++) {//Looping over the List of team
					for(int k=0;k<4;k++) {
						
						//looping over the statusOfTeams in Team class
						
						if(teamList.get(j).getStatusOfTeam(k).equals(consecutiveUserInput) && teamList.get(j).getStatusOfTeam(k+1).equals(consecutiveUserInput)) {
							totalPointsOfConsecutiveTeams+=teamList.get(j).getTeamPoints();
							teamsWithMatchingConsecutives.add(teamList.get(j).getTeamName());
							break;
						}
						
					}
				}
				
				System.out.println("Teams with 2 consicutive "+consecutiveUserInput+" are : ");
				for(String teams:teamsWithMatchingConsecutives) {
					
					//printing the obtained teams under consecutive category
					System.out.println(teams);
				}
				break;
				
			case 3:
				//printing the average of points with those teams with the requested status of win or loss
				System.out.println("Average points of these teams is : "+(totalPointsOfConsecutiveTeams/teamsWithMatchingConsecutives.size()));
				break;
				
			case 4:
				// taking input from user of n number of matches wins or loses;
				
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please Enter Total number of wins or loses");
				int num1 = scanner.nextInt();
				Scanner scv = new Scanner(System.in);
				System.out.println("please enter wins or loses");
				String string = scv.nextLine().toUpperCase();
				int count = 0;
				
				for(int j=0;j<teamList.size();j++) {
					for(int i=0;i<4;i++) {
						
			
							if(teamList.get(j).getStatusOfTeam(i).equals(string) && teamList.get(j).getStatusOfTeam(i+1).equals(string) ) {
							teamPoints += teamList.get(j).getTeamPoints();
							matchingConsecutives.add(teamList.get(j).getTeamName());
							count++;
							break;
							}
							else {
								count--;
							}
						
						
					}
				}
				
				System.out.println("teams with "+num1+" consecutive "+string+" are: ");
				for(String team:matchingConsecutives) {
					System.out.println(team);
				}
				
				
				System.out.println("Average Points of teams: "+teamPoints/matchingConsecutives.size());
				
				break;
			}
		}

	}

}
