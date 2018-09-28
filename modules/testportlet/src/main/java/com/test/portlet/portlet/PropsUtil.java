package com.test.portlet.portlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class PropsUtil {
    
    private static Properties props = null;
    
    private  PropsUtil(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream("resource/portlet.properties");
        props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static synchronized Properties getProperty(){
        if(props == null){
            new PropsUtil();
            return PropsUtil.props;
        }else{
            return props;
        }
    }
    
    public static String get(String key){
        
        return getProperty().getProperty(key);
    }
}