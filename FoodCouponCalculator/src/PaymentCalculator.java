import java.util.Map;
import java.util.TreeMap;

public class PaymentCalculator {
	
	public Map<Integer, Integer> findTheCouponsToBePaid(int billAmount, int totalAmount, InHandCouponsInfoDAO inHandCouponsInfo){
		
//		TODO - handle the partial cash and coupon payment scenario here
		int originalBillAmount = billAmount;
		
		if(billAmount > totalAmount){
			System.out.println("Insufficient coupon amount. ");
			System.out.println("Coupons available only for " + totalAmount + " rupees");
			System.out.println("You are in short of " + (totalAmount - billAmount) + " rupees");
			
			return null;
		}
		
		else{
			int couponsNeeded, couponsAvailable, couponsUsed;
			Map<Integer, Integer> affectedCouponVarietiesMap = new TreeMap<Integer, Integer>();
			Map<Integer, Integer> inHandCouponsMap = inHandCouponsInfo.getInHandCouponsInfo();  
			
			for(Integer couponVariety : inHandCouponsMap.keySet()){
				couponsNeeded = billAmount/couponVariety;
				couponsAvailable = inHandCouponsMap.get(couponVariety);
				
				couponsUsed = (couponsNeeded <= couponsAvailable) ? couponsNeeded : couponsAvailable;
				
				if(couponsUsed >= 1){
					billAmount = billAmount - (couponsUsed * couponVariety);
					affectedCouponVarietiesMap.put(couponVariety, couponsUsed);
				}
				if(billAmount == 0){
					break;
				}
				
			}
			
			
			System.out.println("Coupons to be paid for the sum of " + totalAmount + " rupees : ");
			System.out.println("Amount to be paid as coupons : "    + (originalBillAmount - billAmount));
			System.out.println("Amount to be paid as cash / card :" + billAmount);
			
			new Utils().printTheMap(affectedCouponVarietiesMap);
			
			return affectedCouponVarietiesMap;
		}
	}
}
