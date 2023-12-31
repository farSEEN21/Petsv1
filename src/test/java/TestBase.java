import org.example.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class TestBase extends ApplicationManager {
    static ApplicationManager app = new ApplicationManager();

    @BeforeTest
    public void start() {
        app.init();
    }

    @AfterMethod
    public void down() {
        app.teardown();
    }
}

