package space.bum.junit.mileage;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import space.bum.junit.airport.Passenger;

public class Mileage {

  public static final int VIP_FACTOR = 10;
  public static final int REGULAR_FACTOR = 20;

  private Map<Passenger, Integer> mileages = new HashMap<>();
  private Map<Passenger, Integer> points = new HashMap<>();

  public Map<Passenger, Integer> getPoints() {
    return points;
  }

  public void addMileage(Passenger passenger, int miles) {
    mileages.put(passenger, mileages.getOrDefault(passenger, 0) + miles);
  }

  public void calculateGivenPoints() {
    mileages.keySet().forEach(
        passenger -> points.put(passenger, mileages.get(passenger)
            / (passenger.isVip() ? VIP_FACTOR : REGULAR_FACTOR)));
  }
}
