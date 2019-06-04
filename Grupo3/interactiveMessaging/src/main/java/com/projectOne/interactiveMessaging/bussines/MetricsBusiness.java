package com.projectOne.interactiveMessaging.bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.GroupData;
import com.projectOne.interactiveMessaging.data.MessageData;
import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.data.UserData;
import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.Metrics;
import com.projectOne.interactiveMessaging.domain.Room;
import com.projectOne.interactiveMessaging.domain.User;

@Service
public class MetricsBusiness {
	
	@Autowired
	private MetricsData metricsData;
	Metrics metrics = Metrics.getInstance();
	
	public Metrics findMetrics(int idMetrics) {
		return metricsData.findMetrics(idMetrics);
	}
	
	public Metrics recoverMetricsData() {
		// TODO Auto-generated method stub
		return metrics;
	}
	
	public void loadDataMetrics() {
		metrics = metricsData.recoverMetricsData();
	}
	
	public void save () {
		metricsData.saveMetrics(metrics.getId_Metrics(), metrics.getNumberOfRooms(), metrics.getNumberOfUsers(), metrics.getAverageOfUsersPerRoom()
				,metrics.getDateLastMessage(),metrics.getDateFirstLogin(), metrics.getBigUser(), metrics.getNumberMessagesBigUser()
				,metrics.getLongestMessage(), metrics.getLastRoomCreated(), metrics.getBiggestRoom(), metrics.getNumberMessagesBiggestRoom()
				,metrics.getSumOfUsersPerGroup(), metrics.getQuantityMessageBigUser());
	}
	
	
}