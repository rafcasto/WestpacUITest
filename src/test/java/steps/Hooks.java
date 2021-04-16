package steps;


import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.WebDriverController;
import io.cucumber.java.*;
import io.cucumber.java8.En;

import java.lang.reflect.Type;

public class Hooks implements En {
   private  WebDriverController driver;
    private final ObjectMapper objectMapper = new ObjectMapper();

   public Hooks(WebDriverController driver)
   {
       this.driver = driver;
   }
    @Before
    public void SetUp()
    {
        driver.getDriver().get("https://buggy.justtestit.org/");
    }

    @After
    public void Finish()
    {
        driver.getDriver().close();
    }

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

}
