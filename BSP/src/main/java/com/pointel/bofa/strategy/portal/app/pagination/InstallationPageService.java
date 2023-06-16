package com.pointel.bofa.strategy.portal.app.pagination;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pointel.bofa.strategy.portal.app.dto.InstallationListInfo;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.error.RecordsNotFoundException;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.repository.InstallationListInfoRepo;

@Service
public class InstallationPageService {
	
	public static Logger logger = LogManager.getLogger(PageService.class);
	
	@Autowired
	private InstallationListInfoRepo installationListInfoRepo;
	
	@Autowired
	TraceLogger pointelTraceLogger;
	
	public int inc = 0;
	public int noOfFilters = 0;
	
	public List<InstallationListInfo> doInstallationSort(Pageable pageable, String fieldName, String order) {

		String searchQuery = fieldName + "_" + order;
		List<InstallationListInfo> installationListInfo = null;
		switch (searchQuery) {

		case "installId_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallIdDesc(pageable).getContent();
			break;
		case "installTitle_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallTitleDesc(pageable).getContent();
			break;
		case "installDate_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallDateDesc(pageable).getContent();
			break;
		case "installStatusId_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallStatusIdDesc(pageable).getContent();
			break;
		case "installType_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallTypeDesc(pageable).getContent();
			break;	
		case "displayname_desc":
			installationListInfo = installationListInfoRepo.getInstallationListDisplayNameDesc(pageable).getContent();
			break;
		case "installStatusDesc_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallStatusDesc(pageable).getContent();
			break;	
		case "installTypeDesc_desc":
			installationListInfo = installationListInfoRepo.getInstallationListInstallTypeDescDesc(pageable).getContent();
			break;
		case "totallinked_desc":
			installationListInfo = installationListInfoRepo.getInstallationListTotallinkedDesc(pageable).getContent();
			break;
		case "statusDesc_desc":
			installationListInfo = installationListInfoRepo.getInstallationListStatusDesc(pageable).getContent();
			break;
			
		default:
			installationListInfo = installationListInfoRepo.getInstallationListInfo(pageable).getContent();
		}

		return installationListInfo;
	}
	
	public PagingResponse getInstallationPage(PagingRequest pagingRequest) throws Exception{
		logger.info("[BSP]:getInstallationPage() - Service method call Started");
		
		List<InstallationListInfo> installationList = null;
		List<InstallationListInfo> filtered = null;
		PagingResponse pagingResponse = null;
		try {
			if(pagingRequest.getPage() == 0 || pagingRequest.getPerPage() == 0) {
				logger.error("[BSP]:getInstallationPage() - getPage() or get() Should not be 0 ");
				throw new FailedToFullfillRequest("page or PageField should not be 0","getPage()");
			}
			
			Pageable pageable = PageRequest.of(pagingRequest.getPage(), pagingRequest.getPerPage());

			if (pagingRequest.getSort() == null || pagingRequest.getSortField() == null) {
				logger.info("[BSP]:getSort() and getSortField() are null");
				installationList = installationListInfoRepo.getInstallationListInfo(pageable).getContent();
				if(installationList.isEmpty()) {
					logger.error("[BSP]:getInstallationPage() - Service method ,No Records Found");
					throw new RecordsNotFoundException("Records Not Found","getPage()");
				}
			} else {
				installationList = doInstallationSort(pageable, pagingRequest.getSortField(), pagingRequest.getSort());
				if(installationList.isEmpty()) {
					logger.error("[BSP]:getInstallationPage() - Service method ,No Records Found");
					throw new RecordsNotFoundException("Records Not Found","getPage()");
				}
			}
			filtered = installationList.stream()
					// .sorted(sortEmployees(pagingRequest))
					.filter(new Predicate<InstallationListInfo>() {
						public boolean test(InstallationListInfo installationListInfo) {
							return filterInstallationList(installationListInfo, pagingRequest);
						}
					})
					// .skip(pagingRequest.getPage())
					// .limit(pagingRequest.getPerPage())
					.collect(Collectors.toList());

			long count = installationList.stream().filter(new Predicate<InstallationListInfo>() {
				public boolean test(InstallationListInfo installationListInfo) {
					return filterInstallationList(installationListInfo, pagingRequest);
				}
			}).count();

			Payload<InstallationListInfo> page = new Payload<>(filtered);
			// page.setRecordsFiltered((int) count);
			page.setTotalCount((int) installationList.size());
			page.setOther(null);
			// page.setDraw(pagingRequest.getDraw());

			pagingResponse = new PagingResponse();
			pagingResponse.setPayload(page);
			pagingResponse.setMessage("success");
			
			pagingResponse.setSuccess(true);
		}catch(RecordsNotFoundException notFound) {
			throw new RecordsNotFoundException("No Records Found","getInstallationPage()");
		}catch(FailedToFullfillRequest notFound) {
			throw new FailedToFullfillRequest("Page or pageField should not be 0","getInstallationPage()");
		}catch (Exception e) {
			e.printStackTrace();
			pagingResponse = new PagingResponse();
			// pagingResponse.setPayload();
			pagingResponse.setMessage("Failed to Load Data");
			pagingResponse.setSuccess(false);

		}
		logger.info("[BSP]:getInstallationPage() - Service method call Ended");
		return pagingResponse;
	}
	
	private boolean filterInstallationList(InstallationListInfo installationListInfo, PagingRequest pagingRequest) {

		if (pagingRequest.getFilter() == null || pagingRequest.getFilter().isEmpty()) {
			logger.info("[BSP]:filterInstallationList(): getFilter() field  is  null");
			return true;
		}
			
		inc = 0;
		noOfFilters = pagingRequest.getFilter().size();
		logger.info("count of filters {}" , pagingRequest.getFilter().size());
		pagingRequest.getFilter().forEach(filtrs -> {
			boolean result = doFiltering(installationListInfo, filtrs);
			if (result == true) {
				inc++;
			}
		});
		if (noOfFilters == inc) {
			return true;
		}
		return false;
	}
	
	public boolean doFiltering(InstallationListInfo installationListInfo, Filters filter) {

		System.out.println(installationListInfo.toString());
		System.out.println(filter.toString());
		boolean filterResult = false;
		String fieldName = filter.getField();
		System.out.println("fieldName:"+fieldName);
		switch (fieldName) {
		case "installId":
			logger.info("[BSP]:numberFilterOperations() are called");
			filterResult = numberFilterOperations(installationListInfo.getInstallId(), filter);
			logger.info("[BSP]:numberFilterOperations() are called Ended");
			break;
		case "installTitle":
			logger.info("[BSP]:tagFilterOperations() are called");
			filterResult = tagFilterOperations(installationListInfo.getInstallTitle(), filter);
			logger.info("[BSP]:tagFilterOperations() are called Ended");
			break;
		case "installDate":
			logger.info("[BSP]:dateFilterOperations() are called");
			filterResult = dateFilterOperations(installationListInfo.getInstallDate(), filter);
			logger.info("[BSP]:dateFilterOperations() are called Ended");
			break;
		case "installStatusId":
			logger.info("[BSP]:numberFilterOperations() are called");
			filterResult = numberFilterOperations(installationListInfo.getInstallStatusId(), filter);
			logger.info("[BSP]:numberFilterOperations() are called Ended");
			break;
		case "installType":
			logger.info("[BSP]:numberFilterOperations() are called");
			filterResult = numberFilterOperations(installationListInfo.getInstallType(), filter);
			logger.info("[BSP]:numberFilterOperations() are called Ended");
			break;
		case "displayname":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(installationListInfo.getDisplayname(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "installStatusDesc":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(installationListInfo.getInstallStatusDesc(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "installTypeDesc":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(installationListInfo.getInstallTypeDesc(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "totallinked":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = numberFilterOperations(installationListInfo.getTotallinked(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "statusDesc":
			logger.info("[BSP]:numberFilterOperations() are called");
			filterResult = textFilterOperations(installationListInfo.getStatusDesc(), filter);
			logger.info("[BSP]:numberFilterOperations() are called Ended");
			break;

		default:
			logger.info("[BSP]:No filter FieldNames are matched ");
		}

		return filterResult;
	}
	
	public boolean numberFilterOperations(int stratNum, Filters filter) {

		if (filter.getOperator().equals("between")) {

			String stratId[] = filter.getValue().split("-");

			if (stratNum >= Integer.parseInt(stratId[0]) && stratNum <= Integer.parseInt(stratId[1])) {

				return true;
			}

		} else if (filter.getOperator().equals("eq")) {

			if (stratNum == Integer.parseInt(filter.getValue())) {
				return true;
			}

		} else if (filter.getOperator().equals("neq")) {

			if (stratNum != Integer.parseInt(filter.getValue())) {
				return true;
			}

		} else if (filter.getOperator().equals("greaterthanorequal")) {

			if (stratNum >= Integer.parseInt(filter.getValue())) {
				return true;
			}

		} else if (filter.getOperator().equals("greaterthan")) {

			if (stratNum > Integer.parseInt(filter.getValue())) {
				return true;
			}

		} else if (filter.getOperator().equals("lessthanorequal")) {

			if (stratNum <= Integer.parseInt(filter.getValue())) {

				return true;
			}

		} else if (filter.getOperator().equals("lessthan")) {

			if (stratNum < Integer.parseInt(filter.getValue())) {
				return true;
			}
		}

		return false;
	}

	public boolean textFilterOperations(String stratText, Filters filter) {

		if (filter.getOperator().equals("eq")) {

			if (stratText.equals(filter.getValue())) {
				return true;
			}
		} else if (filter.getOperator().equals("neq")) {
			if (!stratText.equals(filter.getValue())) {
				return true;
			}
		} else if (filter.getOperator().equals("contains")) {
			if (stratText.contains(filter.getValue())) {
				return true;
			}
		} else if (filter.getOperator().equals("startswith")) {
			if (stratText.startsWith(filter.getValue())) {
				return true;
			}
		} else if (filter.getOperator().equals("endswith")) {
			if (stratText.endsWith(filter.getValue())) {
				return true;
			}
		} else if (filter.getOperator().equals("blank")) {
			if (stratText.equals(" ")) {
				return true;
			}
		}
		return false;
	}

	public boolean tagFilterOperations(String valueFromDb, Filters filter) {

		List<String> taglist = null;
		if (filter.getOperator().equals("eq")) {

			if (filter.getValue().contains(",")) {
				String tags[] = filter.getValue().split(",");
				taglist = Arrays.asList(tags);
			} else {
				taglist = Arrays.asList(filter.getValue());
			}
			if (taglist.contains(valueFromDb)) {
				return true;
			}
		}
		return false;
	}

	public boolean dateFilterOperations(String stratDate, Filters filter) {

		try {
			
			String stratDateText = stratDate;
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date stratDateNew = sdf.parse(stratDateText);
			//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			// SimpleDateFormat sdfFromDb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			SimpleDateFormat destSdf = new SimpleDateFormat("yyyy-MM-dd");
			if (filter.getOperator().equals("between")) {
				String betweenDates[] = filter.getValue().split("-");
				String oeStartDateStr = betweenDates[0];
				String oeEndDateStr = betweenDates[1];
				System.out.println("betweenDates[0]:"+betweenDates[0]);
				System.out.println("betweenDates[1]:"+betweenDates[1]);

				Date startDate = sdf.parse(oeStartDateStr);
				String startDateTemp = destSdf.format(startDate);
				startDate = destSdf.parse(startDateTemp);
				Date endDate = sdf.parse(oeEndDateStr);
				String endDateTmp = destSdf.format(endDate);
				endDate = destSdf.parse(endDateTmp);

				Date d = stratDateNew;
				String currDt = destSdf.format(d);
				
				System.out.println("d.after(startDate):"+d.after(startDate));
				System.out.println("(d.before(endDate):"+(d.before(endDate)));
				System.out.println("Date Value:"+d);
				
				if ((d.after(startDate) && (d.before(endDate)))
						|| (currDt.equals(sdf.format(startDate)) || currDt.equals(sdf.format(endDate)))) {
					System.out.println("Date is between 1st april to 14th nov...");
					return true;
				} else {
					System.out.println("Date is not between 1st april to 14th nov...");
				}
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
