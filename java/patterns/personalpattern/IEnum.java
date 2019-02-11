/**
 * 
 * 
 * An example for storing multiple 'enum' types in one interface
 * 
 * 
 * 
 * Created by Edwin Boos ( 11.02.2019 )
 * with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
 * 
 *
 */
package org.jsweet;


public final class Run implements IEnums {

 public static void main(String[] args) {

  System.out.println(EnumCar.VW.toString());
  System.out.println(EnumCar.AUDI.toString());
  System.out.println(EnumColor.BLACK.toString());
  System.out.println(EnumColor.WHITE.toString());

 }
}


public interface IEnums {

 public enum EnumCar {
  VW,
  AUDI;

  @Override
  public String toString() {
   return this.name();
  }
 }


 public enum EnumColor {
  BLACK,
  WHITE;

  @Override
  public String toString() {
   return this.name();
  }
 }


}
