package francis.baseadapter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import francis.baseadapter.R;
import francis.baseadapter.adapter.MyAdapter;
import francis.baseadapter.adapter.MyAdapterByCommonViewHolder;
import francis.baseadapter.module.Bean;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Bean> mDatas;
    private MyAdapter mAdapter;
    private MyAdapterByCommonViewHolder mAdapterByCommonViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_listView);
        //mListView.setAdapter(mAdapter);
        mListView.setAdapter(mAdapterByCommonViewHolder);
    }

    private void initDatas() {
        mDatas = new ArrayList<Bean>();
        Bean bean = new Bean("Android新技能Get 0","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 1","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 2","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 3","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 4","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 5","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 6","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 7","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 8","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 9","Android打造万能的ListView和GridView适配器","2015-12-23","10086");
        mDatas.add(bean);

        mAdapter = new MyAdapter(this,mDatas);
        mAdapterByCommonViewHolder = new MyAdapterByCommonViewHolder(this,mDatas,R.layout.item_listview);
    }
}
