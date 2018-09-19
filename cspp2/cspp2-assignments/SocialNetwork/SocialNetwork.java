import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Arrays;
class SocialNetwork{
	public static void getconnections(HashMap<String, ArrayList<String>> map, String name){
		if(map.keySet().contains(name)){
			System.out.println(map.get(name));
		}
		else{
			System.out.println("Not a user in Network");
		}
	}

	public static void addconnection(HashMap<String, ArrayList<String>> map, String account, String newfriend){
		(map.get(account)).add(newfriend);
	}

	public static void addnewuser(HashMap<String, ArrayList<String>> map, String newuser){
		map.put(newuser, new ArrayList<String>());
	}

	public static ArrayList<String> getcommonconnections(HashMap<String, ArrayList<String>> map, String user1, String user2){
		ArrayList<String> common = new ArrayList<>();
		for(String each : map.get(user1)){
			if(map.get(user2).contains(each)){
				common.add(each);
			}
		}
		return common;
	}
	public static void main(String[] args){
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		String l;
		while (sc.hasNext()){
			l = sc.nextLine();
			String[] line1 = l.split(" is connected to ");
			if(line1.length == 2){
				line1[1] = line1[1].replace(".", "");
				String[] tokens = line1[1].split(", ");
				map.put(line1[0], new ArrayList<String>(Arrays.asList(tokens)));
			
			}
			else {
				String[] line = l.split(" ");
				switch(line[0]){
					case "getConnections":
						getconnections(map, line[1]);
						break;
					case "addConnections":
						addconnection(map, line[1], line[2]);
						break;
					case "addNewUser":
						addnewuser(map, line[1]);
						break;
					case "CommonConnections":
						System.out.println(getcommonconnections(map, line[1], line[2]));
						break;
					case "Network":
						String s ="";
						TreeMap<String, ArrayList<String>> sortedmap = new TreeMap<String, ArrayList<String>>(map);
						for(String each: sortedmap.keySet()){
							s += each + ": " + sortedmap.get(each) + ", ";
						}
						System.out.println(s.substring(0, s.length()-2));
					default:
						break;

			}
			}
						
		}
	}
}