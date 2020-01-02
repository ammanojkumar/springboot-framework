package io.mk.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import io.mk.model.Physician;

@Service
public class PhysicianService {

	private Map<Integer, Physician> physicianMap;
	private Random random;

	public PhysicianService() {
		random = new Random();
		physicianMap = new HashMap<>();
		for (int id = 1; id < 5; id++) {
			createPhysician(id);
		}
	}

	private void createPhysician(int id) {
		Physician physician = new Physician();
		physician.setId(id);
		physician.setName("Name" + id);
		physician.setExperiance(random.nextInt(15));
		int aa = random.nextInt(2);
		System.out.println(aa);
		physician.setSpecialty("Radiologist");
		physicianMap.put(id, physician);
	}

	public Physician getPhysician(int id) {
		return physicianMap.get(id);
	}

	public boolean addPhysician(Physician physician) {
		if (!physicianMap.containsKey(physician.getId())) {
			createPhysician(physician.getId());
			return true;
		}
		return false;
	}

	public boolean removePhysician(int id) {
		boolean remove = false;
		if (physicianMap.containsKey(id)) {
			physicianMap.remove(id);
			remove = true;
		}
		return remove;
	}

	public Physician updatePhysician(Physician physician) {
		removePhysician(physician.getId());
		return getPhysician(physician.getId());
	}

	public Collection<Physician> listPhysicians() {
		return physicianMap.values();
	}
}
