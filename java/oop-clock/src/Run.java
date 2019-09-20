import java.util.Timer;

/**
 *
 * @author Edwin Boos
 * Interface {@link Run}
 *
 * Run class with the main method.
 *
 */
public class Run {

 public Run() {
  final int delay = 0;
  final int period = 1000;
  new Timer().schedule(
   new Clock.Work(
    new Clock.Hour(21),
    new Clock.Minute(59),
    new Clock.Second(45)),
   delay,
   period
  );
 }

 public static void main(String[] args) {
  new Run();
 }
}
