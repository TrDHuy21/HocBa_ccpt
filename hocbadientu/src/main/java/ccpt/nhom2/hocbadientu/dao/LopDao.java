package ccpt.nhom2.hocbadientu.dao;

import ccpt.nhom2.hocbadientu.object.LopObject;
import ccpt.nhom2.hocbadientu.rowmapper.LopRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LopDao extends JdbcDao {
	public LopObject getLopById(String lop_id) {
		String sql = "SELECT * FROM lop WHERE lop_id = ?";
		return getJdbcTemplate().queryForObject(sql, new LopRowMapper(), lop_id);
	}
	
	public List<LopObject> getLopByGvcnId(int giaovien_id) {
		String sql = "SELECT * FROM lop WHERE giaovien_id = ?";
		return getJdbcTemplate().query(sql, new LopRowMapper(), giaovien_id);
	}
}
