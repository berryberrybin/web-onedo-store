package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.util.DbUtil;

public class SurveyDAOImpl implements SurveyDAO {
	private Properties proFile = DbUtil.getProFile();
	
	
	@Override
	public List<GoodsDTO> survey(GoodsAttrDTO goodsAttrDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		String sql = proFile.getProperty("survey.select");

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodsAttrDTO.getSour());
			ps.setInt(2, goodsAttrDTO.getBody());
			ps.setInt(3, goodsAttrDTO.getSweet());
			ps.setInt(4, goodsAttrDTO.getAroma());
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				GoodsDTO goodsList  = new GoodsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
				list.add(goodsList);
				
			}
			
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

}
