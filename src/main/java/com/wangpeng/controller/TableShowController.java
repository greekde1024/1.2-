package com.wangpeng.controller;

import com.wangpeng.service.TableShowService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tableShow")
public class TableShowController {

    @Autowired
    TableShowService service;

    @RequestMapping("queryTable.do")
    public String[][] queryTable(String json) {
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        int cid = Integer.parseInt((String) searchParam.get("cid"));
        int weekno = Integer.parseInt((String) searchParam.get("weekno"));
        String[][] table = service.findTable(cid, weekno);
        return table;
    }

}
