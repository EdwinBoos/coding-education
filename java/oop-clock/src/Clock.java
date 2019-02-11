import java.util.TimerTask;


/**
 *
 * @author Edwin Boos
 * Interface {@link Clock}
 * Let this interface be implemented by following classes {@link Hour}, {@link Minute}, {@link Second}.
 *
 */
public interface Clock {

 /**
  *
  * In the real world, the clock can have a tick on hour, minute and second etc..
  * @returns {int} increments the last timer value by 1 and returns it.
  *
  */
 public int tick();


 /**
  *
  * Resets the current time value by setting it to zero
  *
  */
 public void reset();


 /**
  *
  * Returns the current time value.
  * @returns {int} the current time value
  *
  */
 public int read();


 /**
  *
  * @author Edwin Boos
  * Class {@link Work}
  * extends  {@link TimerTask}
  * implements {@link Enum}
  *
  * Holds the Logic of a clock, and updates/logs the result.
  *
  */
 public final class Work extends TimerTask implements Enum {

  private final Hour hourInstance;
  private final Minute minuteInstance;
  private final Second secondInstance;


  public Work(Hour hourInstance, Minute minuteInstance, Second secondInstance) {

   this.hourInstance = hourInstance;
   this.minuteInstance = minuteInstance;
   this.secondInstance = secondInstance;

  }


  @Override
  public void run() {

   if (secondInstance.tick() > MaxTimers.MAX_SECONDS) {
    secondInstance.reset();

    if (minuteInstance.tick() > MaxTimers.MAX_MINUTES) {
     minuteInstance.reset();

     if (hourInstance.tick() > MaxTimers.MAX_HOURS)

      hourInstance.reset();
    }

   }

   System.out.println(
    new Log().addText("Hour").tab().addNumber(hourInstance.read()).newLine()
    .addText("Minute").tab().addNumber(minuteInstance.read()).newLine()
    .addText("Second").tab().addNumber(secondInstance.read()).newLine()
    .addText("--------------------------------------------")
    .getLoggedText());

  }
 }


 /**
  *
  * @author Edwin Boos
  * Class {@link Hour}
  * implements {@link Clock}
  *
  *
  */
 public final class Hour implements Clock {

  public Hour(int hour) {
   this.hour = hour;
  }
  private int hour;


  @Override
  public int tick() {
   return this.hour += 1;
  }


  @Override
  public void reset() {
   this.hour = 0;
  }


  @Override
  public int read() {
   return this.hour;
  }

 }


 /**
  *
  *
  * @author Edwin Boos
  * Class {@link Minute}
  * implements {@link Clock}
  *
  *
  */
 public final class Minute implements Clock {

  public Minute(int minute) {
   this.minute = minute;
  }
  private int minute;


  @Override
  public int tick() {
   return this.minute += 1;
  }


  @Override
  public void reset() {
   this.minute = 0;
  }


  @Override
  public int read() {
   return this.minute;
  }

 }


 /**
  *
  *
  * @author Edwin Boos
  * Class {@link Second}
  * implements {@link Clock}
  *
  *
  */
 public final class Second implements Clock {

  public Second(int second) {
   this.second = second;
  }
  private int second;


  @Override
  public int tick() {
   return this.second += 1;
  }


  @Override
  public void reset() {
   this.second = 0;
  }


  @Override
  public int read() {
   return this.second;
  }

 }


 /**
  *
  *
  * @author Edwin Boos
  * Class {@link Delay}
  *
  *
  */
 public final class Delay {

  public Delay(int delay) {
   this.delay = delay;
  }
  private final int delay;


  public int getDelay() {
   return this.delay;
  }

 }


 /**
  *
  *
  * @author Edwin Boos
  * Class {@link Period}
  *
  *
  */
 public final class Period {

  public Period(int period) {
   this.period = period;
  }
  private final int period;


  public int getPeriod() {
   return this.period;
  }

 }
}
