package io.mk.actuator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class StatusHistory {
	private String id;
	private String status;
	private String detail;
}

@Component
@Endpoint(id = "appStatus")
public class CustomEndpoint {

	private Map<String, StatusHistory> statusMap = new ConcurrentHashMap<>();

	/*
	 * GET http://localhost:8080/actuator/appStatus
	 */
	@ReadOperation
	public Map<String, StatusHistory> getAllStatus() {
		return statusMap;
	}

	/*
	 * GET http://localhost:8080/actuator/appStatus/20220101
	 */
	@ReadOperation
	public StatusHistory getStatus(@Selector String id) {
		return statusMap.get(id);
	}

	/*
	 * POST http://localhost:8080/actuator/appStatus
	 * 
	 * {"id":"20220101", "status":"up", "detail":"running"}
	 */
	@WriteOperation
	public void configureStatus(String id, String status, String detail) {
		System.out.println("Creating new status " + id);
		statusMap.put(id, new StatusHistory(id, status, detail));
	}

	/*
	 * DELETE http://localhost:8080/actuator/appStatus/20220101
	 */
	@DeleteOperation
	public void deleteStatus(@Selector String name) {
		statusMap.remove(name);
	}

}
