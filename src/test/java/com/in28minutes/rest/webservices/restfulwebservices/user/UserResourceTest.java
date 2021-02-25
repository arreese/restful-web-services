package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserResourceTest {

    @Test
    void createUser() {
        UserDaoService service = mock(UserDaoService.class);
        User newUser = new User();
        User userFromDatabase = new User();
        UserResource resource = new UserResource(service);
        when(service.save(newUser)).thenReturn(userFromDatabase);
//        ReflectionTestUtils.setField(resource, "service", service);

        ResponseEntity<Object> user = resource.createUser(newUser);
        assertEquals(HttpStatus.CREATED, user.getStatusCode());


    }
}