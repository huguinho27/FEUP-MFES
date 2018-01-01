
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
		
		/*for (int i = 0; i < parts.length;i++)
			System.out.println(parts[i]);*/
		
		
		switch(parts[0])
		{
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
			default:
				cycle("");
		}
	}
	
	public static void addPilotToTeamHandler(String[] message)
	{
		if (message.length != 3)
			cycle("");
		
		String name = separateName(message[1]);
		String teamName = separateName(message[2]);
		
		Object obj = rally.addPilotToTeam(name,teamName);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteRaceHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.deleteRace(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteTrackHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.deleteTrack(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addTrackHandler(String[] message)
	{
		if (message.length != 4)
			cycle("");
		String name = separateName(message[1]);
		
		Object obj = rally.addTrack(name,message[2],Integer.parseInt(message[3]));
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteCompetitionHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.deleteCompetition(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addCompetitionHandler(String[] message)
	{
		if (message.length != 3)
			cycle("");
		String name = separateName(message[1]);
		String description = separateName(message[2]);
		Object obj = rally.addCompetition(name,description);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteTeamHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.deleteTeam(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addTeamHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.addTeam(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteSponsorHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.deleteSponsor(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addSponsorHandler(String[] message)
	{
		if (message.length != 3)
			cycle("");
		String name = separateName(message[1]);
		String description = separateName(message[2]);
		Object obj = rally.addSponsor(name,description);
		System.out.println(obj);
		cycle("");
	}
	
	public static void deleteVehicleHandler(String[] message)
	{
		if (message.length != 2)
			cycle("");
		String name = separateName(message[1]);
		Object obj = rally.deleteVehicle(name);
		System.out.println(obj);
		cycle("");
	}
	
	public static void addVehicleHandler(String[] message)
	{
		if (message.length != 5)
			cycle("");
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
