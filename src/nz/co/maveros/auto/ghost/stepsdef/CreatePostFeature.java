package nz.co.maveros.auto.ghost.stepsdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.maveros.auto.ghost.configuration.AutoConfig;
import nz.co.maveros.auto.ghost.fixture.GhostPrimaryObjectFixture;
import nz.co.maveros.auto.ghost.service.PostEditPageService;
import nz.co.maveros.auto.ghost.service.PostEditPageServiceImpl;
import nz.co.maveros.auto.ghost.service.LoginService;
import nz.co.maveros.auto.ghost.service.LoginServiceImpl;

public class CreatePostFeature extends GhostPrimaryObjectFixture {

	private LoginService loginService = new LoginServiceImpl();
	private PostEditPageService postEditPageService = new PostEditPageServiceImpl();
	private AutoConfig config = AutoConfig.getInstance();

	@Given("^valid user logged in$")
	public void validUserLoggedIn() throws Throwable {
		loginService.loadPage();
		loginService.login(config.getUserName(), config.getPassword());
	}

	@When("^user click new post link on navigation menu$")
	public void userClickNewPostLinkOnNavigationMenu() throws Throwable {
		postEditPageService.createNewPostUseMenu();
	}

	@When("^type title and content inside editor$")
	public void typeTitleAndContentInsideEditor() throws Throwable {
		postEditPageService.userInputTitleAndBody();
	}

	@When("^click save draft button$")
	public void clickSaveDraftButton() throws Throwable {
		postEditPageService.userClickSaveDraftButton();
	}

	@Then("^a new draft post is created$")
	public void NewDraftPostIsCreated() throws Throwable {
		postEditPageService.checkNewPostDraftCreated();
	}



}
