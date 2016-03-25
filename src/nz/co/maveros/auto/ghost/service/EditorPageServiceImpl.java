package nz.co.maveros.auto.ghost.service;

import org.openqa.selenium.WebElement;

import nz.co.maveros.auto.ghost.model.page.EditorPage;
import nz.co.maveros.auto.ghost.selenium.Driver;

public class EditorPageServiceImpl implements EditorPageService {

	public void createNewPostUseMenu() {
		WebElement newPostLink = Driver
				.findElementByXpath("//a[contains(@class, 'ember-view') and contains(@class, 'gh-nav-main-editor')]");
		newPostLink.click();
	}

	public void userInputTitle() {
		EditorPage editorPage = new EditorPage("Test Title");
		WebElement title = Driver.findElementByCssSelector("#entry-title");		
		title.sendKeys(editorPage.getContent());
	}

	public void userInputBody() {
		EditorPage editorPage = new EditorPage("Test Body...");
		WebElement body = Driver.findElementByTagName("textarea");
		body.sendKeys(editorPage.getContent());
	}
}
