import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.DEFAULT)
                .build();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");

        CloseableHttpResponse response = httpClient.execute(request);


        String body = new String(response.getEntity().getContent().readAllBytes());
        List<CatFacts> catFacts = mapper.readValue(body, new TypeReference<>(){});

        catFacts = catFacts.stream().filter(catFact -> catFact.getUpVotes() != null && Integer.parseInt(catFact.getUpVotes()) > 0).sorted((a, b) -> Integer.parseInt(b.getUpVotes()) - Integer.parseInt(a.getUpVotes())).collect(Collectors.toList());
        catFacts.forEach(System.out::println);
    }
}
