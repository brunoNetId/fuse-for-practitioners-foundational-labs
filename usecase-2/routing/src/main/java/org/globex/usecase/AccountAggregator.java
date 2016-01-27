package org.globex.usecase;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Aggregator implementation which extract the id and salescontact
 * from CorporateAccount and update the Account
 */
public class AccountAggregator implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

    	
    	
        if (oldExchange == null) {

            return newExchange;
        }
        
        if(oldExchange.getIn().getBody() instanceof org.globex.globex.Account)
        {
        	return oldExchange;
        }
        
        return newExchange;
    }
    
}