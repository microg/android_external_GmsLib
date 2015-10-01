package org.microg.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

import java.util.concurrent.TimeUnit;

/**
 * Created by mopar on 10/1/15.
 */
public class DummyPendingResult<T extends Result> implements PendingResult<T> {

    private final T result;

    private boolean canceled = false;

    public DummyPendingResult(T result) {
        this.result = result;
    }

    @Override
    public T await() {
        return result;
    }

    @Override
    public T await(long time, TimeUnit unit) {
        return result;
    }

    @Override
    public void cancel() {
        canceled = true;
    }

    @Override
    public boolean isCanceled() {
        return canceled;
    }

    @Override
    public void setResultCallback(ResultCallback<T> callback, long time, TimeUnit unit) {
        setResultCallback(callback);
    }

    @Override
    public void setResultCallback(ResultCallback<T> callback) {
        callback.onResult(result);
    }
}
