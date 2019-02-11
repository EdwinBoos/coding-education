/**
 *
 * @author Edwin Boos
 * Class {@link Log}
 *
 * A Logger class
 *
 *
 */
public final class Log {

 public Log() {}
 private String loggedText = "";

 public Log addText(String text) {
  this.loggedText = this.loggedText + text;
  return this;
 }

 public Log addNumber(int number) {
  this.loggedText = this.loggedText + number;
  return this;
 }

 public Log newLine() {
  this.loggedText = this.loggedText + "\n";
  return this;
 }

 public Log tab() {
  this.loggedText = this.loggedText + "\t";
  return this;
 }

 public String getLoggedText() {
  return this.loggedText;
 }

}
