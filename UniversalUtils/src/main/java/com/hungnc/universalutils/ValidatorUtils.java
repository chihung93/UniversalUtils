package com.hungnc.universalutils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

public class ValidatorUtils {

    private static final boolean YES = true;
    private static final boolean NO = false;

    private static final String EMAIL_PATTERN_1 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String EMAIL_PATTERN_2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

    public static boolean nonEmpty(EditText editText) {
        if (editText != null && !(TextUtils.isEmpty(editText.getText().toString().trim()))) {
            return YES;
        } else {
            Log.d("SERI_PAR->Error", "edit text object is null");
            return NO;
        }
    }

    public static boolean nonEmpty(Context context, EditText editText, String msg) {
        if (nonEmpty(editText)) {
            return YES;
        } else {
            ToastUtils.showShort(context,msg);
            return NO;
        }
    }

    public static boolean validateEmail(EditText editText) {
        if (nonEmpty(editText)) {
            String emailAsString = StringUtils.removeBlankSpace(editText.getText().toString());
            return emailAsString.matches(EMAIL_PATTERN_1)
                    || emailAsString.matches(EMAIL_PATTERN_2);

        } else {
            Log.d("SERI_PAR->Error", "edit text object is null");
            return NO;
        }
    }

    public static boolean validateEmail(Context context, EditText editText, String msg) {
        if (validateEmail(editText)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean matchMinLength(EditText editText, int length) {
        if (nonEmpty(editText)) {
            String content = StringUtils.removeBlankSpace(editText.getText().toString());
            return content.length() >= length ? YES : NO;
        } else {
            Log.e("SERI_PAR->Error", "edit text object is null");
            return NO;
        }
    }

    public static boolean matchMinLength(Context context, EditText editText, int length, String msg) {
        if (matchMinLength(editText, length)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean noSpecialCharacters(EditText editText) {
        if (nonEmpty(editText)) {
            String content = StringUtils.removeBlankSpace(editText.getText().toString());
            return content.matches("[a-zA-Z0-9.? ]*");
        } else {
            Log.e("SERI_PAR->Error", "edit text object is null");
            return NO;
        }
    }

    public static boolean noSpecialCharacters(Context context, EditText editText, String msg) {
        if (noSpecialCharacters(editText)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean matchLength(EditText editText, int length) {
        if (nonEmpty(editText)) {
            String content = StringUtils.removeBlankSpace(editText.getText().toString());
            return content.length() == length;
        } else {
            Log.d("SERI_PAR->Error", "edit text object is null");
            return NO;
        }
    }

    public static boolean matchLength(Context context, EditText editText, int length, String msg) {
        if (matchLength(editText, length)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean mobileNumberValidation(EditText editText) {
        if (nonEmpty(editText)) {
            String mobileNumber = StringUtils.removeBlankSpace(editText.getText().toString().trim());
            return Patterns.PHONE.matcher(mobileNumber).matches();
        } else {
            Log.d("SERI_PAR->Error", "edit text object is null");
            return NO;
        }
    }

    public static boolean mobileNumberValidation(Context context, EditText editText, String msg) {
        if (mobileNumberValidation(editText)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean mobileNumberValidation(EditText editText, Pattern pattern) {
        if (nonEmpty(editText)) {
            String mobileNumber = StringUtils.removeBlankSpace(editText.getText().toString());
            return pattern.matcher(mobileNumber).matches();
        } else {
            return NO;
        }
    }

    public static boolean mobileNumberValidation(Context context, EditText editText, Pattern pattern, String msg) {
        if (mobileNumberValidation(editText, pattern)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean mobileNumberValidation(EditText editText, int minLength, int maxLength) {
        if (minLength > 0 && maxLength > 0 && nonEmpty(editText)) {
            String mobileNumber = StringUtils.removeBlankSpace(editText.getText().toString().trim());
            return mobileNumber.length() >= minLength && mobileNumber.length() <= maxLength;
        } else {
            return NO;
        }
    }

    public static boolean mobileNumberValidation(Context context, EditText editText, int minLength, int maxLength, String msg) {
        if (mobileNumberValidation(editText, minLength, maxLength)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }

    public static boolean matchText(EditText baseEditText, EditText... editTexts) {
        if (nonEmpty(baseEditText)) {
            String matchString = baseEditText.getText().toString();
            for (EditText editText : editTexts) {
                if (editText == null || !(matchString.equals(editText.getText().toString()))) {
                    return NO;
                }
            }
        } else {
            return NO;
        }
        return YES;
    }

    public static boolean matchText(Context context, String msg, EditText baseEditText, EditText... editTexts) {
        if (matchText(baseEditText, editTexts)) {
            return YES;
        } else {
            ToastUtils.showShort(context, msg);
            return NO;
        }
    }
}
