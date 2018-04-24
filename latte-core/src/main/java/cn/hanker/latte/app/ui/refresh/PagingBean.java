package cn.hanker.latte.app.ui.refresh;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2018/4/24.
 */
public class PagingBean {

    // 当前是第几页
    private int mPageIndex = 0;
    // 总条数
    private int mTotal = 0;
    // 一页显示几条数据
    private int mPageSize = 0;
    // 当前已显示几条
    private int mCurrentCount = 0;
    //加载延迟
    private int mDelayed = 0 ;

    public PagingBean setPageIndex(int pageIndex) {
        mPageIndex = pageIndex;
        return this;
    }

    public PagingBean setTotal(int total) {
        mTotal = total;
        return this;
    }

    public PagingBean setPageSize(int pageSize) {
        mPageSize = pageSize;
        return this;
    }

    public PagingBean setCurrentCount(int currentCount) {
        mCurrentCount = currentCount;
        return this;
    }

    public PagingBean setDelayed(int delayed) {
        mDelayed = delayed;
        return this;
    }

    public int getPageIndex() {
        return mPageIndex;
    }

    public int getTotal() {
        return mTotal;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public int getCurrentCount() {
        return mCurrentCount;
    }

    public int getDelayed() {
        return mDelayed;
    }

    PagingBean addIndex(){
        mPageIndex++;
        return this;
    }

}
