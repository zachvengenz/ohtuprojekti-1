package Ohjelmistoprojekti1.OmppuJaRane;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OmppuJaRaneRestTests {
@Autowired
private WebApplicationContext webAppContext;

private MockMvc mockMvc;

@BeforeEach
public void setUp() {
this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
}

@Test
public void testLocalEndPoint() throws Exception {

mockMvc.perform(get("/makers/1"))
.andExpect(status().isOk())
.andExpect(content().contentType(MediaType.APPLICATION_JSON));

}


@Test
void ensureThatUserAPICallReturnStatusCode200() throws Exception {
    HttpClient client = HttpClient.newBuilder().build();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api")).build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    assertThat(response.statusCode()).isEqualTo(200);

}

@Test
@DisplayName("Ensures that the content type starts with application/json")
void ensureThatJsonIsReturnedAsContentType() throws Exception {
    HttpClient client = HttpClient.newBuilder().build();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api")).build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    Optional<String> firstValue = response.headers().firstValue("Content-Type");
    String string = firstValue.get();
    assertThat(string).startsWith("application/hal+json");
}

}