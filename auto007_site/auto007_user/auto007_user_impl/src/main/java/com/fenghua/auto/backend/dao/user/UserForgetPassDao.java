package com.fenghua.auto.backend.dao.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.ResetPassRequest;
/**
 * 忘记密码
 * @author heting
 *
 */
@Repository
public interface UserForgetPassDao extends BaseDao<ResetPassRequest>{
	/**
	 * 增加忘记密码信息
	 * @param user
	 */
	public void insert(ResetPassRequest resetPassRequest);
	/**
	 * 根据code查询忘记密码信息
	 * @param map
	 * @return
	 */
	
	public List<ResetPassRequest> selectByCodeAndUser(Map<String,Object> map); 
	/**
	 * 根据用户删除找回密码信息
	 * @param UserId
	 */
	public void deleteByUserId(Map<String,Object> map);
}
