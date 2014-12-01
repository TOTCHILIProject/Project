package Tochtli.Tochtli.controller;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
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

	private Color trans = new Color(0xFF, 0xFF, 0xFF, 0);

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

		JFreeChart chart0 = ChartFactory.createBarChart(title0, "Year", "Value ($)", dataset[0],
				PlotOrientation.VERTICAL, true, true, true);
		CategoryPlot plot0 = (CategoryPlot) chart0.getPlot();
		plot0.setForegroundAlpha(0.5f);

		JFreeChart chart1 = ChartFactory.createBarChart(title1, "Year", "Number", dataset[1], PlotOrientation.VERTICAL,
				true, true, true);
		CategoryPlot plot1 = (CategoryPlot) chart1.getPlot();
		plot1.setForegroundAlpha(0.5f);

		CategoryAxis domainAxis = new CategoryAxis("");
		CombinedDomainCategoryPlot finalPlot = new CombinedDomainCategoryPlot(domainAxis);
		finalPlot.add(plot0);
		finalPlot.add(plot1);

		JFreeChart result = new JFreeChart(title, new Font("SansSerif", Font.BOLD, 12), finalPlot, true);

		result.setBackgroundPaint(trans);
		finalPlot.setBackgroundPaint(trans);

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
		TimeSeriesCollection[] dataset = orderService.getOrdersMonthSeries();
		String title = "Orders per month at " + (new Date());

		JFreeChart chart0 = ChartFactory.createTimeSeriesChart(title, "Month", "Value ($)", dataset[0], true, true,
				false);
		XYPlot plot0 = (XYPlot) chart0.getPlot();
		plot0.setForegroundAlpha(0.5f);
		XYItemRenderer r0 = plot0.getRenderer();
		if (r0 instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer0 = (XYLineAndShapeRenderer) r0;
			renderer0.setBaseShapesVisible(true);
			renderer0.setBaseShapesFilled(true);
			renderer0.setDrawSeriesLineAsPath(true);
		}

		JFreeChart chart1 = ChartFactory.createTimeSeriesChart(title, "Month", "Number", dataset[1], true, true, false);
		XYPlot plot1 = (XYPlot) chart1.getPlot();
		plot1.setForegroundAlpha(0.5f);
		XYItemRenderer r1 = plot1.getRenderer();
		if (r1 instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer1 = (XYLineAndShapeRenderer) r1;
			renderer1.setBaseShapesVisible(true);
			renderer1.setBaseShapesFilled(true);
			renderer1.setDrawSeriesLineAsPath(true);
		}

		CombinedDomainXYPlot finalPlot = new CombinedDomainXYPlot(new DateAxis("Domain"));
		finalPlot.add(plot0);
		finalPlot.add(plot1);
		finalPlot.setOrientation(PlotOrientation.VERTICAL);

		JFreeChart finalResult = new JFreeChart(title, new Font("SansSerif", Font.BOLD, 12), finalPlot, true);

		finalResult.setBackgroundPaint(trans);
		finalPlot.setBackgroundPaint(trans);
		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), finalResult, 750, 400);
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
