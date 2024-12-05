package com.Project.MartinSwiftImpl;

import com.Project.MartinSwiftImpl.Security.User;
import com.Project.MartinSwiftImpl.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private User user1;
	private User user2;
	private User adminUser;

	@MockBean
	private UserService userService;

	@BeforeEach
	public void setUp() {
		user1 = new User(1L, "john_doe", "password123", true, new HashSet<>());
		user2 = new User(2L, "jane_doe", "password456", true, new HashSet<>());
		adminUser = new User(3L, "admin_user", "adminpassword", true, new HashSet<>());
	}

	@Nested
	class RestEndpointTests {

		@Test
		public void testGetAllUsersAsAdmin() throws Exception {
			Mockito.when(userService.findAllUsers()).thenReturn(Arrays.asList(user1, user2, adminUser));

			mockMvc.perform(get("/api/users"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.size()").value(3));
		}

		@Test
		public void testCreateUserAsAdmin() throws Exception {
			User newUser = new User(null, "new_user", "password", true, new HashSet<>());
			Mockito.when(userService.saveUser(any(User.class))).thenReturn(newUser);

			mockMvc.perform(post("/api/users")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(newUser)))
					.andExpect(status().isOk());
		}
	}

	@Nested
	class GraphQLEndpointTests {

		private GraphQlTester graphQlTester;

		@BeforeEach
		public void initGraphQlTester() {
			graphQlTester = Mockito.mock(GraphQlTester.class);
			Mockito.when(graphQlTester.document(anyString())).thenReturn(Mockito.mock(GraphQlTester.Request.class));
		}

		@Test
		public void testGraphQLGetAllUsersAsAdmin() {
			Mockito.when(userService.findAllUsers()).thenReturn(Arrays.asList(user1, user2, adminUser));

			String query = "query { users { id username } }";
			graphQlTester.document(query)
					.execute()
					.path("users")
					.entityList(User.class)
					.hasSize(3);
		}
	}
}
