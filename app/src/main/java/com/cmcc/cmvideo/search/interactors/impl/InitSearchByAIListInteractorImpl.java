package com.cmcc.cmvideo.search.interactors.impl;

import com.cmcc.cmvideo.base.AbstractInteractor;
import com.cmcc.cmvideo.base.BaseObject;
import com.cmcc.cmvideo.base.Executor;
import com.cmcc.cmvideo.base.MainThread;
import com.cmcc.cmvideo.search.interactors.InitSearchByAIListInteractor;
import com.cmcc.cmvideo.search.model.SearchByAIBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.cmcc.cmvideo.utils.Constants.MESSAGE_FROM_AI;
import static com.cmcc.cmvideo.utils.Constants.MESSAGE_TYPE_NORMAL;

/**
 * Created by Yyw on 2018/5/21.
 * Describe:
 */

public class InitSearchByAIListInteractorImpl extends AbstractInteractor implements InitSearchByAIListInteractor {
    private Callback mCallback;

    public InitSearchByAIListInteractorImpl(Executor threadExecutor, MainThread mainThread, InitSearchByAIListInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        this.mCallback = callback;
    }

    @Override
    public void dataObjectChanged(BaseObject dataObject, int what) {
    }

    @Override
    public void dataObjectFailed(BaseObject dataObject, int what, JSONObject errorMsg) {
    }

    @Override
    public void run() {
        final List<SearchByAIBean> searchByAIBeanList = new ArrayList<SearchByAIBean>();
        searchByAIBeanList.add(new SearchByAIBean("您希望我做什么", MESSAGE_TYPE_NORMAL, MESSAGE_FROM_AI));
        searchByAIBeanList.add(new SearchByAIBean("你可以像下这样问我", MESSAGE_TYPE_NORMAL, MESSAGE_FROM_AI));
        searchByAIBeanList.add(new SearchByAIBean("你可以像下这样问我你可以像下这样问我你可以像下这样问我你可以像下这样问我你可以像下这样问我", MESSAGE_TYPE_NORMAL, MESSAGE_FROM_AI));
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onInitSearchByAIListData(searchByAIBeanList);
            }
        });
    }
}
