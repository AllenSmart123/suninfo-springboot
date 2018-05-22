package com.suninfo.service;

import com.suninfo.model.CmdbAttribute;
import java.util.List;
import com.suninfo.util.base.Criteria;

public interface CmdbAttributeService  {

	public int saveCmdbAttribute(CmdbAttribute cmdbAttribute);
	
	public int batchSaveCmdbAttributes(List<CmdbAttribute> cmdbAttributeList);
	
	public int updateCmdbAttribute (CmdbAttribute cmdbAttribute);
	
	public int updateCmdbAttributeBySelective (CmdbAttribute cmdbAttribute); 	
	
	public int deleteCmdbAttribute(String uuid);
	
	public int batchDelCmdbAttributes(List<String> uuidList);
	
	public int getCmdbAttributeByCount();
	
	public List<CmdbAttribute> getCmdbAttributeByList(Criteria criteria);
	
	public List<CmdbAttribute> getAll();
	
	public CmdbAttribute getCmdbAttributeByUuid(String uuid);
	
}
