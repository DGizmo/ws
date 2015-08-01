package ru.sfedu.coursework.main.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;


public class Config {


    private static String propPath;
    private static Properties prop = new Properties();
    private final static String PROPERTY_KEY = "propfile";
    private static Logger logger = Logger.getLogger(Config.class);
    //mysql keys
    public final static String LOGIN_KEY = "login";
    public final static String PASSWORD_KEY = "password";
    public final static String SERVER_KEY = "server";
    public final static String DATABASE_KEY = "database";
    //csv keys
    public final static String CSVARTIST = "csvartist";
    public final static String CSVALBUM = "csvalbum";
    public final static String CSVGENRE = "csvgenre";
    //xml keys
    public final static String XMLARTIST = "xmlartist";
    public final static String XMLALBUM = "xmlalbum";
    public final static String XMLGENRE = "xmlgenre";

    private static SessionFactory sessionFactory = null;


    public static boolean init() {
       propPath = System.getProperty(PROPERTY_KEY,"config.properties");
        try {
            prop.load(new Config().getClass().getResourceAsStream(propPath));
            return true;
        } catch (IOException e) {
            logger.error("Error load properties\n" +e.getMessage());
            return false;
        }
    }

    public static boolean initHibernate() {
        try {
            Configuration configuration = new Configuration().configure("ru/sfedu/coursework/main/config/hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(ssrb.build());
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    public static Properties getProp() {
        return prop;
    }

    public static void setPropPath(String path){
        propPath = path;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
