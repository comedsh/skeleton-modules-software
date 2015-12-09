package com.fenghua.auto.sku.backend.service;

import java.io.InputStream;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.CachedDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fenghua.auto.sku.backend.domain.Sku;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年12月4日
  * @version 
  */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml"})
public class SkuServiceTest extends DBTestCase{
	
	@Autowired
	private SkuService skuService;
	
	private IDataSet dataSetBackup;
	
	private String TABLE_NAME = "sku";
	
   
   /**
    * 删除 
    * 	上架商品不能删除即 只能是下架或草稿状态
    * @throws Exception
    */
	@Test
	public void modifySatusForDelete() throws Exception{	
		/*初始数据
		 *  id:1, 编号 ： Test_SKU_001  状态 :上架; 
			id:2, 编号 ： Test_SKU_002  状态 :下架
			id:3, 编号 ： Test_SKU_003  状态 : 草稿,
			id:4, 编号 ： Test_SKU_004  状态 :删除	
			
			商品状态 ： 1 草稿 ; 2上架 ; 3 下架 ; 4 删除	
		*/
		
		//上架商品不能删除即 只能是下架或草稿状态
		Long[] ids = new Long[]{1l,2l,3l};
		
		List<Sku> result = skuService.updateSkuStatus(ids, 4);
		
		//期望结果
		//返回结果result 的值为1,且sku 编号是 Test_SKU_001
		assertEquals(1, result.size());
		assertEquals("Test_SKU_001", result.get(0).getCode());
		
		//Db中 Test_SKU_002,Test_SKU_003 的状态变为 4,
	    ITable actualJoinData = getConnection().createQueryTable(TABLE_NAME,
	                "SELECT * FROM sku where  status = 4 and id =2 or id = 3 "); 
	 	assertEquals(2, actualJoinData.getRowCount());
	 	
	 	// Test_SKU_001 状态不变 为1
	 	ITable data = getConnection().createQueryTable(TABLE_NAME,
	                "SELECT id,code FROM sku where  status = 2 and id = 1 "); 
	 	assertEquals(1, data.getRowCount());
		
	}
	
	
	/**
	 * 测试下架 
	 *   只有上架商品才能下架
	 * @throws Exception
	 */
	@Test
	public void modifySatusForDownShelf() throws Exception{	
		/*初始数据
		 *  id:1, 编号 ： Test_SKU_001  状态 :上架; 
			id:2, 编号 ： Test_SKU_002  状态 :下架
			id:3, 编号 ： Test_SKU_003  状态 : 草稿,
			id:4, 编号 ： Test_SKU_004  状态 :删除	
			
			商品状态 ： 1 草稿 ; 2上架 ; 3 下架 ; 4 删除	
		*/
		
		Long[] ids = new Long[]{1l,2l,3l,4l};
		
		List<Sku> result = skuService.updateSkuStatus(ids, 3);
		
		//期望结果
		//返回结果result 的值为3
		assertEquals(3, result.size());
		
		//Db中 存在两个下架商品
	    ITable actualJoinData = getConnection().createQueryTable(TABLE_NAME,
	                "SELECT * FROM sku where  status = 3 "); 
	 	assertEquals(2, actualJoinData.getRowCount());
	 	
	 	// Test_SKU_001 状态变为下架 3
	 	ITable data = getConnection().createQueryTable(TABLE_NAME,
	                "SELECT * FROM sku where  status = 3 and id = 1 "); 
	 	assertEquals(1, data.getRowCount());
		
	}
	
	/**
	 * 上架
	 *   删除状态不能上架，只能是草稿和下架状态
	 * @throws Exception
	 */
	@Test
	public void modifySatusForUpShelf() throws Exception{	
		/*初始数据
		 *  id:1, 编号 ： Test_SKU_001  状态 :上架; 
			id:2, 编号 ： Test_SKU_002  状态 :下架
			id:3, 编号 ： Test_SKU_003  状态 : 草稿,
			id:4, 编号 ： Test_SKU_004  状态 :删除	
			
			商品状态 ： 1 草稿 ; 2上架 ; 3 下架 ; 4 删除	
		*/
		
		Long[] ids = new Long[]{2l,3l,4l};
		
		List<Sku> result = skuService.updateSkuStatus(ids, 2);
		
		// 期望结果
		// 返回结果result 的值为1 ，且code 为Test_SKU_004
		assertEquals(1, result.size());
		assertEquals("Test_SKU_004", result.get(0).getCode());

		// Db中 存在 3个上架商品
		ITable actualJoinData = getConnection().createQueryTable(TABLE_NAME, "SELECT * FROM sku where  status = 2 ");
		assertEquals(3, actualJoinData.getRowCount());

		// Test_SKU_002, Test_SKU_003  状态变为上架 
		ITable data = getConnection().createQueryTable(TABLE_NAME,
				"SELECT * FROM sku where  status = 2 and id = 2 or id =3 ");
		assertEquals(2, data.getRowCount());
	}
	
	
	
	
	@Value("${mybatis.driverClassName}")
	private String driverName;
	@Value("${mybatis.url}")
	private String url;
	@Value("${mybatis.username}")
	private String username;
	@Value("${mybatis.password}")
	private String password;
	
	public SkuServiceTest(){
			
			
	}
	
	@Before
	public void setUp() throws Exception{
		//设置数据库连接属性
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,driverName );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, url);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,username);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, password );
        
		//备份数据库中数据		
		 dataSetBackup = new CachedDataSet(getConnection().createDataSet(new String[]{TABLE_NAME}));
		 super.setUp();
		
		 //验证数据库中数据 和xml中数据一致
		 
		 // Fetch database data after executing your code
	     IDataSet databaseDataSet = getConnection().createDataSet();
	     ITable actualTable = databaseDataSet.getTable(TABLE_NAME);
  
	     // Load expected data from an XML dataset
	     IDataSet expectedDataSet = getDataSet();
	     ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);

	     //保持列数一致
	     ITable filteredTable = DefaultColumnFilter.includedColumnsTable(actualTable, 
	    		 expectedTable.getTableMetaData().getColumns());

	     Assertion.assertEquals(expectedTable, filteredTable);

	}
	
	
	
	@After
	public void tearDown() throws Exception {
		IDatabaseTester databaseTester = null;
	    try {
	    	//恢复数据库数据
	        databaseTester = getDatabaseTester();
	        assertNotNull( "DatabaseTester is not set", databaseTester );
	        databaseTester.setTearDownOperation( getTearDownOperation() );
	        databaseTester.setDataSet( dataSetBackup ); 
	        databaseTester.setOperationListener(getOperationListener());
	        databaseTester.onTearDown();
	    } finally {

	    	databaseTester = null;
	        dataSetBackup = null;
	    }
	}

	
	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dataSku.xml");
		assertNotNull(inputStream);
		return new FlatXmlDataSetBuilder().build(inputStream);
	}
	
	
	//插入初始数据
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception
	{
	     return DatabaseOperation.CLEAN_INSERT;
	}

	//删除初始数据
	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception
	{
		return DatabaseOperation.CLEAN_INSERT;
	}
	
}
