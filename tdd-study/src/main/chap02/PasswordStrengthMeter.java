package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        int meetCounts = getMetCriteriaCounts(password);

        if (meetCounts <= 1) return PasswordStrength.WEAK;
        if (meetCounts == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String password){
        int metCounts = 0;
        if (password.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingNumberCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
