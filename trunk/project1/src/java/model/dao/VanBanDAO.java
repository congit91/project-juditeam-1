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
import java.sql.Date;
import java.util.List;
import model.dao.service.VanBanDAOService;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public class VanBanDAO implements VanBanDAOService {

    private static VanBanDAO vbDAO;

    public static VanBanDAO getInstance() {
        if (vbDAO == null) {
            vbDAO = new VanBanDAO();
        }
        return vbDAO;
    }

    @Override
    public List<VanBan> getVanBanAll() {
        List<VanBan> vbList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                VanBan vb = new VanBan();
                vb.setMaVB(rs.getInt("maVB"));
                vb.setTenVB(rs.getString("tenVB"));
                vb.setLoaiVB(rs.getString("loaiVB"));
                vb.setNoiBanHanh(rs.getString("noiBanHanh"));
                vb.setNgayBanHanh(rs.getDate("ngayBanHanh"));
                vb.setNoiNhan(rs.getString("noiNhan"));
                vb.setNoiDung(rs.getString("noiDung"));
                vb.setActive(rs.getInt("isActive"));
                vbList.add(vb);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vbList;
    }

    @Override
    public List<VanBan> getVanBanByTenVB(String tenVB) {
        List<VanBan> vbList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi where tenVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenVB);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                VanBan vb = new VanBan();
                vb.setMaVB(rs.getInt("maVB"));
                vb.setTenVB(rs.getString("tenVB"));
                vb.setLoaiVB(rs.getString("loaiVB"));
                vb.setNoiBanHanh(rs.getString("noiBanHanh"));
                vb.setNgayBanHanh(rs.getDate("ngayBanHanh"));
                vb.setNoiNhan(rs.getString("noiNhan"));
                vb.setNoiDung(rs.getString("noiDung"));
                vb.setActive(rs.getInt("isActive"));
                vbList.add(vb);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vbList;
    }

    @Override
    public List<VanBan> getVanBanByLoaiVB(String loaiVB) {
        List<VanBan> vbList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi where loaiVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loaiVB);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                VanBan vb = new VanBan();
                vb.setMaVB(rs.getInt("maVB"));
                vb.setTenVB(rs.getString("tenVB"));
                vb.setLoaiVB(rs.getString("loaiVB"));
                vb.setNoiBanHanh(rs.getString("noiBanHanh"));
                vb.setNgayBanHanh(rs.getDate("ngayBanHanh"));
                vb.setNoiNhan(rs.getString("noiNhan"));
                vb.setNoiDung(rs.getString("noiDung"));
                vb.setActive(rs.getInt("isActive"));
                vbList.add(vb);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vbList;
    }

    @Override
    public VanBan getVanBanByID(int maVB) {
        VanBan vb = new VanBan();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi where maVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maVB);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vb.setMaVB(rs.getInt("maVB"));
                vb.setTenVB(rs.getString("tenVB"));
                vb.setLoaiVB(rs.getString("loaiVB"));
                vb.setNoiBanHanh(rs.getString("noiBanHanh"));
                vb.setNgayBanHanh(rs.getDate("ngayBanHanh"));
                vb.setNoiNhan(rs.getString("noiNhan"));
                vb.setNoiDung(rs.getString("noiDung"));
                vb.setActive(rs.getInt("isActive"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vb;
    }

    @Override
    public List<VanBan> findVanBanAdvance(String tenVB, String loaiVB, String noiBanHanh, Date ngayBanHanh, String noiNhan) {
        List<VanBan> vbList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi where tenVB like '"+"%"+tenVB+"%"+"' and loaiVB like '"+"%"+loaiVB+"%"+"'"
                    + "and noiBanHanh like '"+"%"+noiBanHanh+"%"+"' and ngayBanHanh = ? and noiNhan like '"+"%"+noiNhan+"%"+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, ngayBanHanh);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                VanBan vb = new VanBan();
                vb.setMaVB(rs.getInt("maVB"));
                vb.setTenVB(rs.getString("tenVB"));
                vb.setLoaiVB(rs.getString("loaiVB"));
                vb.setNoiBanHanh(rs.getString("noiBanHanh"));
                vb.setNgayBanHanh(rs.getDate("ngayBanHanh"));
                vb.setNoiNhan(rs.getString("noiNhan"));
                vb.setNoiDung(rs.getString("noiDung"));
                vb.setActive(rs.getInt("isActive"));
                vbList.add(vb);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vbList;
    }

    @Override
    public boolean createVanBan(VanBan vb) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tbl_vanban(tenVB, loaiVB, noiBanHanh, ngayBanHanh, noiNhan, noiDung, isActive) "
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vb.getTenVB());
            pstmt.setString(2, vb.getLoaiVB());
            pstmt.setString(3, vb.getNoiBanHanh());
            pstmt.setDate(4, (Date) vb.getNgayBanHanh());
            pstmt.setString(5, vb.getNoiNhan());
            pstmt.setString(6, vb.getNoiDung());
            pstmt.setInt(7, vb.getActive());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateVanBan(VanBan vb) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_vanban set tenVB = ?, loaiVB = ?, noiBanHanh = ?, ngayBanHanh = ?"
                    + ", noiNhan = ?, noiDung = ?, isActive= ? where maVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vb.getTenVB());
            pstmt.setString(2, vb.getLoaiVB());
            pstmt.setString(3, vb.getNoiBanHanh());
            pstmt.setDate(4, (Date) vb.getNgayBanHanh());
            pstmt.setString(5, vb.getNoiNhan());
            pstmt.setString(6, vb.getNoiDung());
            pstmt.setInt(7, vb.getActive());
            pstmt.setInt(8, vb.getMaVB());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean removeVanBan(int maVB) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_vanban set isActive= 0 where maVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);            
            pstmt.setInt(1, maVB);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean restoreVanBan(int maVB) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_vanban set isActive= 1 where maVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);            
            pstmt.setInt(1, maVB);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean deleteVanBan(int maVB) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete from tbl_vanban where maVB = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);            
            pstmt.setInt(1, maVB);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

}
