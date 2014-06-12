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
import model.dao.service.DiaPhuongDAOService;
import model.entities.DiaPhuong;

/**
 *
 * @author Admin
 */
public class DiaPhuongDAO implements DiaPhuongDAOService {

    private static DiaPhuongDAO dpDAO;

    public static DiaPhuongDAO getInstance() {
        if (dpDAO == null) {
            dpDAO = new DiaPhuongDAO();
        }
        return dpDAO;
    }

    @Override
    public List<DiaPhuong> getDiaPhuongAll() {
        List<DiaPhuong> dpList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_diaphuong";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaPhuong dp = new DiaPhuong();
                dp.setMaDP(rs.getInt("maDP"));
                dp.setTenDP(rs.getString("tenDP"));
                dp.setSDT(rs.getString("SDT"));
                dp.setNoiNhan(rs.getString("noiNhan"));
                dp.setDienTich(rs.getFloat("dienTich"));
                dp.setSoDan(rs.getFloat("soDan"));
                dp.setActive(rs.getInt("isActive"));
                dp.setTcList(DiaPhuong_TieuChiDAO.getInstance().getTCByDP(rs.getInt("maDP")));
                dp.setNptList(NguoiPhuTrachDAO.getInstance().findNguoiPhuTrachByDP(rs.getInt("maDP")));
                dpList.add(dp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dpList;
    }
    
    @Override
    public List<DiaPhuong> fintDiaPhuongByTen(String tenDP) {
        List<DiaPhuong> dpList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_diaphuong where tenDP like '" + "%" + tenDP + "%" + "'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DiaPhuong dp = new DiaPhuong();
                dp.setMaDP(rs.getInt("maDP"));
                dp.setTenDP(rs.getString("tenDP"));
                dp.setSDT(rs.getString("SDT"));
                dp.setNoiNhan(rs.getString("noiNhan"));
                dp.setDienTich(rs.getFloat("dienTich"));
                dp.setSoDan(rs.getFloat("soDan"));
                dp.setActive(rs.getInt("isActive"));
                dp.setTcList(DiaPhuong_TieuChiDAO.getInstance().getTCByDP(rs.getInt("maDP")));
                dp.setNptList(NguoiPhuTrachDAO.getInstance().findNguoiPhuTrachByDP(rs.getInt("maDP")));
                dpList.add(dp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dpList;
    }

    @Override
    public DiaPhuong getDiaPhuongByTenDP(String tenDP) {
        DiaPhuong dp = new DiaPhuong();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_diaphuong where UPPER(tenDP) = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenDP.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dp.setMaDP(rs.getInt("maDP"));
                dp.setTenDP(rs.getString("tenDP"));
                dp.setSDT(rs.getString("SDT"));
                dp.setNoiNhan(rs.getString("noiNhan"));
                dp.setDienTich(rs.getFloat("dienTich"));
                dp.setSoDan(rs.getFloat("soDan"));
                dp.setActive(rs.getInt("isActive"));
                dp.setTcList(DiaPhuong_TieuChiDAO.getInstance().getTCByDP(rs.getInt("maDP")));
                dp.setNptList(NguoiPhuTrachDAO.getInstance().findNguoiPhuTrachByDP(rs.getInt("maDP")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dp;
    }

    @Override
    public DiaPhuong getDiaPhuongByID(int maDP) {
        DiaPhuong dp = new DiaPhuong();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_diaphuong where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dp.setMaDP(rs.getInt("maDP"));
                dp.setTenDP(rs.getString("tenDP"));
                dp.setSDT(rs.getString("SDT"));
                dp.setNoiNhan(rs.getString("noiNhan"));
                dp.setDienTich(rs.getFloat("dienTich"));
                dp.setSoDan(rs.getFloat("soDan"));
                dp.setActive(rs.getInt("isActive"));
                dp.setTcList(DiaPhuong_TieuChiDAO.getInstance().getTCByDP(rs.getInt("maDP")));
                dp.setNptList(NguoiPhuTrachDAO.getInstance().findNguoiPhuTrachByDP(rs.getInt("maDP")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dp;
    }

    @Override
    public boolean createDiaPhuong(DiaPhuong dp) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tbl_diaphuong(tenDP, SDT, noiNhan, dienTich, soDan, isActive)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dp.getTenDP());
            pstmt.setString(2, dp.getSDT());
            pstmt.setString(3, dp.getNoiNhan());
            pstmt.setFloat(4, dp.getDienTich());
            pstmt.setFloat(5, dp.getSoDan());
            pstmt.setInt(6, dp.getActive());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateDiaPhuong(DiaPhuong dp) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_diaphuong set tenDP = ?, SDT = ?, noiNhan = ?, dienTich = ?, "
                    + "soDan = ?, isActive = ? where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dp.getTenDP());
            pstmt.setString(2, dp.getSDT());
            pstmt.setString(3, dp.getNoiNhan());
            pstmt.setFloat(4, dp.getDienTich());
            pstmt.setFloat(5, dp.getSoDan());
            pstmt.setInt(6, dp.getActive());
            pstmt.setInt(7, dp.getMaDP());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean removeDiaPhuong(int maDP) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_diaphuong set isActive = 0 where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean restoreDiaPhuong(int maDP) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_diaphuong set isActive = 1 where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean deleteDiaPhuong(int maDP) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete from tbl_diaphuong where maDP = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDP);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

}
