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
import model.dao.service.TaiKhoanDAOService;
import model.entities.TaiKhoan;

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO implements TaiKhoanDAOService {

    private static TaiKhoanDAO tkDAO;

    public static TaiKhoanDAO getInstance() {
        if (tkDAO == null) {
            tkDAO = new TaiKhoanDAO();
        }
        return tkDAO;
    }

    @Override
    public boolean checkDangNhap(String tenTK, String matkhau) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_taikhoan where tenTK = ? and matkhau = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenTK);
            pstmt.setString(2, matkhau);
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
    public List<TaiKhoan> getTaiKhoanAll() {
        List<TaiKhoan> tkList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_taikhoan";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(rs.getInt("maTK"));
                tk.setTenTK(rs.getString("tenTK"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setHoTen(rs.getString("hoTen"));
                tk.setEmail(rs.getString("email"));
                tk.setSDT(rs.getString("SDT"));
                int tt = rs.getInt("trangThaiHD");
                tk.setTrangThaiHD(tt == 1);
                tkList.add(tk);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tkList;
    }

    @Override
    public List<TaiKhoan> getTaiKhoanByHoTen(String hoTen) {
        List<TaiKhoan> tkList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_taikhoan where hoTen = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hoTen);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(rs.getInt("maTK"));
                tk.setTenTK(rs.getString("tenTK"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setHoTen(rs.getString("hoTen"));
                tk.setEmail(rs.getString("email"));
                tk.setSDT(rs.getString("SDT"));
                int tt = rs.getInt("trangThaiHD");
                tk.setTrangThaiHD(tt == 1);
                tkList.add(tk);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tkList;
    }

    @Override
    public TaiKhoan getTaiKhoanByID(int maTK) {
        TaiKhoan tk = new TaiKhoan();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_taikhoan where maTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTK);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tk.setMaTK(rs.getInt("maTK"));
                tk.setTenTK(rs.getString("tenTK"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setHoTen(rs.getString("hoTen"));
                tk.setEmail(rs.getString("email"));
                tk.setSDT(rs.getString("SDT"));
                int tt = rs.getInt("trangThaiHD");
                tk.setTrangThaiHD(tt == 1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tk;
    }

    @Override
    public TaiKhoan getTaiKhoanByTenTK(String tenTK) {
        TaiKhoan tk = new TaiKhoan();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_taikhoan where tenTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenTK);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tk.setMaTK(rs.getInt("maTK"));
                tk.setTenTK(rs.getString("tenTK"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setHoTen(rs.getString("hoTen"));
                tk.setEmail(rs.getString("email"));
                tk.setSDT(rs.getString("SDT"));
                int tt = rs.getInt("trangThaiHD");
                tk.setTrangThaiHD(tt == 1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tk;
    }

    @Override
    public boolean checkTaiKhoan(String tenTK) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_taikhoan where tenTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenTK);
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
    public boolean createTaiKhoan(TaiKhoan tk) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tbl_taikhoan(tenTK, matkhau, hoTen, email, SDT, trangThaiHD)"
                    + " values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tk.getTenTK());
            pstmt.setString(2, tk.getMatkhau());
            pstmt.setString(3, tk.getHoTen());
            pstmt.setString(4, tk.getEmail());
            pstmt.setString(5, tk.getSDT());
            int tt = 0;
            if(tk.isTrangThaiHD()) tt = 1;
            pstmt.setInt(6, tt);

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateTaiKhoan(TaiKhoan tk) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_taikhoan set hoTen = ?, email = ?, SDT = ?, "
                    + "trangThaiHD = ? where maTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tk.getHoTen());
            pstmt.setString(2, tk.getEmail());
            pstmt.setString(3, tk.getSDT());
            int tt = 0;
            if(tk.isTrangThaiHD()) tt = 1;
            pstmt.setInt(4, tt);
            pstmt.setInt(5, tk.getMaTK());

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateMatKhau(TaiKhoan tk) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_taikhoan set matkhau = ? where maTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tk.getMatkhau());
            pstmt.setInt(2, tk.getMaTK());

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean removeTaiKhoan(TaiKhoan tk) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_taikhoan set trangThaiHD = '0' where maTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tk.getMaTK());

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean restoreTaiKhoan(TaiKhoan tk) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_taikhoan set trangThaiHD = '1' where maTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tk.getMaTK());

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean deleteTaiKhoan(int maTK) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete from tbl_taikhoan where maTK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTK);

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }
}
