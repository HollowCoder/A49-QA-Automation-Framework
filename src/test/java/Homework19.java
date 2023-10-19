import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "Deleting playlist \"TestPro Playlist\"";

        provideEmail("andrew.oleary@testpro.io");
        providePassword("te$t$tudent437");
        clickSubmit();
        //createPlaylist();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
    }

    public void openPlaylist(){
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
    }

    public void createPlaylist() throws InterruptedException{
        WebElement createPlaylist = driver.findElement(By.cssSelector(".fa-plus-circle create creating"));
        createPlaylist.click();
        WebElement createNewPlaylist = driver.findElement(By.cssSelector("playlist-context-menu-create-simple"));
        createNewPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException{
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }


}