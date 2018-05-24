package test;

import org.apache.ibatis.session.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GenMain {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        //如果已经生成过了是否进行覆盖
        boolean overwrite = true;
        String genCfg = "generator.xml";
        URL url = GenMain.class.getResource(genCfg);
        String file = url.getFile();
        File configFile = new File(file);
        ConfigurationParser cfgParser = new ConfigurationParser(warnings);
        Configuration config = null;

        try {
            cfgParser.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }

    }
}
