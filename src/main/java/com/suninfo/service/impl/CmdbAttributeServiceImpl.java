package com.suninfo.service.impl;
import com.suninfo.model.CmdbAttribute;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suninfo.dao.CmdbAttributeDao;
import com.suninfo.service.CmdbAttributeService;
import com.suninfo.util.base.Criteria;
import com.github.pagehelper.PageHelper;
/**
 * 【描述】：
 */
@Service("cmdbAttributeService")
public class  CmdbAttributeServiceImpl implements CmdbAttributeService {

   private static Logger log = LoggerFactory.getLogger(CmdbAttributeServiceImpl.class);
	
	@Autowired
    private CmdbAttributeDao cmdbAttributedao;

		
	public CmdbAttributeDao getCmdbAttributeDao() {
		return cmdbAttributedao;
	}

	public int saveCmdbAttribute (CmdbAttribute cmdbAttribute){
		return cmdbAttributedao.saveCmdbAttribute(cmdbAttribute);
	}
	
	public int batchSaveCmdbAttributes(List<CmdbAttribute> cmdbAttributeList){
		return cmdbAttributedao.batchSaveCmdbAttributes(cmdbAttributeList);
	}
	
	public int updateCmdbAttribute(CmdbAttribute cmdbAttribute){
		return cmdbAttributedao.updateCmdbAttribute(cmdbAttribute);
	}
	
	public int updateCmdbAttributeBySelective(CmdbAttribute cmdbAttribute){
		return cmdbAttributedao.updateCmdbAttributeBySelective(cmdbAttribute);
	}
	
	public int deleteCmdbAttribute(String uuid){
		return cmdbAttributedao.deleteCmdbAttribute(uuid);
	}
	
	public int batchDelCmdbAttributes(List<String> uuidList){
		return cmdbAttributedao.batchDelCmdbAttributes(uuidList);
	}
	public int getCmdbAttributeByCount(){
		return cmdbAttributedao.getCmdbAttributeByCount();
	}
	
	public List<CmdbAttribute> getCmdbAttributeByList(Criteria criteria){
		//分页例子
		PageHelper.startPage(1,10);
		criteria.setOrderByClause("id");
		return cmdbAttributedao.getCmdbAttributeByList(criteria);
	}
	
	public List<CmdbAttribute> getAll(){
		return cmdbAttributedao.getAll();
	}
	
	public CmdbAttribute getCmdbAttributeByUuid(String uuid){
		return  cmdbAttributedao.getCmdbAttributeByUuid(uuid);
	}

}
