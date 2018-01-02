
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Interface {

	public static Scanner scan;
	public static Rally rally;

	public Interface() {
	}

	public static void main(String[] args) {
		//IO.println(Utils.toString(Utils.VOID_VALUE));
		rally = new Rally();
		scan = new Scanner(System.in);
		cycle("");
	}
	
	public static void cycle(String response)
	{
		if (response != "")
			System.out.println(response);
		System.out.println("> ");
		String option = scan.nextLine();
		
		String[] parts = option.split(" ");
		
		switch(parts[0])
		{
			case "resetInfo":
				rally = new Rally();
				cycle("");
				break;
			case "loadInfo":
				loadInfoHandler();
				break;
			case "addCompetition":
				addCompetitionHandler(parts);
				break;
			case "deleteCompetition":
				deleteCompetitionHandler(parts);
				break;
			case "addTrack":
				addTrackHandler(parts);
				break;
			case "deleteTrack":
				deleteTrackHandler(parts);
				break;
			case "addRaceToCompetition":
				addRaceToCompetitionHandler(parts);
				break;
			case "deleteRace":
				deleteRaceHandler(parts);
				break;
			case "addPilot":
				addPilotHandler(parts);
				break;
			case "deletePilot":
				deletePilotHandler(parts);
				break;
			case "addVehicle":
				addVehicleHandler(parts);
				break;
			case "deleteVehicle":
				deleteVehicleHandler(parts);
				break;
			case "addSponsor":
				addSponsorHandler(parts);
				break;
			case "deleteSponsor":
				deleteSponsorHandler(parts);
				break;
			case "addTeam":
				addTeamHandler(parts);
				break;
			case "deleteTeam":
				deleteTeamHandler(parts);
				break;
			case "addPilotToTeam":
				addPilotToTeamHandler(parts);
				break;
			case "deletePilotFromTeam":
				deletePilotFromTeamHandler(parts);
				break;
			case "addSponsorToTeam":
				addSponsorToTeamHandler(parts);
				break;
			case "deleteSponsorFromTeam":
				deleteSponsorFromTeamHandler(parts);
				break;
			case "addVehicleToTeam":
				addVehicleToTeamHandler(parts);
				break;
			case "deleteVehicleFromTeam":
				deleteVehicleFromTeamHandler(parts);
				break;
			case "deletePilotParticipantFromRace":
				deletePilotParticipantFromRaceHandler(parts);
				break;
			case "setParticipantResultInRace":
				setParticipantResultInRaceHandler(parts);
				break;
			case "listResults":
				listResultsHandler(parts);
				break;
			case "listApplication":
				rally.listApplication();
				cycle("");
				break;
			case "listCalendar":
				rally.listCalendar();
				cycle("");
				break;
			default:
				cycle("Bad Command");
		}
	}
	
	public static void loadInfoHandler()
	{
		TestRally testClass = new TestRally();
	    testClass.testDates();
	    testClass.testRallyCreation();
	    testClass.testAddAndDeleteCompetition();
	    testClass.testAddAndDeleteTrack();
	    testClass.testAddAndDeleteRace();
	    testClass.testAddAndDeletePilot();
	    testClass.testAddAndDeleteVehicle();
	    testClass.testAddAndDeleteSponsor();
	    testClass.testAddAndDeleteTeam();
	    testClass.testAddAndDeltePilotInTeam();
	    testClass.testAddAndDeleteSponsorInTeam();
	    testClass.testAddAndDeleteVehicleInTeam();
	    testClass.testAddAndDeleteParticipantResult();
	    testClass.testCalendar();
	    testClass.testResults();
	    cycle("");
	}
	
	public static void addRaceToCompetitionHandler(String[] message)
	{
		if (message.length != 5)
			cycle("Bad Command");
		
		String racename = separateName(message[1]);
		String compName = separateName(message[2]);
		String trackName = separateName(message[3]);
		
		String[] bday = message[4].split("-");
		if (bday.length != 3)
				cycle("Bad Command");
		
		Object obj = rally.addRaceToCompetition(racename,compName,
				trackName, new RallyUtils.Date(Long.parseLong(bday[0]), Long.parseLong(bday[1]), 
						Long.parseLong(bday[2])));
		System.out.println(obj);
		cycle("");
	}
	
	public static void listResultsHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		
		String eventname = separateName(message[1]);
		
		rally.listResults(eventname);
		cycle("");
	}
	
	public static void setParticipantResultInRaceHandler(String[] message)
	{
		if (message.length != 6)
			cycle("Bad Command");
		
		String racename = separateName(message[1]);
		String pilotName = separateName(message[2]);
		String vehicleName = separateName(message[3]);
		String teamName = separateName(message[4]);
		
		Object obj = rally.setParticipantResultInRace(racename,pilotName,
				vehicleName,teamName,Integer.parseInt(message[5]));
		System.out.println(obj);
		cycle("");
	}
	
	public static void deletePilotParticipantFromRaceHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String raceName = separateName(message[2]);
		
		Object obj = rally.deletePilotParticipantFromRace(name,raceName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteVehicleFromTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.deleteVehicleFromTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addVehicleToTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.addVehicleToTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteSponsorFromTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.deleteSponsorFromTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addSponsorToTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.addSponsorToTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deletePilotFromTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.deletePilotFromTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addPilotToTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.addPilotToTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteRaceHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		Object obj = rally.deleteRace(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteTrackHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		String name = separateName(message[1]);
		Object obj = rally.deleteTrack(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addTrackHandler(String[] message)
	{
		if (message.length != 4)
			cycle("Bad Command");
		String name = separateName(message[1]);
		
		Object obj = rally.addTrack(name,message[2],Integer.parseInt(message[3]));
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteCompetitionHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		String name = separateName(message[1]);
		Object obj = rally.deleteCompetition(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addCompetitionHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		String name = separateName(message[1]);
		String description = separateName(message[2]);
		Object obj = rally.addCompetition(name,description);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteTeamHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		Object obj = rally.deleteTeam(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addTeamHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		Object obj = rally.addTeam(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteSponsorHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		String name = separateName(message[1]);
		Object obj = rally.deleteSponsor(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addSponsorHandler(String[] message)
	{
		if (message.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		String description = separateName(message[2]);
		
		Object obj = rally.addSponsor(name,description);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteVehicleHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		Object obj = rally.deleteVehicle(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addVehicleHandler(String[] message)
	{
		if (message.length != 5)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		Object obj = rally.addVehicle(name,message[2],message[3],message[4]);
		System.out.println(obj);
		cycle("");
	}
	
	
	public static void deletePilotHandler(String[] message)
	{
		if (message.length != 2)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		Object obj = rally.deletePilot(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addPilotHandler(String[] message)
	{
		if (message.length != 4)
			cycle("Bad Command");
		
		String[] bday = message[2].split("-");
		
		if(bday.length != 3)
			cycle("Bad Command");
		
		String name = separateName(message[1]);
		
		Object obj = rally.addPilot(name, new RallyUtils.Date(Long.parseLong(bday[0]), Long.parseLong(bday[1]), 
				Long.parseLong(bday[2])), message[3]);
		System.out.println(obj);
		cycle("");
	}
	
	public static String separateName(String input)
	{
		String name = "";
		String[] nameParts = input.split("_");
		for (int i = 0; i < nameParts.length; i++) {
			name += nameParts[i];
			if (i == nameParts.length-1)
				break;
			name += " ";
		}
		return name;
	}
}
