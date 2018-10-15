package com.lzw.leetcodeqa;

/**
 * Author: lzw
 * Date: 2018/10/15
 * Description: This is QAClass_2
 */

public class QAClass_2 {

    /**
     * 字符串转整数 (atoi)
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        str = str.trim();
        if (str != null && str.length() > 0) {
            String firstStr = String.valueOf(str.charAt(0));
            if (isNumber(firstStr)) {
                stringBuffer.append(firstStr);
                for (int i = 1; i < str.length(); i++) {
                    if (isNumber(str.charAt(i) + "")) {
                        stringBuffer.append(str.charAt(i));
                    } else {
                        break;
                    }
                }
            } else if (firstStr.equals("+")) {
                for (int i = 1; i < str.length(); i++) {
                    if (isNumber(str.charAt(i) + "")) {
                        stringBuffer.append(str.charAt(i));
                    } else {
                        break;
                    }
                }
            } else if (firstStr.equals("-")) {
                stringBuffer.append("-");
                if (str.length() > 1) {
                    String secondStr = String.valueOf(str.charAt(1));
                    if (isNumber(secondStr)) {
                        for (int i = 1; i < str.length(); i++) {
                            if (isNumber(str.charAt(i) + "")) {
                                stringBuffer.append(str.charAt(i));
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        String lastValue = stringBuffer.toString();
        if (lastValue.length() > 0) {
            if (lastValue.contains("-")) {
                if (lastValue.length() == 1) {
                    return 0;
                }
                lastValue = lastValue.replace("-", "");
                if (isNumber(lastValue)) {
                    int value = Integer.parseInt(lastValue);
                    if (value < -2147483648) {
                        value = -2147483648;
                    }
                    value = 0 - value;
                    return value;
                } else {
                    return -2147483648;
                }
            } else {
                if (isNumber(lastValue)) {
                    int value = Integer.parseInt(lastValue);
                    if (value > 2147483647) {
                        value = 2147483647;
                    }
                    return value;
                } else {
                    return 2147483647;
                }
            }
        } else {
            return 0;
        }
    }

    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
