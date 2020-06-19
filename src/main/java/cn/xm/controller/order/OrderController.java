package cn.xm.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xm.bean.order.Order;
import cn.xm.controller.AbstractUUIDController;
import cn.xm.service.BaseService;
import cn.xm.service.order.OrderService;

@Controller
@RequestMapping("order")
public class OrderController extends AbstractUUIDController<Order> {

	@Autowired
	private OrderService orderService;
	
	@Override
	public String getViewBasePath() {
		return "order";
	}

	@Override
	public BaseService<Order, String> getBaseService() {
		return orderService;
	}

}
