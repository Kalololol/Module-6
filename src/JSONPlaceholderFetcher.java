import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSONPlaceholderFetcher {
    private final HttpClient client = HttpClient.newBuilder().build();

    // używając metody GET, odpytaj o pojedynczy post, używając podanego id przy budowie URI i zwróć ten post;
    public String getSinglePost(int id){
        URI uri = URI.create("https://www.google.com");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
    // -> używając metody GET odpytaj o wszystkie posty i zwróć je;
    public String getAllPosts(){
        return "";
    }
    // -> dodaj ciało do swojego zapytania: {
    //    title: 'foo',
    //    body: 'bar',
    //    userId: 1, }; a następnie używając metody POST dodaj nowe dane do istniejącego zasobu. Zwróć true,
    //    kiedy operacja zakończy się sukcesem, false, jeśli nie.
    public boolean addPost(String post){

        return true;
    }

}
