package steps;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("before scenario");
    }

    @After
    public void cleanup(){
        System.out.println("after scenario");

    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all ------");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all ------");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("before step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("after step");

    }
}
