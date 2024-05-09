package sbu.cs;

import java.util.ArrayList;

public class TaskScheduler
{
    public static class Task implements Runnable
    {
        String taskName;
        int    processingTime;

        public Task (String taskName, int processingTime)
        {
            this.taskName       = taskName;
            this.processingTime = processingTime;
        }

        @Override
        public void run ()
        {
            try
            {
                System.out.println ("Executing task: " + taskName);
                Thread.sleep (processingTime);
                System.out.println ("Completed task: " + taskName + "\n");
            }
            catch (InterruptedException e)
            {
                System.out.println (e.getMessage ());
            }
        }
    }

    public static ArrayList <String> doTasks (ArrayList <Task> tasks)
    {
        ArrayList <String> finishedTasks = new ArrayList <> ();

        tasks.sort ((t1, t2) -> t2.processingTime - t1.processingTime); //sort tasks based on processing time

        //execute tasks from the highest required time to the lowest required time
        for (Task task : tasks)
        {
            Thread thread = new Thread (task);
            thread.start ();
            try
            {
                thread.join (); //wait for the task to finish
                finishedTasks.add (task.taskName); //add task name to finished tasks
            }
            catch (InterruptedException e)
            {
                e.printStackTrace ();
            }
        }

        return finishedTasks;
    }

    public static void main (String[] args)
    {
        ArrayList <Task> tasks = new ArrayList <> (); //create an array list of tasks

        //add tasks to the array list
        tasks.add (new Task ("First Task", 1000));
        tasks.add (new Task ("Second Task", 2000));
        tasks.add (new Task ("Third Task", 3000));
        tasks.add (new Task ("Fourth Task", 4000));
        tasks.add (new Task ("Fifth Task", 5000));

        ArrayList <String> finishedTasks = doTasks (tasks); //execute tasks and add their names to the array list
        System.out.println ("Finished tasks: " + finishedTasks); //print all the executed tasks names
    }
}
