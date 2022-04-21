package onedo.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.QnaDAO;
import onedo.mvc.dao.QnaDAOImpl;
import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.ReviewDTO;

public class QnaServiceImpl implements QnaService {
	private QnaDAO qdao = new QnaDAOImpl();

	@Override
	public List<QnaDTO> selectAll() throws SQLException {
		List<QnaDTO> list = qdao.selectAll();
		
		return list;
	}

	@Override
	public List<QnaDTO> selectAll(int pageNo) throws SQLException {
		List<QnaDTO> list = qdao.getBoardList(pageNo);
		
		return list;
	}

	@Override
	public void insert(QnaDTO qnaDTO) throws SQLException {
		int result = qdao.insert(qnaDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public QnaDTO selectByQnaCode(int qnaNo) throws SQLException {
		QnaDTO qdto = qdao.selectByQnaCode(qnaNo);
		if(qdto==null) {
			throw new SQLException("상세보기 오류 발생했습니다.");
		}
		
		return qdto;
	}

	@Override
	public void delete(int qnaNo,String qnaPwd) throws SQLException {
			
			//비밀번호 일치 여부 체크
			int result =  qdao.delete(qnaNo, qnaPwd);

			if(result==0) {
				throw new SQLException(qnaNo+"게시물을 삭제할수 없습니다.");
			}
			
			/*
			 * if(qnaDB.getFname()!=null) { new
			 * File(path+"/"+qnaDB.getFname()).delete();//파일삭제 }
			 */
		}

	@Override
	public void update(QnaDTO qnaDTO) throws SQLException {
		
		int result = qdao.update(qnaDTO);
		
		if(result==0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}

	@Override
	public List<QnaDTO> selectQnaByGoodsCode(int goodsCode) throws SQLException{
		List<QnaDTO> list = qdao.selectQnaByGoodsCode(goodsCode);
		if(list==null) {
			throw new SQLException("상품코드가 "+goodsCode+"인 상품의 문의를 불러올 수 없습니다.");
		}
		
		return list;
	}

	
}
