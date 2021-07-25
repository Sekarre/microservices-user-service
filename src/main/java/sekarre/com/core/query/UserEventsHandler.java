package sekarre.com.core.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import sekarre.com.core.model.PaymentDetails;
import sekarre.com.core.model.User;
import sekarre.com.core.query.FetchUserPaymentDetailsQuery;

@Component
public class UserEventsHandler {


    @QueryHandler
    public User on(FetchUserPaymentDetailsQuery query) {

       PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("SERGEY KARGOPOLOV")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        User userRest = User.builder()
                .firstName("Sergey")
                .lastName("Kargopolov")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

        return userRest;
    }

}
