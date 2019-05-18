package cr.ac.ucr.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.data.MetricsData;
import cr.ac.ucr.domain.Metrics;

@Service
public class RecoverStateBusiness {
	@Autowired
	private MetricsData metricData;
	
	public void retrieveState() {
		metricData.setState(Metrics.getInstance());
		
	}

	
}
