package qa.demo.models;

import lombok.Data;
import java.util.List;

@Data
public class BookAddingBodyModel {
    private String userId;
    private List<IsbnModel> collectionOfIsbns;

    public void addIsbnToList(IsbnModel isbnModel){
        collectionOfIsbns.add(isbnModel);
    }
}
