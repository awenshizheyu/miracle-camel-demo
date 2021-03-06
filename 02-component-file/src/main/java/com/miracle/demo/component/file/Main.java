/**
 * Project Name : miracle-camel-demo
 * File Name    : Main
 * Package Name : com.miracle.demo.helloworld
 * Date         : 2019-11-18 16:13
 * Author       : fan.wenbin
 * Copyright (c) 2018, fan.wenbin@ustcinfo.com All Rights Reserved.
 */
package com.miracle.demo.component.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @program: miracle-camel-demo
 * @className: Main
 * @description: TODO
 * @CreateTime: 2019-11-18 16:13
 * @author: fan.wenbin
 * @version: V1.0
 */
public class Main {

    private static final String FROM_PATH = "/Users/awen/Desktop/from";
    private static final String TO_PATH = "/Users/awen/Desktop/to";

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:" + FROM_PATH)
                        .to("file:" + TO_PATH);
            }
        };
        context.addRoutes(routeBuilder);
        context.start();
        Thread.sleep(Integer.MAX_VALUE);
        context.stop();
    }
}
