package cn.hanker.latte.app.ui.recycler;

import java.util.ArrayList;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public abstract class DataConverter {

    protected final ArrayList<MultipleItemEntity> ENTIVITES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String json){
        this.mJsonData = json;
        return this;
    }

    public String getJsonData(){
        if (mJsonData == null || mJsonData.isEmpty()){
            throw new NullPointerException("DATA IS NULL");
        }
        return mJsonData;
    }


}
