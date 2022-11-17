package Ohjelmistoprojekti1.OmppuJaRane;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OmppuJaRaneRestJunitMockTests {
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
public void testLocalEndPointTest() throws Exception {
	mockMvc.perform(get("/apparels"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	
}
}
