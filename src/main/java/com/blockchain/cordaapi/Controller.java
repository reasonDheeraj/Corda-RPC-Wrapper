package com.blockchain.cordaapi;

import net.corda.core.messaging.CordaRPCOps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Controller {
    private final CordaRPCOps proxy;
    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    public Controller(NodeRPCConnection rpc) {
        this.proxy = rpc.proxy;
    }

    @GetMapping(value = "/getFlows", produces = "text/plain")
    private String getFlows() {
        System.out.println(proxy.registeredFlows().toString());
        return proxy.registeredFlows().toString();
    }
    @GetMapping(value = "/test", produces = "text/plain")
    private String test() {
        System.out.println("Application is Up and Running");
        return "Application is Up and Running." ;
    }
}