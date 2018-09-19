import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedInputStream;
class Food {
	private String foodname;
	private String datetime;
	private int quantity;
	public Food(String n, String d, int q) {
		this.foodname = n;
		this.datetime = d;
		this.quantity = q;
	}

	public String getfoodname() {
		return this.foodname;
	}

	public String getdatetime() {
		return this.datetime;
	}

	public int getquantity() {
		return this.quantity;
	}
	public String toString() {
		return "Food: \n" + "name: " + foodname + "\n" + "Date and time: "
               + datetime + "\n" + "Quantity: " + quantity ;
	}
}

class Water {
	private int quantity;
	private String datetime;
	public Water(int d, String q) {
		this.quantity = d;
		this.datetime = q;
	}

	public String getdatetime() {
		return this.datetime;
	}

	public int getquantity() {
		return this.quantity;
	}

	public String toString() {
		return "water\n" + "Date: " + datetime + "\n" + "Quantity:" + quantity + "ml";
	}
}

class PhysicalActivity {
	private String activityname;
	private String date;
	private String starttime;
	private String endtime;
	private String notes;
	public PhysicalActivity(String n, String d, String s, String e) {
		this.activityname = n;
		this.date = d;
		this.starttime = s;
		this.endtime = e;
	}

	public PhysicalActivity(String name, String d, String s, String e, String n) {
		this.activityname = name;
		this.date = d;
		this.starttime = s;
		this.endtime = e;
		this.notes = n;
	}

	public String getactivityname() {
		return this.activityname;
	}

	public String getdate() {
		return this.date;
	}

	public String getstarttime() {
		return this.starttime;
	}
	public String getendtime() {
		return this.endtime;
	}

	public String getnotes() {
		return this.notes;
	}

	public String toString() {
		if (notes != null) {
			return "PhysicalActivity\n" + "name: " + activityname + "\n" + "date: " + date + "\n"
                   + "StartTime: " + starttime + "\n" + "Endtime: " + endtime + "\n" + "Notes: " + notes ;
		}
		return "PhysicalActivity\n" + "name: " + activityname + "\n" + "date: " + date + "\n"
               + "StartTime: " + starttime + "\n" + "Endtime: " + endtime ;
	}
}

class Weight {
	private String weight;
	private String fatpercentage;
	private String date;
	public Weight(String w, String d, String f) {
		this.weight = w;
		this.date = d;
		this.fatpercentage = f;
	}

	public String getdate() {
		return this.date;
	}

	public String getweight() {
		return this.weight;
	}

	public String getfatpercentage() {
		return this.fatpercentage;
	}

	public String toString() {
		return "Weight\n" + "Date:" + date + "\n" + "Weight" + weight + "\n" + "Fat " + fatpercentage;
	}
}

class Sleep {
	private String starttime;
	private String endtime;
	public Sleep(String s, String e) {
		this.starttime = s;
		this.endtime = e;
	}

	public String getstarttime() {
		return this.starttime;
	}

	public String getendtime() {
		return this.endtime;
	}

	public String toString() {
		return "Sleep\n" + "StartTime: " + starttime + "\n" + "Endtime: " + endtime ;
	}

}
class FitByte {
	public static void main(String[] args) {
		ArrayList<Food> foodlog = new ArrayList<>();
		ArrayList<Water> waterlog = new ArrayList<>();
		ArrayList<PhysicalActivity> activitylog = new ArrayList<>();
		ArrayList<Weight> weightlog = new ArrayList<>();
		ArrayList<Sleep> sleeplog = new ArrayList<>();
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			switch (tokens[0]) {
			case "Food":
				foodlog.add(new Food(tokens[1], tokens[2], Integer.parseInt(tokens[2 + 1])));
				break;
			case "Water":
				waterlog.add(new Water(Integer.parseInt(tokens[1]), tokens[2]));
				break;
			case "PhysicalActivity":
				if (tokens.length == 2 + 2 + 1) {
					activitylog.add(new PhysicalActivity(tokens[1], tokens[2], tokens[2 + 1], tokens[2 + 2]));
				} else {
					activitylog.add(new PhysicalActivity(tokens[1], tokens[2], tokens[2 + 1], tokens[2 + 2], tokens[2 + 2 + 1]));
				}
				break;
			case "Weight":
				weightlog.add(new Weight(tokens[1], tokens[2],tokens[2 + 1]));
				break;
			case "Sleep":
				sleeplog.add(new Sleep(tokens[1], tokens[2]));
				break;
			case "Foodlog":
				for (Food e : foodlog) {
					//if (e.getdatetime().equals(tokens[1])) {
						System.out.println(e);
						System.out.println();
				}
				break;
			case "Waterlog":
				for (Water e : waterlog) {
					//if (e.getdatetime().equals(tokens[1])) {
						System.out.println(e);
						System.out.println();
				}
				break;
			case "PhysicalActivitylog":
				for (PhysicalActivity e : activitylog) {
					//if (e.getdate().equals(tokens[1])) {
						System.out.println(e);
						System.out.println();
					
				}
				break;
			case "Weightlog":
				for (Weight e : weightlog) {
					//if (e.getdate().equals(tokens[1])) {
						System.out.println(e);
						System.out.println();
					
				}
				break;
			case "Sleeplog":
				for (Sleep e : sleeplog) {
					//if (e.getdate().equals(tokens[1])) {
						System.out.println(e);
						System.out.println();
					
				}
				break;
			case "Summary":
                for (Food e : foodlog) {
                    System.out.println(e);
                }
                for (Water e : waterlog) {
                    System.out.println(e);
                }
                for (PhysicalActivity e : activitylog) {
                    System.out.println(e);
                }
                for (Weight e : weightlog) {
                    System.out.println(e);
                }
                for (Sleep e : sleeplog) {
                    System.out.println(e);
                }
                break;
			default:
				break;

			}
		}
	}
}