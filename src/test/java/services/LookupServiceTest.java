package services;

import org.junit.Before;
import org.junit.Test;

public class LookupServiceTest {

    private CategoryLookupService categoryLookupService;

    @Before
    public void setUp() {
        categoryLookupService = new CategoryLookupService();
    }

    @Test
    public void loadsDataFromFileOnCreation() {

    }
}
