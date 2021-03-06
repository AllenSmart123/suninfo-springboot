package com.suninfo.util.autoCode;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CodeGenerateFactory {

	private static Logger log = LoggerFactory.getLogger( CodeGenerateFactory.class );

	private static String url = CodeResourceUtil.URL;

	private static String username = CodeResourceUtil.USERNAME;

	private static String passWord = CodeResourceUtil.PASSWORD;

	private static String buss_package = CodeResourceUtil.bussiPackage;

	private static String projectPath = getProjectPath();

	private static String webProjectPath = getProjectPath();

	public static void codeGenerate( CreateBean createBean, String tableName, String codeName, String controllerEntityPackage, String keyType ) {
		codeGenerate( createBean, tableName, codeName, "", controllerEntityPackage, keyType );
	}

	public static void codeGenerate( CreateBean createBean, String tableName, String codeName, String entityPackage, String controllerEntityPackage, String keyType ) {

		String className = createBean.getTablesNameToClassName( tableName );
		String lowerName = className.substring( 0, 1 ).toLowerCase() + className.substring( 1, className.length() );
		String srcPath = projectPath + CodeResourceUtil.source_root_package + "\\";
		String webSrcPath = webProjectPath + CodeResourceUtil.source_root_package + "\\";
		String resourcePath = projectPath + CodeResourceUtil.resource_root_package + "\\";
		String testPath = projectPath + CodeResourceUtil.test_root_package + "\\";
		String srcPckPath = srcPath + CodeResourceUtil.bussiPackageUrl + "\\";
		String webSrcPckPath = webSrcPath + CodeResourceUtil.bussiPackageUrl + "\\";
		String testPckPath = testPath + CodeResourceUtil.bussiPackageUrl + "\\";
		String webPath = projectPath + CodeResourceUtil.web_root_package + "\\view\\" + CodeResourceUtil.bussiPackageUrl + "\\";
		String entityPath = ( entityPackage == null || "".equals( entityPackage ) ) ? "" : entityPackage + "\\";
		String cPath = ( controllerEntityPackage == null || "".equals( controllerEntityPackage ) ) ? "" : controllerEntityPackage + "\\";
		String beanPath = "model\\" + entityPath + className + ".java";
		String mapperPath = "dao\\" + entityPath + className + "Dao.java";
		String servicePath = "service\\" + entityPath + className + "Service.java";
		String serviceImplPath = "service\\impl\\" + entityPath + className + "ServiceImpl.java";
		String ServiceJunitPath = "test\\" + entityPath + className + "ServiceTest.java";
		String controllerPath = "controller\\" + cPath + className + "Controller.java";
		String sqlMapperPath = "mapper\\" + entityPath + className + "Mapper.xml";
		webPath = webPath + entityPath;
		String jspPath = lowerName + ".jsp";

		VelocityContext context = new VelocityContext();
		context.put( "className", className );
		context.put( "lowerName", lowerName );
		context.put( "codeName", codeName );
		context.put( "tableName", tableName );
		context.put( "bussPackage", buss_package );
		context.put( "entityPackage", entityPackage == "" ? null : entityPackage );
		context.put( "controllerEntityPackage", controllerEntityPackage == "" ? null : controllerEntityPackage );
		context.put( "keyType", keyType );
		try {
			context.put( "feilds", createBean.getBeanFeilds( tableName ) );
		} catch( Exception e ) {
			e.printStackTrace();
		}

		try {
			Map sqlMap = createBean.getAutoCreateSql( tableName );
			context.put( "columnDatas", createBean.getColumnDatas( tableName ) );
			context.put( "SQL", sqlMap );
		} catch( Exception e ) {
			e.printStackTrace();
			return;
		}


		CommonPageParser.WriterPage( context, "EntityTemplate.ftl", srcPckPath, beanPath );
		CommonPageParser.WriterPage( context, "DaoTemplate.ftl", srcPckPath, mapperPath );
		CommonPageParser.WriterPage( context, "ServiceTemplate.ftl", srcPckPath, servicePath );
		CommonPageParser.WriterPage( context, "ServiceImplTemplate.ftl", srcPckPath, serviceImplPath );
		CommonPageParser.WriterPage( context, "MapperTemplate.xml", resourcePath, sqlMapperPath );
		CommonPageParser.WriterPage( context, "ControllerTemplate.ftl", webSrcPckPath, controllerPath );
		CommonPageParser.WriterPage( context, "ServiceJunitTemplate.ftl", testPckPath, ServiceJunitPath );

		// CommonPageParser.WriterPage(context, "jspTemplate.ftl", webPath,
		// jspPath);

		log.info( "----------------------------\u4EE3\u7801\u751F\u6210\u5B8C\u6BD5---------------------------" );
	}

	public static String getProjectPath() {
		String path = System.getProperty( "user.dir" ).replace( "\\", "/" ) + "/";
		//path = path +"suninfoAPI/";
		return path;
	}

	public static String getWebProjetPath() {
		String path = getProjectPath().replace( "suninfoAPI", "ROOT" );
		return path;
	}
}