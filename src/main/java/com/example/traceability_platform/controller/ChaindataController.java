package com.example.traceability_platform.controller;

import com.example.traceability_platform.entity.Chaindata;
import com.example.traceability_platform.interfaces.PassToken;
import com.example.traceability_platform.service.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chain")
public class ChaindataController {
    @Autowired
    ChainService chainService;

    @PassToken
    @RequestMapping("/find")
    public List display(@RequestParam("private_key") String private_key){
        List<Chaindata> list = chainService.findbykey(private_key);
        if(list.size()==0){
            List<String> fall = new ArrayList<>();
            fall.add("无此链上数据");
            return fall;
        }
        return list;
    }

}
