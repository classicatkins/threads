//resources in GreetingThreadRunner file

import java.util.Date;

public class GreetingRunnable implements Runnable
{
   public  int repition;
   public  int delay;
   private String greeting;

   //creates a runnable object
   public GreetingRunnable(String aGreeting)
   {
      greeting = aGreeting;
   }

   public void run()
   {
      try
      {
         for (int i = 1; i <= repition; i++)
         {
            Date now = new Date();
            System.out.println(now + " " + greeting);
            Thread.sleep(delay);         
         }
      }

      catch (InterruptedException exception)
      {

      }
   }
}


