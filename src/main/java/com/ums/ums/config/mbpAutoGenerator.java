package com.ums.ums.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;


public class mbpAutoGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.SQL_SERVER);
        dataSourceConfig.setUrl("jdbc:sqlserver://localhost:1433;database=ums");
        dataSourceConfig.setUsername("DemoAdmin");
        dataSourceConfig.setPassword("demo1234");
        dataSourceConfig.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        autoGenerator.setDataSource(dataSourceConfig);
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        globalConfig.setOpen(false);
        globalConfig.setAuthor("wudi");

        autoGenerator.setGlobalConfig(globalConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.ums.ums");
        //packageConfig.setModuleName("");
        packageConfig.setController("Controller");
        packageConfig.setService("Service");
        packageConfig.setEntity("Entity");
        packageConfig.setServiceImpl("Service.Imp");
        packageConfig.setMapper("Mapper");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();

    }
}
