package com.example.imdb.serviceTest;

import com.example.imdb.dao.MovieRepository;
import com.example.imdb.dto.MoviesEntitiesDTO;
import com.example.imdb.dto.TitlePrincipalDTO;
import com.example.imdb.entities.TitleBasics;
import com.example.imdb.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Testcontainers
//@ActiveProfiles("test-containers")
class MovieServiceTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    Connection conn;

    @Container
    public static PostgreSQLContainer postgresContainer = new PostgreSQLContainer()
            .withDatabaseName("lunatech_imdb")
            .withUsername("postgres")
            .withPassword("postgres");

//    @Container
//    public PostgreSQLContainer postgresContainer = new PostgreSQLContainer();

    @BeforeEach
    void setUp() throws SQLException {
        String jdbcUrl = postgresContainer.getJdbcUrl();
        String username = postgresContainer.getUsername();
        String password = postgresContainer.getPassword();
        conn = DriverManager.getConnection(jdbcUrl, username, password);

        MockitoAnnotations.initMocks(this);
        movieService = new MovieService(movieRepository);
    }

    @Test
    void whenSelectQueryExecuted_thenResultsReturned() throws Exception {
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1");
        resultSet.next();
        int result = resultSet.getInt(1);

        assertEquals(1, result);
    }

//    @DynamicPropertySource
//    static void properties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", container::getJdbcUrl);
//        registry.add("spring.datasource.password", container::getPassword);
//        registry.add("spring.datasource.username", container::getUsername);
//    }

    @Test
    void getMovieByOriTitleOrPrimTitleTest() {
        List<TitlePrincipalDTO> newList = new ArrayList<>();
        newList.add(new TitlePrincipalDTO("renos"));
        when(movieRepository.findByTitle("Scream")).thenReturn((List<TitleBasics>) new MoviesEntitiesDTO("Scream", "movie", "", true, 1996, 0, 120, "horor", newList));

        List<MoviesEntitiesDTO> res = movieService.getMovieByOriTitleOrPrimTitle("Scream");
        assertNotNull(res);
    }

}
