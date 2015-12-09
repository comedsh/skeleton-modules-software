package com.fenghua.auto.backend.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.dao.PageInfo;
import com.fenghua.auto.backend.domain.DomainObject;
import com.fenghua.auto.backend.service.BaseService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月25日
  * @version 
  */
@Transactional
public abstract class BaseServiceImpl<T extends DomainObject> implements BaseService<T>{
		

		public <V extends T> V selectOne(T query) {
			return (V) getBaseDao().selectOne(query);
		}
		
		
		public <V extends T> V selectById(T query) {
			return (V) getBaseDao().selectById(query);
		}
		
		public  <V extends T> List<V> selectList(T query) {
			return getBaseDao().selectList(query);
		}
		
		public <V extends T> PageInfo<V> selectListByPage(T query, String sqlName, PageInfo pageInfo){
			return getBaseDao().selectListByPage(query, sqlName, pageInfo);
		};

		public <V extends T> V selectById(Serializable id){
			return getBaseDao().selectById(id);
		}

		
		public <V extends T> List<V> selectAll(){
			return getBaseDao().selectAll();
		}


		
		public <K, V extends T> Map<K, V> selectMap(T query, String mapKey) {
			return getBaseDao().selectMap(query, mapKey);
		}


		public <V extends T> List<V> selectList(T query, Pageable pageable) {
			return getBaseDao().selectList(query, pageable);
		}

		public <K, V extends T> Map<K, V> selectMap(T query, String mapKey, Pageable pageable) {
		   return getBaseDao().selectMap(query, mapKey, pageable);
		}

		
		public Long selectCount() {
			return getBaseDao().selectCount();
		}


		public Long selectCount(T query) {
			return getBaseDao().selectCount();
		}

		
		public void insert(T entity) {
			 getBaseDao().insert(entity);
		}


		
		public int delete(T query) {
			return getBaseDao().delete(query);
		}
		
		public int deleteById(Serializable id) {
			return getBaseDao().deleteById(id);
		}

		public int deleteAll() {
			return getBaseDao().deleteAll();
		}


		public int updateById(T entity) {
			return getBaseDao().updateById(entity);
		}

		public int updateByIdSelective(T entity) {
			return getBaseDao().updateByIdSelective(entity);
		}
		
		public void insertInBatch(List<T> entityList) {
	      getBaseDao().insertInBatch(entityList);
		}

		
		public void deleteByIdInBatch(List<Long> idList) {
			 getBaseDao().deleteByIdInBatch(idList);
		}


		
		public void updateInBatch(List<T> entityList) {
			getBaseDao().updateInBatch(entityList);
		}

		/**
		 * 子类提供BaseDao
		 * @return
		 */
		protected abstract BaseDao<T> getBaseDao();
		
}
