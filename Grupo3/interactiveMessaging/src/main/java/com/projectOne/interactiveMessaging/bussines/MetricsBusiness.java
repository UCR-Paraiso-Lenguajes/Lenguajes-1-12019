package com.projectOne.interactiveMessaging.bussines;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.domain.Metrics;
@Service
public class MetricsBusiness {
	@Autowired
	MetricsData metricsDao;
	
	public Iterator<Metrics> findMetrics(int idMetrics) {
		return metricsDao.findMetrics(idMetrics);
	}

}
