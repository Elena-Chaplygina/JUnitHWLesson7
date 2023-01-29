import org.junit.jupiter.api.*;

public class DemoTest {


    @BeforeEach
    void beforeEach(){
        System.out.println("BEFORE EACH!!!");
    }
    @BeforeAll
    void beforeAll(){
        System.out.println("BEFORE ALL!!!");
    }
    @AfterAll
    void afterAll(){
        System.out.println("AFTER ALL!!!");
    }
    @AfterEach
    void afterEach(){
        System.out.println("AFTER EACH!!!");
    }
    @Test
    void demo(){
        System.out.println("DEMO TEST!");
        Assertions.assertTrue(3<2);
    }

    @Test
    void demo2(){
        System.out.println("DEMO TEST2!!!");
        Assertions.assertTrue(3>2);
    }

}
