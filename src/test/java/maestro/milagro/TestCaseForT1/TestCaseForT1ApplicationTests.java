package maestro.milagro.TestCaseForT1;

import maestro.milagro.TestCaseForT1.model.RequestDTO;
import maestro.milagro.TestCaseForT1.model.ResponseDTO;
import maestro.milagro.TestCaseForT1.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestCaseForT1ApplicationTests {
	@LocalServerPort
	private int port;
	String expected = "'a': 5, 'c': 4, 'b': 1";
	String message = "aaaaabcccc";
	Service service = new Service();
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void sortTest() {
		String result = service.sortMessage(new RequestDTO(message)).getSortedMessage();

		Assertions.assertEquals(expected, result);
	}

	@Test
	public void restTest(){
		ResponseEntity<ResponseDTO> response = restTemplate.postForEntity(createURLWithPort("/sort"), new RequestDTO(message), ResponseDTO.class);

		System.out.println(response.getBody());

		String result = response.getBody().getSortedMessage();

		 Assertions.assertEquals(expected, result);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}



}
