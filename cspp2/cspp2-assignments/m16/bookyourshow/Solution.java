import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Show {
    private String moviename;
    private String showTime;
    private String[] seats;

    Show (String movie, String showTime, String[] seats) {
        this.moviename = movie;
        this.showTime = showTime;
        this.seats = seats;
    }

    String getMoviename() {
        return moviename;
    }

    String getShowTime() {
        return showTime;
    }


    String[] getSeats()  {
        return seats;
    }

    void setSeatNA(int index) {
        seats[index] = "N/A";
    }

    public String toString() {
        return moviename + "," + showTime;
    }
}

class Patron {
    private String name1;
    private String mobile;

    Patron (String name, String mobile) {
        this.name1 = name;
        this.mobile = mobile;
    }

    String getName() {
        return name1;
    }

    String getMobile() {
        return mobile;
    }

    public String toString() {
        return name1 + " " + mobile;
    }
}

class BookYourShow {
    ArrayList<Show> showList;
    ArrayList<String> ticketList;

    BookYourShow() {
        showList = new ArrayList<>();
        ticketList = new ArrayList<>();
    }

    void addAShow(Show s) {
        showList.add(s);
    }

    Show getAShow(String movie, String showTime) {
        for (Show s : showList)
            if (s.getMoviename().equals(movie) && s.getShowTime().equals(showTime))
                return s;
        return null;
    }

    void bookAShow(String movie, String showTime, Patron patron, String[] seats) {
        Show show = getAShow(movie, showTime);
        if (show == null) {
            System.out.println("No show");
            return;
        }
        boolean flag = false;
        String[] showseats = show.getSeats();
        for (String seat : seats)
            for (int i = 0; i < showseats.length; i++)
                if (seat.equals(showseats[i])) {
                    show.setSeatNA(i);
                    flag = true;
                }


        if (flag) {
            ticketList.add(patron.getMobile()+" "+movie+" "+showTime);
        }
        // System.out.println(ticketList);
    }

    void printTicket(String movie, String showTime, String mobile) {
        String ticket = mobile+" "+movie+" "+showTime;
        if (ticketList.contains(ticket))
            System.out.println(ticket);
        else
            System.out.println("Invalid");
    }

    void showAll() {
        for (Show s : showList)
            System.out.println(s.toString() + "," + Arrays.toString(s.getSeats()).replace(" ",""));
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookYourShow b = new BookYourShow();
        int n = sc.nextInt();
        for (int i=0; i<n+1;i++){
            String line = sc.nextLine();
            String[] tokens = line.split(" ", 2);
            switch (tokens[0]) {
                case "add":
                    String[] elements = tokens[1].split(",", 3);
                    String[] s = (elements[2].substring(1,elements[2].length()-1)).split(",");
                    b.addAShow(new Show(elements[0], elements[1], s));
                    break;
                case "book":
                    elements = tokens[1].split(",",5);
                    s = (elements[4].substring(1,elements[4].length()-1)).split(",");
                    b.bookAShow(elements[0], elements[1],new Patron(elements[2], elements[3]), s);
                    break;
                case "get":
                    elements = tokens[1].split(",",2);
                    Show show = b.getAShow(elements[0], elements[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                    break;
                case "print":
                    elements = tokens[1].split(",",3);
                    b.printTicket(elements[0], elements[1], elements[2]);
                    break;
                case "showAll":
                    b.showAll();
                    break;
            }

        }

    }
}

