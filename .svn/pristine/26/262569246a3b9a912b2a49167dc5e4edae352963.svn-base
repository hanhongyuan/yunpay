package com.yunpay.serv.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.yunpay.database.dao.BaseDao;
import com.yunpay.serv.model.PayTranLs;

@Repository("payTranLsDao")
public interface PayTranLsDao extends BaseDao<PayTranLs>{
	
	@Select("select * from t_pay_tran_ls where user_order_no=#{user_order_no} and merchantNo=#{merchantNo}")
	public PayTranLs findTranLsByOrderNo(@Param("user_order_no")String user_order_no,@Param("merchantNo")String merchantNo);
	
	@Update("update t_pay_tran_ls set status=#{status} where id=#{id}")
	public int updTranStatus(@Param("id")Integer id, @Param("status")Integer status);
	
	@Select("select * from t_pay_tran_ls where transNum=#{transNum}")
	public PayTranLs findTranLsByTransNum(String transNum);
	
	@Select("select * from t_pay_tran_ls t where  (t.status=1 or t.status=0) AND date_add(t.transTime, interval #{intervalTime} minute) > now() ")
	List<PayTranLs> selectAllSynPayLs(@Param("intervalTime")Integer intervalTime);
}
