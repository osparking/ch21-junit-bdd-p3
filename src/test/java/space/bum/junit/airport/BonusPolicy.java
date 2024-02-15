package space.bum.junit.airport;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BonusPolicy {
  @Given("^마일리지를 동반하는 일반 승객이 있다$")
  public void 마일리지를_동반하는_일반_승객이_있다() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @When("^이 일반 승객이 (\\d+)과 (\\d+) 및 (\\d+)으로 여행한다$")
  public void 이_일반_승객이_과_및_으로_여행한다(int arg1, int arg2, int arg3) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Then("^이 일반 승객의 보너스 점수는 (\\d+)이 되어야 한다$")
  public void 이_일반_승객의_보너스_점수는_이_되어야_한다(int arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Given("^마일리지를 동반하는 VIP 승객이 있다$")
  public void 마일리지를_동반하는_VIP_승객이_있다() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @When("^이 VIP 승객이 (\\d+)과 (\\d+) 및 (\\d+)으로 여행한다$")
  public void 이_VIP_승객이_과_및_으로_여행한다(int arg1, int arg2, int arg3) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Then("^이 VIP 승객의 보너스 점수는 (\\d+)이 되어야 한다$")
  public void 이_VIP_승객의_보너스_점수는_이_되어야_한다(int arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }
}
