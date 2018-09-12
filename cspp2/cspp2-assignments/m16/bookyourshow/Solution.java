import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
    /**
     * moviename.
     */
    private String moviename;
    /**
     * showtime.
     */
    private String showTime;
    /**
     * seats.
     */
    private String[] seats;
    /**
     * Constructs the object.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      seats     The seats
     */
    Show (String movie, String showTime, String[] seats) {
        this.moviename = movie;
        this.showTime = showTime;
        this.seats = seats;
    }
    /**
     * Gets the moviename.
     *
     * @return     The moviename.
     */
    String getMoviename() {
        return moviename;
    }
    /**
     * Gets the show time.
     *
     * @return     The show time.
     */
    String getShowTime() {
        return showTime;
    }

    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    String[] getSeats()  {
        return seats;
    }
    /**
     * Sets the seat na.
     *
     * @param      index  The index
     */
    void setSeatNA(int index) {
        seats[index] = "N/A";
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return moviename + "," + showTime;
    }
}
/**
 * Class for patron.
 */
class Patron {
    /**
     * moviename1.
     */
    private String name1;
    /**
     * mobile number.
     */
    private String mobile;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      mobile  The mobile
     */

    Patron (String name, String mobile) {
        this.name1 = name;
        this.mobile = mobile;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name1;
    }
    /**
     * Gets the mobile.
     *
     * @return     The mobile.
     */
    String getMobile() {
        return mobile;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name1 + " " + mobile;
    }
}
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * shows array.
     */
    ArrayList<Show> showList;
    /**
     * tickets.
     */
    ArrayList<String> ticketList;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        showList = new ArrayList<>();
        ticketList = new ArrayList<>();
    }
    /**
     * Adds a show.
     *
     * @param      s     { parameter_description }
     */
    void addAShow(Show s) {
        showList.add(s);
    }
    /**
     * Gets a show.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     *
     * @return     A show.
     */
    Show getAShow(String movie, String showTime) {
        for (Show s : showList)
            if (s.getMoviename().equals(movie) &&
             s.getShowTime().equals(showTime))
                return s;
        return null;
    }
    /**
     * booking.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      patron    The patron
     * @param      seats     The seats
     */
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
            ticketList.add(patron.getMobile() + " " + movie + " " + showTime);
        }
        // System.out.println(ticketList);
    }
    /**
     * printing.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      mobile    The mobile
     */
    void printTicket(String movie, String showTime, String mobile) {
        String ticket = mobile + " " + movie + " " + showTime;
        if (ticketList.contains(ticket))
            System.out.println(ticket);
        else
            System.out.println("Invalid");
    }
    /**
     * Shows all.
     */
    void showAll() {
        for (Show s : showList)
            System.out.println(s.toString() + "," + 
                Arrays.toString(s.getSeats()).replace(" ", ""));
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
        for (int i = 0; i < n + 1; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ", 2);
            switch (tokens[0]) {
            case "add":
                String[] elements = tokens[1].split(",", 3);
                String[] s = (elements[2].
                    substring(1, elements[2].length() - 1)).split(",");
                b.addAShow(new Show(elements[0], elements[1], s));
                break;
            case "book":
                elements = tokens[1].split(",", 5);
                s = (elements[4].
                    substring(1, elements[4].length() - 1)).split(",");
                b.bookAShow(elements[0], elements[1],
                 new Patron(elements[2], elements[3]), s);
                break;
            case "get":
                elements = tokens[1].split(",", 2);
                Show show = b.getAShow(elements[0], elements[1]);
                if (show != null) {
                    System.out.println(show);
                } else {
                    System.out.println("No show");
                }
                break;
            case "print":
                elements = tokens[1].split(",", 3);
                b.printTicket(elements[0], elements[1], elements[2]);
                break;
            case "showAll":
                b.showAll();
                break;
            }

        }

    }
}

