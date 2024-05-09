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
        return null;
    }

    public static void main (String[] args)
    {

    }
}
