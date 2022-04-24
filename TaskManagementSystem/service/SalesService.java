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
    Integer addSalesMan(String name, String email){
        int saleManId=userIds.incrementAndGet();
        SalesMan customer=new SalesMan(saleManId, name, email, true, CommonUtil.getDateEquivalent(System.currentTimeMillis()));
        salesManList.put(saleManId, customer);
        return saleManId;
    }
    void removeSalesMan(Integer salesManId){
        salesManList.remove(salesManId);
    }
    void updateAvailability(Integer id, boolean status){
        salesManList.get(id).setAvailable(status);
    }
    void addIncentive(Long saleManId, Long date, Long amount){
        if(!incentivesMap.containsKey(saleManId)){
            incentivesMap.put(saleManId, new HashMap<>());
        }
        Long dateMillis=CommonUtil.getDateEquivalent(date);
        Map<Long, Long> incentiveMapForGivenSaleMan=incentivesMap.get(saleManId);
        incentiveMapForGivenSaleMan.put(dateMillis, incentiveMapForGivenSaleMan.getOrDefault(dateMillis, 0L)+amount);
    }
    Long getIncentive(Long salesManId, Long date){
        Long dateMillis=CommonUtil.getDateEquivalent(date);
        if(incentivesMap.containsKey(salesManId)){
            return incentivesMap.get(salesManId).get(dateMillis);
        }
        return 0l;
    }
    SalesMan getSalesMan(Integer salesManId){
        return salesManList.get(salesManId);
    }
}
