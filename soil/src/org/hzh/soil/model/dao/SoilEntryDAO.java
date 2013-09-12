/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hzh.soil.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hzh.soil.model.data.SoilEntry;
import org.hzh.soil.model.mapper.SoilEntryMapper;

/**
 *
 * @author Administrator
 */
public class SoilEntryDAO {

    private SqlSessionFactory sqlSessionFactory;

    public SoilEntryDAO() {
        sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
    }

    public List<SoilEntry> selectById(int iId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<SoilEntry> list = session.selectList("SoilEntry.getById", iId);
            return list;
        } finally {
            session.close();
        }
    }

    public List<SoilEntry> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<SoilEntry> list = session.selectList("SoilEntry.getAll");
            return list;
        } finally {
            session.close();
        }
    }

    public List<SoilEntry> selectPhRange(double min, double max) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Map param = new HashMap();
            param.put("start", min);
            param.put("end", max);
            List<SoilEntry> entry = session.selectList("SoilEntry.selectByPh", param);
            return entry;
        } finally {
            session.close();
        }
    }

    public void insertSoilEntry(SoilEntry entry) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
//            SoilEntryMapper mapper = session.getMapper(SoilEntryMapper.class);
//            mapper.insert(entry);
            session.insert("SoilEntry.insert", entry);
            session.commit();
        } finally {
            session.close();
        }
    }

//    public void insertSoilEntry2(SoilEntry entry) {
//        try {
//            Class.forName("org.sqlite.JDBC");
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:soil_entry.db");
//            Statement stat = conn.createStatement();
//            stat.executeUpdate("create table if not exists soil_entry(id integer ,  lng real, lat real,  ph real, timestamp text);");
//            String insert_stat = "insert into soil_entry values(" + entry.getId() + "," + entry.getLng() + "," + entry.getLat() + "," + entry.getPh() + ",'" + entry.getTimestmp() + "')";
//            stat.executeUpdate(insert_stat); //插入数据
//            conn.close(); //结束数据库的连接
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void updateSoilEntry(SoilEntry entry) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("SoilEntry.updata", entry);
            session.commit();
        } finally {
            session.close();
        }
    }

    void deleteSoilEntry(int id) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("SoilEntry.deleteById", id);
            session.commit();
        } finally {
            session.close();
        }
    }

    public static void main(String args[]) {
        // smoke tests
        SoilEntryDAO dao = new SoilEntryDAO();
        dao.deleteSoilEntry(4);
        SoilEntry entry = new SoilEntry(4, 123.22, -12.33, 6.5, "2012-11-03 12:34:55, 123");
        dao.insertSoilEntry(entry);

        List<SoilEntry> entry2 = dao.selectById(4);
        System.out.println("id = 4 :  " + entry2);

        dao.deleteSoilEntry(4);
        entry2 = dao.selectById(4);
        System.out.println(entry2);

        entry = new SoilEntry(111, 123.22, -12.33, 6.5, "2012-11-03 12:34:55, 123");
        dao.insertSoilEntry(entry);
        entry2 = dao.selectAll();
        System.out.println(entry2);

        entry2 = dao.selectPhRange(5.5, 7.7);

        System.out.println("by ph" + entry2);
    }
}
