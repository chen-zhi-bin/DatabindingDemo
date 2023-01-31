package com.program.databindingdemo.views;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriseNumberFilter implements InputFilter {

    private final Pattern mPattern;

    public PriseNumberFilter() {
        //前面位数不限，后面限制2位，如果需要自行修改即可
        String regex = "[0-9]*+(\\.[0-9]{0,2})?";
        mPattern = Pattern.compile(regex);
    }

    /**
     * @param source 将要输入的字符串,如果是删除操作则为空字符串
     * @param start  将要输入的字符串起始下标，一般为0
     * @param end    start + source字符的长度
     * @param dest   输入之前文本框中的内容
     * @param dstart 将会被替换的起始位置
     * @param dend   将会被替换的字符串长度
     * @return 返回值 ：方法返回的值将会替换掉dest字符串中dstartd位置到dend位置之间字符
     * 返回source表示不做任何处理，返回空字符串""表示不输入任何字符
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (".".contentEquals(source) && "".contentEquals(dest.toString())) {
            return "0.";
        }
        StringBuilder builder = new StringBuilder(dest);
        if ("".contentEquals(source)) {
            builder.replace(dstart, dend, "");
        } else {
            builder.insert(dstart, source);
        }
        String resultTemp = builder.toString();
        Matcher matcher = mPattern.matcher(resultTemp);
        // 新添加的代码片段 resultTemp.matches("^0\\d") ||
        if (resultTemp.matches("^0\\d") || !matcher.matches()) {
            return "";
        }
        return null;
    }
}
