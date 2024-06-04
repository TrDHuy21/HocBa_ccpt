package ccpt.nhom2.hocbadientu.rowmapper;


import ccpt.nhom2.hocbadientu.object.LopObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LopRowMapper implements RowMapper<LopObject> {

	@Override
	public LopObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		LopObject lop = new LopObject();
		lop.setLop_id(rs.getString("lop_id"));
		lop.setLop_name(rs.getString("lop_name"));
		lop.setGvcn_id(rs.getInt("giaovien_id"));
		return lop;
	}

}
