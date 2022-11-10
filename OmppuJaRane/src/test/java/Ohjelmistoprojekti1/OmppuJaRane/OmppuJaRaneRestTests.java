package Ohjelmistoprojekti1.OmppuJaRane;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OmppuJaRaneRestTests {

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
        assertThat(string).startsWith("application/json");
    }

}
