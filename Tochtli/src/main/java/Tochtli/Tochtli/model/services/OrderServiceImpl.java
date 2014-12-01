package Tochtli.Tochtli.model.services;

import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tochtli.Tochtli.model.dao.OrderDAO;
import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.pojo.OrderFilter;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	public OrderServiceImpl(OrderDAO od) {
		this.orderDAO = od;
	}

	public OrderServiceImpl() {

	}

	@Override
	public void placeOrder(Order order) {
		orderDAO.persistOrder(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	public List<Order> getAllOrdersByFilter(OrderFilter filter) {
		return orderDAO.getAllOrdersByFilter(filter);
	}

	@Override
	public DefaultCategoryDataset getOrdersBarDataSet() {
		DefaultCategoryDataset dpd = new DefaultCategoryDataset();

		List<Object[]> li = orderDAO.getInfosByYear();
		/* o[0] = total o[1]=count o[2]=year */
		for (Object[] o : li) {
			dpd.setValue(Double.parseDouble((o[0]).toString()), "total", (o[2]).toString());
			dpd.setValue(Double.parseDouble((o[1]).toString()), "nomber", (o[2]).toString());
		}

		return dpd;
	}

	@Override
	public TimeSeriesCollection getOrdersMonthSeries() {
		TimeSeries number = new TimeSeries("number", Day.class);
		TimeSeries total = new TimeSeries("total", Day.class);

		List<Object[]> li = orderDAO.getInfosByMonth();
		/* o[0] = total o[1]=count o[2]=month o[3]=year */
		for (Object[] o : li) {
			number.add(new Day(1, Integer.parseInt((o[2]).toString()), Integer.parseInt((o[3]).toString())),
					Integer.parseInt((o[1]).toString()));
			total.add(new Day(1, Integer.parseInt((o[2]).toString()), Integer.parseInt((o[3]).toString())),
					Double.parseDouble((o[0]).toString()));
		}

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(number);
		dataset.addSeries(total);

		return dataset;

	}
}
