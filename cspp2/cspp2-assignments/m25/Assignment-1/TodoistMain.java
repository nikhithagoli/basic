import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

class Task{
	private String taskname;
	private String personname;
	private int time;
	private boolean important;
	private boolean urgent;
	private String status;

	public Task(String title, String assignedTo, int timeToComplete, boolean important, boolean urgent, String status){
		if(title == null || title.isEmpty()){
        	try {
            	throw new Exception("Title not provided");
        	} catch (Exception e) {
            	System.out.println();
        	}
    	} else{
        	this.taskname = title;
        	this.personname = assignedTo;
        	if(timeToComplete < 0){
        		try{
        			throw new Exception("Invalid timeToComplete ");
        		} catch (Exception e){
        			System.out.println(Integer.toString(time));
        		}
        	} else {
        		this.time = timeToComplete;
        		this.important = important;
				this.urgent = urgent;
				if (!(status.equals("done") || status.equals("todo"))){
					try {
						throw new Exception("Invalid status ");
					} catch (Exception e){
						System.out.println(status);
					}
				} else {
					this.status = status;
				}
        	}

    	}
	}

	public String gettask(){
		return this.taskname;
	}

	public String getpersonname(){
		return this.personname;
	}

	public int gettime(){
		return this.time;
	}

	public boolean getimportant(){
		return this.important;
	}

	public boolean geturgent(){
		return this.urgent;
	}

	public String getstatus(){
		return this.status;
	}

	public String toString(){
		String s = taskname + ", " + personname + ", " + time + ", ";
		if (this.important){
			s += "Important, ";
		} else {
			s += "Not Important, ";
		}
		if (this.urgent){
			s += "Urgent, ";
		} else {
			s += "Not Urgent, ";
		}
		return s + this.status; 
	}
}


class Todoist{
	Task[] tasklist;
	int size;

	public Todoist(){
		tasklist = new Task[2 * (2 + 2 + 1)];
		size = 0;
	}

	public void resize(){
		tasklist =  Arrays.copyOf(tasklist, tasklist.length * 2);
	}

	public void addTask(Task task){
		if (size == tasklist.length){
			resize();
		}
		tasklist[size++] = task;
	}

	public void toStringlist(){
		for (Task each: tasklist){
			System.out.println(each);;
		}
	}

	public Task getNextTask(String name){
		for(Task each: tasklist){
			if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (!each.geturgent())){
				return each;
			}
		}
		for(Task each: tasklist){
			if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (each.geturgent())){
				return each;
			}
		}
		return null;
	}

	public Task[] getNextTask(String name, int count){
		Task[] multipletasks = new Task[count];
		int i = 0;
		for(Task each: tasklist){
			if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (!each.geturgent())){
				multipletasks[i++] = each;
			}
		}
		if(i == count){
			return multipletasks;
		}
		for(Task each: tasklist){
			if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (each.geturgent())){
				multipletasks[i++] = each;
			}
		}
		if (i == count){
			return multipletasks;
		}
		return null;
	}

	public int totalTime4Completion(){
		int total = 0;
		for (Task each: tasklist){
			if (each.getstatus().equals("todo")){
				total += each.gettime();
			}
		}
		return total;
	}
	
 }
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
