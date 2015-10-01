// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import android.text.TextUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import org.microg.gms.common.Objects;

public final class MediaTrack
{
    public static class Builder
    {

        public Builder setContentId(String contentId)
        {
            zzJr.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType)
        {
            zzJr.setContentType(contentType);
            return this;
        }

        public Builder setName(String trackName)
        {
            zzJr.setName(trackName);
            return this;
        }

        public Builder setLanguage(String language)
        {
            zzJr.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale)
        {
            zzJr.setLanguage(CastMediaControlIntent.languageTagForLocale(locale));
            return this;
        }

        public Builder setSubtype(int subtype)
            throws IllegalArgumentException
        {
            zzJr.zzaf(subtype);
            return this;
        }

        public Builder setCustomData(JSONObject customData)
        {
            zzJr.setCustomData(customData);
            return this;
        }

        public MediaTrack build()
        {
            return zzJr;
        }

        private final MediaTrack zzJr;

        public Builder(long trackId, int trackType)
            throws IllegalArgumentException
        {
            zzJr = new MediaTrack(trackId, trackType);
        }
    }


    MediaTrack(JSONObject json)
        throws JSONException
    {
        zzd(json);
    }

    MediaTrack(long id, int type)
        throws IllegalArgumentException
    {
        clear();
        this.id = id;
        if(type <= 0 || type > 3)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type ").append(type).toString());
        } else
        {
            this.type = type;
            return;
        }
    }

    public long getId()
    {
        return id;
    }

    public int getType()
    {
        return type;
    }

    public String getContentId()
    {
        return contentId;
    }

    public void setContentId(String contentId)
    {
        this.contentId = contentId;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    public String getLanguage()
    {
        return language;
    }

    void setLanguage(String language)
    {
        this.language = language;
    }

    public int getSubtype()
    {
        return subType;
    }

    void zzaf(int i)
        throws IllegalArgumentException
    {
        if(i <= -1 || i > 5)
            throw new IllegalArgumentException((new StringBuilder()).append("invalid subtype ").append(i).toString());
        if(i != 0 && type != 1)
        {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        } else
        {
            subType = i;
            return;
        }
    }

    public JSONObject getCustomData()
    {
        return customData;
    }

    void setCustomData(JSONObject customData)
    {
        this.customData = customData;
    }

    private void clear()
    {
        id = 0L;
        type = 0;
        contentId = null;
        name = null;
        language = null;
        subType = -1;
        customData = null;
    }

    private void zzd(JSONObject jsonobject)
        throws JSONException
    {
        clear();
        id = jsonobject.getLong("trackId");
        String s = jsonobject.getString("type");
        if("TEXT".equals(s))
            type = 1;
        else
        if("AUDIO".equals(s))
            type = 2;
        else
        if("VIDEO".equals(s))
            type = 3;
        else
            throw new JSONException((new StringBuilder()).append("invalid type: ").append(s).toString());
        contentId = jsonobject.optString("trackContentId", null);
        contentType = jsonobject.optString("trackContentType", null);
        name = jsonobject.optString("name", null);
        language = jsonobject.optString("language", null);
        if(jsonobject.has("subtype"))
        {
            String s1 = jsonobject.getString("subtype");
            if("SUBTITLES".equals(s1))
                subType = 1;
            else
            if("CAPTIONS".equals(s1))
                subType = 2;
            else
            if("DESCRIPTIONS".equals(s1))
                subType = 3;
            else
            if("CHAPTERS".equals(s1))
                subType = 4;
            else
            if("METADATA".equals(s1))
                subType = 5;
            else
                throw new JSONException((new StringBuilder()).append("invalid subtype: ").append(s1).toString());
        } else
        {
            subType = 0;
        }
        customData = jsonobject.optJSONObject("customData");
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("trackId", id);
            switch(type)
            {
            case 1: // '\001'
                jsonobject.put("type", "TEXT");
                break;

            case 2: // '\002'
                jsonobject.put("type", "AUDIO");
                break;

            case 3: // '\003'
                jsonobject.put("type", "VIDEO");
                break;
            }
            if(contentId != null)
                jsonobject.put("trackContentId", contentId);
            if(contentType != null)
                jsonobject.put("trackContentType", contentType);
            if(name != null)
                jsonobject.put("name", name);
            if(!TextUtils.isEmpty(language))
                jsonobject.put("language", language);
            switch(subType)
            {
            case 1: // '\001'
                jsonobject.put("subtype", "SUBTITLES");
                break;

            case 2: // '\002'
                jsonobject.put("subtype", "CAPTIONS");
                break;

            case 3: // '\003'
                jsonobject.put("subtype", "DESCRIPTIONS");
                break;

            case 4: // '\004'
                jsonobject.put("subtype", "CHAPTERS");
                break;

            case 5: // '\005'
                jsonobject.put("subtype", "METADATA");
                break;
            }
            if(customData != null)
                jsonobject.put("customData", customData);
        }
        catch(JSONException jsonexception) { }
        return jsonobject;
    }

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(!(other instanceof MediaTrack))
            return false;
        MediaTrack mediatrack = (MediaTrack)other;
        if((customData == null) != (mediatrack.customData == null))
            return false;
        if(customData != null && mediatrack.customData != null && !Objects.jsonEquals(customData, mediatrack.customData))
            return false;
        else
            return id == mediatrack.id && type == mediatrack.type && Objects.equals(contentId, mediatrack.contentId) && Objects.equals(contentType, mediatrack.contentType) && Objects.equals(name, mediatrack.name) && Objects.equals(language, mediatrack.language) && subType == mediatrack.subType;
    }

    public int hashCode()
    {
        return Objects.hash(id, type, contentId, contentType, name, language, subType, customData);
    }

    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_VIDEO = 3;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_METADATA = 5;
    private long id;
    private int type;
    private String contentId;
    private String contentType;
    private String name;
    private String language;
    private int subType;
    private JSONObject customData;
}
