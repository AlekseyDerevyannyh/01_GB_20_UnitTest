package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    @Test
    void bookRoomTest() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(1)).thenReturn(true);
        when(hotelService.isRoomAvailable(2)).thenReturn(false);

        assertTrue(bookingService.bookRoom(1));
        assertFalse(bookingService.bookRoom(2));
    }
}