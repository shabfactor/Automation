package nz.co.maveros.auto.ghost.service;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import nz.co.maveros.auto.ghost.model.page.PostEditPage;
import nz.co.maveros.auto.ghost.selenium.Driver;

public class PostEditPageServiceImpl implements PostEditPageService {

	private PostEditPage editorPage = new PostEditPage(UUID.randomUUID().toString(), UUID.randomUUID().toString());

	public void createNewPostUseMenu() {
		WebElement newPostLink = Driver
				.findElementByXpath("//a[contains(@class, 'ember-view') and contains(@class, 'gh-nav-main-editor')]");
		newPostLink.click();
	}

	public void userInputTitleAndBody() {
		WebElement title = Driver.findElementByCssSelector("#entry-title");
		WebElement body = Driver.findElementByTagName("textarea");
		title.sendKeys(editorPage.getTitle());
		body.sendKeys(editorPage.getBody());
	}

	public void userClickSaveDraftButton() {
		WebElement saveDraftButton = Driver
				.findElementClickable(By.cssSelector("button.btn.btn-sm.js-publish-button.btn-blue.ember-view"));
		saveDraftButton.click();
	}

	public void checkNewPostDraftCreated() {
		WebElement contentNavigationLink = Driver.findElementByCssSelector("a.ember-view.gh-nav-main-content");
		contentNavigationLink.click();
		String testTitle = Driver.findElementByCssSelector("h3.entry-title").getText();
		Assert.assertTrue(testTitle.equals(editorPage.getTitle()));
		Driver.get().close();
	}

}
