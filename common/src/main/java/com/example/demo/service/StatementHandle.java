package com.example.demo.service;

import com.example.demo.enums.ReconciliationTypeEnums;

public interface StatementHandle<T> {
    void process(T t);

    ReconciliationTypeEnums getType();
}
