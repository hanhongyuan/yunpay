package com.yunpay.serv.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yunpay.serv.model.CardInfo;

@Repository("cardInfoDao")
public interface CardInfoDao {
	
	@Select("select * from t_card_info where weixin_card_id=#{cardId}")
	public CardInfo findCardByCardId(String cardId);
}
