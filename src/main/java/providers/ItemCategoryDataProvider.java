package providers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import util.ItemCategorie;

import java.util.HashMap;
import java.util.Map;

public class ItemCategoryDataProvider implements DataProvider<HashMap<String, ItemCategorie>> {
    private Map<String,ItemCategorie> categoryData;

    public ItemCategoryDataProvider() {
        categoryData = parseFile();
    }

    private Map<String, ItemCategorie> parseFile() {
        Map<String, ItemCategorie> map = new HashMap<>();
        map.put("Book",ItemCategorie.BOOK);
        map.put("Chocolate Bar", ItemCategorie.FOOD);
        map.put("Music CD", ItemCategorie.OTHER);

        return map;
    }

    @Override
    public HashMap<String, ItemCategorie> getCatalog() {
        return new HashMap<>(categoryData);
    }
}
