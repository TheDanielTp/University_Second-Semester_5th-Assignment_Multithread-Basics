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
                System.out.println ("Completed task: " + taskName);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace ();
            }
        }
    }

    public static ArrayList <String> doTasks (ArrayList <Task> tasks)
    {
        ArrayList <String> finishedTasks = new ArrayList <> ();

        // Sort tasks based on processing time (descending order)
        tasks.sort ((t1, t2) -> t2.processingTime - t1.processingTime);

        // Execute tasks
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

    }
}
