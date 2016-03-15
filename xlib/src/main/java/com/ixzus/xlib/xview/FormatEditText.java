package com.ixzus.xlib.xview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by metro on 2016/3/14.
 * 格式化电话号码
 */
public class FormatEditText extends EditText{
    private int phoneNumLength = 11;
    private int firstGapPos = 3;
    private int secondGapPos = 8;
    boolean firstGapInstert;
    boolean secondGapInstert;


    public FormatEditText(Context context) {
        super(context);
        init();
    }

    public FormatEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FormatEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint("NewApi")
    public FormatEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    void init() {
        addTextChangedListener(new MyTextWatcher(this));
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    class MyTextWatcher implements TextWatcher {
        EditText editText;
        String whiteSpace = " ";

        public MyTextWatcher(EditText editText) {
            this.editText = editText;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            int len = s.length();
            if (len == 0) {
                return;
            }
            String str = s.toString();
            for (int i = 0; i < len; i++) {
                String sub = str.substring(i, i + 1);
                if (i == len - 1){
                    if (TextUtils.isEmpty(sub.trim())) {
                        s.replace(i, i + 1, "");
                    }
                }else if (i == firstGapPos || i == secondGapPos) {
                    continue;
                } else {
                    if (TextUtils.isEmpty(sub.trim())) {
                        s.replace(i, i + 1, "");
                    }
                }
            }

            len = s.length();
            if (len < phoneNumLength) {
                if (len == firstGapPos + 1 && !firstGapInstert) {
                    firstGapInstert = true;
                    s.insert(firstGapPos, whiteSpace);
                } else if (len == secondGapPos + 1 && !secondGapInstert) {
                    secondGapInstert = true;
                    s.insert(secondGapPos, whiteSpace);
                }
                if (firstGapInstert && len <= firstGapPos) {
                    firstGapInstert = false;
                }
                if (secondGapInstert && len <= secondGapPos) {
                    secondGapInstert = false;
                }
            } else if (len == phoneNumLength) {
                if (!firstGapInstert) {
                    firstGapInstert = true;
                    s.insert(firstGapPos, whiteSpace);
                }

                if (!secondGapInstert) {
                    secondGapInstert = true;
                    s.insert(secondGapPos, whiteSpace);
                }
            } else if (len > phoneNumLength + 2 && firstGapInstert && secondGapInstert) {
                s.replace(secondGapPos, secondGapPos + 1, "");
                secondGapInstert = false;
                s.replace(firstGapPos, firstGapPos + 1, "");
                firstGapInstert = false;
            }
        }
    }
}
