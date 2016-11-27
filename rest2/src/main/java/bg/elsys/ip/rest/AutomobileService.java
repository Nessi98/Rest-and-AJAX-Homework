package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		
		public void addAutomobile(Automobile automobile) {
			automobileList.add(automobile);
		}
		
		public PagedResponse getAutomobilesInPagesFiltered(int page, int perPage, String withBrand) {
			long previousEntries = page * perPage;
			List<Automobile> pageOfAutomobiles = automobileList.stream().filter((u) -> u.getBrand().equals(withBrand) || withBrand == null)
					.skip(previousEntries).limit(perPage).collect(Collectors.toList());

			int totalPages = (int) Math.ceil(((double) automobileList.size()) / perPage);
			PagedResponse response = new PagedResponse(pageOfAutomobiles, page, totalPages);

			return response;
		}

		public List<Automobile> getAutomobiles() {
			return Collections.unmodifiableList(automobileList);
		}
		
		public List<String> getAllDistinctAutomobileBrands() {
			return automobileList.stream()
					.map((u) -> u.getBrand())
					.distinct()
					.collect(Collectors.toList());
		}
	}