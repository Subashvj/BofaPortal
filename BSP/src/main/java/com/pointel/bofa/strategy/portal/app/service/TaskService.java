package com.pointel.bofa.strategy.portal.app.service;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pointel.bofa.strategy.portal.app.dto.EditTaskDto;
import com.pointel.bofa.strategy.portal.app.dto.TaskBean;
import com.pointel.bofa.strategy.portal.app.dto.MasterData;
import com.pointel.bofa.strategy.portal.app.entity.StratTasks;

public interface TaskService {
	
	public BigInteger saveTask(StratTasks stratTask) throws Exception;
	public BigInteger editTask(EditTaskDto startTask) throws Exception;
	public MasterData getMasterData() throws JsonProcessingException;
	public List<TaskBean> getTask(int stratId) throws Exception;

}
