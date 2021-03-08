package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
class UserResourceTest {

    //Had to add lines 26 & 27 to get rid of the "No Current ServletRequestAttributes" error
    @Test
    void createUser() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        UserDaoService service = mock(UserDaoService.class);
        User newUser = new User();
        User userFromDatabase = new User();
        UserResource resource = new UserResource(service);
        when(service.save(newUser)).thenReturn(userFromDatabase);


        ResponseEntity<Object> user = resource.createUser(newUser);
        assertEquals(HttpStatus.CREATED, user.getStatusCode());


    }
}