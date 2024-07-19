package com.qst.medical.controller;


import com.qst.medical.service.impl.DashBoardServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "仪表盘控制器")
@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {
    @Autowired
    DashBoardServiceImpl dashboardService;

    @GetMapping
    public Msg getDashboardData() {
        return Msg.success().data("data", dashboardService.getDashboardData());
    }
}
