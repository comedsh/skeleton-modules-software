package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.Role;;
/**
 * 角色dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface RoleDao extends BaseDao<Role> {
	/**
	 * 通过角色id查询对应的实体
	 * @param id
	 * @return
	 */
	public List<Role> getRoleById(Long id);
	/**
	 * 插入角色数据时返回主键Id
	 * @param role
	 * @return
	 */
	public Long getIdInsert(Role role);
	
}
