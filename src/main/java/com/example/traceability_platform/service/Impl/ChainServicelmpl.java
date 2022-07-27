package com.example.traceability_platform.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.traceability_platform.entity.Chaindata;
import com.example.traceability_platform.mapper.ChainMapper;
import com.example.traceability_platform.service.ChainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChainServicelmpl extends ServiceImpl<ChainMapper,Chaindata> implements ChainService {
    @Override
    public List<Chaindata> findbykey(String private_key){

        QueryWrapper<Chaindata> queryWrapper =  new QueryWrapper<>();
        queryWrapper.eq("private_key",private_key);

        List<Chaindata> list = this.list(queryWrapper);
        return list;

    }


}
