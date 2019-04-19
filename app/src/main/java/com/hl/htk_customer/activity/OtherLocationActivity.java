package com.hl.htk_customer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.hl.htk_customer.R;
import com.hl.htk_customer.adapter.OtherAddressAdapter;
import com.hl.htk_customer.base.BaseActivity;
import com.hl.htk_customer.model.EventAddressEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherLocationActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, PoiSearch.OnPoiSearchListener {

    @Bind(R.id.ll_return)
    LinearLayout llReturn;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.edt_address)
    EditText edtAddress;
    @Bind(R.id.listView)
    ListView listView;
    private OtherAddressAdapter otherAddressAdapter;
    private PoiSearch.Query query;// Poi查询条件类
    private PoiSearch  poiSearch;// POI搜索

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_location);
        ButterKnife.bind(this);
        initWidget();
    }

    private void initWidget() {
        tvTitle.setText(getResources().getText(R.string.other_location));
        llReturn.setOnClickListener(this);
        otherAddressAdapter = new OtherAddressAdapter(this);
        listView.setAdapter(otherAddressAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_return:
                finish();
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.tv_search)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                String address = edtAddress.getText().toString();
                if ("".equals(address)) {
                    showMessage("请输入搜索关键字");
                    return;
                } else {
                    doSearchQuery(address);
                }
                break;
        }
    }

    /**
     * 开始进行poi搜索
     */
    protected void doSearchQuery(String key) {
        //不输入城市名称有些地方搜索不到
        // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query = new PoiSearch.Query(key, "", "");
        // 设置每页最多返回多少条poiitem
        //query.setPageSize(10);
        // 设置查询页码
        //query.setPageNum(0);

        //构造 PoiSearch 对象，并设置监听
        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        //调用 PoiSearch 的 searchPOIAsyn() 方法发送请求。
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int rCode) {
        //rCode 为1000 时成功,其他为失败
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            // 解析result   获取搜索poi的结果
            if (poiResult != null && poiResult.getQuery() != null) {
                if (poiResult.getQuery().equals(query)) {  // 是否是同一条
                    // 取得第一页的poiitem数据，页数从数字0开始
                    //poiResult.getPois()可以获取到PoiItem列表
                    List<PoiItem> poiItems = poiResult.getPois();

                    /*
                    //若当前城市查询不到所需POI信息，可以通过result.getSearchSuggestionCitys()获取当前Poi搜索的建议城市
                    List<SuggestionCity> suggestionCities = poiResult.getSearchSuggestionCitys();
                    //如果搜索关键字明显为误输入，则可通过result.getSearchSuggestionKeywords()方法得到搜索关键词建议。
                    List<String> suggestionKeywords =  poiResult.getSearchSuggestionKeywords();
                    */

                    if (poiItems != null && poiItems.size() > 0) {
                        otherAddressAdapter.setData(poiItems);
                    } else {
                        otherAddressAdapter.setData(poiItems);
                        showMessage("无搜索结果");
                    }

                    /*
                    //解析获取到的PoiItem列表
                    for(PoiItem item : poiItems){
                        //获取经纬度对象
                        LatLonPoint llp = item.getLatLonPoint();
                        double lon = llp.getLongitude();
                        double lat = llp.getLatitude();
                        //返回POI的名称
                        String title = item.getTitle();
                        //返回POI的地址
                        String text = item.getSnippet();
                        data.add(new LocationAddressInfo(String.valueOf(lon), String.valueOf(lat), title, text));
                    }
                    */
                }
            } else {
                showMessage("无搜索结果");
            }
        } else {
            showMessage("错误码"+rCode);
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        PoiItem item1 = (PoiItem) otherAddressAdapter.getItem(position);
        EventBus.getDefault().post(new EventAddressEntity(item1.getTitle()));
        Intent intent=new Intent();
        LatLonPoint latLonPoint = item1.getLatLonPoint();
        intent.putExtra("longitude", latLonPoint.getLongitude());
        intent.putExtra("latitude", latLonPoint.getLatitude());
        intent.putExtra( "address" , item1.getTitle());
        setResult(101 , intent);
        finish();
    }
}
