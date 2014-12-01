package Tochtli.Tochtli.model.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderFilter {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	public OrderFilter() {
		// init endDate = today
		endDate = new Date();
		// startDate = 1 week before today
		startDate = new Date(endDate.getTime() - 7 * 24 * 3600 * 1000);
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
