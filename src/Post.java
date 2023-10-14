import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    @JsonProperty("title")
    private String title;
    private  String body;
    private  int userId;
    private int id;
}
