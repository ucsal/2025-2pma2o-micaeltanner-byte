package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator() {
        policies = new HashMap<>();
        policies.put(CustomerType.REGULAR, new RegularPolicy());
        policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        policies.put(CustomerType.PARTNER, new PartnerPolicy());
    }

    public double apply(double amount, CustomerType type) {
        return policies.getOrDefault(type, a -> a).apply(amount);
    }
}
