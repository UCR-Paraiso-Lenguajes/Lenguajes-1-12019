package com.projectOne.interactiveMessaging.bussines;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.domain.Metrics;

@Service
public class MetricsBusiness {
	
	@Autowired
	private MetricsData metricsData;
	
	public Iterator<Metrics> recoverMetricsData(){
		return metricsData.recoverMetricsData();
	}
}
