package ccpt.nhom2.hocbadientu.rowmapper;



import ccpt.nhom2.hocbadientu.object.HS_TKB_Object;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HS_TKB_RowMapper implements RowMapper<HS_TKB_Object> {
	@Override
	public HS_TKB_Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		HS_TKB_Object tkb = new HS_TKB_Object();
		tkb.setThoigian(rs.getInt("thoigian"));
		tkb.setTiethoc(rs.getInt("tiethoc"));
		tkb.setMonhoc_name(rs.getString("monhoc_name"));
		return tkb;
	}
}
