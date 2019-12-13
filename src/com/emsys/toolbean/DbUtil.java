package com.emsys.toolbean;
import com.emsys.pojo.gunali;
import com.emsys.pojo.jiuyuan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/emd";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection conn;
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jiuyuan> suoyou_jiuyuan() throws ClassNotFoundException, SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan");
        List<jiuyuan> res = new ArrayList<>();
        jiuyuan g = null;
        while(rs.next()){
            g = new jiuyuan();
            g.setDanwei(rs.getInt("danwei"));
            g.setDianhua(rs.getString("dianhua"));
            g.setXingming(rs.getString("xingming"));
            g.setIdnumber(rs.getString("idnumber"));
            g.setGonghao(rs.getInt("gonghao"));

            res.add(g);
        }
        return res;
    }

    public jiuyuan chaxun_jiuyuan(String name) throws ClassNotFoundException, SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM jiuyuan where name=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, name);
        ResultSet rs = ptmt.executeQuery();
        jiuyuan g = null;
        while (rs.next()) {
            g = new jiuyuan();
            g.setDanwei(rs.getInt("danwei"));
            g.setDianhua(rs.getString("dianhua"));
            g.setXingming(rs.getString("xingming"));
            g.setIdnumber(rs.getString("idnumber"));
            g.setGonghao(rs.getInt("gonghao"));
        }
        return g;
    }

    public jiuyuan chaxun_jiuyuan(int gonghao) throws ClassNotFoundException, SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM jiuyuan where gonghao=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, gonghao);
        ResultSet rs = ptmt.executeQuery();
        jiuyuan g = null;
        while (rs.next()) {
            g = new jiuyuan();
            g.setDanwei(rs.getInt("danwei"));
            g.setDianhua(rs.getString("dianhua"));
            g.setXingming(rs.getString("xingming"));
            g.setIdnumber(rs.getString("idnumber"));
            g.setGonghao(rs.getInt("gonghao"));
        }
        return g;
    }

    public jiuyuan chaxun_jiuyuan(int gonghao, String mima) throws ClassNotFoundException, SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM jiuyuan where gonghao=? and mima=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, gonghao);
        ptmt.setString(2, mima);

        ResultSet rs = ptmt.executeQuery();

        jiuyuan g = null;
        while (rs.next()) {
            g = new jiuyuan();
            g.setDanwei(rs.getInt("danwei"));
            g.setDianhua(rs.getString("dianhua"));
            g.setXingming(rs.getString("xingming"));
            g.setIdnumber(rs.getString("idnumber"));
            g.setGonghao(rs.getInt("gonghao"));

        }
        return g;

    }

    public gunali chaxun_guanli(String name) throws ClassNotFoundException, SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM guanli where name=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, name);
        ResultSet rs = ptmt.executeQuery();
        gunali g = null;
        while (rs.next()) {
            g = new gunali();
            g.setMima(rs.getString("mima"));
            g.setGonghao(rs.getInt("gonghao"));
        }
        return g;
    }

    public gunali chaxun_guanli(int gonghao, String password) throws ClassNotFoundException, SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM guanli where gonghao=? and mima=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, gonghao);
        ptmt.setString(2, password);
        ResultSet rs = ptmt.executeQuery();
        gunali g = null;
        while (rs.next()) {
            g = new gunali();
            g.setMima(rs.getString("mima"));
            g.setGonghao(rs.getInt("gonghao"));
        }
        return g;
    }

    public void tianjia_jiuyuan(jiuyuan g) throws ClassNotFoundException, SQLException {
        //Statement stmt = conn.createStatement();
        String sql = "INSERT INTO jiuyuan(gonghao, xingming, danwei, dianhua, idnumber)"+
                "values("+"?,?,?,?,?)";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, g.getGonghao());
        ptmt.setString(2, g.getXingming());
        ptmt.setInt(3, g.getDanwei());
        ptmt.setString(4, g.getDianhua());
        ptmt.setString(5, g.getIdnumber());
        ResultSet rs = ptmt.executeQuery();
        ptmt.execute();
    }

    public void shanchu_jiuyuan(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from jiuyuan where gonghao=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }

    public void xiugai_jiuyuan(jiuyuan g) throws  ClassNotFoundException, SQLException {
        String sql = "UPDATE jiuyuan SET xingming = ?,mima = ?,danwei = ?,dianhua = ?  WHERE gonghao = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, g.getXingming());
        ptmt.setString(2,g.getMima());
        ptmt.setInt(3,g.getDanwei());
        ptmt.setString(4,g.getDianhua());
        ptmt.setInt(5,g.getGonghao());

        ptmt.execute();
    }

    public void xiugai_guanli(String mima, int gonghao) throws  ClassNotFoundException, SQLException {
        String sql = "UPDATE guanli SET mima=? WHERE gonghao=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, mima);
        ptmt.setInt(2, gonghao);

        ptmt.execute();
    }


}