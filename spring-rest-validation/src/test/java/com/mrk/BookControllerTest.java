package com.mrk;

import com.fasterxml.jackson.databind.ObjectMapper;
// Modern Spring Boot 3.x uses JUnit 5 instead of JUnit 4
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Modern Spring Boot 3.x: JUnit 5 doesn't require @RunWith annotation
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BookControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    // Modern Spring Boot 3.x: Constructor injection preferred even in tests
    private final MockMvc mockMvc;
    
    @MockBean
    private BookRepository mockRepository;
    
    BookControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    /*
        {
            "timestamp":"2019-03-05T09:34:13.280+0000",
            "status":400,
            "errors":["Author is not allowed.","Please provide a price","Please provide a author"]
        }
     */
    // Modern JUnit 5 test methods can have package-private visibility
    @Test
    void save_emptyAuthor_emptyPrice_400() throws Exception {

        // Java 24: Text blocks for better JSON readability
        String bookInJson = """
            {
                "name": "ABC"
            }
            """;

        mockMvc.perform(post("/books")
                .content(bookInJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp", is(notNullValue())))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors", hasSize(3)))
                .andExpect(jsonPath("$.errors", hasItem("Author is not allowed.")))
                .andExpect(jsonPath("$.errors", hasItem("Please provide a author")))
                .andExpect(jsonPath("$.errors", hasItem("Please provide a price")));

        verify(mockRepository, times(0)).save(any(Book.class));

    }

    /*
        {
            "timestamp":"2019-03-05T09:34:13.207+0000",
            "status":400,
            "errors":["Author is not allowed."]
        }
     */
    @Test
    void save_invalidAuthor_400() throws Exception {

        // Java 24: Text blocks for complex JSON
        String bookInJson = """
            {
                "name": "Spring REST tutorials",
                "author": "abc",
                "price": "9.99"
            }
            """;

        mockMvc.perform(post("/books")
                .content(bookInJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp", is(notNullValue())))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors", hasSize(1)))
                .andExpect(jsonPath("$.errors", hasItem("Author is not allowed.")));

        verify(mockRepository, times(0)).save(any(Book.class));

    }

}
