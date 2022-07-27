package com.example.traceability_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.traceability_platform.entity.Chaindata;

import java.util.List;

public interface ChainService extends IService<Chaindata> {
    List<Chaindata> findbykey(String private_key);
}
