package com.program.databindingdemo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.program.databindingdemo.R;


public class InputNumberView extends RelativeLayout {

    private static final String TAG = "InputNumberView";
    private int mCurrentNumber = 0;
    private View mMinsBtn;
    private EditText mValueEdt;
    private View mPulsBtn;
    private OnNumberValueChangeListener mOnNumberValueChangeListener=null;
    private int mMax;
    private int mMin;
    private int mStep;
    private int mDefaultValue;
    private boolean mDisable;
    private int mBtnBgRes;

    public InputNumberView(Context context) {
        this(context,null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initarrts(context, attrs);
        //处理事件
        setUpEvent();
    }

    private void initarrts(Context context, AttributeSet attrs) {
        //获取相关属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InputNumberView);
        mMax = a.getInt(R.styleable.InputNumberView_max, 0);
        mMin = a.getInt(R.styleable.InputNumberView_min, 0);
        mStep = a.getInt(R.styleable.InputNumberView_step, 1);
        mDefaultValue = a.getInt(R.styleable.InputNumberView_defaultValue, 0);
        this.mCurrentNumber = mDefaultValue;
        updataText();
        mDisable = a.getBoolean(R.styleable.InputNumberView_disable, false);
        mBtnBgRes = a.getResourceId(R.styleable.InputNumberView_btnBackground, -1); //-1表示找不到
        Log.d(TAG,"mMax=="+mMax);
        Log.d(TAG,"mMin=="+mMin);
        Log.d(TAG,"mStep=="+mStep);
        Log.d(TAG,"mDefaultValue=="+mDefaultValue);
        Log.d(TAG,"mDisable=="+mDisable);
        Log.d(TAG,"mBtnBgRes=="+mBtnBgRes);
        //
        a.recycle();
    }

    private void setUpEvent() {
        mMinsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPulsBtn.setEnabled(true);
                mCurrentNumber-=mStep;
                if (mMin!=0&&mCurrentNumber<=mMin){
                    v.setEnabled(false);
                    mCurrentNumber = mMin;
                    Log.d(TAG,"current is mini value...");
                    if (mOnNumberValueChangeListener != null) {
                        mOnNumberValueChangeListener.onNumberMin(mMin);
                    }
                }
                updataText();
            }
        });
        mPulsBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                mMinsBtn.setEnabled(true);
                mCurrentNumber+=mStep;
                if (mMax!=0&&mCurrentNumber>=mMax){
                    v.setEnabled(false);
                    mCurrentNumber = mMax;
                    Log.d(TAG,"current is max value");
                    if (mOnNumberValueChangeListener != null) {
                        mOnNumberValueChangeListener.onNumberMin(mMax);
                    }
                }
                updataText();
            }
        });
    }

    private void initView(Context context) {
        //true表示把当前载到的view绑到当前ViewGroup中，默认为ture,false为不绑定（不绑定不显示）
        //以下代码功能等价
        //View view = LayoutInflater.from(context).inflate(R.layout.input_number_view,this,true);
        //View view = LayoutInflater.from(context).inflate(R.layout.input_number_view,this);
        View view = LayoutInflater.from(context).inflate(R.layout.input_number_view,this,false);
        addView(view);
        //以上代码功能等价,都是把view加入到容器里
        mMinsBtn = this.findViewById(R.id.minus_btn);
        mValueEdt = this.findViewById(R.id.value_edt);
        mPulsBtn = this.findViewById(R.id.puls_btn);

        //初始化控件值
        updataText();
//        Toast.makeText(context,""+mDisable,Toast.LENGTH_SHORT).show();
        mMinsBtn.setEnabled(!mDisable);
        mPulsBtn.setEnabled(!mDisable);
    }

    /**
     *更新数值
     */
    private void updataText(){
        mValueEdt.setText(String.valueOf(mCurrentNumber));
        if (mOnNumberValueChangeListener != null) {
            mOnNumberValueChangeListener.onNumberValueChange(this.mCurrentNumber);
        }
    }

    public int getNumber() {
        return mCurrentNumber;
    }

    public void setNumber(int value) {
        mCurrentNumber = value;
        this.updataText();
    }

    public View getMinsBtn() {
        return mMinsBtn;
    }

    public void setMinsBtn(View minsBtn) {
        mMinsBtn = minsBtn;
    }

    public int getMax() {
        return mMax;
    }

    public void setMax(int max) {
        mMax = max;
    }

    public int getMin() {
        return mMin;
    }

    public void setMin(int min) {
        mMin = min;
    }

    public int getStep() {
        return mStep;
    }

    public void setStep(int step) {
        mStep = step;
    }

    public int getDefaultValue() {
        return mDefaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        mDefaultValue = defaultValue;
        this.mCurrentNumber = defaultValue;
        this.updataText();
    }

    public boolean isDisable() {
        return mDisable;
    }

    public void setDisable(boolean disable) {
        mDisable = disable;
    }

    public int getBtnBgRes() {
        return mBtnBgRes;
    }

    public void setBtnBgRes(int btnBgRes) {
        mBtnBgRes = btnBgRes;
    }

    public void setOnNumberValueChangeListener(OnNumberValueChangeListener listener){
        this.mOnNumberValueChangeListener=listener;
    }

    public interface OnNumberValueChangeListener{
        void onNumberValueChange(int value);

        void onNumberMax(int maxValue);

        void onNumberMin(int minValue);
    }
}
