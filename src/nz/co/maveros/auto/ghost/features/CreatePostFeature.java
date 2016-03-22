package nz.co.maveros.auto.ghost.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.maveros.auto.ghost.fixture.GhostPrimaryObjectFixture;
import nz.co.maveros.auto.ghost.service.LoginService;
import nz.co.maveros.auto.ghost.service.LoginServiceImpl;

public class CreatePostFeature extends GhostPrimaryObjectFixture {
	
	private LoginService loginService = new LoginServiceImpl();

	@Given("^valid user logged in$")
	public void validUserLoggedIn() throws Throwable {
		loginService.loadPage();
		loginService.login("ghostbddtest@gmail.com", "ghostadmin");
	}

	@When("^user click new post link on navigation menu$")
	public void userClickNewPostLinkOnNavigationMenu() throws Throwable {
		// code define in the GPOF
		System.out.println("user click new post link on navigation menu");
	}

	@When("^type title and content inside editor$")
	public void typeTitleAndContentInsideEditor() throws Throwable {
		// code define in the GPOF
		System.out.println("type title and content inside editor");
	}

	@When("^click save draft button$")
	public void clickSaveDraftButton() throws Throwable {
		System.out.println("click save draft button");
	}

	@Then("^a new draft post is created$")
	public void NewDraftPostIsCreated() throws Throwable {
		System.out.println("a new draft post is created");
	}

	@When("^user click new post button$")
	public void userClickNewPostButton() throws Throwable {
		System.out.println("user click new post button");
	}

}
