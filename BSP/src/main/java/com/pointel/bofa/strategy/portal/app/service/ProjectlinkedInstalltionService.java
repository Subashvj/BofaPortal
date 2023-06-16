package com.pointel.bofa.strategy.portal.app.service;

import java.util.List;

import com.pointel.bofa.strategy.portal.app.dto.LinkedInstalltionEditInfo;

public interface ProjectlinkedInstalltionService {

	List<LinkedInstalltionEditInfo>getLinkedInstallEdit(int stratId)throws Exception;
}
