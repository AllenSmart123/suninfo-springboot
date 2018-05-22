package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end;

import com.suninfo.model.${className};
import java.util.List;
import com.suninfo.util.base.Criteria;

public interface ${className}Service  {

	public int save${className}(${className} ${lowerName});
	
	public int batchSave${className}s(List<${className}> ${lowerName}List);
	
	public int update${className} (${className} ${lowerName});
	
	public int update${className}BySelective (${className} ${lowerName}); 	
	
	public int delete${className}(String uuid);
	
	public int batchDel${className}s(List<String> uuidList);
	
	public int get${className}ByCount();
	
	public List<${className}> get${className}ByList(Criteria criteria);
	
	public List<${className}> getAll();
	
	public ${className} get${className}ByUuid(String uuid);
	
}
