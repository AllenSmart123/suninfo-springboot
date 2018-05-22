package com.suninfo.util.autoCode;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author lintu5.com
 * 
 */

public class CodeUtilMain {

	private static String url = CodeResourceUtil.URL;

	private static String username = CodeResourceUtil.USERNAME;

	private static String passWord = CodeResourceUtil.PASSWORD;

	public static void main( String[] args ) {

		try {
			config();
		} catch( SQLException e ) {
			e.printStackTrace();
		}

	}

	private static void config() throws SQLException {
		CreateBean createBean = new CreateBean();
		createBean.setMysqlInfo( url, username, passWord );
		List<String> tables = createBean.getTables();

		//for( int i = 0; i < tables.size(); i++ ) {
			String tableName = "cmdb_attribute";
			String codeName = tableName;// 中文注释 当然你用英文也是可以的
			String entityPackage = "";// 实体包
			String keyType = FtlDef.KEY_TYPE_02;// 主键生成方式 01:UUID 02:自增
			CodeGenerateFactory.codeGenerate( createBean, tableName, codeName, entityPackage, keyType );
		//}

	}

}
