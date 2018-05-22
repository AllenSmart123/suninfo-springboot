package com.suninfo.util.base.dynamicDataSource;

import java.lang.annotation.*;

@Target( { ElementType.METHOD, ElementType.TYPE } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface DataSource {

	String name() default DataSource.master;

	public static String master = "master";

	public static String slave = "slave";

}
