
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Interface {

	public static Scanner scan;
	public static Rally rally;

	public Interface() {
	}

	public static void main(String[] args) {
		//IO.println(Utils.toString(Utils.VOID_VALUE);
		rally = new Rally();
		scan = new Scanner(System.in);
		cycle("To list all information type: listAll");
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
			case "listAll":
				listAllHandler();
				break;
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
	
	public static void listAllHandler()
	{
		System.out.println("resetInfo");
		System.out.println("loadInfo");
		System.out.println("addCompetition");
		System.out.println("deleteCompetition");
		System.out.println("addTrack");
		System.out.println("deleteTrack");
		System.out.println("addRaceToCompetition");
		System.out.println("deleteRace");
		System.out.println("addPilot");
		System.out.println("addVehicle");
		System.out.println("deleteVehicle");
		System.out.println("addSponsor");
		System.out.println("deleteSponsor");
		System.out.println("addTeam");
		System.out.println("deleteTeam");
		System.out.println("addPilotToTeam");
		System.out.println("deletePilotFromTeam");
		System.out.println("addSponsorToTeam");
		System.out.println("deleteSponsorFromTeam");
		System.out.println("addVehicleToTeam");
		System.out.println("deleteVehicleFromTeam");
		System.out.println("deletePilotParticipantFromRace");
		System.out.println("setParticipantResultInRace");
		System.out.println("listResults");
		System.out.println("listApplication");
		System.out.println("listCalendar");
		cycle("");
	}
	
	public static void loadInfoHandler()
	{
		rally.addCompetition("wrc", "wrc rally");
		rally.addCompetition("f1", "formula 1");
		rally.addTrack("montecarlo", "italia", 123);
		rally.addTrack("estoril", "algarve", 123);
		rally.addRaceToCompetition("race1", "wrc", "montecarlo", new RallyUtils.Date(2017, 01, 01));
		rally.addRaceToCompetition("race2", "wrc", "montecarlo", new RallyUtils.Date(2017, 01, 02));		
		rally.addRaceToCompetition("race3", "wrc", "montecarlo", new RallyUtils.Date(2017, 01, 04));
		rally.addRaceToCompetition("race4", "wrc", "montecarlo", new RallyUtils.Date(2017, 01, 03));
		rally.addRaceToCompetition("race5", "f1", "estoril", new RallyUtils.Date(2017, 01, 03));

		rally.addTeam("ferrari");

		rally.addPilot("Abel_Aguiar", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Bruno_Bala", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Carlos_Cruz", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Diogo_Delgado", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Ernesto_Esmeraldo", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Fernando_Fernandes", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Guilherme_Goncalves", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Hugo_Helicopetero", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Ilias_Igual", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Joao_Julio", new RallyUtils.Date(1996, 11,30), "Male");
		rally.addPilot("Karmen_Karpito", new RallyUtils.Date(1996, 11,30), "Female");
		rally.addPilot("Lumiar_Luminosa", new RallyUtils.Date(1996, 11,30), "Female");

		rally.addVehicle("carro1", "mclaren", "p8", "99-00-01");
		rally.addVehicle("carro2", "mclaren", "p8", "99-00-02");
		rally.addVehicle("carro3", "mclaren", "p8", "99-00-03");
		rally.addVehicle("carro4", "mclaren", "p8", "99-00-04");
		rally.addVehicle("carro5", "mclaren", "p8", "99-00-05");
		rally.addVehicle("carro6", "mclaren", "p8", "99-00-06");
		rally.addVehicle("carro7", "mclaren", "p8", "99-00-07");
		rally.addVehicle("carro8", "mclaren", "p8", "99-00-08");
		rally.addVehicle("carro9", "mclaren", "p8", "99-00-09");
		rally.addVehicle("carro10", "mclaren", "p8", "99-00-10");
		rally.addVehicle("carro11", "mclaren", "p8", "99-00-11");
		rally.addVehicle("carro12", "mclaren", "p8", "99-00-12");

		rally.addPilotToTeam("Abel_Aguiar", "ferrari");
		rally.addPilotToTeam("Bruno_Bala", "ferrari");
		rally.addPilotToTeam("Carlos_Cruz", "ferrari");
		rally.addPilotToTeam("Diogo_Delgado", "ferrari");
		rally.addPilotToTeam("Ernesto_Esmeraldo", "ferrari");
		rally.addPilotToTeam("Fernando_Fernandes", "ferrari");
		rally.addPilotToTeam("Guilherme_Goncalves", "ferrari");
		rally.addPilotToTeam("Hugo_Helicopetero", "ferrari");
		rally.addPilotToTeam("Ilias_Igual", "ferrari");		
		rally.addPilotToTeam("Joao_Julio", "ferrari");		
		rally.addPilotToTeam("Karmen_Karpito", "ferrari");		
		rally.addPilotToTeam("Lumiar_Luminosa", "ferrari");

		rally.addVehicleToTeam("carro1", "ferrari");
		rally.addVehicleToTeam("carro2", "ferrari");
		rally.addVehicleToTeam("carro3", "ferrari");
		rally.addVehicleToTeam("carro4", "ferrari");
		rally.addVehicleToTeam("carro5", "ferrari");
		rally.addVehicleToTeam("carro6", "ferrari");
		rally.addVehicleToTeam("carro7", "ferrari");
		rally.addVehicleToTeam("carro8", "ferrari");
		rally.addVehicleToTeam("carro9", "ferrari");
		rally.addVehicleToTeam("carro10", "ferrari");
		rally.addVehicleToTeam("carro11", "ferrari");
		rally.addVehicleToTeam("carro12", "ferrari");

		rally.setParticipantResultInRace("race1", "Abel_Aguiar", "carro1", "ferrari", 413);
		rally.setParticipantResultInRace("race1", "Bruno_Bala", "carro2", "ferrari", 465);
		rally.setParticipantResultInRace("race1", "Carlos_Cruz", "carro3", "ferrari", 233);
		rally.setParticipantResultInRace("race1", "Diogo_Delgado", "carro4", "ferrari", 452);
		rally.setParticipantResultInRace("race1", "Ernesto_Esmeraldo", "carro5", "ferrari", 380);
		rally.setParticipantResultInRace("race1", "Fernando_Fernandes", "carro6", "ferrari", 348);
		rally.setParticipantResultInRace("race1", "Guilherme_Goncalves", "carro7", "ferrari", 311);
		rally.setParticipantResultInRace("race1", "Hugo_Helicopetero", "carro8", "ferrari", 311);
		rally.setParticipantResultInRace("race1", "Ilias_Igual", "carro9", "ferrari", 258);
		rally.setParticipantResultInRace("race1", "Joao_Julio", "carro10", "ferrari", 413);
		rally.setParticipantResultInRace("race1", "Karmen_Karpito", "carro11", "ferrari", 426);
		rally.setParticipantResultInRace("race1", "Lumiar_Luminosa", "carro12", "ferrari", 359);

		rally.setParticipantResultInRace("race2", "Abel_Aguiar", "carro1", "ferrari", 443);
		rally.setParticipantResultInRace("race2", "Bruno_Bala", "carro2", "ferrari", 470);
		rally.setParticipantResultInRace("race2", "Carlos_Cruz", "carro3", "ferrari", 380);
		rally.setParticipantResultInRace("race2", "Diogo_Delgado", "carro4", "ferrari", 497);
		rally.setParticipantResultInRace("race2", "Ernesto_Esmeraldo", "carro5", "ferrari", 245);
		rally.setParticipantResultInRace("race2", "Fernando_Fernandes", "carro6", "ferrari", 379);
		rally.setParticipantResultInRace("race2", "Guilherme_Goncalves", "carro7", "ferrari", 337);
		rally.setParticipantResultInRace("race2", "Hugo_Helicopetero", "carro8", "ferrari", 332);
		rally.setParticipantResultInRace("race2", "Ilias_Igual", "carro9", "ferrari", 360);
		rally.setParticipantResultInRace("race2", "Joao_Julio", "carro10", "ferrari", 238);
		rally.setParticipantResultInRace("race2", "Karmen_Karpito", "carro11", "ferrari", 261);
		rally.setParticipantResultInRace("race2", "Lumiar_Luminosa", "carro12", "ferrari", 276);

		rally.setParticipantResultInRace("race3", "Abel_Aguiar", "carro1", "ferrari", 432);
		rally.setParticipantResultInRace("race3", "Bruno_Bala", "carro2", "ferrari", 424);
		rally.setParticipantResultInRace("race3", "Carlos_Cruz", "carro3", "ferrari", 449);
		rally.setParticipantResultInRace("race3", "Diogo_Delgado", "carro4", "ferrari", 443);
		rally.setParticipantResultInRace("race3", "Ernesto_Esmeraldo", "carro5", "ferrari", 273);
		rally.setParticipantResultInRace("race3", "Fernando_Fernandes", "carro6", "ferrari", 404);
		rally.setParticipantResultInRace("race3", "Guilherme_Goncalves", "carro7", "ferrari", 209);
		rally.setParticipantResultInRace("race3", "Hugo_Helicopetero", "carro8", "ferrari", 302);
		rally.setParticipantResultInRace("race3", "Ilias_Igual", "carro9", "ferrari", 301);
		rally.setParticipantResultInRace("race3", "Joao_Julio", "carro10", "ferrari", 390);
		rally.setParticipantResultInRace("race3", "Karmen_Karpito", "carro11", "ferrari", 393);
		rally.setParticipantResultInRace("race3", "Lumiar_Luminosa", "carro12", "ferrari", 370);
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
