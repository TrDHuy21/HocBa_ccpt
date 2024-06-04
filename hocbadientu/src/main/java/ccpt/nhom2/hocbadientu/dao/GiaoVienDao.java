package ccpt.nhom2.hocbadientu.dao;


import ccpt.nhom2.hocbadientu.object.GiaoVienObject;
import ccpt.nhom2.hocbadientu.rowmapper.GiaoVienRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GiaoVienDao extends JdbcDao {
	public GiaoVienObject getGiaoVienByTDN(String tendangnhap) {
		String SQL = "SELECT * "
				+ "FROM giaovien "
				+ "JOIN user "
				+ "ON giaovien.user_tendangnhap = user.user_tendangnhap "
				+ "WHERE user.user_tendangnhap = ? ";
		
		return getJdbcTemplate().queryForObject(SQL, new GiaoVienRowMapper(), tendangnhap);
	}
}
