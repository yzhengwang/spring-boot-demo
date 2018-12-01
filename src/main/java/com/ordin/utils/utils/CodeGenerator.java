package com.ordin.utils.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    /**
     * 数据库相关的参数
     */
    private static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://10.249.1.249:3306/sydltd_cloud?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123456";

    /**
     * 项目相关
     */
    // 项目路径
    private static final String PROJECT_PATH = "E:/projects/ordin/utils";
    // 输出目录
    private static final String OUTPUT_DIR = PROJECT_PATH + "/src/main/java/";
    // 父包名
    private static final String PARENT_PACKAGE = "com.ordin.utils";
    // 存放mybatis映射文件的地方
    private static final String MAPPER_DIR = PROJECT_PATH + "/src/main/resources/mapper/";
    // 表的前缀
    private static final String TABLE_PREFIX = "syd_";


    public CodeGenerator() {
        super();
    }

    /**
     * <p>
     * 从控制台内容读取表明
     * </p>
     */
    public static String[] scanner() {
        System.out.println("请输入表名(多个表名以逗号','隔开)：");
        Scanner scanner = new Scanner(System.in);
        String[] tableNames = scanner.next().split(",");
        scanner.close();
        if (tableNames.length <= 0) {
            throw new MybatisPlusException("请输入表名！");
        }
        return tableNames;
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(OUTPUT_DIR);
        gc.setAuthor("yzhengwang");
        gc.setOpen(false);
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(JDBC_DRIVER_NAME);
        dsc.setUrl(JDBC_URL);
        dsc.setUsername(JDBC_USERNAME);
        dsc.setPassword(JDBC_PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 这里根据实际情况变化
        pc.setParent(PARENT_PACKAGE);
        // 默认是mapper
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return MAPPER_DIR + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(TABLE_PREFIX);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner());
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
