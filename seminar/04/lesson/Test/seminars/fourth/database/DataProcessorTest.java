package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataProcessorTest {

    @Test
    void dataProcessorTest() {
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        when(database.query(anyString())).thenReturn(Arrays.asList("1", "2"));

        List<String> actual = dataProcessor.processData("select * from users");

        assertThat(actual)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .contains("1")
                .contains("2");
    }
}