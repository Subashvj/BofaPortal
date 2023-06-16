package com.pointel.bofa.strategy.portal.app.pagination;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.pointel.bofa.strategy.portal.app.dto.ProjectListInfo;
import com.pointel.bofa.strategy.portal.app.error.FailedToFullfillRequest;
import com.pointel.bofa.strategy.portal.app.error.RecordsNotFoundException;
import com.pointel.bofa.strategy.portal.app.logger.TraceLogger;
import com.pointel.bofa.strategy.portal.app.repository.ProjectListInfoRepo;


@Service
public class PageService {

	public static Logger logger = LogManager.getLogger(PageService.class);
	
	@Autowired
	private ProjectListInfoRepo projectListInfoRepo;
	
	@Autowired
	TraceLogger traceLogger;

	public int inc = 0;
	public int noOfFilters = 0;

	public List<ProjectListInfo> doSort(Pageable pageable, String fieldName, String order) {

		String searchQuery = fieldName + "_" + order;
		List<ProjectListInfo> projectListInfo = null;
		switch (searchQuery) {

		case "stratId_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailStratIdDesc(pageable).getContent();
			break;
		case "stratName_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailStratNameDesc(pageable).getContent();
			break;
		case "stratStatusDesc_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailStratStatusDesDesc(pageable).getContent();
			break;
		case "stratCatDesc_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailStratCatDesDesc(pageable).getContent();
			break;
		case "displayname_DESC":
			projectListInfo = projectListInfoRepo.fetchProjDetailDisplayNameDesc(pageable).getContent();
			break;
		case "fullDeploy_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailInstDateDesc(pageable).getContent();
			break;
		case "targetDate_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailTargetDateDesc(pageable).getContent();
			break;	
		case "componentName_DESC":
			projectListInfo = projectListInfoRepo.fetchProjDetailComponentNameDesc(pageable).getContent();
			break;
		case "stratPhaseDesc_DESC":
			projectListInfo = projectListInfoRepo.fetchProjDetailStratPhaseDesDesc(pageable).getContent();
			break;
		case "lobDesc_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailLobDesDesc(pageable).getContent();
			break;
		case "platformTypeDescription_desc":
			projectListInfo = projectListInfoRepo.fetchProjDetailPlatformTypeDesc(pageable).getContent();
			break;	
			
		default:
			projectListInfo = projectListInfoRepo.fetchProjectDetails(pageable).getContent();
		}

		return projectListInfo;
	}

	public PagingResponse getPage(PagingRequest pagingRequest) throws Exception{
		logger.info("[BSP]:getPage() - Service method call Started");
		
		List<ProjectListInfo> projectList = null;
		List<ProjectListInfo> filtered = null;
		PagingResponse pagingResponse = null;
		try {
			if(pagingRequest.getPage() == 0 || pagingRequest.getPerPage() == 0) {
				logger.error("[BSP]:getPage() - getPage() or get() Should not be 0 ");
				throw new FailedToFullfillRequest("page or PageField should not be 0","getPage()");
			}
			
			Pageable pageable = PageRequest.of(pagingRequest.getPage(), pagingRequest.getPerPage());

			if (pagingRequest.getSort() == null || pagingRequest.getSortField() == null) {
				logger.info("[BSP]:getSort() and getSortField() are null");
				projectList = projectListInfoRepo.fetchProjectDetails(pageable).getContent();
				if(projectList.isEmpty()) {
					logger.error("[BSP]:getPage() - Service method ,No Records Found");
					throw new RecordsNotFoundException("Records Not Found","getPage()");
				}
			} else {
				projectList = doSort(pageable, pagingRequest.getSortField(), pagingRequest.getSort());
				if(projectList.isEmpty()) {
					logger.error("[BSP]:getPage() - Service method ,No Records Found");
					throw new RecordsNotFoundException("Records Not Found","getPage()");
				}
			}
			filtered = projectList.stream()
					// .sorted(sortEmployees(pagingRequest))
					.filter(new Predicate<ProjectListInfo>() {
						public boolean test(ProjectListInfo projectListInfo) {
							return filterProjectList(projectListInfo, pagingRequest);
						}
					})
					// .skip(pagingRequest.getPage())
					// .limit(pagingRequest.getPerPage())
					.collect(Collectors.toList());

			long count = projectList.stream().filter(new Predicate<ProjectListInfo>() {
				public boolean test(ProjectListInfo projectListInfo) {
					return filterProjectList(projectListInfo, pagingRequest);
				}
			}).count();

			Payload<ProjectListInfo> page = new Payload<>(filtered);
			// page.setRecordsFiltered((int) count);
			page.setTotalCount((int) projectList.size());
			page.setOther(null);
			// page.setDraw(pagingRequest.getDraw());

			pagingResponse = new PagingResponse();
			pagingResponse.setPayload(page);
			pagingResponse.setMessage("success");
			
			pagingResponse.setSuccess(true);
		}catch(RecordsNotFoundException notFound) {
			throw new RecordsNotFoundException("No Records Found","getPage()");
		}catch(FailedToFullfillRequest notFound) {
			throw new FailedToFullfillRequest("Page or pageField should not be 0","getPage()");
		}catch (Exception e) {
			e.printStackTrace();
			pagingResponse = new PagingResponse();
			// pagingResponse.setPayload();
			pagingResponse.setMessage("Failed to Load Data");
			pagingResponse.setSuccess(false);

		}
		logger.info("[BSP]:getPage() - Service method call Ended");
		return pagingResponse;
	}
	
	private boolean filterProjectList(ProjectListInfo projectListInfo, PagingRequest pagingRequest) {

		if (pagingRequest.getFilter() == null || pagingRequest.getFilter().isEmpty()) {
			logger.info("[BSP]:getFilter() and getFilter() are null");
			return true;
		}
			
		inc = 0;
		noOfFilters = pagingRequest.getFilter().size();
		logger.info("count of filters {}" , pagingRequest.getFilter().size());
		pagingRequest.getFilter().forEach(filtrs -> {
			boolean result = doFiltering(projectListInfo, filtrs);
			if (result == true) {
				inc++;
			}
		});
		if (noOfFilters == inc) {
			return true;
		}
		return false;
	}

	public boolean doFiltering(ProjectListInfo projectListInfo, Filters filter) {

		System.out.println(projectListInfo.toString());
		System.out.println(filter.toString());
		boolean filterResult = false;
		String fieldName = filter.getField();
		System.out.println("fieldName:"+fieldName);
		switch (fieldName) {
		case "stratId":
			logger.info("[BSP]:numberFilterOperations() are called");
			filterResult = numberFilterOperations(projectListInfo.getStratId(), filter);
			logger.info("[BSP]:numberFilterOperations() are called Ended");
			break;
		case "stratName":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(projectListInfo.getStratName(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "stratCatDesc":
			logger.info("[BSP]:tagFilterOperations() are called");
			filterResult = tagFilterOperations(projectListInfo.getStratCatDesc(), filter);
			logger.info("[BSP]:tagFilterOperations() are called Ended");
			break;
		case "stratStatusDesc":
			logger.info("[BSP]:tagFilterOperations() are called");
			filterResult = tagFilterOperations(projectListInfo.getStratStatusDesc(), filter);
			logger.info("[BSP]:tagFilterOperations() are called Ended");
			break;
		case "applicationName":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(projectListInfo.getApplicationName(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "targetDate":
			logger.info("[BSP]:dateFilterOperations() are called");
			filterResult = dateFilterOperations(projectListInfo.getTargetDate(), filter);
			logger.info("[BSP]:dateFilterOperations() are called Ended");
			break;
		case "fullDeploy":
			logger.info("[BSP]:dateFilterOperations() are called");
			filterResult = dateFilterOperations(projectListInfo.getFullDeploy(), filter);
			logger.info("[BSP]:dateFilterOperations() are called Ended");
			break;
		case "lobDesc":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(projectListInfo.getLobDesc(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "componentName":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(projectListInfo.getComponentName(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "stratPhaseDesc":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(projectListInfo.getStratPhaseDesc(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
			break;
		case "platformTypeDescription":
			logger.info("[BSP]:textFilterOperations() are called");
			filterResult = textFilterOperations(projectListInfo.getPlatformTypeDescription(), filter);
			logger.info("[BSP]:textFilterOperations() are called Ended");
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

	/*
	 * public boolean stratStatusDescFilterOperations(ProjectListInfo
	 * projectListInfo, Filters filter) {
	 * 
	 * List<String> taglist = null; if (filter.getOperator().equals("eq")) {
	 * 
	 * if (filter.getValue().contains(",")) { String tags[] =
	 * filter.getValue().split(","); taglist = Arrays.asList(tags); } else { taglist
	 * = Arrays.asList(filter.getValue()); } if
	 * (taglist.contains(projectListInfo.getStratStatusDesc())) { return true; } }
	 * return false; }
	 * 
	 * public boolean lobDescFilterOperations(ProjectListInfo projectListInfo,
	 * Filters filter) { List<String> taglist = null; if
	 * (filter.getOperator().equals("eq")) { if (filter.getValue().contains(",")) {
	 * String tags[] = filter.getValue().split(","); taglist = Arrays.asList(tags);
	 * } else { taglist = Arrays.asList(filter.getValue()); } if
	 * (taglist.contains(projectListInfo.getLobDesc())) { return true; } } return
	 * false; }
	 */
	public boolean dateFilterOperations(String stratDate, Filters filter) {

		try {
			String stratDateText = stratDate;
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date stratDateNew = sdf.parse(stratDateText);
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
