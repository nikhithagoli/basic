import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
/**
 * Class for task.
 */
class Task {
    /**
     * taskname.
     */
    private String taskname;
    private String personname;
    private int time;
    private boolean important;
    private boolean urgent;
    private String status;
    /**
     * Constructs the object.
     *
     * @param      title           The title
     * @param      assignedTo      The assigned to
     * @param      timeToComplete  The time to complete
     * @param      important1       The important
     * @param      urgent1         The urgent
     * @param      status1          The status
     */
    public Task(final String title, final String assignedTo, final int timeToComplete, final boolean important1, final boolean urgent1, final String status1) {
        if (title == null || title.isEmpty()) {
            try {
                throw new Exception("Title not provided");
            } catch (Exception e) {
                //System.out.println("Title not provided");
            }
        } else {
            this.taskname = title;
            this.personname = assignedTo;
            if (timeToComplete < 0) {
                try {
                    throw new Exception("Invalid timeToComplete " + Integer.toString(time));
                } catch (Exception e) {
                    //System.out.println("Invalid timeToComplete " + Integer.toString(time));
                }
            } else {
                this.time = timeToComplete;
                this.important = important1;
                this.urgent = urgent1;
                if (!(status1.equals("done") || status1.equals("todo"))) {
                    try {
                        throw new Exception("Invalid status " + status1);
                    } catch (Exception e) {
                        //System.out.println("Invalid status " + status1);
                    }
                } else {
                    this.status = status1;
                }
            }

        }
    }
    /**
     * gettask.
     *
     * @return     { description_of_the_return_value }
     */
    public String gettask() {
        return this.taskname;
    }
    /**
     * getpersonname.
     *
     * @return     { description_of_the_return_value }
     */
    public String getpersonname() {
        return this.personname;
    }
    /**
     * gettime.
     *
     * @return     { description_of_the_return_value }
     */
    public int gettime() {
        return this.time;
    }
    /**
     * getimportant.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean getimportant() {
        return this.important;
    }
    /**
     * geturgent.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean geturgent() {
        return this.urgent;
    }
    /**
     * get status.
     *
     * @return     { description_of_the_return_value }
     */
    public String getstatus() {
        return this.status;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = taskname + ", " + personname + ", " + time + ", ";
        if (this.important) {
            s += "Important, ";
        } else {
            s += "Not Important, ";
        }
        if (this.urgent) {
            s += "Urgent, ";
        } else {
            s += "Not Urgent, ";
        }
        return s + this.status;
    }
}

/**
 * Class for todoist.
 */
class Todoist {
    /**
     * tasklist
     */
    Task[] tasklist;
    int size;
    /**
     * Constructs the object.
     */
    public Todoist() {
        tasklist = new Task[2 * (2 + 2 + 1)];
        size = 0;
    }
    /**
     * resize.
     */
    public void resize() {
        tasklist =  Arrays.copyOf(tasklist, tasklist.length * 2);
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        if (size == tasklist.length) {
            resize();
        }
        tasklist[size++] = task;
    }
    /**
     * { function_description }
     */
    public void toStringlist() {
        for (Task each : tasklist) {
            System.out.println(each);;
        }
    }
/**
 * Gets the next task.
 *
 * @param      name  The name
 *
 * @return     The next task.
 */
    public Task getNextTask(final String name) {
        for (Task each : tasklist) {
            if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (!each.geturgent())) {
                return each;
            }
        }
        for (Task each : tasklist) {
            if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (each.geturgent())) {
                return each;
            }
        }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      name   The name
     * @param      count  The count
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String name, final int count) {
        Task[] multipletasks = new Task[count];
        int i = 0;
        for (Task each : tasklist) {
            if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (!each.geturgent())) {
                multipletasks[i++] = each;
            }
        }
        if (i == count) {
            return multipletasks;
        }
        for (Task each : tasklist) {
            if (each.getpersonname().equals(name) && each.getstatus().equals("todo") && each.getimportant() && (each.geturgent())) {
                multipletasks[i++] = each;
            }
        }
        if (i == count) {
            return multipletasks;
        }
        return null;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int total = 0;
        for (Task each : tasklist) {
            if (each.getstatus().equals("todo")) {
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
        Task t = null;
        try {
            t = createTask(tokens);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (t != null) {
            System.out.println(t);
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
