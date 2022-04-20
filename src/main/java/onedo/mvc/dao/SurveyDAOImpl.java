package onedo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.util.DbUtil;

public class SurveyDAOImpl implements SurveyDAO {
private Properties proFile = new Properties();
	
	public SurveyDAOImpl() {
		try {
			//proFile.load(new FileInputStream("src/~~~~"));
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버에서 실행될때 classes폴더의 위치를 동적으로 가져와서 경로를 설정해야한다.
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<GoodsAttrDTO> survey(int sour, int body, int sweet, int aroma) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<GoodsAttrDTO> list = new ArrayList<GoodsAttrDTO>();
		String sql = proFile.getProperty("survey.select");//select * from goods_attr where sour=? and sweet=? and aroma=? and balance=?

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, sour);

			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				GoodsAttrDTO attrList = new GoodsAttrDTO(rs.getInt(1), rs.getInt(2), 
						rs.getInt(3), rs.getInt(4), rs.getInt(5));
				list.add(attrList);
			}
			
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(list);
		return list;
	}

}
