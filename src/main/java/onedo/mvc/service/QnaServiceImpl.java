package onedo.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.QnaDAO;
import onedo.mvc.dao.QnaDAOImpl;
import onedo.mvc.dto.QnaDTO;

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
	public void delete(int qnaNo,String path) throws SQLException {
			QnaDTO qnaDB =  qdao.selectByQnaCode(qnaNo);
			if(qdao.delete(qnaNo)==0) {
				throw new SQLException(qnaNo+"게시물을 삭제할수 없습니다.");
			}
			
			if(qnaDB.getFname()!=null) {
				new File(path+"/"+qnaDB.getFname()).delete();//파일삭제
			}
		}

	@Override
	public void update(QnaDTO qnaDTO) throws SQLException {

		if(qdao.update(qnaDTO)==0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}

	
}
