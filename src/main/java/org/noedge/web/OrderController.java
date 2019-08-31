package org.noedge.web;

import org.noedge.domain.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 */
@RestController
public class OrderController {
    Result getOrders(@RequestParam Map map){
        return Result.getResult(0,"",null);
    }
}
