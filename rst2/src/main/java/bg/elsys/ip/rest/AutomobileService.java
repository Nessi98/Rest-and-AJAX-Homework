package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutomobileService {
		private static AutomobileService instance;

		public static AutomobileService getInstance() {
			if (instance == null) {
				instance = new AutomobileService();
			}
			return instance;
		}

		private List<Automobile> automobileList = new ArrayList<>();

		public AutomobileService() {
			for(int i = 0; i < 10; i ++){
				automobileList.add(new Automobile("Honda " + i, "Accord Tourer", "pink", "bla"));
				automobileList.add(new Automobile("Mercedes " + i, "...", "blue", "..."));
				automobileList.add(new Automobile("Nissan " + i, "Primera", "purple", "asdad"));
				automobileList.add(new Automobile("Mercedes " + i, "...", "black", "..."));
			}
			

		}

		public List<Automobile> getAutomobiles() {
			return Collections.unmodifiableList(automobileList);
		}

		public void addAutomobile(Automobile automobile) {
			automobileList.add(automobile);
		}
	}