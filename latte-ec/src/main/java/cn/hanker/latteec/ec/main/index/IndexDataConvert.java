package cn.hanker.latteec.ec.main.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

import cn.hanker.latte.app.ui.recycler.DataConverter;
import cn.hanker.latte.app.ui.recycler.ItemType;
import cn.hanker.latte.app.ui.recycler.MultipleFidlds;
import cn.hanker.latte.app.ui.recycler.MultipleItemEntity;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public final class IndexDataConvert extends DataConverter{



    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final String imageUrl = data.getString("imageUrl");
            final String text = data.getString("text");
            final int spanSize = data.getInteger("spanSize");
            final int id = data.getInteger("goodsId");
            final JSONArray banners = data.getJSONArray("banners");

            final ArrayList<String> bannerImages = new ArrayList<>();
            int type = 0 ;
            if (imageUrl == null && text!= null){
                type = ItemType.TEXT;

            }else if (imageUrl != null && text == null){
                type = ItemType.IMAGE;
            }else if (imageUrl != null && text != null){
                type = ItemType.TEXT_IMAGE;
            }else if (banners != null){
                type = ItemType.BANNERS;
                final int bannerSize = banners.size();
                for (int j = 0; j < bannerSize; j++) {
                    // banner 初始化
                   final String banner = banners.getString(j);
                   bannerImages.add(banner);
                }
            }
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFidlds.ITEM_TYPE, type)
                    .setField(MultipleFidlds.SPAN_SIZE, spanSize)
                    .setField(MultipleFidlds.ID, id)
                    .setField(MultipleFidlds.TEXT, text)
                    .setField(MultipleFidlds.IMAGE_RUL, imageUrl)
                    .setField(MultipleFidlds.BANNERS, bannerImages)
                    .build();
                ENTIVITES.add(entity);

        }
        return ENTIVITES;
    }

}
