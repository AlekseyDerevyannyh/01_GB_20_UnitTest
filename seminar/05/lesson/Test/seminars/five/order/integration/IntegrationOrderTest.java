package seminars.five.order.integration;

import org.junit.jupiter.api.Test;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationOrderTest {

    @Test
    void integrationOrderTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("A", 1);

        assertTrue(result);
    }
}
