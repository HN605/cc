package com.example.demo;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScrewApplicationTests extends DemoApplicationTests {
    @Autowired
    ApplicationContext context;

    /**
     * 生成数据库文档
     */
    @Test
    public void contextLoad() {
        DataSource mysqlDataSource = context.getBean(DataSource.class);

        EngineConfig engineConfig = EngineConfig.builder()
                .fileOutputDir("./doc")
                .openOutputDir(false)
                .fileType(EngineFileType.HTML)
                .produceType(EngineTemplateType.freemarker)
                .build();

        Configuration config = Configuration.builder()
                .version("1.0.0")
                .description("生成文档的描述信息")
                .dataSource(mysqlDataSource)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig()).build();

        new DocumentationExecute(config).execute();
    }

    private ProcessConfig getProcessConfig() {
        List<String> ignoreTableName = Arrays.asList("a", "test_group");
        List<String> ignorePrefix = Arrays.asList("a", "t");
        List<String> ignoreSuffix = Arrays.asList("_test", "cbz_");

        List<String> designatedTableName = new ArrayList<>();
        designatedTableName.add("Customers");
        designatedTableName.add("Orders");

        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(designatedTableName)
                .designatedTablePrefix(new ArrayList<>())
                .designatedTableSuffix(new ArrayList<>())
                .ignoreTableName(ignoreTableName)
                .ignoreTablePrefix(ignorePrefix)
                .ignoreTableSuffix(ignoreSuffix)
                .build();
    }
}
