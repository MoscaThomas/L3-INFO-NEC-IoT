package business;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dao.FluctuationDao;
import entities.Fluctuation;

@Singleton
public class FluctuationBusiness {

	@Inject
	private FluctuationDao fluctuationDao;

	public List<Fluctuation> getAllFluctuations() {
		return fluctuationDao.getAll();
	}

	public Fluctuation get(long id) {
		return fluctuationDao.get(id);
	}

	public void add(Fluctuation Fluctuation) {
		fluctuationDao.create(Fluctuation);
	}

	public void delete(long id) {
		fluctuationDao.delete(get(id));
	}

	public void update(Fluctuation Fluctuation) {
		fluctuationDao.update(Fluctuation);
	}

	public Fluctuation search(String name) {
		return fluctuationDao.getByName(name);
	}

}
