/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.service.NguoiPhuTrachDAOService;
import model.entities.DiaPhuong;
import model.entities.NguoiPhuTrach;
import model.entities.NguoiPhuTrach;

/**
 *
 * @author Admin
 */
public class NguoiPhuTrachDAO implements NguoiPhuTrachDAOService {

    private static NguoiPhuTrachDAO nptDAO;

    public static NguoiPhuTrachDAO getInstance() {
        if (nptDAO == null) {
            nptDAO = new NguoiPhuTrachDAO();
        }
        return nptDAO;
    }

    @Override
    public List<NguoiPhuTrach> getNPTList() {
        List<NguoiPhuTrach> nptList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_nguoiphutrach";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                NguoiPhuTrach npt = new NguoiPhuTrach();
                npt.setMaNPT(rs.getInt("maNPT"));
                npt.setHoTen(rs.getString("hoTen"));
                npt.setNamSinh(rs.getDate("namSinh"));
                npt.setQueQuan(rs.getString("queQuan"));
                npt.setHocVi(rs.getString("hocVi"));
                npt.setChucVu(rs.getString("chucVu"));
                npt.setSDT(rs.getString("SDT"));
                npt.setEmail(rs.getString("email"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                npt.setDiaPhuong(dp);
                npt.setActive(rs.getInt("isActive"));
                nptList.add(npt);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nptList;
    }

    @Override
    public List<NguoiPhuTrach> getNPTListByName(String tenNPT) {
        List<NguoiPhuTrach> nptList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_nguoiphutrach where hoTen = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenNPT);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                NguoiPhuTrach npt = new NguoiPhuTrach();
                npt.setMaNPT(rs.getInt("maNPT"));
                npt.setHoTen(rs.getString("hoTen"));
                npt.setNamSinh(rs.getDate("namSinh"));
                npt.setQueQuan(rs.getString("queQuan"));
                npt.setHocVi(rs.getString("hocVi"));
                npt.setChucVu(rs.getString("chucVu"));
                npt.setSDT(rs.getString("SDT"));
                npt.setEmail(rs.getString("email"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                npt.setDiaPhuong(dp);
                npt.setActive(rs.getInt("isActive"));
                nptList.add(npt);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nptList;
    }

    @Override
    public NguoiPhuTrach getNPTByID(int maNPT) {
        NguoiPhuTrach npt = new NguoiPhuTrach();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_nguoiphutrach where maNPT = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNPT);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                npt.setMaNPT(rs.getInt("maNPT"));
                npt.setHoTen(rs.getString("hoTen"));
                npt.setNamSinh(rs.getDate("namSinh"));
                npt.setQueQuan(rs.getString("queQuan"));
                npt.setHocVi(rs.getString("hocVi"));
                npt.setChucVu(rs.getString("chucVu"));
                npt.setSDT(rs.getString("SDT"));
                npt.setEmail(rs.getString("email"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                npt.setDiaPhuong(dp);
                npt.setActive(rs.getInt("isActive"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return npt;
    }

    @Override
    public List<NguoiPhuTrach> findNguoiPhuTrachByDP(int maDP) {
        List<NguoiPhuTrach> nptList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_nguoiphutrach where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                NguoiPhuTrach npt = new NguoiPhuTrach();
                npt.setMaNPT(rs.getInt("maNPT"));
                npt.setHoTen(rs.getString("hoTen"));
                npt.setNamSinh(rs.getDate("namSinh"));
                npt.setQueQuan(rs.getString("queQuan"));
                npt.setHocVi(rs.getString("hocVi"));
                npt.setChucVu(rs.getString("chucVu"));
                npt.setSDT(rs.getString("SDT"));
                npt.setEmail(rs.getString("email"));
                npt.setActive(rs.getInt("isActive"));
                nptList.add(npt);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nptList;
    }

    @Override
    public boolean createNPT(NguoiPhuTrach npt) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tbl_nguoiphutrach(hoTen, namSinh, queQuan, hocVi, chucVu, SDT, email, maDP, isActive) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, npt.getHoTen());
            pstmt.setDate(2, (Date) npt.getNamSinh());
            pstmt.setString(3, npt.getQueQuan());
            pstmt.setString(4, npt.getHocVi());
            pstmt.setString(5, npt.getChucVu());
            pstmt.setString(6, npt.getSDT());
            pstmt.setString(7, npt.getEmail());
            pstmt.setInt(8, npt.getDiaPhuong().getMaDP());
            pstmt.setInt(9, npt.getActive());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateNPT(NguoiPhuTrach npt) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_nguoiphutrach set hoTen = ?, namSinh = ?, queQuan = ?, hocVi = ?, chucVu = ?, "
                    + "SDT = ?, email = ?, maDP = ?, isActive = ? where maNPT = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, npt.getHoTen());
            pstmt.setDate(2, (Date) npt.getNamSinh());
            pstmt.setString(3, npt.getQueQuan());
            pstmt.setString(4, npt.getHocVi());
            pstmt.setString(5, npt.getChucVu());
            pstmt.setString(6, npt.getSDT());
            pstmt.setString(7, npt.getEmail());
            pstmt.setInt(8, npt.getDiaPhuong().getMaDP());
            pstmt.setInt(9, npt.getActive());
            pstmt.setInt(10, npt.getMaNPT());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean deteleNPT(int maNPT) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete from tbl_nguoiphutrach where maNPT = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNPT);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public NguoiPhuTrach findNPTByDP(int maNPT, int maDP) {
        NguoiPhuTrach npt = new NguoiPhuTrach();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_nguoiphutrach where maNPT = ? and maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNPT);
            pstmt.setInt(2, maDP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                npt.setMaNPT(rs.getInt("maNPT"));
                npt.setHoTen(rs.getString("hoTen"));
                npt.setNamSinh(rs.getDate("namSinh"));
                npt.setQueQuan(rs.getString("queQuan"));
                npt.setHocVi(rs.getString("hocVi"));
                npt.setChucVu(rs.getString("chucVu"));
                npt.setSDT(rs.getString("SDT"));
                npt.setEmail(rs.getString("email"));
                DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByID(rs.getInt("maDP"));
                npt.setDiaPhuong(dp);
                npt.setActive(rs.getInt("isActive"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return npt;
    }

    @Override
    public boolean updateNPT_DP(int maNPT, int maDP) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_nguoiphutrach set maDP = ? where maNPT = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            pstmt.setInt(2, maNPT);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

}
