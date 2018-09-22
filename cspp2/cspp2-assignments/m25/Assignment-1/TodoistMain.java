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
    /**
     * taskname.
     */
    private String personname;
    /**
     * personname.
     */
    private int time;
    /**
     * important.
     */
    private boolean important;
    /**
     * urgent.
     */
    private boolean urgent;
    /**
     * status.
     */
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
     * @throws     Exception        ndkfh
     */
    Task(final String title, final String assignedTo, final int timeToComplete,
    final boolean important1, final boolean urgent1,
    final String status1) throws Exception {
        if (title == null || title.isEmpty()) {
            throw new Exception("Title not provided");
        } else {
            this.taskname = title;
            this.personname = assignedTo;
            if (timeToComplete < 0) {
                throw new Exception("Invalid timeToComplete " + timeToComplete);
            } else {
                this.time = timeToComplete;
                this.important = important1;
                this.urgent = urgent1;
                if (!(status1.equals("done") || status1.equals("todo"))) {
                    throw new Exception("Invalid status " + status1);
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
     * tasklist.
     */
    private Task[] tasklist;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Todoist() {
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
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            System.out.println(tasklist[i]);
        }
        return str;
    }
    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(final String name) {
        for (int i = 0; i < size; i++) {
            if (tasklist[i].getpersonname().equals(name)) {
                if (tasklist[i].getstatus().equals("todo")) {
                    if (tasklist[i].getimportant()) {
                        if (!tasklist[i].geturgent()) {
                            return tasklist[i];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (tasklist[i].getpersonname().equals(name)) {
                if (tasklist[i].getstatus().equals("todo")) {
                    if (tasklist[i].getimportant()) {
                        if (tasklist[i].geturgent()) {
                            return tasklist[i];
                        }
                    }
                }
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
        int size1 = 0;
        for (int i = 0; i < size; i++) {
            if (tasklist[i].getpersonname().equals(name)) {
                if (tasklist[i].getstatus().equals("todo")) {
                    if (tasklist[i].getimportant()) {
                        if (!tasklist[i].geturgent()) {
                            multipletasks[size1++] = tasklist[i];
                        }
                    }
                }
            }
        }
        if (size1 == count) {
            return multipletasks;
        }
        int size2 = 0;
        Task[] multipletask = new Task[count];
        for (int i = 0; i < size; i++) {
            if (tasklist[i].getpersonname().equals(name)) {
                if (tasklist[i].getstatus().equals("todo")) {
                    if (tasklist[i].getimportant()) {
                        if (tasklist[i].geturgent()) {
                            multipletask[size2++] = tasklist[i];
                        }
                    }
                }
            }
        }

        if (size2 == count) {
            return multipletask;
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (tasklist[i].getstatus().equals("todo")) {
                total += tasklist[i].gettime();
            }
        }
        return total;
    }

}
/**
 * Class for todoist main.
 */
public final class TodoistMain {

    /**
     * Starts a test.
     */
    private TodoistMain() {
        //constructor.
    }
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
        int timeToComplete = Integer.parseInt(tokens[2 + 1]);
        boolean important = tokens[2 + 2].equals("y");
        boolean urgent = tokens[2 + 2 + 1].equals("y");
        String status = tokens[2 + 2 + 2];
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
