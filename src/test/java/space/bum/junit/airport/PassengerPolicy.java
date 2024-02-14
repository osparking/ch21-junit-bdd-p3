package space.bum.junit.airport;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PassengerPolicy {
  private Flight economyFlight;
  private Passenger kim;
  private Flight businessFlight;
  private Flight premiumFlight;
  private Passenger park;

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

  @Then("^일반 승객을 경제 항공편에 다중 탑승시킬 수 없다$")
  public void 일반_승객을_경제_항공편에_다중_탑승시킬_수_없다() throws Throwable {
    for (int i = 0; i < 10; i++) {
      economyFlight.addPassenger(kim);
    }
    assertAll(
        "Verify a regular passenger can be added to an economy flight only once",
        () -> assertEquals(1, economyFlight.getPassengers().size()),
        () -> assertTrue(economyFlight.getPassengers().contains(kim)),
        () -> assertTrue(new ArrayList<>(economyFlight.getPassengers())
            .get(0).getName().equals("김")));
  }

  @When("^VIP 승객이 한명 도착했다$")
  public void vip_승객이_한명_도착했다() throws Throwable {
    park = new Passenger("박", true);
  }

  @Then("^VIP 를 경제 항공편에 탑승가능하나 취소는 불가능하다$")
  public void vip_를_경제_항공편에_탑승가능하나_취소는_불가능하다() throws Throwable {
    assertAll("Verify all conditions for a VIP passenger and an economy flight",
        () -> assertEquals("1", economyFlight.getId()),
        () -> assertEquals(true, economyFlight.addPassenger(park)),
        () -> assertEquals(1, economyFlight.getPassengers().size()),
        () -> assertTrue(economyFlight.getPassengers().contains(park)),
        () -> assertEquals(false, economyFlight.removePassenger(park)),
        () -> assertEquals(1, economyFlight.getPassengers().size()));
  }

  @Then("^VIP 승객을 경제 항공편에 다중 탑승시킬 수 없다$")
  public void vip_승객을_경제_항공편에_다중_탑승시킬_수_없다() throws Throwable {
    for (int i = 0; i < 10; i++) {
      economyFlight.addPassenger(park);
    }

    assertAll(
        "Verify a VIP passenger can be added to an economy flight only once",
        () -> assertEquals(1, economyFlight.getPassengers().size()),
        () -> assertTrue(economyFlight.getPassengers().contains(park)),
        () -> assertTrue(new ArrayList<>(economyFlight.getPassengers())
            .get(0).getName().equals("박")));
  }

  @Given("^비즈니스 항공편이 한대 있다$")
  public void 비즈니스_항공편이_한대_있다() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    businessFlight = new BusinessFlight("2");
  }

  @Then("^일반 승객의 비즈니스편 탑승 및 취소 모두 불가능하다$")
  public void 일반_승객의_비즈니스편_탑승_및_취소_모두_불가능하다() throws Throwable {
    assertAll(
        "Verify all conditions for a regular passenger and a business flight",
        () -> assertEquals(false, businessFlight.addPassenger(kim)),
        () -> assertEquals(0, businessFlight.getPassengers().size()),
        () -> assertEquals(false, businessFlight.removePassenger(kim)),
        () -> assertEquals(0, businessFlight.getPassengers().size()));
  }

  @Then("^VIP의 비즈니스편 탑승은 가능하나 취소는 불가능하다$")
  public void vip의_비즈니스편_탑승은_가능하나_취소는_불가능하다() throws Throwable {
    assertAll("Verify all conditions for a VIP passenger and a business flight",
        () -> assertEquals(true, businessFlight.addPassenger(park)),
        () -> assertEquals(1, businessFlight.getPassengers().size()),
        () -> assertEquals(false, businessFlight.removePassenger(park)),
        () -> assertEquals(1, businessFlight.getPassengers().size()));
  }

  @Then("^VIP를 비즈니스편에 다중 탑승시킬 수 없다$")
  public void vip를_비즈니스편에_다중_탑승시킬_수_없다() throws Throwable {
    for (int i = 0; i < 10; i++) {
      businessFlight.addPassenger(park);
    }

    assertAll(
        "Verify a VIP passenger can be added to a business flight only once",
        () -> assertEquals(1, businessFlight.getPassengers().size()),
        () -> assertTrue(businessFlight.getPassengers().contains(park)),
        () -> assertTrue(new ArrayList<>(businessFlight.getPassengers())
            .get(0).getName().equals("박")));
  }

  @Given("^프리미엄 항공편이 한대 있다$")
  public void 프리미엄_항공편이_한대_있다() throws Throwable {
    premiumFlight = new PremiumFlight("3");
  }

  @Then("^일반 승객의 프리미엄편 탑승 및 취소는 둘다 불가능하다$")
  public void 일반_승객의_프리미엄편_탑승_및_취소는_둘다_불가능하다() throws Throwable {
    assertAll(
        "Verify all conditions for a regular passenger and a premium flight",
        () -> assertEquals(false, premiumFlight.addPassenger(kim)),
        () -> assertEquals(0, premiumFlight.getPassengers().size()),
        () -> assertEquals(false, premiumFlight.removePassenger(kim)),
        () -> assertEquals(0, premiumFlight.getPassengers().size()));
  }

  @Then("^VIP를 프리미엄편에 탑승 및 취소 모두 가능하다$")
  public void vip를_프리미엄편에_탑승_및_취소_모두_가능하다() throws Throwable {
    assertAll("Verify all conditions for a VIP passenger and a premium flight",
        () -> assertEquals(true, premiumFlight.addPassenger(park)),
        () -> assertEquals(1, premiumFlight.getPassengers().size()),
        () -> assertEquals(true, premiumFlight.removePassenger(park)),
        () -> assertEquals(0, premiumFlight.getPassengers().size()));
  }

  @Then("^VIP 승객을 프리미엄편에 다중 탑승시킬 수 없다$")
  public void vip_승객을_프리미엄편에_다중_탑승시킬_수_없다() throws Throwable {
    for (int i = 0; i < 10; i++) {
      premiumFlight.addPassenger(park);
    }

    assertAll(
        "Verify a VIP passenger can be added to a premium flight only once",
        () -> assertEquals(1, premiumFlight.getPassengers().size()),
        () -> assertTrue(premiumFlight.getPassengers().contains(park)),
        () -> assertTrue(new ArrayList<>(premiumFlight
            .getPassengers())
            .get(0).getName().equals("박")));
  }

}
