package seminars.fourth.http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebServiceTest {

    @Test
    void webServiceTest() {
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn("ok");

        String result = webService.request("body");

        assertThat(result).isEqualTo("ok");
    }
}
