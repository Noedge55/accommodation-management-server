package org.noedge.web;

import org.noedge.domain.Hostel;
import org.noedge.domain.Result;
import org.noedge.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 */
@RestController
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @RequestMapping(value = "/getHomehotelList")
    public Result getHomehotelList(@RequestParam int personId){
        List<Hostel> hostelList = hostelService.getAllByPIdPermission(personId);
        System.out.println("123123");
        return Result.getResult(0,"success",null);
    }
}
