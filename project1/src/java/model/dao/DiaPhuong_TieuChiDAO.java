/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.service.DPTCDAOService;
import model.entities.DiaPhuong;
import model.entities.DiaPhuong_TieuChi;
import model.entities.TieuChi;

/**
 *
 * @author Admin
 */
public class DiaPhuong_TieuChiDAO implements DPTCDAOService {

    private static DiaPhuong_TieuChiDAO tcDAO;

    public static DiaPhuong_TieuChiDAO getInstance() {
        if (tcDAO == null) {
            tcDAO = new DiaPhuong_TieuChiDAO();
        }
        return tcDAO;
    }

    @Override
    public List<DiaPhuong_TieuChi> getAllList() {
        List<DiaPhuong_TieuChi> dptcList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_dptc";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi();
                dptc.setMaDPTC(rs.getInt("maDPTC"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                dptc.setDiaPhuong(dp);
                TieuChi tc = TieuChiDAO.getInstance().getTCByID(rs.getInt("maTC"));
                dptc.setTieuChi(tc);
                dptc.setNoiDung(rs.getString("noiDung"));
                dptcList.add(dptc);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dptcList;
    }

    @Override
    public DiaPhuong_TieuChi getDPTCByID(int maDPTC) {
        DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_dptc where maDPTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDPTC);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dptc.setMaDPTC(rs.getInt("maDPTC"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                dptc.setDiaPhuong(dp);
                TieuChi tc = TieuChiDAO.getInstance().getTCByID(rs.getInt("maTC"));
                dptc.setTieuChi(tc);
                dptc.setNoiDung(rs.getString("noiDung"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dptc;
    }

    @Override
    public DiaPhuong_TieuChi getDPTCByDPTC(int maDP, int maTC) {
        DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_dptc where maDP = ? and maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            pstmt.setInt(2, maTC);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dptc.setMaDPTC(rs.getInt("maDPTC"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                dptc.setDiaPhuong(dp);
                TieuChi tc = TieuChiDAO.getInstance().getTCByID(rs.getInt("maTC"));
                dptc.setTieuChi(tc);
                dptc.setNoiDung(rs.getString("noiDung"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dptc;
    }

    @Override
    public List<DiaPhuong> getDPByTC(int maTC) {
        List<DiaPhuong> dpList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select maDP from tbl_dptc where maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTC);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maDP = rs.getInt("maDP");
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(maDP);
                dpList.add(dp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dpList;
    }
    @Override
    public List<DiaPhuong_TieuChi> getDPTCByDP(int maDP) {
        List<DiaPhuong_TieuChi> dpList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_dptc where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi();
                dptc.setTieuChi(TieuChiDAO.getInstance().getTCByID(rs.getInt("maTC")));
                dptc.setNoiDung(rs.getString("noiDung"));
                dpList.add(dptc);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dpList;
    }

    @Override
    public List<TieuChi> getTCByDP(int maDP) {
        List<TieuChi> tcList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select maTC from tbl_dptc where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maTC = rs.getInt("maTC");
                TieuChi tc = TieuChiDAO.getInstance().getTCByID(maTC);
                tcList.add(tc);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tcList;
    }

    @Override
    public boolean checkCreate(int maDP, int maTC) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_dptc where maDP = ? and maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            pstmt.setInt(2, maTC);
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                isCheck = rs.next();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean create(DiaPhuong_TieuChi dptc) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tbl_dptc(maDP, maTC, noiDung) values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dptc.getDiaPhuong().getMaDP());
            pstmt.setInt(2, dptc.getTieuChi().getMaTC());
            pstmt.setString(3, dptc.getNoiDung());            
            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean update(DiaPhuong_TieuChi dptc) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_dptc set maDP = ?, maTC = ?, noiDung = ? where maDPTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dptc.getDiaPhuong().getMaDP());
            pstmt.setInt(2, dptc.getTieuChi().getMaTC());
            pstmt.setString(3, dptc.getNoiDung());
            pstmt.setInt(4, dptc.getMaDPTC());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean delete(DiaPhuong_TieuChi dptc) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete from tbl_dptc where maDPTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dptc.getMaDPTC());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public List<DiaPhuong_TieuChi> getDPTCByTC(int maTC) {
        List<DiaPhuong_TieuChi> dpList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_dptc where maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTC);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaPhuong_TieuChi dptc = new DiaPhuong_TieuChi();
                dptc.setDiaPhuong(DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP")));
                dptc.setNoiDung(rs.getString("noiDung"));
                dpList.add(dptc);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dpList;
    }

}
