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

package com.google.android.gms.appinvite;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Api;

import org.microg.gms.appinvite.AppInviteApiBuilder;
import org.microg.gms.appinvite.AppInviteApiImpl;
import org.microg.gms.common.PublicApi;


@PublicApi
public final class AppInvite {
    private static final String TAG = "GmsAppInvite";
    
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<Api.ApiOptions.NoOptions>(new AppInviteApiBuilder());

    public static final AppInviteApi AppInviteApi = new AppInviteApiImpl();

    
    private AppInvite() {

    }
}
