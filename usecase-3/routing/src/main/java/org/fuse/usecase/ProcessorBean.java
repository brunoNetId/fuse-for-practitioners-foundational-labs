package org.fuse.usecase;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import java.util.HashMap;
import java.util.Map;

public class ProcessorBean {

    public void debug(Exchange exchange) {
        Object body = (Object) exchange.getIn().getBody();
        Map<String, Object> headers = (Map<String, Object>) exchange.getIn().getHeaders();
        System.out.println(">> TO DEBUG >>");
    }
    
    public Map<String, Object> defineNamedParameters(Exchange exchange)
    {
    	Message m = exchange.getIn();
    	
    	
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ERROR_CODE",1);
        map.put("ERROR_MESSAGE","some message");
        map.put("MESSAGE",m.getBody(String.class));
        map.put("STATUS","ERROR");
        return map;
    }
    
}
