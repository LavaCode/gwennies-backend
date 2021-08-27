package com.gwennies.eindopdracht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    // @Autowired
    // private OrderService orderService;

    // @PostMapping("/create-checkout-session")
    // public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
    //     Session session = orderService.createSession(checkoutItemDtoList);
    //     StripeResponse stripeResponse = new StripeResponse(session.getId());
    //     return new ResponseEntity<StripeResponse>(stripeResponse,HttpStatus.OK);
    // }

}
