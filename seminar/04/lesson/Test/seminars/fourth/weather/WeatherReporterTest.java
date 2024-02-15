package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    @Test
    void generatorReportTest() {
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(15);

        assertThat(weatherReporter.generateReport()).isEqualTo("Текущая температура: 15 градусов.");
    }
}