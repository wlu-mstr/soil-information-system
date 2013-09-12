/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hzh.soil.model.dao;


/**
 *
 * @author Administrator
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hzh.soil.model.mapper.SoilEntryMapper;


/**
 * MyBatis Connection Factory, which reads the configuration data from a XML
 * file.
 *
 * @author Loiane Groner http://loianegroner.com (English) http://loiane.com
 * (Portuguese)
 */
public class ConnectionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    static {

        try {
            String resource = "SoilMapConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);

            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                

                sqlSessionFactory.getConfiguration().addMapper(SoilEntryMapper.class);
                
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
