package com.example.demo.execute;

import com.example.demo.comment.ApplicationContextHelper;
import com.example.demo.service.StatementHandle;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StatementClient<T> implements InitializingBean {

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    private Map<String, StatementHandle> typeAndStatementHandle = new ConcurrentHashMap<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, StatementHandle> statementHandles = applicationContextHelper.getBeansOfType(StatementHandle.class);
        for (Map.Entry<String, StatementHandle> statementHandle: statementHandles.entrySet()) {
            typeAndStatementHandle.put(statementHandle.getValue().getType().getConfigCode(), statementHandle.getValue());
        }
    }

    public void doHandler(String tag, T t) {
        typeAndStatementHandle.get(tag).process(t);
    }
}
