package com.projectOne.interactiveMessaging.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.domain.Metrics;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsBussinessTest {
	@Autowired
	private MetricsData metricsData;
	@Autowired
	private MetricsBusiness metricsBusiness;
	Metrics metrics = Metrics.getInstance();
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
//		metrics = metricsData.findMetrics(1);
	}
	
	@Test
	public void loadMetrics_Test() {
		metricsBusiness.loadDataMetrics();
		assertEquals("22", metrics.getLongestMessage());
		assertEquals(30, metrics.getNumberOfUsers());
		assertEquals("12", metrics.getBigUser());
	}
	


}
