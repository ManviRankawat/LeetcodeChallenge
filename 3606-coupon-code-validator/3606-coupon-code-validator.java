class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> validCoupons = new ArrayList<>();
        if(isActive == null || businessLine == null || code == null) return validCoupons;

        // First, collect all valid coupons with their business lines
        List<Coupon> coupons = new ArrayList<>();
        
        for(int i = 0; i < code.length; i++){
            if(isActive[i] && 
               isValidCode(code[i]) && 
               isValidBusinessLine(businessLine[i])){
                coupons.add(new Coupon(code[i], businessLine[i]));
            }
        }
        
        // Sort by business line order, then by code lexicographically
        Collections.sort(coupons, (a, b) -> {
            int orderA = getBusinessLineOrder(a.businessLine);
            int orderB = getBusinessLineOrder(b.businessLine);
            if(orderA != orderB) {
                return orderA - orderB;
            }
            return a.code.compareTo(b.code);
        });
        
        // Extract codes
        for(Coupon c : coupons) {
            validCoupons.add(c.code);
        }
        
        return validCoupons;
    }
    
    // Helper method to validate code
    private boolean isValidCode(String code) {
        if(code == null || code.isEmpty()) return false;
        for(char c : code.toCharArray()) {
            if(!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
    
    // Helper method to validate business line
    private boolean isValidBusinessLine(String businessLine) {
        return businessLine != null && 
               (businessLine.equals("electronics") || 
                businessLine.equals("grocery") || 
                businessLine.equals("pharmacy") || 
                businessLine.equals("restaurant"));
    }
    
    // Helper method to get business line sort order
    private int getBusinessLineOrder(String businessLine) {
        switch(businessLine) {
            case "electronics": return 0;
            case "grocery": return 1;
            case "pharmacy": return 2;
            case "restaurant": return 3;
            default: return 4;
        }
    }
    
    // Helper class to store coupon information
    private class Coupon {
        String code;
        String businessLine;
        
        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}