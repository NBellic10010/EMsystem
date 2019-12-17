package com.emsys.toolbean;
import com.emsys.pojo.daiban;
import com.emsys.pojo.gunali;
import com.emsys.pojo.jiuyuan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/emd";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    private Connection conn;
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<jiuyuan> suoyou_jiuyuan() throws ClassNotFoundException, SQLException {
        Statement stmt = this.conn.createStatement();
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
            g.setZhuangtai(rs.getBoolean("zhuangtai"));
            //System.out.println(rs.getInt("gonghao"));
            res.add(g);
        }
        return res;
    }

    public jiuyuan chaxun_jiuyuan(String name) throws ClassNotFoundException, SQLException {
        Statement stmt = this.conn.createStatement();
        String sql = "SELECT * FROM jiuyuan where name=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
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
        Statement stmt = this.conn.createStatement();
        String sql = "SELECT * FROM jiuyuan where gonghao=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
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
        Statement stmt = this.conn.createStatement();
        String sql = "SELECT * FROM jiuyuan where gonghao=? and mima=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
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
        Statement stmt = this.conn.createStatement();
        String sql = "SELECT * FROM guanli where name=?";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
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
        Statement stmt = this.conn.createStatement();
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
        String sql = "INSERT INTO jiuyuan(xingming, danwei, dianhua, idnumber)"+
                "values("+"?,?,?,?)";
        //ResultSet rs = stmt.executeQuery("SELECT * FROM jiuyuan where name=?");
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
        ptmt.setString(1, g.getXingming());
        ptmt.setInt(2, g.getDanwei());
        ptmt.setString(3, g.getDianhua());
        ptmt.setString(4, g.getIdnumber());
        ResultSet rs = ptmt.executeQuery();
        ptmt.execute();
    }

    public void shanchu_jiuyuan(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from jiuyuan where gonghao=?";
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }

    public void xiugai_jiuyuan(jiuyuan g) throws  ClassNotFoundException, SQLException {
        String sql = "UPDATE jiuyuan SET xingming = ?,mima = ?,danwei = ?,dianhua = ?,zhuangtai = ?  WHERE gonghao = ?";
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
        ptmt.setString(1, g.getXingming());
        ptmt.setString(2,g.getMima());
        ptmt.setInt(3,g.getDanwei());
        ptmt.setString(4,g.getDianhua());
        ptmt.setBoolean(5, g.getZhuangtai());
        ptmt.setInt(6,g.getGonghao());

        ptmt.execute();
    }

    public void xiugai_guanli(String mima, int gonghao) throws  ClassNotFoundException, SQLException {
        String sql = "UPDATE guanli SET mima=? WHERE gonghao=?";
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
        ptmt.setString(1, mima);
        ptmt.setInt(2, gonghao);

        ptmt.execute();
    }

    public void tianjia_daiban(daiban d) throws  ClassNotFoundException, SQLException {
        String sql = "INSERT INTO TABLE(jiuyuan_gonghao, neirong) daiban VALUES(?, ?)";
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
        ptmt.setString(2, d.getNeirong());
        ptmt.setInt(1, d.getJiuyuan_gonghao());

        ptmt.execute();
    }

    public List<daiban> chazhao_daiban(int gonghao) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * IN daiban where jiuyuan_gonghao=?";
        PreparedStatement ptmt = this.conn.prepareStatement(sql);
        ptmt.setInt(1, gonghao);

        ResultSet rs = ptmt.executeQuery();
        List<daiban> result = new ArrayList<>();
        while (rs.next()) {
            daiban g = new daiban();
            g.setJiuyuan_gonghao(gonghao);
            g.setNeirong(rs.getString("neirong"));
        }

        return result;
    }


}