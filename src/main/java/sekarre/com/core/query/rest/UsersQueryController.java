package sekarre.com.core.query.rest;

import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sekarre.com.core.model.User;
import sekarre.com.core.query.FetchUserPaymentDetailsQuery;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("/{userId}/payment-details")
    public User getUserPaymentDetails(@PathVariable String userId) {

        FetchUserPaymentDetailsQuery query = new FetchUserPaymentDetailsQuery(userId);

        return queryGateway.query(query, ResponseTypes.instanceOf(User.class)).join();

    }
}