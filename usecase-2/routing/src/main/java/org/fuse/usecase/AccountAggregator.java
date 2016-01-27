package org.fuse.usecase;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.cxf.message.MessageContentsList;
import org.globex.globex.Account;
import org.globex.Company;
import org.globex.Contact;
import org.globex.CorporateAccount;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Aggregator implementation which extract the id and salescontact
 * from CorporateAccount and update the Account
 */
public class AccountAggregator implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

/*     Company company = new Company();
     company.setName("myCompany");
     
     Contact contact = new Contact();
     contact.setFirstName("John");
    	
     Account account = new Account();
     account.set*/
     
    	System.out.println("Aggregator in action");
    	
        if (oldExchange == null) {

            return newExchange;
        }
        
        if(oldExchange.getIn().getBody() instanceof Account)
        {
        	oldExchange.getIn().getBody(Account.class).setSalesRepresentative(newExchange.getIn().getBody(CorporateAccount.class).getSalesContact());
        	
        	return oldExchange;
        }

        newExchange.getIn().getBody(Account.class).setSalesRepresentative(oldExchange.getIn().getBody(CorporateAccount.class).getSalesContact());
        
        return newExchange; 
     
     
   
/*        if (oldExchange == null) {

            return newExchange;
        }

        oldExchange.getIn().setBody(oldExchange.getIn().getBody(String.class)+newExchange.getIn().getBody(String.class));
        
        return oldExchange;*/
        
        
    }
    
}