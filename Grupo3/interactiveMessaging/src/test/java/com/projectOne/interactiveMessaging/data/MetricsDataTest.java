package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

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
	MetricsData metricsDao;
	
	@Test
	public void findMetricsTest() {
		Iterator<Metrics> metrics = metricsDao.findMetrics(1);
		assertNotNull(metrics);
	}
}
