package services.impl;

import java.util.Arrays;

import entities.Order;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private Order[] orders;
	private int lastIndex;
	
	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order == null)
			return; 
		if (orders.length <= lastIndex){
			Arrays.copyOf(orders, orders.length<<1);
		}
		orders[lastIndex++] = order;
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		int ordersByUserCount = 0;
		for (Order o : orders)
			if (o!=null && o.getCustomerId() == userId)
				ordersByUserCount++;
		int index =0;
		Order[] ordersByUser = new Order[ordersByUserCount];
		for (Order o : orders)
			if (o!=null && o.getCustomerId() == userId)
				ordersByUser[index++] = o;
		return ordersByUser;
	}

	@Override
	public Order[] getOrders() {
		int notNullOrdersCount = 0;
		for (Order o : orders)
			if (o!=null )
				notNullOrdersCount++;
		int index =0;
		Order[] notNullOrders = new Order[notNullOrdersCount];
		for (Order o : orders)
			if (o!=null)
				notNullOrders[index++] = o;
		return notNullOrders;
	}

	void clearServiceState() {
		lastIndex = 0;
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

}
