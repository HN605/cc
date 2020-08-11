package com.example.demo;

import com.example.demo.entity.StatementDTO;
import com.example.demo.enums.ReconciliationTypeEnums;
import com.example.demo.execute.StatementClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StatementClientTest extends DemoApplicationTests {

    @Autowired
    private StatementClient<StatementDTO> statementClient;

    @Test
    void test() {
        StatementDTO statementDTO = new StatementDTO();
        statementDTO.setRemark("测试理赔");
        statementDTO.setTag(ReconciliationTypeEnums.BXLP.getConfigCode());

        statementClient.doHandler(statementDTO.getTag(), statementDTO);

        statementDTO.setRemark("测试");
        statementDTO.setTag(ReconciliationTypeEnums.BXFY.getConfigCode());

        statementClient.doHandler(statementDTO.getTag(), statementDTO);


    }
}
