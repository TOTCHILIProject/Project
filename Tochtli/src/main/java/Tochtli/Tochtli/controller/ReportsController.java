package Tochtli.Tochtli.controller;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Tochtli.Tochtli.model.services.OrderService;
import Tochtli.Tochtli.model.services.ProductCategoryService;

@Controller
@RequestMapping("/admin/reports")
@Scope("session")
public class ReportsController {

	@Autowired
	private ProductCategoryService productService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView googlechart(HttpServletResponse response) {
		return new ModelAndView("admin/reportsAdmin");
	}

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public void stock(HttpServletResponse response) {

		response.setContentType("image/png");
		DefaultPieDataset dpd = productService.getStockPieDataSet();
		String title = "Stock at " + (new Date());

		JFreeChart chart = ChartFactory.createPieChart(title, dpd, true, true, false);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundAlpha(0.0f);

		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		chart.setBackgroundPaint(trans);
		plot.setBackgroundPaint(trans);

		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 750, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/year", method = RequestMethod.GET)
	public void year(HttpServletResponse response) {

		response.setContentType("image/png");
		DefaultCategoryDataset[] dataset = orderService.getOrdersBarDataSet();
		String title0 = "Value of Orders per year at " + (new Date());
		String title1 = "Number of Orders per year at " + (new Date());
		String title = "Orders per year at " + (new Date());

		JFreeChart chart0 = ChartFactory.createBarChart(title0, "Year", "Quantity", dataset[0],
				PlotOrientation.VERTICAL, true, true, true);
		CategoryPlot plot0 = (CategoryPlot) chart0.getPlot();
		plot0.setForegroundAlpha(0.5f);
		plot0.setBackgroundAlpha(0.0f);

		JFreeChart chart1 = ChartFactory.createBarChart(title1, "Year", "Quantity", dataset[1],
				PlotOrientation.VERTICAL, true, true, true);
		CategoryPlot plot1 = (CategoryPlot) chart1.getPlot();
		plot1.setForegroundAlpha(0.5f);
		plot1.setBackgroundAlpha(0.0f);

		CategoryAxis domainAxis = new CategoryAxis("");
		CombinedDomainCategoryPlot finalPlot = new CombinedDomainCategoryPlot(domainAxis);
		finalPlot.add(plot0, 2);
		finalPlot.add(plot1, 1);

		JFreeChart result = new JFreeChart(title, new Font("SansSerif", Font.BOLD, 12), finalPlot, true);

		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), result, 750, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/month", method = RequestMethod.GET)
	public void month(HttpServletResponse response) {

		response.setContentType("image/png");
		TimeSeriesCollection dataset = orderService.getOrdersMonthSeries();
		String title = "Orders per month at " + (new Date());

		JFreeChart chart = ChartFactory.createTimeSeriesChart(title, "Test1", "Test2", dataset, true, true, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundAlpha(0.0f);

		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 750, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Google charts
	 * 
	 * Slice s1 = Slice.newSlice(15, Color.ALICEBLUE); Slice s2 =
	 * Slice.newSlice(85, Color.BLUEVIOLET);
	 * 
	 * PieChart pie = GCharts.newPieChart(s1,s2); pie.setTitle("TITLE");
	 * pie.setSize(720,360); pie.setThreeD(true);
	 * 
	 * modelView.addObject("pieUrl2", pie.toURLString());
	 */
}
