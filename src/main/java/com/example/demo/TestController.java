package com.example.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping(value = "/hello")
    @SentinelResource(value= "hello", blockHandler = "exceptionHandler")
    public String hello() {
        return "Hello Sentinel";
    }

    // 限流与阻塞处理
    public void exceptionHandler(String str, BlockException ex) {
        System.out.println("aaa");
        log.error( "blockHandler：" + str, ex);
    }

}
