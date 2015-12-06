package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.Company;;
/**
 * 企业dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface CompanyDao extends BaseDao<Company> {
	/**
	 * 通过固定电话查询是否有对应的company
	 * @param fixed
	 * @return
	 */
	public List<Company> getById(Long id);
	/**
	 * 通过固定电话查询是否有对应的company
	 * @param fixed
	 * @return
	 */
	public List<Company> selectByFixed(String fixed);
	/**
	 * 通过手机查询是否有对应的company
	 * @param telephone
	 * @return
	 */
	public List<Company> selectByTelephone(String telephone);
	/**
	 * 通过企业邮箱查询是否有对应的company
	 * @param email
	 * @return
	 */
	public List<Company> selectByEmail(String email);
	/**
	 * 通过插入语句返回主键id
	 * @param company
	 * @return
	 */
	public Long getCompanyId(Company company);
}
