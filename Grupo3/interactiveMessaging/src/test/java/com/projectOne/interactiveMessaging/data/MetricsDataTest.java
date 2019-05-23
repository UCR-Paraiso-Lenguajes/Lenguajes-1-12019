package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import static org.junit.Assert.assertTrue;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.Metrics;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsDataTest {
	
	@Autowired
	private MetricsData metricsData;
	
	@Test
	public void saveMetrics() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			java.util.Date date = dateformat.parse("2019/04/10");
			java.util.Date date2 =  dateformat.parse("2019/03/10");
			assertTrue(metricsData.saveMetrics(4, 20, 30, 10, date, date2, 12, 100, 22, 9, 100, 400));
			//metricsData.saveMetrics(3, 20, 30, 10, date, date2, 12, 100, 22, 9, 100, 400);
		} catch (ParseException e) {
			throw new RuntimeException("Error al declarar fecha");
		}
		
	}
	
	@Autowired
	MetricsData metricsDao;
	
	@Test
	public void findMetricsTest() {
		Iterator<Metrics> metrics = metricsDao.findMetrics(1);
		assertNotNull(metrics);
	}


}
