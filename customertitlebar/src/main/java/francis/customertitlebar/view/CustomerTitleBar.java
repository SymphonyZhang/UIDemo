package francis.customertitlebar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import francis.customertitlebar.R;

/**
 * Created by Francis on 2015/12/22.
 */
public class CustomerTitleBar extends RelativeLayout {

    //定义自定义控件中需要的控件
    private Button leftButton,rightButton;
    private TextView tvTitle;

    //定义控件属性（与atts对应）
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    //用于布局
    private LayoutParams leftParams,rightParams,titleParams;

    //用回调实现按钮事件
    //1.实现一个接口
    public interface customerTitleBarClickListener{
        public void leftClick();
        public void rightClick();
    }

    //定义一个接口对象
    private customerTitleBarClickListener listener;

    //暴露一个方法用于回掉
    public void setOnCustomerTitleBarClickListener(customerTitleBarClickListener listener){
        this.listener = listener;
    }


    public CustomerTitleBar(Context context) {
        this(context, null);
    }

    public CustomerTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    @SuppressLint("NewApi")
    public CustomerTitleBar(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //自定义属性与atts中定义属性关联并从layout中获取值
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomerTitleBar);
        leftTextColor = ta.getColor(R.styleable.CustomerTitleBar_leftTextColor,0);
        leftBackground = ta.getDrawable(R.styleable.CustomerTitleBar_leftBackground);
        leftText=ta.getString(R.styleable.CustomerTitleBar_leftText);
        rightTextColor = ta.getColor(R.styleable.CustomerTitleBar_rightTextColor,0);
        rightBackground = ta.getDrawable(R.styleable.CustomerTitleBar_rightBackground);
        rightText=ta.getString(R.styleable.CustomerTitleBar_rightText);
        titleTextSize=ta.getDimension(R.styleable.CustomerTitleBar_myTitleTextSize,0);
        titleTextColor = ta.getColor(R.styleable.CustomerTitleBar_myTitleTextColor,0);
        title=ta.getString(R.styleable.CustomerTitleBar_myTitle);

        //清空
        ta.recycle();

        //实例化控件
        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);

        //给控件赋值
        leftButton.setTextColor(leftTextColor);
        leftButton.setText(leftText);
        leftButton.setBackground(leftBackground);
        rightButton.setTextColor(rightTextColor);
        rightButton.setText(rightText);
        rightButton.setBackground(rightBackground);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setText(title);
        tvTitle.setGravity(Gravity.CENTER);
        //setBackgroundColor(0xFFF59563);

        //设置控件位置----
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//设置控件宽高
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);//设置控件位置

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);

        //把控件加载到父布局中
        addView(leftButton,leftParams);
        addView(rightButton,rightParams);
        addView(tvTitle,titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
    }

    public void setLeftIsVisable(boolean flag){
        if(flag){
            leftButton.setVisibility(View.VISIBLE);
        }else {
            leftButton.setVisibility(View.GONE);
        }
    }
    public void setRightIsVisable(boolean flag){
        if(flag){
            rightButton.setVisibility(View.VISIBLE);
        }else {
            rightButton.setVisibility(View.GONE);
        }
    }
}
