import java.util.Timer;

/**
 *
 * @author Edwin Boos
 * Interface {@link Run}
 *
 * Run class with the main method.
 *
 */
public class Run  {

    
    public static void main(String[] args)
    {

        new Timer().schedule(
                new Clock.Work(
                        new Clock.Hour(21),
                        new Clock.Minute(59),
                        new Clock.Second(45)), 
                new Clock.Delay(0).getDelay(), 
                new Clock.Period(1000).getPeriod());

    }
}
