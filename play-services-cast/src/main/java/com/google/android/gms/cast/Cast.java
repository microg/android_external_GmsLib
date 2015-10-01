//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.*;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.images.WebImage;
import org.microg.gms.common.Objects;
import org.microg.gms.common.api.ApiBuilder;
import org.microg.gms.common.api.ApiConnection;
import org.microg.gms.common.api.DummyPendingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public final class Cast {
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final Api<Cast.CastOptions> API;
    public static final Cast.CastApi CastApi;

    private Cast() {
    }

    static {
        CastApi = new CastApi.CastApiImpl();
        API = new Api<>(new ApiBuilder<CastOptions>() {
            @Override
            public ApiConnection build(Context context, Looper looper, CastOptions options, AccountInfo accountInfo, ConnectionCallbacks callbacks, OnConnectionFailedListener connectionFailedListener) {
                return new ApiConnection() {
                    private boolean connected = false;

                    @Override
                    public void connect() {
                        connected = true;
                    }

                    @Override
                    public void disconnect() {
                        connected = false;
                    }

                    @Override
                    public boolean isConnected() {
                        return connected;
                    }

                    @Override
                    public boolean isConnecting() {
                        return false;
                    }
                };
            }
        });
    }

    public interface CastApi {
        void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient var1, String var2, String var3);

        PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2);

        @Deprecated
        PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, boolean var3);

        PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, LaunchOptions var3);

        PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, String var2, String var3);

        PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, String var2);

        PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1);

        PendingResult<Status> leaveApplication(GoogleApiClient var1);

        PendingResult<Status> stopApplication(GoogleApiClient var1);

        PendingResult<Status> stopApplication(GoogleApiClient var1, String var2);

        void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException;

        double getVolume(GoogleApiClient var1) throws IllegalStateException;

        void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException;

        boolean isMute(GoogleApiClient var1) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException;

        void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException;

        void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException;

        public static final class CastApiImpl implements Cast.CastApi {
            private double volume;
            private boolean mute;
            private ApplicationMetadata applicationMetadata = new ApplicationMetadata(1, "bob", "bob", new ArrayList<WebImage>(), new ArrayList<>(Collections.singletonList("bob")), "bob", null);

            public CastApiImpl() {
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {

            }

            public PendingResult<Status> sendMessage(final GoogleApiClient client, final String namespace, final String message) {
                return new DummyPendingResult<>(Status.SUCCESS);
            }

            public PendingResult<Cast.ApplicationConnectionResult> launchApplication(final GoogleApiClient client, final String applicationId) {
                return new DummyPendingResult<>(dummyApplicationConnectionResult(Status.INTERRUPTED, applicationMetadata));
            }

            public PendingResult<Cast.ApplicationConnectionResult> launchApplication(final GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return new DummyPendingResult<>(dummyApplicationConnectionResult(Status.INTERRUPTED, applicationMetadata));
            }

            @Deprecated
            public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                LaunchOptions var4 = (new com.google.android.gms.cast.LaunchOptions.Builder()).setRelaunchIfRunning(relaunchIfRunning).build();
                return this.launchApplication(client, applicationId, var4);
            }

            public PendingResult<Cast.ApplicationConnectionResult> joinApplication(final GoogleApiClient client, final String applicationId, final String sessionId) {
                return new DummyPendingResult<>(dummyApplicationConnectionResult(Status.INTERRUPTED, applicationMetadata));
            }

            public PendingResult<Cast.ApplicationConnectionResult> joinApplication(final GoogleApiClient client, final String applicationId) {
                return new DummyPendingResult<>(dummyApplicationConnectionResult(Status.INTERRUPTED, applicationMetadata));
            }

            public PendingResult<Cast.ApplicationConnectionResult> joinApplication(final GoogleApiClient client) {
                return new DummyPendingResult<>(dummyApplicationConnectionResult(Status.INTERRUPTED, applicationMetadata));
            }

            public PendingResult<Status> leaveApplication(final GoogleApiClient client) {
                return new DummyPendingResult<>(Status.SUCCESS);
            }

            public PendingResult<Status> stopApplication(final GoogleApiClient client) {
                return new DummyPendingResult<>(Status.SUCCESS);
            }

            public PendingResult<Status> stopApplication(final GoogleApiClient client, final String sessionId) {
                return new DummyPendingResult<>(Status.SUCCESS);
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                this.volume = volume;
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return volume;
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                this.mute = mute;
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return mute;
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return applicationMetadata;
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return null;
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, Cast.MessageReceivedCallback callbacks) throws IOException, IllegalStateException {

            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {

            }
        }
    }

    private static Cast.ApplicationConnectionResult dummyApplicationConnectionResult(final Status status, final ApplicationMetadata applicationMetadata) {
        return new Cast.ApplicationConnectionResult() {
            public Status getStatus() {
                return status;
            }

            public boolean getWasLaunched() {
                return false;
            }

            public String getSessionId() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return applicationMetadata;
            }
        };
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice castDevice;
        final Cast.Listener castListener;
        private final int verboseLogging;

        private CastOptions(Cast.CastOptions.Builder builder) {
            this.castDevice = builder.castDevice;
            this.castListener = builder.castListener;
            this.verboseLogging = builder.verboseLogging;
        }

        public static Cast.CastOptions.Builder builder(CastDevice castDevice, Cast.Listener castListener) {
            return new Cast.CastOptions.Builder(castDevice, castListener);
        }

        public static final class Builder {
            CastDevice castDevice;
            Cast.Listener castListener;
            private int verboseLogging;

            private Builder(CastDevice castDevice, Cast.Listener castListener) {
                Objects.requireNonNull(castDevice, "CastDevice parameter cannot be null");
                Objects.requireNonNull(castListener, "CastListener parameter cannot be null");
                this.castDevice = castDevice;
                this.castListener = castListener;
                this.verboseLogging = 0;
            }

            public Cast.CastOptions.Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.verboseLogging |= 1;
                } else {
                    this.verboseLogging &= -2;
                }

                return this;
            }

            public Cast.CastOptions build() {
                return new Cast.CastOptions(this);
            }
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice var1, String var2, String var3);
    }

    public static class Listener {
        public Listener() {
        }

        public void onApplicationStatusChanged() {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void zzab(int var1) {
        }

        public void zzac(int var1) {
        }

        public void onVolumeChanged() {
        }
    }
}
