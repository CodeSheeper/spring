package cn.easybuy.service.order;
import java.util.List;

import cn.easybuy.entity.*;
import cn.easybuy.param.OrderDetailParam;
import cn.easybuy.param.OrderParams;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;
import cn.easybuy.utils.ShoppingCart;

public interface OrderService {

	Order payShoppingCart(ShoppingCart cart, User user,String adress);//购物

	List<Order> queryOrderList(Integer id,Pager pager);

	public int getOrderRowCount(OrderParams params);

	List<OrderDetail> queryOrderDetailList(OrderDetailParam params);

	Order findById(String parameter);//根据ID获取订单
	//查询全部订单
	List<Order> queryOrderList(Pager pager);
}
