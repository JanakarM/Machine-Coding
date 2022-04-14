package design_1.service;

import java.util.HashMap;
import java.util.Map;

import design_1.constants.CommonConstants;
import design_1.constants.CustomerStatus;
import design_1.model.Customer;
import design_1.model.SalesMan;
import design_1.utils.CommonUtil;

public class SalesService extends CommonConstants {
    Map<Integer, SalesMan> salesManList=new HashMap<>();
    Map<Long, Map<Long, Long>> incentivesMap=new HashMap<>();
    void addSalesMan(String name, String email){
        int saleManId=userIds.incrementAndGet();
        SalesMan customer=new SalesMan(saleManId, name, email, true, CommonUtil.getDateEquivalent(System.currentTimeMillis()));
        salesManList.put(saleManId, customer);
    }
    void removeSalesMan(Integer salesManId){
        salesManList.remove(salesManId);
    }
    void updateAvailability(Integer id, boolean status){
        salesManList.get(id).setAvailable(status);
    }
    void addIncentive(Long saleManId, Long date, Long amount){
        Map<Long, Long> incentiveMapForGivenSaleMan=incentivesMap.get(saleManId);
        incentiveMapForGivenSaleMan.put(date, incentiveMapForGivenSaleMan.getOrDefault(date, 0L)+amount);
    }
    Long getIncentive(Long salesManId, Long date){
        return incentivesMap.get(salesManId).get(date);
    }
}
