package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 结果集添加合适的集合条件：切3刀 且 s.length()==0
 * 2. for循环 一次切的结果
 * 3. 关于使用subString切割字符串 和 使用Integer.valueOf()将字符串转换成数字
 */
public class RestoreIpAddresses_93 {
    public static void main(String[] args) {
        String s = "2552551112";
        System.out.println(new RestoreIpAddresses_93().restoreIpAddresses(s));
    }

//    public List<String> restoreIpAddresses(String s) {
//        List<String> address = new ArrayList<>();
//        StringBuilder tempAddress = new StringBuilder();
//        doRestore(0, address, tempAddress, s);
//        return address;
//    }
//
//    private void doRestore(int k, List<String> address, StringBuilder tempAddress, String s) {
//        if (k == 4 || s.length() == 0) {
//            if (k == 4 && s.length() == 0) {
//                address.add(tempAddress.toString());
//            }
//            return;
//        }
//
//        for (int i = 0; i <= 2 && i < s.length(); i++) {
//            //打断点调试一下为什么需要这个 答：不以0开头 如果0开头，只能是单独一个0 append --> tempAddress
//            if (i != 0 && s.charAt(0) == '0') {
//                break;
//            }
//
//            String part = s.substring(0, i + 1);
//            if (Integer.valueOf(part) <= 255) {
//                if (tempAddress.length() != 0) {
//                    part = '.' + part; //加上.符号
//                }
//                tempAddress.append(part);
//                doRestore(k + 1, address, tempAddress, s.substring(i + 1));
//                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
//            }
//        }
//    }
    public List<String> restoreIpAddresses(String s) {
        List<String> address = new ArrayList<>();
        StringBuilder tmp  = new StringBuilder();
        doRestore(s, address, tmp, 0);//0代表分段的次数
        return address;
    }

    private void doRestore(String s, List<String> address, StringBuilder tmp, int k) {
        if(k == 4 || s.length() == 0) {
            if( k == 4 && s.length() == 0) {
                address.add(tmp.toString());
            }
            return;
        }

        for(int i = 0; i <= 2 && i < s.length(); i++) {
            if(i != 0 && s.charAt(0) == '0') {
                break;
            }

            String sub = s.substring(0, i + 1);
            if(Integer.valueOf(sub) <= 255) {
                if(k != 0) {
                    sub = '.' + sub;
                }
                tmp.append(sub);
                doRestore(s.substring(i + 1), address, tmp, k + 1);
                tmp.delete(tmp.length() - sub.length(), tmp.length());
            }
        }
    }
}
