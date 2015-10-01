//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.microg.gms.common.api.DummyPendingResult;

public class RemoteMediaPlayer implements MessageReceivedCallback {

    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_TIMED_OUT = 2102;
    public static final int STATUS_REPLACED = 2103;

    private final Object lock = new Object();

    private RemoteMediaPlayer.OnMetadataUpdatedListener onMetadataUpdatedListener;
    private RemoteMediaPlayer.OnStatusUpdatedListener onStatusUpdatedListener;
    private String namespace = "bla";
    private MediaStatus mediaStatus = new MediaStatus(new MediaInfo("bla"));
    private long streamDuration;
    private long approximateStreamPosition;

    public RemoteMediaPlayer() {

    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return this.load(apiClient, mediaInfo, true, 0L, (long[])null, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return this.load(apiClient, mediaInfo, autoplay, 0L, (long[])null, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return this.load(apiClient, mediaInfo, autoplay, playPosition, (long[])null, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return this.load(apiClient, mediaInfo, autoplay, playPosition, (long[])null, customData);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> load(final GoogleApiClient apiClient, final MediaInfo mediaInfo, final boolean autoplay, final long playPosition, final long[] activeTrackIds, final JSONObject customData) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(GoogleApiClient apiClient) {
        return this.pause(apiClient, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(GoogleApiClient apiClient) {
        return this.stop(apiClient, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(GoogleApiClient apiClient) {
        return this.play(apiClient, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return this.seek(apiClient, position, 0, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return this.seek(apiClient, position, resumeState, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> seek(final GoogleApiClient apiClient, final long position, final int resumeState, final JSONObject customData) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return this.setStreamVolume(apiClient, volume, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamVolume(final GoogleApiClient apiClient, final double volume, final JSONObject customData) throws IllegalArgumentException {
        if(!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return new DummyResult();
        } else {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return this.setStreamMute(apiClient, muteState, (JSONObject)null);
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return new DummyResult();
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if(trackIds == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        } else {
            return new DummyResult();
        }
    }

    public PendingResult<RemoteMediaPlayer.MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if(trackStyle == null) {
            throw new IllegalArgumentException("trackStyle cannot be null");
        } else {
            return new DummyResult();
        }
    }

    public long getApproximateStreamPosition() {
        synchronized(this.lock) {
            return this.approximateStreamPosition;
        }
    }

    public long getStreamDuration() {
        synchronized(this.lock) {
            return this.streamDuration;
        }
    }

    public MediaStatus getMediaStatus() {
        synchronized(this.lock) {
            return this.mediaStatus;
        }
    }

    public MediaInfo getMediaInfo() {
        synchronized(this.lock) {
            return this.mediaStatus.getMediaInfo();
        }
    }

    public String getNamespace() {
        return this.namespace;
    }

    public void setOnStatusUpdatedListener(RemoteMediaPlayer.OnStatusUpdatedListener listener) {
        this.onStatusUpdatedListener = listener;
    }

    private void onStatusUpdated() {
        if(this.onStatusUpdatedListener != null) {
            this.onStatusUpdatedListener.onStatusUpdated();
        }

    }

    public void setOnMetadataUpdatedListener(RemoteMediaPlayer.OnMetadataUpdatedListener listener) {
        this.onMetadataUpdatedListener = listener;
    }

    private void onMetadataUpdated() {
        if(this.onMetadataUpdatedListener != null) {
            this.onMetadataUpdatedListener.onMetadataUpdated();
        }

    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {

    }

    private static final class DummyResult extends DummyPendingResult<MediaChannelResult> {
        public DummyResult() {
            super(new StatusResult(Status.INTERRUPTED)); // always say it's interrupted
        }
    }

    private static final class StatusResult implements RemoteMediaPlayer.MediaChannelResult {
        private final Status status;
        private final JSONObject customData = new JSONObject();

        StatusResult(Status var1) {
            this.status = var1;
        }

        public Status getStatus() {
            return this.status;
        }

        public JSONObject getCustomData() {
            return this.customData;
        }
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }
}
