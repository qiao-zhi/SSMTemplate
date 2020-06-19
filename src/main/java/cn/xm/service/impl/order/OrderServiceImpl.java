package cn.xm.service.impl.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xm.bean.order.Order;
import cn.xm.mapper.BaseMapper;
import cn.xm.mapper.order.OrderMapper;
import cn.xm.service.impl.AbastractBaseUUIDServiceImpl;
import cn.xm.service.order.OrderService;
@Service
public class OrderServiceImpl extends AbastractBaseUUIDServiceImpl<Order> implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public BaseMapper<Order, String> getBaseMapper() {
		return orderMapper;
	}

}
