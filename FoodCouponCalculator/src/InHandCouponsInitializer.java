import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InHandCouponsInitializer {
	
	List<Integer> varietyOfCoupons;
	
	
	public InHandCouponsInitializer(List<Integer> varietyOfCoupons) {
		this.varietyOfCoupons = varietyOfCoupons;
	}
	
	public Map<Integer, Integer> initializeCouponsInHand() {
		
		System.out.println("Enter the details for coupons in hand ... ");
		Scanner in = new Scanner(System.in);
		/**
		 * the keys have to be in descending order so that the maximum coupon value has first priority.
		 * if this is not done then at times, a lower coupon value would be consumed first 
		 */
		Map<Integer, Integer> couponsInHand = new TreeMap<>(Collections.reverseOrder());
		int numberOfCoupons;
		
		for(Integer couponVariety : varietyOfCoupons){
			System.out.println("Enter the number of " + couponVariety + " coupons in hand" );
			numberOfCoupons = in.nextInt();
			
			couponsInHand.put(couponVariety, numberOfCoupons);
		}
		return couponsInHand;
	}
}
