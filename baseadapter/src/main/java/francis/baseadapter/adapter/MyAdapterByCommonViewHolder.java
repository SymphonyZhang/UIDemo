package francis.baseadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import francis.baseadapter.R;
import francis.baseadapter.adapter.utils.CommonAdapter;
import francis.baseadapter.adapter.utils.ViewHolder;
import francis.baseadapter.module.Bean;

/**
 * Created by Francis on 2015/12/23.
 */
public class MyAdapterByCommonViewHolder extends CommonAdapter<Bean> {

    //第二种方案：用一个list记录哪些item被选中
    private List<Integer> mPos = new ArrayList<Integer>();

    public MyAdapterByCommonViewHolder(Context context, List<Bean> datas,int layoutId) {
        super(context,datas,layoutId);
    }
    @Override
    public void convert(final ViewHolder viewHolder, final Bean bean) {

        viewHolder.setText(R.id.id_title,bean.getTitle())
                .setText(R.id.id_desc,bean.getDesc())
                .setText(R.id.id_time,bean.getTime())
                .setText(R.id.id_phone,bean.getPhone());
        final CheckBox cb = viewHolder.getView(R.id.id_cb);
        //第一种解决方案：在实体中添加标记是否被选中解决复用选中状态的混乱
        /*cb.setChecked(bean.isChecked());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(cb.isChecked());
            }
        });*/
        //-------------------------------------------------------------
        //第二种方案：
        cb.setChecked(false);
        if(mPos.contains(viewHolder.getPosition())){
            cb.setChecked(true);
        }
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb.isChecked()){
                    mPos.add(viewHolder.getPosition());
                }else {
                    mPos.remove((Integer)viewHolder.getPosition());
                }
            }
        });
    }
}
