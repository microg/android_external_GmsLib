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

import org.microg.gms.common.PublicApi;

import android.content.Intent;
import android.accounts.Account;
import android.net.Uri;
import android.util.Log;

import java.util.Map;


@PublicApi
public final class AppInviteInvitation {
    private static final String TAG = "GmsAppInviteInvitation";

    public static String[] getInvitationIds (int resultCode, Intent result) {
        return null;
    }


    public static final class IntentBuilder {
        private static final String TAG = "GmsAppIIIntentBuilder";

        public static final int MAX_CALL_TO_ACTION_TEXT_LENGTH = 20;
        public static final int MAX_EMAIL_HTML_CONTENT = 512000;
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int MIN_CALL_TO_ACTION_TEXT_LENGTH = 2;

        IntentBuilder(CharSequence title) throws NullPointerException {

        }

        public Intent build() throws IllegalArgumentException {
            return null;
        }

        public IntentBuilder setAccount(Account account) {
            return this;
        }

        public IntentBuilder setAdditionalReferralParameters(Map<String, String> params) {
            return this;
        }

        public IntentBuilder setAndroidMinimumVersionCode(int versionCode) {
            return this;
        }

        public IntentBuilder setCallToActionText(CharSequence callToActionText) throws IllegalArgumentException {
            return this;
        }

        public IntentBuilder setCustomImage(Uri imageUri) {
            return this;
        }

        public IntentBuilder setDeepLink(Uri deepLink) {
            return this;
        }

        public IntentBuilder setEmailHtmlContent(String htmlContent) throws IllegalArgumentException {
            return this;
        }

        public IntentBuilder setEmailSubject (String subject) {
            return this;
        }

        public IntentBuilder setGoogleAnalyticsTrackingId(String trackingId) {
            return this;
        }

        public IntentBuilder setMessage (CharSequence message) throws IllegalArgumentException {
            return this;
        }

        public IntentBuilder setOtherPlatformsTargetApplication (int targetPlatform, String clientId) throws IllegalArgumentException {
            return this;
        }


        public static @interface PlatformMode {
            public static final int PROJECT_PLATFORM_ANDROID = 2;
            public static final int PROJECT_PLATFORM_IOS = 1;
        }
    }
}