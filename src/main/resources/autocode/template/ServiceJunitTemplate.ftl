package com.suninfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ${bussPackage}.model#if($!entityPackage).${entityPackage}#end.${className};
import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;




/*
 * @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true) 
 * transactionManager的默认取值是"transactionManager"，
 * defaultRollback的默认取值是true，当然，你也可以改成false。
 * true表示测试不会对数据库造成污染,false的话当然就会改动到数据库中了。
 * 在方法名上添加@Rollback(false)表示这个测试用例不需要回滚。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ${className}ServiceTest {
	@Autowired
	private ${className}Service $!{lowerName}Service;
	

	@Test
	public void testAdd(){
		try {
			${className} $!{lowerName} = new ${className}();
			int i = $!{lowerName}Service.save${className}($!{lowerName});
			System.out.println(i+"行数据更新");
			System.out.println("$!{lowerName}.getId():"+$!{lowerName}.getId());
			System.out.println("$!{lowerName}.getUuid():"+$!{lowerName}.getUuid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDel(){
		try {
			String uuid = "";
			$!{lowerName}Service.delete${className}(uuid);
			System.out.println("---testDel-----------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
