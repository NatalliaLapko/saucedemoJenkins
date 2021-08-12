import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Driver {


    @BeforeAll
    public void setUp() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/user.properties"));
        Configuration.startMaximized = true;


    }

    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }
}
