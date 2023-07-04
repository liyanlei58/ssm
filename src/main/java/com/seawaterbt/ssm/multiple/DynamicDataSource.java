package com.seawaterbt.ssm.multiple;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * @description:  动态数据源决策
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceType = DynamicDataSourceContextHolder.getDataSourceType();
        return dataSourceType;
    }
}
