package test;

// 코드 작성을 보면 성공이 맨아래고 이제 실패하는게 맨먼저 걸러지고있다 즉 성공이 모든조건이라서 맨아래다
// 나머지 조건을 만족해야 통과니까 그래서 이런식으로 코드를 작성해야한다
public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()){
            return PasswordStrength.INVALID;
        }
        int metCounts = metCount(s);
        if(metCounts<=1) return PasswordStrength.WEAK;
        if(metCounts==2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
    private boolean containsUpperCase(String s){
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)) return true;
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s){
        for(char ch : s.toCharArray()){
            if(ch>='0' && ch <='9'){
                return true;
            }
        }
        return false;
    }

    private int metCount(String s){
        boolean lengthEnough = s.length() >=8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpp = containsUpperCase(s);
        int metCounts = 0;
        if(lengthEnough){
            metCounts +=1;
        }
        if(containsNum){
            metCounts+=1;
        }
        if(containsUpp){
            metCounts+=1;
        }
        return metCounts;
    }
}
