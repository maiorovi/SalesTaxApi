package providers;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemCategoryDataProviderTest {

    private ItemCategoryDataProvider dataProvider;

    @Before
    public void setUp() throws IOException {
        dataProvider = new ItemCategoryDataProvider("dictionary.json");
    }

    @Test
    public void readsDataFromFile() {
        assertThat(dataProvider.<String>getCatalog()).isEqualTo("some line");
    }
}
