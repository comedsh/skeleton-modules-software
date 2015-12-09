/**
 * 
 */
package com.fenghua.auto.user.backend.iservice;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.domain.PlainInvoiceTitle;
import com.fenghua.auto.user.backend.service.PlainInvoiceTitleService;
import com.fenghua.auto.user.intf.dto.PlainInvoiceTitleDTO;
import com.fenghua.auto.user.intf.service.IPlainInvoiceTitleService;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
@Service
public class IPlainInvoiceTitleServiceImpl implements IPlainInvoiceTitleService {

	@Autowired
	private PlainInvoiceTitleService plainInvoiceTitleService;
	
	/* (non-Javadoc)
	 * @see com.fenghua.auto.user.intf.service.IPlainInvoiceTitleService#loadByUserIdAndTitleId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public PlainInvoiceTitleDTO loadByUserIdAndTitleId(Long userId, Long TitleId) {
		PlainInvoiceTitle query = new PlainInvoiceTitle();
		query.setUserId(userId);
		query.setId(TitleId);
		return BeanMapper.map(plainInvoiceTitleService.selectOne(query), PlainInvoiceTitleDTO.class);
	}

	/* (non-Javadoc)
	 * @see com.fenghua.auto.user.intf.service.IPlainInvoiceTitleService#loadByUserId(java.lang.Long)
	 */
	@Override
	public List<PlainInvoiceTitleDTO> loadByUserId(Long userId) {
		PlainInvoiceTitle query = new PlainInvoiceTitle();
		query.setUserId(userId);
		return BeanMapper.mapList(plainInvoiceTitleService.selectList(query), PlainInvoiceTitleDTO.class);
	}

	@Transactional
	@Override
	public PlainInvoiceTitleDTO saveInvoiceTitle(PlainInvoiceTitleDTO invoiceTitleDTO) {
		PlainInvoiceTitle title = BeanMapper.map(invoiceTitleDTO, PlainInvoiceTitle.class);
		if(title.getUserId() == null || title.getUserId() <= 0
				|| StringUtils.isBlank(title.getTitle())) {
			return null;
		}
		if(title.getId() == null || title.getId() <= 0) {
			title.setId(null);
			title.setCreatedTs(new Date());
			if(title.getCreatedBy() == null) {
				title.setCreatedBy("-1");
			}
			plainInvoiceTitleService.insert(title);
		} else {
			title.setModifiedTs(new Date());
			if(title.getModifiedBy() == null) {
				title.setModifiedBy("-1");
			}
			plainInvoiceTitleService.updateById(title);
		}
		
		if(title.getId() != null && title.getId() > 0) {
			return BeanMapper.map(title, PlainInvoiceTitleDTO.class);
		}
		return null;
	}

	@Transactional
	@Override
	public int deleteInvoiceTitle(Long userId, Long titleId) {
		PlainInvoiceTitle query = new PlainInvoiceTitle();
		query.setUserId(userId);
		query.setId(titleId);
		List<PlainInvoiceTitle> titles = plainInvoiceTitleService.selectList(query);
		if(titles != null && titles.size() == 1) {
			PlainInvoiceTitle plainInvoiceTitle = titles.get(0);
			return plainInvoiceTitleService.deleteById(plainInvoiceTitle.getId());
		}
		return 0;
	}

}
