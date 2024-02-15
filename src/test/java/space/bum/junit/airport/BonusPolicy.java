package space.bum.junit.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import space.bum.junit.mileage.Mileage;

public class BonusPolicy {
  private Passenger kang;
  private Mileage mileage;
  private Passenger jung;

  @Given("^마일리지를 동반하는 일반 승객이 있다$")
  public void 마일리지를_동반하는_일반_승객이_있다() throws Throwable {
    kang = new Passenger("강감찬", false);
    mileage = new Mileage();
  }

  @When("^이 일반 승객이 (\\d+)과 (\\d+) 및 (\\d+)으로 여행한다$")
  public void 이_일반_승객이_과_및_으로_여행한다(int mile1, int mile2, int mile3)
      throws Throwable {
    mileage.addMileage(kang, mile1);
    mileage.addMileage(kang, mile2);
    mileage.addMileage(kang, mile3);
  }

  @Then("^이 일반 승객의 보너스 점수는 (\\d+)이 되어야 한다$")
  public void 이_일반_승객의_보너스_점수는_이_되어야_한다(int points) throws Throwable {
    mileage.calculateGivenPoints();
    assertEquals(points, mileage.getPoints().get(kang).intValue());
  }

  @Given("^마일리지를 동반하는 VIP 승객이 있다$")
  public void 마일리지를_동반하는_VIP_승객이_있다() throws Throwable {
    jung = new Passenger("정소정", true);
    mileage = new Mileage();
  }

  @When("^이 VIP 승객이 (\\d+)과 (\\d+) 및 (\\d+)으로 여행한다$")
  public void 이_VIP_승객이_과_및_으로_여행한다(int mile1, int mile2, int mile3)
      throws Throwable {
    mileage.addMileage(jung, mile1);
    mileage.addMileage(jung, mile2);
    mileage.addMileage(jung, mile3);
  }

  @Then("^이 VIP 승객의 보너스 점수는 (\\d+)이 되어야 한다$")
  public void 이_VIP_승객의_보너스_점수는_이_되어야_한다(int points) throws Throwable {
    mileage.calculateGivenPoints();
    assertEquals(points, mileage.getPoints().get(jung).intValue());
  }
}
