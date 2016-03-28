package nz.co.maveros.auto.ghost.service;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import nz.co.maveros.auto.ghost.model.page.PostEditPage;
import nz.co.maveros.auto.ghost.selenium.Driver;

public class PostEditPageServiceImpl implements PostEditPageService {

	private PostEditPage editorPage = new PostEditPage(UUID.randomUUID().toString(), UUID.randomUUID().toString());

	public void createNewPostUseMenu() {
		WebElement newPostLink = Driver.findElementPresence(By.xpath("//a[contains(@class, 'ember-view') and contains(@class, 'gh-nav-main-editor')]"));
		newPostLink.click();
	}
	
	public void createNewPostUseButton() {
		Driver.findElementPresence(By.cssSelector("a.btn.btn-green.ember-view")).click();
	}

	public void userInputTitleAndBody() {
		WebElement title = Driver.findElementPresence(By.cssSelector("#entry-title"));
		WebElement body = Driver.findElementPresence(By.tagName("textarea"));
		title.sendKeys(editorPage.getTitle());
		body.sendKeys(editorPage.getBody());
	}

	public void userClickSaveDraftButton() {
		WebElement saveDraftButton = Driver
				.findElementClickable(By.cssSelector("button.btn.btn-sm.js-publish-button.btn-blue.ember-view"));
		saveDraftButton.click();
	}

	public void checkNewPostDraftCreated() {
		WebElement contentNavigationLink = Driver.findElementPresence(By.cssSelector("a.ember-view.gh-nav-main-content"));
		contentNavigationLink.click();
		String testTitle = Driver.findElementPresence(By.cssSelector("h3.entry-title")).getText();
		assertTrue(testTitle.equals(editorPage.getTitle()));
		//Driver.getDriver().close();
	}

}
