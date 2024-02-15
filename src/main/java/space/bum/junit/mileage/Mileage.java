package space.bum.junit.mileage;

import java.util.HashMap;
import java.util.Map;

import space.bum.junit.airport.Passenger;

public class Mileage {

  public static final int VIP_FACTOR = 10;
  public static final int REGULAR_FACTOR = 20;

  private Map<Passenger, Integer> mileages = new HashMap<>();
  private Map<Passenger, Integer> points = new HashMap<>();

  public void addMileage(Passenger passenger, int miles) {
  }

  public void calculateGivenPoints() {
  }
}
