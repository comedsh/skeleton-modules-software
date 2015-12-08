package com.fenghua.auto.sku.backend.service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcBasedDBTestCase;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.QueryDataSet;
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
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fenghua.auto.sku.backend.domain.SkuStatistic;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年12月8日
  * @version 
  */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml"})
public class SkuStatisticServiceTest extends DBTestCase{

	@Autowired
    private SkuStatisticService skuStatisticService;
	
	private QueryDataSet queryDataSet;
	
	private String TABLE_NAME = "sku_statistic";
	
	@Test
	public void insert() throws SQLException, Exception{
		insertData();
	}
	
	private void insertData() throws SQLException, Exception{
		//插入数据  <sku_statistic id="1" sale_count="100" buyer_count="50" high_praise="90%" comment_count="30" high_comment_count="10" sku_id="1"/>
		SkuStatistic entity = new SkuStatistic();
		entity.setId(1l);
		entity.setSaleCount(100l);
		entity.setBuyerCount(50l);
		entity.setHighPraise("90%");
		entity.setCommentCount(30l);
		entity.setHighCommentCount(10l);
		entity.setSkuId(1l);	
		skuStatisticService.insert(entity);
		
		 //验证数据插入是否成功 ，如果成功 ,和模拟数据相同
		 // Fetch database data after executing your code
	     IDataSet databaseDataSet = getConnection().createDataSet();
	     ITable actualTable = databaseDataSet.getTable(TABLE_NAME);
 
	     // Load expected data from an XML dataset
	     IDataSet expectedDataSet = getDataSet();
	     ITable expectedTable = expectedDataSet.getTable(TABLE_NAME);

	     //保持列数一致
	     ITable filteredTable = DefaultColumnFilter.includedColumnsTable(actualTable, expectedTable.getTableMetaData().getColumns());

	     Assertion.assertEquals(expectedTable, filteredTable);
		
	}
	
	@Test
	public void update() throws SQLException, Exception{
		insertData();
		//更新
		SkuStatistic entity = new SkuStatistic();
		entity.setId(1l);
		entity.setSaleCount(1000l);
		
		skuStatisticService.updateById(entity);
		
		 ITable actualTable = getConnection().createQueryTable(TABLE_NAME, "select * from sku_statistic where id=1 and sale_count = 1000");
		 assertEquals(1, actualTable.getRowCount());	
	}
	
	@Test
	public void delete() throws SQLException, Exception{
		//插入数据
		insertData();
		
		//删除ID为1的数据

		skuStatisticService.deleteById(1l);
		
		//删除成功后, id = 1的数据总数为0
		 ITable actualTable = getConnection().createQueryTable(TABLE_NAME, "select * from sku_statistic where id=1");
		 assertEquals(0, actualTable.getRowCount());	
		
	}
    
	
	@Value("${mybatis.driverClassName}")
	private String driverName;
	@Value("${mybatis.url}")
	private String url;
	@Value("${mybatis.username}")
	private String username;
	@Value("${mybatis.password}")
	private String password;
	
	@Before
	public void setUp() throws Exception{
		//设置数据库连接属性
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,driverName );
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, url);
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,username);
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, password );
		
		        
	     //判断预先准备的数据是否存在，如果存在，备份数据库中的数据	
		 QueryDataSet queryDataSet = new QueryDataSet(getConnection());
		 queryDataSet.addTable(TABLE_NAME, "select * from sku_statistic where id=1");
		 super.setUp();
		
	     IDataSet databaseDataSet = getConnection().createDataSet();
	     ITable actualTable = databaseDataSet.getTable(TABLE_NAME);
  
	     //数据库中不存在该数据
	     assertEquals(0,  actualTable.getRowCount());

	}
	
	
	
	@After
	public void tearDown() throws Exception {
		IDatabaseTester databaseTester = null;
	    try {
	    	//恢复数据库数据
	        databaseTester = getDatabaseTester();
	        assertNotNull( "DatabaseTester is not set", databaseTester );
	        databaseTester.setTearDownOperation( getTearDownOperation() );
	        if(queryDataSet != null){
	        	  databaseTester.setDataSet(queryDataSet);
	        }else{
	        	databaseTester.setDataSet(getDataSet());
	        }
	       
	        databaseTester.setOperationListener(getOperationListener());
	        databaseTester.onTearDown();
	    } finally {
	    	databaseTester = null;
	    	queryDataSet = null;
	    }
	}

	
	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dataSkuStatistic.xml");
		assertNotNull(inputStream);
		return new FlatXmlDataSetBuilder().build(inputStream);
	}
	
	
	//清楚数据库数据
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception
	{
	     return DatabaseOperation.DELETE;
	}

	//恢复数据库数据
	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception
	{
		if(queryDataSet != null && queryDataSet.getTable(TABLE_NAME).getRowCount() > 0){
			//恢复数据
			return DatabaseOperation.REFRESH;
		}
		return DatabaseOperation.DELETE;
		
	}
	
}
