import org.testng.Assert;
import org.testng.annotations.Test;
import homework22.NewLoginPage;
import homework22.NewPlaylistPage;

public class NewHomeWork22 extends NewBaseTest {

    @Test
    public void renamePlaylist() {
        NewLoginPage loginPage = new NewLoginPage(driver);
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");

        NewPlaylistPage playlistPage = new NewPlaylistPage(driver);
        playlistPage.createPlaylist("MyNewList");
        playlistPage.renamePlaylist("RenamedList");

        Assert.assertTrue(playlistPage.isSuccessPopupDisplayed());
    }
}
