import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class JSONPlaceholderFetcher {
    private final HttpClient client = HttpClient.newBuilder().build();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONPlaceholderFetcher(){}
    public JSONPlaceholderFetcher(int id) {
        this.id = id;
    }

    // używając metody GET, odpytaj o pojedynczy post, używając podanego id przy budowie URI i zwróć ten post;
    public String getSinglePost(int id){
        String result = "";

        try {
            URI uri = URI.create("https://jsonplaceholder.typicode.com/posts/" + id);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            result = response.body();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    //  używając metody GET odpytaj o wszystkie posty i zwróć je;
    public String getAllPosts(){
        String result = "";

        URI uri = URI.create("https://jsonplaceholder.typicode.com/posts/" );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            result = response.body();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
        // -> dodaj ciało do swojego zapytania: {
        //    title: 'foo',
        //    body: 'bar',
        //    userId: 1, }; a następnie używając metody POST dodaj nowe dane do istniejącego zasobu. Zwróć true,
    //    kiedy operacja zakończy się sukcesem, false, jeśli nie.

    public boolean addPost(String post){

        boolean result = true;
        URI uri = URI.create("https://jsonplaceholder.typicode.com/posts/1" );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(post))
                .build();
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        }catch (Exception e){
            result = false;
            e.getMessage();
        }

    return result;
    }

}
