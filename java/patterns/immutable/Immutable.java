package org.jsweet;

import static jsweet.dom.Globals.*;

/**
 * 
 * 
 * An example of a implementation of a Lat Lng Immutable Object.
 * Immutable means that the fields or the state of the object cannot be changed, once its initialized in the constructor.
 *
 * 
 * 
 * 
 * Created by Edwin Boos ( 02.06.2017 )
 * with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
 * 
 *
 */
public final class Run {

 public static void main(String[] args) {

  final ImmutableLatLng latlng = new ImmutableLatLng(new ImmutableLatitude(43333.75),
   new ImmutableLongitude(98867.12));

  /**
   * Prints in the console: 
   * 			43333.75
   * 			98867.12
   */
  System.out.println(latlng.getLatitude());
  System.out.println(latlng.getLongitude());

 }

}


public final class ImmutableLatLng {

 private final double latitude;
 private final double longitude;

 public ImmutableLatLng(ImmutableLatitude immutableLatitude, ImmutableLongitude immutableLongitude) {

  this.latitude = immutableLatitude.getLatitude();
  this.longitude = immutableLongitude.getLongitude();

 }

 public double getLatitude() {

  return this.latitude;

 }

 public double getLongitude() {

  return this.longitude;

 }

}


public final class ImmutableLatitude {

 private final double latitude;

 public ImmutableLatitude(double latitude) {

  this.latitude = latitude;

 }

 public double getLatitude() {

  return this.latitude;

 }

}


public final class ImmutableLongitude {

 private final double longitude;

 public ImmutableLongitude(double longitude) {

  this.longitude = longitude;

 }

 public double getLongitude() {

  return this.longitude;

 }

}
