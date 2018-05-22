package ${bussPackage}.service.impl#if($!entityPackage).${entityPackage}#end;
import com.suninfo.model.${className};
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end.${className}Dao;
import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;
import com.suninfo.util.base.Criteria;
import com.github.pagehelper.PageHelper;
/**
 * 【描述】：
 */
@Service("$!{lowerName}Service")
public class  ${className}ServiceImpl implements ${className}Service {

   private static Logger log = LoggerFactory.getLogger(${className}ServiceImpl.class);
	
	@Autowired
    private ${className}Dao ${lowerName}dao;

		
	public ${className}Dao get${className}Dao() {
		return ${lowerName}dao;
	}

	public int save${className} (${className} ${lowerName}){
		return ${lowerName}dao.save${className}(${lowerName});
	}
	
	public int batchSave${className}s(List<${className}> ${lowerName}List){
		return ${lowerName}dao.batchSave${className}s(${lowerName}List);
	}
	
	public int update${className}(${className} ${lowerName}){
		return ${lowerName}dao.update${className}(${lowerName});
	}
	
	public int update${className}BySelective(${className} ${lowerName}){
		return ${lowerName}dao.update${className}BySelective(${lowerName});
	}
	
	public int delete${className}(String uuid){
		return ${lowerName}dao.delete${className}(uuid);
	}
	
	public int batchDel${className}s(List<String> uuidList){
		return ${lowerName}dao.batchDel${className}s(uuidList);
	}
	public int get${className}ByCount(){
		return ${lowerName}dao.get${className}ByCount();
	}
	
	public List<${className}> get${className}ByList(Criteria criteria){
		//分页例子
		PageHelper.startPage(1,10);
		criteria.setOrderByClause("id");
		return ${lowerName}dao.get${className}ByList(criteria);
	}
	
	public List<${className}> getAll(){
		return ${lowerName}dao.getAll();
	}
	
	public ${className} get${className}ByUuid(String uuid){
		return  ${lowerName}dao.get${className}ByUuid(uuid);
	}

}
