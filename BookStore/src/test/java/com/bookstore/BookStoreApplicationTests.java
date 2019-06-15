package com.bookstore;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.bookstore.domain.Employee;
import com.bookstore.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookStoreApplicationTests {

	@LocalServerPort
    private int port;

    @Autowired
    private RestOperations restTemplate;
    
      @MockBean
    private EmployeeRepository<Employee> employeeRepositoryImpl;
    
	@Test
	public void contextLoads() {
		
		
	}
	
	//Integration test
	@Test
	public void check() {
		HttpHeaders headers = new HttpHeaders();
        headers.set("username", "testmail@mail.com");
        HttpEntity<Employee> request = new HttpEntity<>(headers);
        assertNotNull(restTemplate.postForEntity("http://localhost:" + port + "/bookstore"+"/login",new HttpEntity<>(headers),Employee.class));
		//System.out.println(restTemplate.getForObject("http://localhost:" + port + "/bookstore/login",Employee.class));
	}
	   

}
