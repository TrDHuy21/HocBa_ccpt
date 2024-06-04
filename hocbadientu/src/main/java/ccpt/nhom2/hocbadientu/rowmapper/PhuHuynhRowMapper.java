package ccpt.nhom2.hocbadientu.rowmapper;


import ccpt.nhom2.hocbadientu.object.PhuHuynhObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhuHuynhRowMapper implements RowMapper<PhuHuynhObject> {

	@Override
	public PhuHuynhObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		PhuHuynhObject ph = new PhuHuynhObject();
		ph.setPhuhuynh_id(rs.getInt("phuhuynh_id"));
		ph.setTendangnhap(rs.getString("user_tendangnhap"));
		ph.setPassword(rs.getString("user_password"));
		ph.setHo(rs.getString("user_ho"));
		ph.setTen(rs.getString("user_ten"));
		ph.setHoten(String.format("%s %s", rs.getString("user_ho"), rs.getString("user_ten")));
		ph.setDiachi(rs.getString("user_diachi"));
		ph.setSdt(rs.getString("user_sdt"));
		ph.setEmail(rs.getString("user_email"));
		ph.setNgaysinh(rs.getDate("user_ngaysinh"));
		ph.setLoaitk(rs.getString("user_loaitk"));
		ph.setGioitinh(rs.getInt("user_gioitinh"));
		return ph;
	}
}
