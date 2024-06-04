package ccpt.nhom2.hocbadientu.rowmapper;



import ccpt.nhom2.hocbadientu.object.MonHocObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonHocRowMapper implements RowMapper<MonHocObject> {

	@Override
	public MonHocObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		MonHocObject mh = new MonHocObject();
		mh.setHocKi(rs.getInt("hocki"));
		mh.setMonHoc_id(rs.getString("monhoc_id"));
		mh.setMonHoc_name(rs.getString("monhoc_name"));
		return mh;
	}

}
