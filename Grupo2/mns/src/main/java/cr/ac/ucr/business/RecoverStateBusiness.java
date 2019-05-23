package cr.ac.ucr.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.data.MessageData;
import cr.ac.ucr.data.MetricsData;
import cr.ac.ucr.domain.Message;
import cr.ac.ucr.domain.Metrics;

@Service
public class RecoverStateBusiness {
	@Autowired
	private MetricsData metricData;
	@Autowired
	private MessageData messageData;
	
	public List<Message> retrieveState(int amount) {
		metricData.setState(Metrics.getInstance());
		return messageData.ListMessages(amount);
	}

	
}
