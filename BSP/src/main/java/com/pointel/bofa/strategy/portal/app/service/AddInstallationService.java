package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.InstallEnvironmentInfo;
import com.pointel.bofa.strategy.portal.app.entity.InstallTypesInfo;

public interface AddInstallationService {
	 List<InstallEnvironmentInfo> getInstalltionEnvironmetInfo();
	 List<InstallTypesInfo> getInstallTypeInfo();

}
