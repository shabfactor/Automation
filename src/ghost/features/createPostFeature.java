package ghost.features;


import ghostobjects.GhostPrimaryObjectFixture;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class createPostFeature extends GhostPrimaryObjectFixture{	
	@Given("^valid user logged in$")
	public void validUserLoggedIn() throws Throwable {
		userLogin();    //code define in the GPOF
	}
		
	@When("^user click new post link on navigation menu$")
	public void userClickNewPostLinkOnNavigationMenu() throws Throwable {
		//code define in the GPOF
		System.out.println("user click new post link on navigation menu");
	}

	@When("^type title and content inside editor$")
	public void typeTitleAndContentInsideEditor() throws Throwable {
		//code define in the GPOF
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
