package space.bum.junit.airport;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PassengerPolicy {
  private Flight economyFlight;
  private Passenger kim;

  @Given("^경제적 항공편이 한대 있다$")
  public void 경제적_항공편이_한대_있다() throws Throwable {
    economyFlight = new EconomyFlight("1");
  }

  @When("^일반등급 승객이 한명 도착했다$")
  public void 일반등급_승객이_한명_도착했다() throws Throwable {
    kim = new Passenger("김", false);
  }

  @Then("^일반등급 승객을 경제적 항공편에 탑승 및 취소할 수 있다$")
  public void 일반등급_승객을_경제적_항공편에_탑승_및_취소할_수_있다() throws Throwable {
    assertAll("검증 대상 상태 - 일반 승객 경제적 항공편",
        () -> assertEquals("1", economyFlight.getId()),
        () -> assertEquals(true, economyFlight.addPassenger(kim)),
        () -> assertEquals(1, economyFlight.getPassengers().size()),
        () -> assertTrue(economyFlight.getPassengers().contains(kim)),
        () -> assertEquals(true, economyFlight.removePassenger(kim)),
        () -> assertEquals(0, economyFlight.getPassengers().size()));
  }
}
