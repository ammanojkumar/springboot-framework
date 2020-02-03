package io.mk.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.mk.cache.model.TVProgram;
import io.mk.cache.model.TVPrograms;

@Service
public class TVService {

	@Cacheable(cacheNames = "tvCache", key = "#channelId")
	public TVPrograms getTVPrograms(int channelId) {
		System.out.println("Retriving non cache data: " + channelId);
		TVPrograms programs = new TVPrograms();
		programs.setChannelId(channelId);
		programs.setChannelName("channel" + channelId);

		int pgmId = 1;
		for (int hour = 0; hour < 24; hour++) {
			programs.getTvProgramList().add(new TVProgram(pgmId++, "program" + pgmId, hour + ":00", 30));
			programs.getTvProgramList().add(new TVProgram(pgmId++, "program" + pgmId, hour + ":30", 30));
		}
		return programs;
	}
}
