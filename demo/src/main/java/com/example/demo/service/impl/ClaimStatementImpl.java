package com.example.demo.service.impl;

import com.example.demo.entity.StatementDTO;
import com.example.demo.enums.ReconciliationTypeEnums;
import com.example.demo.service.StatementHandle;
import org.springframework.stereotype.Service;

@Service
public class ClaimStatementImpl implements StatementHandle<StatementDTO> {
    @Override
    public void process(StatementDTO statementDTO) {
        System.out.println("处理保险理赔");
    }

    @Override
    public ReconciliationTypeEnums getType() {
        return ReconciliationTypeEnums.BXLP;
    }
}
