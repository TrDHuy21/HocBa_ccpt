package ccpt.nhom2.hocbadientu.dao;

import ccpt.nhom2.hocbadientu.object.PhuHuynhObject;
import ccpt.nhom2.hocbadientu.rowmapper.PhuHuynhRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PhuHuynhDao extends JdbcDao {
	public PhuHuynhObject getPhuHuynhByTDN(String tendangnhap) {
		String SQL = "SELECT * "
				+ "FROM phuhuynh "
				+ "JOIN user "
				+ "ON phuhuynh.user_tendangnhap = user.user_tendangnhap "
				+ "WHERE user.user_tendangnhap = ?";
		return getJdbcTemplate().queryForObject(SQL, new PhuHuynhRowMapper(), tendangnhap);
	}
}
