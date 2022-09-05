package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Applyname;
import com.example.mapper.ApplynameMapper;
import com.example.service.ApplynameService;
import org.springframework.stereotype.Service;

@Service
public class ApplynameServiceImpl extends ServiceImpl<ApplynameMapper, Applyname> implements ApplynameService {
}
