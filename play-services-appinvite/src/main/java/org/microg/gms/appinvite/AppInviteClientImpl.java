/*
 * Copyright (C) 2019 e Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.microg.gms.appinvite;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Api;

import org.microg.gms.common.DummyApiConnection;


public class AppInviteClientImpl extends DummyApiConnection {
    private static final String TAG = "GmsAppInviteClientImpl";

    public AppInviteClientImpl(Context context, Api.ApiOptions.NoOptions options, GoogleApiClient.ConnectionCallbacks callbacks, GoogleApiClient.OnConnectionFailedListener connectionFailedListener) {
    }
}
