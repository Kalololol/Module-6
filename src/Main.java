public class Main {
    public static void main(String[] args) {

        JSONPlaceholderFetcher json = new JSONPlaceholderFetcher(1);
       // System.out.println(json.getAllPosts());
     //   System.out.println(json.getSinglePost(1));
         String input = "{\n" +
                        "  \"title\": \"foo\",\n" +
                        "  \"body\": \"bar\"\n" +
                        "  \"userId\": 1,\n" +
                        "}";
        System.out.println(json.addPost(input));

    }
}