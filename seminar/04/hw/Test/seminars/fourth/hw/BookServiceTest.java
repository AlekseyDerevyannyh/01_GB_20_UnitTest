package seminars.fourth.hw;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Test
    void bookServiceTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findAll()).thenReturn(Arrays.asList("book1", "book2"));

        List<String> result = bookService.getAllBooks();

        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .contains("book1")
                .contains("book2");
    }
}
